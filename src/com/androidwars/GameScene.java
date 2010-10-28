package com.androidwars;

import android.view.MotionEvent;

import com.stickycoding.rokon.Scene;
import com.stickycoding.rokon.background.FixedBackground;
import android.util.Log;

public class GameScene extends Scene {

    private Unit[] p1UnitStack;
    private Unit[] p2UnitStack;
    private int actingPlayer;
    private int turnNumber;
    private MapManager mapManager;
    private boolean hasMoveCharge;
    private int oldCellX;
    private int oldCellY;
    
    private Unit unitInUse;
    
    
    public GameScene() {
        super(1, 10);
        
        mapManager = new MapManager();
        p1UnitStack = new Unit[5];
        hasMoveCharge = false;
        actingPlayer = 1;
        turnNumber = 1;
        
        initUnits();
        setBackground(background = new FixedBackground(Textures.background));  
    }
    
    //Usage: initUnits();
    //After: Units have been created and put on the map
    private void initUnits(){
        
    	for(int i = 0; i < 5; i++){
    		p1UnitStack[i] = new Unit(1, 1, 30, 30);
    		//p2UnitStack[i] = new Unit(1,1,30,30);
    		p1UnitStack[i].setTexture(Textures.guy);
    		//p2UnitStack[i].setTexture(Textures.guy);
    		mapManager.putUnit(p1UnitStack[i], i, 5);
    		//mapManager.setUnit(p2UnitStack[i], i, 5);
    		
    		add(0,p1UnitStack[i]);
    	}
    	
    }
    
    @Override
    public void onTouchDown(float x, float y, MotionEvent event, int pointerCount, int pointerId) {
    	int cellY = mapManager.getYcell2(y);
    	int cellX = mapManager.getXCell2(x, mapManager.getYcell2(y));
    	
    	Log.v("CHECKING MOVE", "hasMoveCharge = " + hasMoveCharge);
    	Log.v("Is it all true", mapManager.cellIsEmpty2(cellX, cellY));

    	
    	if(hasMoveCharge && mapManager.cellIsEmpty(cellX, cellY)){
    		//move unit from currentCell to new Cell but only if it's within 1 square
    		//and it's a part of allowed cells. Disallowed cells are cells[x-1][y+1] and cells[x+1][y-1].
    		
    		if(oldCellY%2 == 0){
    			if(cellY + 1 == oldCellY && (cellX + 1 == oldCellX || cellY - 1 == oldCellX))
    				return;
    		}
    		else{
    			if(cellY + 1 == oldCellY && cellX + 1 == oldCellX || cellY - 1 == oldCellY && cellY - 1 == oldCellX)
    				return;
    		}
    		
    		//if the touched square is one away then
    		if( (cellY + 1 == oldCellY || cellY - 1 == oldCellY) || cellY == oldCellY && (cellX + 1 == oldCellX || cellX - 1 == oldCellX || cellX == oldCellX)){
 
    			//mapManager.putUnit(p1UnitStack[0], cellX, cellY);
    			mapManager.putUnit(mapManager.getUnit(oldCellX, oldCellY), cellX, cellY);
    			mapManager.removeUnit(oldCellX, oldCellY);
    			hasMoveCharge = false;
    			return;
    		}
    	}
    	
    	if(hasMoveCharge == false && mapManager.cellIsEmpty(cellX, cellY) == false){
    		hasMoveCharge = true;
    		oldCellX = cellX;
    		oldCellY = cellY;
    	}
    	
    	//int temp = mapManager.getYcell2(y);
    	//mapManager.setUnit(p1UnitStack[0],mapManager.getXcell(x, y), mapManager.getYcell(x,y));
    	//mapManager.setUnit(p1UnitStack[0],mapManager.getXCell2(x, temp), temp);
    	
    }

    @Override
    public void onTouchMove(float x, float y, MotionEvent event, int pointerCount, int pointerId) {
    	// This is called when you move your finger over the screen. (ie pretty much every frame if your holding your finger down)

    	//Here we'll just make Bob follow your finger.
    	//bob.x = x - (Textures.bob.getWidth() / 2);
    	//bob.y = y - (Textures.bob.getHeight() / 2);
    }

    @Override
    public void onTouchUp(float x, float y, MotionEvent event, int pointerCount, int pointerId) {
    	// And this is called when you stop pressing.
    }
    
    @Override
    public void onGameLoop() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onReady() {
    	//p1UnitStack[0].moveTo(450, 100, 5000);
    }
}
