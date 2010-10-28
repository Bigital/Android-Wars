package com.androidwars;

import android.util.Log;

public class Cell {
	private int x, y;
	private Unit containedUnit;
	private boolean hasUnit;
	
	public Cell(int x, int y){
		this.x = x;
		this.y = y;
		hasUnit = false;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean isEmpty(){
		return(hasUnit == false);
	}
	
	public Unit getUnit(){
		return containedUnit;
	}
	
	public void flushUnit(){
		hasUnit = false;
		containedUnit = null;
	}
	
	public void setUnit(Unit unit){
		hasUnit = true;
		containedUnit = unit;
	}
}
