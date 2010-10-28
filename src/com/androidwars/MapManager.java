package com.androidwars;

//import java.util.Vector;
import android.util.Log;

public class MapManager {
	private Cell[][] cells;//The playing field, where cells[x][y] is (x = width) * (y = height)
	
	public MapManager(){
		cells = new Cell[10][17];
		
		//j stendur fyrir 'y' röðina á kortinu, i er x röðin
		//það eru 10 cellur í oddatölu y röðum en 9 í sléttum
		for(int j = 0; j < 17; j++){
			for(int i = 0; i < 10; i++){
				// Make sure only 9 cells are created on even-numbered rows
				if(i == 9 && j%2 == 0){
					//Log.v("IN if", "cells[" + i + "][" + j + "]");
					break;
				}
				cells[i][j] = new Cell(i,j);
			}
		}
	}
	
	//Usage: u = mm.getUnit(xCell, yCell)
	//Before: u is a Unit, xCell is lower or equal to number of horizontal hexes,
	//		  yCell is lower or equal to the number of vertical hexagons
	//After: The unit in square (xCell, yCell) is contained in u.
	public Unit getUnit(int xCell, int yCell){
		return cells[xCell][yCell].getUnit();
	}
	
	//Usage: b = mm.cellIsEmpty(xCell, yCell)
	//Before: b is boolean, xCell is lower or equal to number of horizontal hexes,
	//		  yCell is lower or equal to the number of vertical hexagons
	//After: if the cell does not contain a unit then b is true, otherwise false.
	public boolean cellIsEmpty(int xCell, int yCell){
		Log.v("TEST", "cells[" + xCell + "][" + yCell + "]");
		return cells[xCell][yCell].isEmpty();
	}
	
	//Temp function used for logging.
	public String cellIsEmpty2(int x, int y){
		//Log.v("TEST", "cells[" + x + "][" + y + "]");
		if(cells[x][y].isEmpty())
			return "cell is empty";
		return "cell is not empty";
	}
	
	//Usage: putUnit(unit, xCell, yCell);
	//Before: xCell is lower or equal to number of horizontal hexes,
	//		  yCell is lower or equal to the number of vertical hexagons
	//After: unit is now in cells[x][y].
	public void putUnit(Unit unit, int xCell, int yCell){
		cells[xCell][yCell].setUnit(unit);
		unit.x = getXpos(xCell,yCell) - unit.getWidth()/2;
		unit.y = getYpos(xCell,yCell) - unit.getHeight()/2;
	}
	
	public void removeUnit(int xCell, int yCell){
		cells[xCell][yCell].flushUnit();
	}
	
	// Width of a cell: 30 px
	// Height of a cell: 29 px
	// Length from middle of cell to the one two steps below: 48 px
	// Middle of cell 0,0 is 40 px to the right of the edge and 48 px down
	// Middle of cell 0,1 is 25 px to the right and 48+24 = 72 px down
	
	// Takes map coordinate
	// Returns screen coordinate
	// TODO: MAKE BETTER
	public float getXpos(int x, int y) {
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
	public float getYpos(int x, int y) {
		float Y;
		Y = 48.0f+(y*24.0f);
		return Y;
	}
	
	//Usage: i = getYcell2(y);
	//Before: i is an integer, f a is float.
	//After: the cell that corresponds to the y-pos is contained in i 
	public int getYcell2(float y){
		int j = (int)(y/24 - 1.5);
		return j;
	}
	
	//Usage: i = getXCell2(x, yCell);
	//Before: i and yCell are integers, x is a float
	//After: the cell that corresponds to the x-pos and yCell is contained in i
	public int getXCell2(float x, int yCell){
		int i = 0;
		if(yCell%2 != 0){
			return (int)((x-25)/30 + 0.5);
		}
		return (int)((x-40)/30 + 0.5);
	}
}