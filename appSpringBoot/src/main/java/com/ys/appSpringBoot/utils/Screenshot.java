package com.ys.appSpringBoot.utils;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.android.ddmlib.AndroidDebugBridge;
import com.android.ddmlib.IDevice;
import com.android.ddmlib.RawImage;

public class Screenshot {

	public static void main(String[] args) {
		getImage();
	}
	
	public static void getImage(){
		 IDevice device;
	        AndroidDebugBridge.init(false);
	        AndroidDebugBridge bridge = AndroidDebugBridge.createBridge(ReadProperties.GetPropertyByKey("adb"), false);
	        waitForDevice(bridge);
	        IDevice devices[] = bridge.getDevices();
	        device = devices[0];
	        takeScreenshot(device);
	        
//	    	bridge.disconnectBridge();
//	    	AndroidDebugBridge.terminate();
	    	bridge.terminate();
	}

    private static void waitForDevice(AndroidDebugBridge bridge) {
        int count = 0;
        while (!bridge.hasInitialDeviceList()) {
            try {
                Thread.sleep(100);
                count++;
            } catch (InterruptedException ignored) {
            }
            if (count > 300) {
                System.err.print("Time out");
                break;
            }
        }
    }
	private static void takeScreenshot(IDevice device) {
	    try {
	        RawImage rawScreen = device.getScreenshot();
	        if (rawScreen != null) {
	            int width = rawScreen.width;
	            int height = rawScreen.height;
	            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	            int index = 0;
	            int indexInc = rawScreen.bpp >> 3;
	            for (int y = 0; y < rawScreen.height; y++) {
	                for (int x = 0; x < rawScreen.width; x++, index += indexInc) {
	                    int value = rawScreen.getARGB(index);
	                    image.setRGB(x, y, value);
	                }
	            }
	            ImageIO.write(image, "PNG", new File(ProjectPath.getProjectPath()+"/image/pwd.png"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
