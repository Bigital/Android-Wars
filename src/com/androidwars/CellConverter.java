package com.androidwars;

public class CellConverter {
	
	public CellConverter(){
		
	}
	
	public float getXPos(int x, int y){
		float X;
		if (y%2==0){
			// y is an even number
			X = 40.0f+(x*30.0f);
		}
		else {
			// y is an odd number
			X = 25.0f+(x*30.0f);
		}
		return X;
	}
	
	public float getYPos(int y){
		float Y;
		Y = 48.0f+(y*24.0f);
		return Y;
	}
	
	public int getYCell(float y){
		int j = (int)(y/24 - 1.5);
		return j;
	}
	
	public int getXCell(float x, int yCell){
		if(yCell%2 != 0){
			return (int)((x-25)/30 + 0.5);
		}
		return (int)((x-40)/30 + 0.5);
	}
	
	
	
}