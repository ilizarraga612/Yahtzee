

//ScorePanel should be a JPanel that displas the scorecard for the current yahtzee game.
//It should display the current score for each player. And update after each move
// ScorePanel also needs an exit button that allows user to click and will take to the 
// game over screen.

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ScorePanel implements Observer {
	private YahtzeeController controller;
	private YahtzeeGUI yahtzeeGUI;
	private JPanel totalScorePanel;
	private JLabel tableTitle;
	private JButton exitButton;
	
	private ScoringPanel scoringPanel;
	private JPanel scorePanel;
	
	private Map<String,JLabel> scoreLabels;
	
	
	public ScorePanel(YahtzeeController controller, YahtzeeGUI yahtzeeGUI) {
		this.controller = controller;
		this.yahtzeeGUI = yahtzeeGUI;
		setUp();
	}
	
	//should init the scorePnale panel and have a blank
	// scorecard fro each active player, and an exit button
	private void setUp() {
	    scorePanel = new JPanel(new BorderLayout());
	    
	    // Use BorderLayout for totalScorePanel to allow easier placement of components
	    totalScorePanel = new JPanel(new BorderLayout());
	    totalScorePanel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));

	    // Title label setup
	    tableTitle = new JLabel("Score Card", JLabel.CENTER);
	    tableTitle.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 25));
	    totalScorePanel.add(tableTitle, BorderLayout.NORTH);

	    // Player score table setup
	    JPanel playerTable = new JPanel();
	    playerTable.setLayout(new GridLayout(controller.getNames().size(), 1));
	    totalScorePanel.add(playerTable, BorderLayout.CENTER);
	    
	    
	    HashMap<String, String> totalScores = controller.getTotalScores();
	    scoreLabels = new HashMap<>();
	    for (String name : controller.getNames()) {
	        JLabel scoreLabel = new JLabel(totalScores.get(name));
	        scoreLabels.put(name, scoreLabel);
	        playerTable.add(scoreLabel);
	    }

	    // Exit button setup
	    exitButton = new JButton("Exit");
	    exitButton.addActionListener(e -> exitButtonClicked());
	    totalScorePanel.add(exitButton, BorderLayout.SOUTH);
	    
	    // Scoring panel setup
	    scoringPanel = new ScoringPanel(this.controller);
	    
	    // Add scorePanel to the main panel
	    scorePanel.add(totalScorePanel, BorderLayout.EAST);
	    scorePanel.add(scoringPanel.getScoringPanel(), BorderLayout.WEST);
	    update();
	}
	
	//navigate to game over panel/screen when exit is clicked
	private void exitButtonClicked() {
		JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(scorePanel);
		frame.getContentPane().removeAll();
		
		EndPanel endPanel = new EndPanel(controller, yahtzeeGUI);
		frame.getContentPane().add(endPanel.getEndPanel());
		frame.revalidate();
		frame.repaint();
		

	}

	//update scores for all current players
	public void updateScore() {
		this.scoringPanel.update();
		HashMap<String, String> totalScores = controller.getTotalScores();
		
		for (String name : controller.getNames()) {
			JLabel scoreLabel = scoreLabels.get(name);
			if (scoreLabel != null) {
				scoreLabel.setText(totalScores.get(name));
			}
		}
	}
	
	// return scorePanel
	public JPanel getScorePanel() {
		return scorePanel;
	}

	@Override
	public void update() {
		updateScore();
		// TODO Auto-generated method stub
		if (controller.isOver()) {
			exitButtonClicked();
		}
		
	}
	


}