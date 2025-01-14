import java.awt.BorderLayout;
import java.util.HashMap;

import javax.swing.*;
import java.awt.*;



public class EndPanel {
	// private YahtzeeController controller;
	private JPanel endPanel;
	private YahtzeeGUI yahtzeeGUI;
	
	public EndPanel(YahtzeeController controller, YahtzeeGUI yahtzeeGUI) {
        this.yahtzeeGUI = yahtzeeGUI;
        this.endPanel = new JPanel(new BorderLayout());
        
       //panel title label setup
       JLabel panelTitle = new JLabel("Game Over!", JLabel.CENTER);
       panelTitle.setBackground(new Color(0,102,0));
       panelTitle.setFont(new Font("Arial", Font.BOLD, 25));
       endPanel.add(panelTitle, BorderLayout.NORTH);
       endPanel.setBackground(new Color(0,102,0));
       
       //final scores display
       JTextArea finalScores = new JTextArea();
       finalScores.setEditable(false);
       finalScores.setFont(new Font("Arial", Font.PLAIN, 20));
       finalScores.setBackground(new Color(102,255,102));
       
       //add final scores of players to finalScores text area
       StringBuffer scores = new StringBuffer();
       scores.append("Final Scores:\n");
       HashMap<String, String> totalScores = controller.getTotalScores();
       for (String name : controller.getNames()) {
           scores.append(totalScores.get(name) + " ");
           
       }
       finalScores.setText(scores.toString());
       endPanel.add(finalScores, BorderLayout.CENTER);
       
      
       // set up play again button
       JButton playAgain = new JButton("Play Again");
       playAgain.addActionListener(e -> playAgainClicked());
       
       //set up final exit button
       JButton exitGameButton = new JButton("Exit Game");
       exitGameButton.addActionListener(e -> exitGameButtonClicked());
       
       // add buttons in new panel so both can be .SOUTH
       JPanel theButtons = new JPanel();
       theButtons.add(playAgain);
       theButtons.add(exitGameButton);
       endPanel.add(theButtons, BorderLayout.SOUTH);
       
       
    }

	//handle action for exit button
	private void exitGameButtonClicked() {
		System.exit(0);
	}

	//use YahtzeeGUI method to start new game
	private void playAgainClicked() {
		yahtzeeGUI.showMainPanel();
	}
	
	//return endPanel
	public JPanel getEndPanel() {
		return endPanel;
	}
	
}