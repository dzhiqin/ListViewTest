package com.example.listviewtest.model;

import android.widget.ImageView;

public class Fruit {

	private String name;
	private String description;
	private int imageId;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public int getImageId(){
		return imageId;
	}
	public void setImageId(int imageId){
		this.imageId=imageId;
	}
	public Fruit(String name,String description,int imageId){
		this.name=name;
		this.description=description;
		this.imageId=imageId;
	}
}
