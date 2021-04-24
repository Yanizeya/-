package tetrominos;

public class Tetrominos_T extends Tetrominos{
		int block[][][] = {
			{
				{0,0,0,0},
				{0,0,0,0},
				{0,1,0,0},
				{1,1,1,0},
			}
			,
			{
				{0,0,0,0},
				{1,0,0,0},
				{1,1,0,0},
				{1,0,0,0},
			},
			{
				{0,0,0,0},
				{0,0,0,0},
				{1,1,1,0},
				{0,1,0,0},
			},
			{
				{0,0,0,0},
				{0,1,0,0},
				{1,1,0,0},
				{0,1,0,0},
			}
		};
		public Tetrominos_T() {
			numOfRotation = 4;
		}
}
