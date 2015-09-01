/*
 * This is the solution to StoneMason Karel. It checks for the missing stones
 * in the Columns and puts the missing stone.
 * Written By AB
 */

import stanford.karel.*;

public class StoneMason extends SuperKarel {
	
	public void run() {
		
		repairColumn();
		while (frontIsClear()){
			moveToNextColumn();
			repairColumn();
		}
		
		
	}
	//repairColumn() checks if beeper is absent and places it
	private void repairColumn(){
		
		turnLeft();
		
		while (frontIsClear()){
			
			putStone();
			
			move();
		}
		if (frontIsBlocked()){
			
			putStone();
		}
		
		moveToOriginalPositionInColumn();
		
	}
	
	//moveToOriginalPositionInColumn() moves karel to the initial
	//position at the base of the column it is working on
	
	private void moveToOriginalPositionInColumn(){
		turnAround();
		while (frontIsClear()){
			move();
		}
		turnLeft();
	}
	
	//moveToNextColumn(): Moves Karel to the next column
	private void moveToNextColumn(){
		for (int i=0; i<4; i++){
			move();
		}
	
	}
	//putStone(): Puts stone only if stone is not present
	private void putStone(){
		if (noBeepersPresent()){
			putBeeper();
		}
	}

}
