package logic;

import java.awt.Graphics;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GUI.GameFrame;
import GUI.ImageHandler;

public class Game {
	public static final int NUM_OF_CELLS = 19;
	public static int CELL_SIZE;
	
	private JFrame frame;
	private PlayerType player_turn = PlayerType.BLACK;
	
	private Player blackPlayer;
	private Player whitePlayer;
	private int tern_counter;
	private Board gameBoard;
	  
	public Game(GameFrame fr) 
	{
		frame = fr;
		
		gameBoard = new Board();
		
		blackPlayer = new Player();
		whitePlayer = new Player();
		
		tern_counter = 1;
		
		// Initialize static variable
		CELL_SIZE = frame.getWidth() / NUM_OF_CELLS;
	}
	
	public void MakeTern(Graphics gr, int x, int y) throws CloneNotSupportedException 
	{
		int win_flag = 0;
		x = PiecePlacementHandler.GetReletivePosition(x);
		y = PiecePlacementHandler.GetReletivePosition(y);
		System.out.println(frame.getWidth());
		
		if(gameBoard.PlacePiece(x, y, player_turn))
		{
			ImageHandler.paint(gr, x, y, player_turn, frame);
			
			if(y >= 323)
				y += 6;
			if(x >= 323)
				x += 6;
			
			if(player_turn == PlayerType.BLACK)
			{
				win_flag = blackPlayer.addPosition(Math.round((float)(y) / CELL_SIZE) - 1,
												   Math.round((float)(x) / CELL_SIZE) - 1,
												   gameBoard.clone());
			}
			else
			{
				win_flag = whitePlayer.addPosition(Math.round((float)(y) / CELL_SIZE) - 1,
												   Math.round((float)(x) / CELL_SIZE) - 1,
												   gameBoard.clone());
			}
			
			if(win_flag == 2)
			{
				JOptionPane.showMessageDialog(frame, player_turn + " Player won!");
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
				
			HandlePlayerTurn();
			tern_counter++;
		}
	}
	
	public void HandlePlayerTurn()
	{
		System.out.println(gameBoard.getNumberOfPieces());
		if(gameBoard.getNumberOfPieces() == 1 || player_turn == PlayerType.BLACK && tern_counter > 2)
		{
			player_turn = PlayerType.WHITE;
			tern_counter = 1;
		}
		else if(player_turn == PlayerType.WHITE && tern_counter > 2)
		{
			player_turn = PlayerType.BLACK;
			tern_counter = 1;
		}
	}
}
