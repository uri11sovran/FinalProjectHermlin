package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import logic.PlayerType;

public class ImageHandler {
	public static void paint(Graphics gr, int x, int y, PlayerType player_type, JFrame frame) 
	{
		Image img = Toolkit.getDefaultToolkit().getImage(ImageHandler.getPieceImage(player_type));
		y += 20;
		gr.drawImage(img, x - 10, y - 10, 20, 20, frame);
		y -= 20;
	}
	
	public static String getPieceImage(PlayerType player_turn)
	{
		String imagePath = null;
		
		if(player_turn == PlayerType.BLACK)
		{
			imagePath = "src/images/black-stone.gif";
		}
		else
		{
			imagePath = "src/images/white-stone.gif";
		}
		
		return imagePath;
	}
}
