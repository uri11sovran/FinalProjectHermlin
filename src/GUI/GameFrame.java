package GUI;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import logic.Game;
import logic.PlayerType;

/*
 * The class is a JFrame that prints on the screen the board status.
 * It implements MouseListener the get the details of the users interaction
 * with the board.
 */
@SuppressWarnings("serial")
public class GameFrame extends JFrame implements MouseListener {
	Game gameController; // an instance of the Game class that controls the logic of the game itself
	JLabel label; // a label that holds an image of the game board and allows the user to interact with the board
    MediaTracker tracker; // used to track the loading of piece images
	
	public GameFrame() {
		// set initial frame
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Connect6 Game");
		this.setLayout(new FlowLayout());
		
		// set image icon
		ImageIcon image = new ImageIcon("src/images/Board.png");
		this.setIconImage(image.getImage());
		
		// set board image as label
		ImageIcon icon = new ImageIcon("src/images/Board.png"); 
		label = new JLabel();
		label.addMouseListener(this);
		label.setIcon(icon);
		
		// add the board image to the frame
		this.add(label);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		gameController = new Game(this);
		
		waitForImage();
	}
	
	/*
	 * The function is responsible for waiting for piece images to load
	 */
	public void waitForImage()
	{
		// gets the black image path
		Image black_img = Toolkit.getDefaultToolkit().getImage(
											ImageHandler.getPieceImage(PlayerType.BLACK));
		// gets the white image path
		Image white_img = Toolkit.getDefaultToolkit().getImage(
											ImageHandler.getPieceImage(PlayerType.WHITE));
		
		// added the wanted images to track
		tracker = new MediaTracker(this);
		tracker.addImage(black_img, 0);
		tracker.addImage(white_img, 1);

		try {
			// waits for the images to load
            tracker.waitForID(0);
            tracker.waitForID(1);
        } catch (InterruptedException e) {
            System.out.println("error");
        }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x=e.getX();
	    int y=e.getY();

	    try {
			gameController.MakeTern(getGraphics(), x, y);
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        this.setCursor(cursor);
        this.setVisible(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        this.setCursor(cursor);
        this.setVisible(true);
	}
}
