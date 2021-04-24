package screen;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import event.Accept_Key;
import event.Set_Timer;
import tetris.Tetris;
import tetrominos.Operate_Tetrominos;
import tetrominos.Tetrominos;
public class TetrisScreen extends JFrame{
	public Tetris tetris;
	int widthOfTetrisScreen = 600, heightOfTetrisScreen = 800;
	public Gameboard gameboard = new Gameboard();
	public Nextboard nextboard = new Nextboard(gameboard);
	public TetrisScreen(Tetris tetris){
		this.tetris = tetris;
		Container c = getContentPane();
		c.add(gameboard);
		c.add(nextboard);
		c.setLayout(null);
		setSize(widthOfTetrisScreen,heightOfTetrisScreen);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public class Gameboard extends JPanel{
		
		
		public int widthOfGameboard = widthOfTetrisScreen/2;
		public int heightOfGameboard = widthOfGameboard*2;
		public int gameboardX = widthOfTetrisScreen/6*1, gameboardY = heightOfTetrisScreen/10*1;
		public int sizeOfBlock = widthOfGameboard/10;
		public int numOfWidthblock = 10, numOfHeightblock = 20;
		
		public Tetrominos stackblock[][] = new Tetrominos[numOfHeightblock][numOfWidthblock];
		public Tetrominos currentblock[][] = new Tetrominos[4][4];
		public Tetrominos nextblock[][]= new Tetrominos[4][4];
		
		public int currentXnum;
		public int currentYnum;
		public int currentRotation;
		
		Draw_TetrisScreen drawscreen = new Draw_TetrisScreen(this);
		
		public Gameboard() {
			setBackground(Color.DARK_GRAY);
			System.out.println(widthOfGameboard);
			System.out.println(gameboardX);
			System.out.println(widthOfTetrisScreen);
			setBounds(gameboardX, gameboardY, widthOfGameboard, heightOfGameboard);
		}
		
		
		public void paint(Graphics g){
			System.out.println("paint");
			super.paint(g);
			drawscreen.drawGameblock(g);
		}
		
		public Tetris getTetris() {
			return tetris;
		}public Nextboard getNextboard() {
			return nextboard;
		}
	}
public class Nextboard extends JPanel{
	public int widthOfGameboard = widthOfTetrisScreen/5;
	public int heightOfGameboard = widthOfGameboard/2*2;
	public int gameboardX = 420, gameboardY = 80;
	public int sizeOfBlock = widthOfGameboard/6;
	public int currentXnum = 0;
	public int currentYnum = 0;
	Draw_TetrisScreen drawscreen;
	
	public Nextboard(Gameboard gameboard) {
		setBackground(Color.DARK_GRAY);
		System.out.println(widthOfGameboard);
		System.out.println(gameboardX);
		System.out.println(widthOfTetrisScreen);
		setBounds(gameboardX, gameboardY, widthOfGameboard, heightOfGameboard);
		drawscreen = new Draw_TetrisScreen(gameboard);
	}
	
	
	public void paint(Graphics g){
		super.paint(g);
		//drawscreen.drawGame(g);
		drawscreen.drawNextblock(g);
	}
	}
}
