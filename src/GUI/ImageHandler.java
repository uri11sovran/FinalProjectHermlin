package GUI;

import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import logic.PlayerType;

public class ImageHandler {
	public static final double SCREEN_HIGHT_TO_IMG_SIZE_RATIO = 0.00462962963;
	public static final double SCREEN_WIDTH_TO_IMG_SIZE_RATIO = 0.00260416;
	private static final int IMG_LEN = 20;
	
	public static void paint(Graphics gr, int x, int y, PlayerType player_type, JFrame frame) 
	{
		DisplayMode mode = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		
		Image img = Toolkit.getDefaultToolkit().getImage(ImageHandler.getPieceImage(player_type));
		
		// moves the image down by one image frame
		y += IMG_LEN;
		
		// draws image
		gr.drawImage(img,
					x - (int)(Math.round(mode.getWidth() * SCREEN_WIDTH_TO_IMG_SIZE_RATIO)),
					y - (int)(Math.round(mode.getHeight() * SCREEN_HIGHT_TO_IMG_SIZE_RATIO)),
					IMG_LEN, IMG_LEN,
					frame);
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
