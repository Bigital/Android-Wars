package com.androidwars;

public class CombatManager {

	public CombatManager(){
		
	}
	
	public void fight(Unit unit01, Unit unit02, Cell u01Cell, Cell u02Cell){
		if(unit01.getType() == "Infantry"){
			if(unit02.getType() == "Jeep"){
				u01Cell.flushUnit();
			}
			else if(unit02.getType() == "Tank"){
				u02Cell.flushUnit();
			}
			else{
				randomKill(u01Cell, u02Cell).flushUnit();
			}
		}
		if(unit01.getType() == "Jeep"){
			if(unit02.getType() == "Tank"){
				u01Cell.flushUnit();
			}
			else if(unit02.getType() == "Infantry"){
				u02Cell.flushUnit();
			}
			else{
				randomKill(u01Cell, u02Cell).flushUnit();
			}
		}
		if(unit01.getType() == "Tank"){
			if(unit02.getType() == "Infantry"){
				u01Cell.flushUnit();
			}
			else if(unit02.getType() == "Jeep"){
				u02Cell.flushUnit();
			}
			else{
				randomKill(u01Cell, u02Cell).flushUnit();
			}
		}
	}
	
	private Cell randomKill(Cell u01Cell, Cell u02Cell){
		if(java.lang.Math.random() < 0.5)
			return u01Cell;
		return u02Cell;
	}
	
}
