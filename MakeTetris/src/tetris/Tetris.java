package tetris;

import event.Accept_Key;
import event.Set_Timer;
import screen.TetrisScreen;
import screen.TetrisScreen.Gameboard;
import tetrominos.Operate_Tetrominos;
import tetrominos.Tetrominos;

public class Tetris {
	public TetrisScreen screen = new TetrisScreen(this);
	public Gameboard gameboard = screen.gameboard;
	public Operate_Tetrominos opTe = new Operate_Tetrominos(gameboard);
	
	
	
	public Tetris(){
		tetrisSet();
		Set_Timer timer = new Set_Timer(this);
		screen.addKeyListener(new Accept_Key(this));
	}
	
	public void tetrisSet (){
		System.out.println("tetrisSet");
		opTe.setTetrominos(gameboard.currentblock);
		opTe.setNullTetrominos(gameboard.stackblock);
	}
}
