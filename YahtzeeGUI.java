import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class YahtzeeGUI {

	private JFrame frame;

	public YahtzeeGUI() { 
		frame = new JFrame("Yahtzee Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		
		showMainPanel();
		
		frame.setVisible(true);
	}
	
	void showMainPanel() {
		JPanel mainPage = new JPanel();
		mainPage.setBackground(new Color(51, 153, 255));
		mainPage.setLayout(new BorderLayout());
		
		JLabel title = new JLabel("Choose an option", JLabel.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 25));
		mainPage.add(title, BorderLayout.NORTH);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		buttonPanel.setBackground(new Color(51, 204, 255));
		
		//adds space between buttons
		buttonPanel.add(Box.createVerticalStrut(120));
				
		JButton playerButton = new JButton("Player(s)"); 
		playerButton.setFont(new Font("Arial", Font.PLAIN, 18));
		playerButton.setPreferredSize(new Dimension(300, 100));
		playerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		playerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPlayerPanel();
			}
		});
		buttonPanel.add(playerButton);
		
		//adds space between buttons
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		JButton cpuButton = new JButton("Computer");
		cpuButton.setFont(new Font("Arial", Font.PLAIN, 18));
		playerButton.setPreferredSize(new Dimension(300, 100));
		cpuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		cpuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCpuPanel();
			}
		});
		buttonPanel.add(cpuButton);
		
		//adds space between buttons
		buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		JButton instrButton = new JButton("Instructions");
		instrButton.setFont(new Font("Arial", Font.PLAIN, 18));
		playerButton.setPreferredSize(new Dimension(300, 100));
		instrButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		instrButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showInstructions();
			}
		});
		buttonPanel.add(instrButton);
				
		mainPage.add(buttonPanel, BorderLayout.CENTER);
		
		frame.setContentPane(mainPage);
		
		frame.revalidate();
		frame.repaint();
	}
	
	private void showPlayerPanel() {
		JPanel playerPage = new JPanel();
		playerPage.setBackground(new Color(144, 238, 144));
		playerPage.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("How many players?", JLabel.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 25));
		playerPage.add(label, BorderLayout.NORTH);
		
		JComboBox<Integer> dropdown = new JComboBox<>();
		dropdown.addItem(2);
		dropdown.addItem(3);
		dropdown.addItem(4);
		
		dropdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // <----------------add individual stuff-------------------------->
				int selectedInstruction = (int) dropdown.getSelectedItem();
		        ArrayList<String> names = new ArrayList<>();
		        
		        // Dynamically create player names based on selectedInstruction
		        for (int i = 1; i <= selectedInstruction; i++) {
		            names.add("Player " + i);
		        }
				YahtzeeController controller = new YahtzeeController(names, "none");
				gamePanel(controller);
			}
		});
		
		playerPage.add(dropdown, BorderLayout.CENTER);
		
		JButton backToMain = new JButton("Back to Main Page");
		backToMain.setFont(new Font("Arial", Font.PLAIN, 14));
		backToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMainPanel(); 
			}
		});
		
		playerPage.add(backToMain, BorderLayout.SOUTH);
		
		
		frame.setContentPane(playerPage);
		frame.revalidate();
		frame.repaint();
	}
	
	private void showCpuPanel() {
		// JPanel computerPanel = new JPanel();
		// computerPanel.setBackground(new Color(144, 238, 144));
		// computerPanel.setLayout(new BorderLayout());
		JPanel computerPage = new JPanel();
		computerPage.setBackground(new Color(144, 238, 144));
		computerPage.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("What kind of computer?", JLabel.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 25));
		computerPage.add(label, BorderLayout.NORTH);
		
		String[] types = { "Easy", "Hard"};

		JComboBox<String> computerCombo = new JComboBox<String>(types);
		computerCombo.setSelectedIndex(0);

		computerPage.add(computerCombo);
		computerCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // <----------------add individual stuff-------------------------->
				String selectedInstruction = (String) computerCombo.getSelectedItem();
		        ArrayList<String> names = new ArrayList<>();
		        
		        // Dynamically create player names based on selectedInstruction
		            names.add("Player 1");
					names.add("Computer");
		        
				YahtzeeController controller = new YahtzeeController(names, selectedInstruction);
				gamePanel(controller);
			}
		});

		computerPage.add(computerCombo, BorderLayout.CENTER);
		
		JButton backToMain = new JButton("Back to Main Page");
		backToMain.setFont(new Font("Arial", Font.PLAIN, 14));
		backToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMainPanel(); 
			}
		});
		
		computerPage.add(backToMain, BorderLayout.SOUTH);
		
		frame.setContentPane(computerPage);
		frame.revalidate();
		frame.repaint();
	}
	
	private void showInstructions() {
		JPanel instructions = new JPanel();
		instructions.setBackground(new Color(144, 238, 144));
		instructions.setLayout(new BorderLayout());
		
		JLabel label = new JLabel("How to Play:", JLabel.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 25));
		instructions.add(label, BorderLayout.NORTH);
		
		JTextArea text = new JTextArea();
		text.setEditable(false);
		text.setFont(new Font("Arial", Font.PLAIN, 15));
		text.setBackground(new Color(240, 240, 240));
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		text.setCaretPosition(0);
		
		getText(text);
		
		JScrollPane scrollpane = new JScrollPane(text);
		scrollpane.setPreferredSize(new Dimension(300, 150));
		instructions.add(scrollpane, BorderLayout.CENTER);
		
		JButton backToMain = new JButton("Back to Main Page");
		backToMain.setFont(new Font("Arial", Font.PLAIN, 14));
		backToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMainPanel();
			}
		});
		
		instructions.add(backToMain, BorderLayout.SOUTH);
		
		frame.setContentPane(instructions);
		frame.revalidate();
		frame.repaint();
		
	}
	
	
	private void getText(JTextArea text) {
	    try (InputStream input = getClass().getResourceAsStream("instructions.txt");
	    	     BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
	    	    String line;
	    	    while ((line = reader.readLine()) != null) {
	    	        text.append(line + "\n");
	    	    }
	    	} catch (IOException e) {
	    	    text.append("Error reading the file");
	    	}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new YahtzeeGUI();
			}
		});
		
	}
	
	public void gamePanel(YahtzeeController controller) {
		
		JPanel gamePanel = new JPanel(new BorderLayout());
		
		CupPanel cupPanelClass = new CupPanel(controller);
		JPanel CupPanel = cupPanelClass.getCupPanel();
		
		ScorePanel scorePanelClass = new ScorePanel(controller, this);
		JPanel scorePanel = scorePanelClass.getScorePanel();
		
		JButton backToMain = new JButton("Back to Main Page");
		backToMain.setFont(new Font("Arial", Font.PLAIN, 14));
		backToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMainPanel();
			}
		});
		
		JPanel backPanel = new JPanel(new FlowLayout());
		backPanel.add(backToMain);
		backPanel.setBackground(Color.GREEN);
		
		CupPanel.add(backPanel);
		gamePanel.add(CupPanel, BorderLayout.WEST);
		controller.addObserver(cupPanelClass);
		controller.addObserver(scorePanelClass);
		
		gamePanel.add(scorePanel, BorderLayout.EAST);
		frame.setContentPane(gamePanel);
		frame.revalidate();
		frame.repaint();
	}

}	