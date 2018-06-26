package com.ys.appSpringBoot.mapping;

import java.util.HashMap;

public class WelcomePage {

	public String[] cn_name={"单击","下滑","上滑"};
	
	public String[] action_name={"onclick","",""};
	

	public String getAction(String actionName){
		for(int i=0;i<cn_name.length;i++){
			if(actionName.contains(cn_name[i])){
				return action_name[i];
			}
		}
		return null;
	}
	
}
