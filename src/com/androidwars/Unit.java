package com.androidwars;

import com.stickycoding.rokon.Sprite;
import com.stickycoding.rokon.Texture;
import com.stickycoding.rokon.TextureAtlas;

public class Unit extends Sprite{
	
	private int moveAllowance; //not being used yet

	private int owner; //what player owns this unit
		
	public Unit(float xPos, float yPos, float width, float height){
		super(xPos, yPos, width, height);
	}
	
	public String getType(){
		return "Infantry";
	}
}