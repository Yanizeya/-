package tetrominos;

import screen.TetrisScreen.Gameboard;

public class Check_OperatingCondition {
	Gameboard gameboard;
	Operate_Tetrominos opTe;
	Check_OperatingCondition(Gameboard gameboard, Operate_Tetrominos opTe){
		this.gameboard = gameboard;
		this.opTe = opTe;
	}
	
	
	public boolean move(Tetrominos block[][]) {
		int currentXnum = gameboard.currentXnum;
		int currentYnum = gameboard.currentYnum;
		System.out.println("checkMoveable");
		for(int i =0; i<4; i++)
			for(int j=0; j<4; j++){
				if(block[i][j].use) { 
					if(currentYnum+i >= gameboard.numOfHeightblock-1) {
							System.out.println("Floor");
							opTe.changeBlockToStack(block);
							return false;
					}
					if(gameboard.stackblock[i+currentYnum+1][j+currentXnum].use) {
						System.out.println("Crash");
						opTe.changeBlockToStack(block);
						return false;
					}
				}
				if(i==3 && j==3)
						return true;
				else 
					continue;
			}
		return false;
		
	}
	
	public void clearLine(int higherY) {
		int lineToClear[] = {0, 0, 0, 0};
		System.out.println("higherY="+higherY);
		for(int floorOfBox = 3; higherY <= floorOfBox; higherY++) {
			for(int j=0; j<gameboard.numOfWidthblock; j++) {
				if(gameboard.stackblock[gameboard.currentYnum+higherY][j].use) {
					if(j == gameboard.numOfWidthblock-1)
						lineToClear[higherY] = 1;
					else
						continue;
				}
				else {
					System.out.println("Break!");
					break;
				}
			}
		}

		for(int i=0;i<4;i++)
			System.out.print(lineToClear[i]);
		System.out.println();
		
		opTe.ClearLine(lineToClear);
	}
	
	boolean gameOver(int higherY) {
		if(gameboard.currentYnum+higherY <= 2) {
			return true;
			}
		else 
			return false;
		
			
		}
}
