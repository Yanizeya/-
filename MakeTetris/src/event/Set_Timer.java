package event;

import java.util.Timer;
import java.util.TimerTask;

import tetris.Tetris;
import tetrominos.Operate_Tetrominos;

public class Set_Timer {
	Operate_Tetrominos opTe;
	public boolean gameOver = false;
	public Set_Timer(Tetris tetris){
		opTe = tetris.opTe;
		Timer timer = new Timer();
		
		TimerTask timertask = new TimerTask() {
			public void run() {
				opTe.moveDown(tetris.gameboard.currentblock);
				
				if(gameOver) {
					System.out.println("GameOver");
					timer.cancel();
				}
				else
					tetris.screen.repaint();
			}
		};
		timer.schedule(timertask, 500, 700);
	}
}
