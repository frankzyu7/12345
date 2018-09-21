
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Crossword {

	private JFrame f;
	private static char[][] charSet;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crossword window = new Crossword();
					window.f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				/*
				charSet = new char[20][20];
				for (int i=0;i<20;i++) {
					for (int j = 0; j<20;j++) {
						charSet[i][j]=
					}
				}
				*/
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Crossword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		f = new JFrame();
		f.setBounds(100, 100, 800, 800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new BorderLayout());

        JPanel container = new JPanel(new FlowLayout());
        final CrosswordPanel panel = new CrosswordPanel();
        container.add(panel);
        f.getContentPane().add(container, BorderLayout.CENTER);
        
        generate(panel);
  
    
        

        f.setSize(800, 800);
        f.setLocationRelativeTo(null);
        f.setVisible(true);


	}
	
	private static void generate(CrosswordPanel panel)
	{
		int w = 20;
		int h = 20;
		char crossword[][] = new char[w][h];
		for (int y=0; y<h; y++)
		{
			for (int x=0; x<w; x++)
			{
					crossword[x][y] = '\u0020'; // null character
				
			}
		}

		panel.setCrossword(crossword);
	}

	class CrosswordPanel extends JPanel
	{
		private JTextField textFields[][];

		void setCrossword(char array[][])
		{
			removeAll();
			int w = array.length;
			int h = array[0].length;
			setLayout(new GridLayout(w, h));
			textFields = new JTextField[w][h];
			

			for (int y=0; y<h; y++)
			{
				for (int x=0; x<w; x++)
				{
					char c = array[x][y];
					if (c != 0)
					{
						textFields[x][y] = new JTextField(String.valueOf(c));
						textFields[x][y].setFont(textFields[x][y].getFont().deriveFont(20.0f));
				        textFields[x][y].setColumns(1); // the widths of the textfileds

						add(textFields[x][y]);
					}
					else
					{
						add(new JLabel());
					}
				}
			}
			getParent().validate();
			repaint();
		}

		char[][] getCrossword()
		{
			int w = textFields.length;
			int h = textFields[0].length;
			char crossword[][] = new char[w][h];
			
			return crossword;
		}

	}
}