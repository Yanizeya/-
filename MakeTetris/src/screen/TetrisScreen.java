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
	public Gameboard gameboard = new Gameboard();
	
	public TetrisScreen(Tetris tetris){
		this.tetris = tetris;
		Container c = getContentPane();
		c.add(gameboard);
		c.setLayout(null);
		setSize(600,800);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public class Gameboard extends JPanel{
		
		public int gameboardX = 20, gameboardY = 40;
		public int widthOfGameboard = 350;
		public int heightOfGameboard = 700;
		public int sizeOfBlock = widthOfGameboard/10;
		public int numOfWidthblock = 10, numOfHeightblock = 20;
		
		public Tetrominos stackblock[][] = new Tetrominos[numOfHeightblock][numOfWidthblock];
		public Tetrominos currentblock[][] = new Tetrominos[4][4];
		public Tetrominos nextblock;
		
		public int currentXnum;
		public int currentYnum;
		public int currentRotation;
		
		Draw_Screen drawscreen = new Draw_Screen(this);
		
		public Gameboard() {
			setBackground(Color.DARK_GRAY);
			setBounds(gameboardX, gameboardY, widthOfGameboard, heightOfGameboard);
		}
		
		
		public void paint(Graphics g){
			System.out.println("paint");
			super.paint(g);
			drawscreen.drawGame(g);
		}
		
		public Tetris getTetris() {
			return tetris;
		}
	}

}
