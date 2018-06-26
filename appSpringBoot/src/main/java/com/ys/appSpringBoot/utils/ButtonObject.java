package com.ys.appSpringBoot.utils;

public class ButtonObject {

	public   Integer width;//number宽
	public   Integer height;//number高
	public   Integer x;//x
	public   Integer y;//y
	
	public ButtonObject(Integer width, Integer height,
			Integer x, Integer y) {
		super();
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
	}
	public Integer getNumberwidth() {
		return width;
	}
	public void setNumberwidth(Integer width) {
		this.width = width;
	}
	public Integer getNumberheight() {
		return height;
	}
	public void setNumberheight(Integer height) {
		this.height = height;
	}
	public Integer getNumberx() {
		return x;
	}
	public void setNumberx(Integer x) {
		this.x = x;
	}
	public Integer getNumbery() {
		return y;
	}
	public void setNumbery(Integer y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "元素坐标："+x+","+y+","+width+","+height;
	}
	
	
}
