package com.example.java_android_ponggame;

public class Circle {
	private float x;
	private float y;
	private float radius;
	
	Circle(float x, float y, float radius){
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	void setX (float x){
		this.x = x;
	}
	
	void setY (float y){
		this.y = y;
	}
	
	void setRadius (float radius){
		this.radius = radius;
	}
	
	float getX(){
		return x;
	}
	
	float getY(){
		return y;
	}
	
	float getRadius(){
		return radius;
	}

	void moveCircle(float delta_x, float delta_y){
		x += delta_x;
		y += delta_y;
	}
	

}
