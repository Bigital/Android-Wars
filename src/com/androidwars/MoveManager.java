package com.androidwars;

public class MoveManager {

	private CellConverter converter;
	
	public MoveManager(){
			converter = new CellConverter();
	}
	
	public void move(Unit unit, float newX, float newY){
		isHexEmpty(newX, newY);
		
		unit.x = newX;
		unit.y = newY;
	}
	
	private boolean isHexEmpty(float x, float y){
		return false;
	}
	
	public void move(Cell oldCell, Cell newCell){
		if(newCell.isEmpty()){
			moveUnit(oldCell, newCell);
			return;
		}
				
	}
	
	private void moveUnit(Cell oldCell, Cell newCell){
		newCell.setUnit(oldCell.getUnit());
		oldCell.flushUnit();
		newCell.getUnit().x = converter.getXPos(newCell.getX(), newCell.getY());
		newCell.getUnit().y = converter.getYPos(newCell.getY());
	}
}
