package screen;

import java.awt.Color;
import java.awt.Graphics;

import screen.TetrisScreen.Gameboard;
import tetrominos.Tetrominos;

public class Draw_Screen {
	Gameboard gameboard;
	int widthOfGameboard;
	int sizeOfBlock;
	int numOfWidthblock, numOfHeightblock;
	
	Draw_Screen(Gameboard gameboard){
		this.gameboard = gameboard;
		this.widthOfGameboard = gameboard.widthOfGameboard;
		this.sizeOfBlock = gameboard.sizeOfBlock;
		this.numOfWidthblock = gameboard.numOfWidthblock;
		this.numOfHeightblock = gameboard.numOfHeightblock;
	}
	
	public void drawGame(Graphics g){
		drawGameblock(g);
	}
	
	private void drawGameblock(Graphics g){
		drawStackblock(g);
		drawPredictCurrentblock(g);
		drawCurrentblock(g);
		
	}
	
	
	
	private void drawCurrentblock(Graphics g){
		for(int i=0; i<4; i++)
			for(int j =0; j<4; j++)	
			{
				if(gameboard.currentblock[i][j].use) {
				g.setColor(gameboard.currentblock[i][j].color);
				g.fill3DRect((gameboard.currentXnum+j)*sizeOfBlock, (gameboard.currentYnum+i)*sizeOfBlock, sizeOfBlock, sizeOfBlock, true);
				}
			}
		
	}
	
	private void drawStackblock(Graphics g){
		for(int i=0; i<numOfHeightblock; i++)
			for(int j =0; j<numOfWidthblock; j++)	
			{
				if(gameboard.stackblock[i][j].use) {
				g.setColor(gameboard.stackblock[i][j].color);
				g.fill3DRect(j*sizeOfBlock, i*sizeOfBlock, sizeOfBlock, sizeOfBlock, true);
				}
			}
		
	}
	
	private void drawPredictCurrentblock(Graphics g) {
		
		Tetrominos currentblock[][] = gameboard.currentblock;
		int curYnum = gameboard.currentYnum, curXnum = gameboard.currentXnum;
		
		wo:
		while(true) {
			for(int i = 3; i>=0; i--) {
				for(int j=0; j<4; j++){
					if(currentblock[i][j].use) {
						if(gameboard.stackblock[curYnum+i][curXnum+j].use) {
							for(int i2 =0; i2<4; i2++) {
								for(int j2=0; j2<4; j2++){
									if(currentblock[i2][j2].use) {
										g.setColor(gameboard.currentblock[i2][j2].color);
										g.draw3DRect((curXnum+j2)*sizeOfBlock, (curYnum+i2-1)*sizeOfBlock, sizeOfBlock, sizeOfBlock, true);
									}
								}
							}
							System.out.println("Crash");
							return;
						}
						
					}
					
				}
			}if(curYnum+3 >= gameboard.numOfHeightblock-1) {
				break wo;
			}
			curYnum++;
		}
		
		System.out.println("Floor");
		
		for(int i =0; i<4; i++) {
			for(int j=0; j<4; j++){
				if(currentblock[i][j].use) {
					g.setColor(gameboard.currentblock[i][j].color);
					g.draw3DRect((curXnum+j)*sizeOfBlock, (curYnum+i)*sizeOfBlock, sizeOfBlock, sizeOfBlock, true);
				}
			}
		}
	}
}
