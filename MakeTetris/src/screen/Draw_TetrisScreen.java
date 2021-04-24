package screen;

import java.awt.Color;
import java.awt.Graphics;

import screen.TetrisScreen.Gameboard;
import tetrominos.Tetrominos;

public class Draw_TetrisScreen {
	Gameboard gameboard;
	int widthOfGameboard;
	int sizeOfBlock;
	int numOfWidthblock, numOfHeightblock;
	
	Draw_TetrisScreen(Gameboard gameboard){
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
		drawCurrentblock(g);
		drawPredictblock(g);
		drawGameOverline(g);
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
	
	private void drawPredictblock(Graphics g) {
		
		Tetrominos currentblock[][] = gameboard.currentblock;
		Tetrominos stackblock[][] = gameboard.stackblock;
		int curYnum = gameboard.currentYnum, curXnum = gameboard.currentXnum; //predict블럭을 그릴 부분을 검사하는 임시 블럭
		int spaceOfCurrentblockAndPredictblock; 
		
		wo:
		while(true) {
			for(int i = 3; i>=0; i--) {
				for(int j=0; j<4; j++){ //currentblock의 왼쪽 아래부터 검사시작
					if(currentblock[i][j].use) { //current블록의 해당 부분이 사용중이라면
						if(gameboard.stackblock[curYnum+i][curXnum+j].use) {//현재 curY의 검사 부분과 stack 블럭이 충돌했을 경우 그리기 단계로 이동
							spaceOfCurrentblockAndPredictblock = curYnum-gameboard.currentYnum-1; //현재 검사중인 cur블럭과 본래 current블럭의 y값차이
							if(spaceOfCurrentblockAndPredictblock >=0) {
								for(int i2 =0; i2<4; i2++) {
									for(int j2=0; j2<4; j2++){
										if(currentblock[i2][j2].use) { 
											if(spaceOfCurrentblockAndPredictblock + i2< 4) {
												if(gameboard.currentblock[spaceOfCurrentblockAndPredictblock+i2][j2].use) { //만약에 predict블럭을 그릴 cur블럭의 자리에 currentblock이 있다면
													System.out.println("i2="+i2+" j2="+j2);
													continue;
												}
											}
											System.out.println("curYnum="+curYnum+" currentYnum="+gameboard.currentYnum);
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
				}
			}
			if(curYnum+3 >= gameboard.numOfHeightblock-1) {//cur블럭이 satck블럭과 충돌하지 못하고 지면과 닿았을경우 curYnum의 값 덧셈 중단
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
	
	void drawGameOverline(Graphics g) {
		
	}
}
