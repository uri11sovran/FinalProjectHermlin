package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	JLabel label;
	
	public MainFrame()
	{	      
		JButton vsPlayer = new JButton(new ImageIcon("src/images/2977044-200.png"));
		vsPlayer.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new GameFrame();
				dispose();
			}
		});
		vsPlayer.setBounds(140,200,200,150);
		
		JButton pcPlayer = new JButton(new ImageIcon("src/images/PvPc.png"));
		vsPlayer.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		pcPlayer.setBounds(140,50,200,150);
		
	    this.add(vsPlayer);
	    this.add(pcPlayer);
	    
		this.setLayout(null);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Connect6 Game Menu");
		this.getContentPane().setBackground(Color.CYAN);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		ImageIcon image = new ImageIcon("src/images/Board.png");
		this.setIconImage(image.getImage());
	}
}
