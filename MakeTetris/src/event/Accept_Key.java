package event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import screen.TetrisScreen.Gameboard;
import tetris.Tetris;
import tetrominos.Operate_Tetrominos;
import tetrominos.Tetrominos;

public class Accept_Key implements KeyListener{
	Tetris tetris;
	Operate_Tetrominos opTe;
	Gameboard gameboard;
	public Accept_Key(Tetris tetris){
		this.tetris = tetris;
		opTe = tetris.opTe;
		gameboard = tetris.gameboard;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if(tetris.timer.gameOver != true) {
			if(e.getKeyCode() == KeyEvent.VK_LEFT)
				opTe.moveLeft(gameboard.currentblock);
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				opTe.moveRight(gameboard.currentblock);
			
			if(e.getKeyCode() == KeyEvent.VK_DOWN)
				opTe.moveDown(gameboard.currentblock);
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				Tetrominos curblock = gameboard.currentblock[0][0];
				while(curblock == gameboard.currentblock[0][0]) {
					opTe.moveDown(gameboard.currentblock);
					}
			}
			if(e.getKeyCode() == KeyEvent.VK_UP) {
				opTe.turnBlock(gameboard.currentblock);
			}
			if(tetris.timer.gameOver != true) {
				System.out.println("keypress repaint");
				tetris.screen.repaint();
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}
