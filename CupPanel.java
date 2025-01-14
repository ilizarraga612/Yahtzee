import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CupPanel implements Observer {

	private JPanel cupPanel; 
	
	private JPanel cupText1Panel, cupText2Panel, cupText3Panel;
	private JLabel currentPlayerLabel, numRollsLeftLabel;
	private DicePanel dicePanelClass;
	private YahtzeeController controller;
	
	public CupPanel (YahtzeeController controller) {
		this.controller = controller;
    	setUp(this.controller);
    }
	
	private void setUp(YahtzeeController controller) {
        // Initialize panels
        cupPanel = new JPanel(new GridLayout(3, 1));
        cupPanel.setBackground(Color.GREEN);

        playerAndRollsLeftPanel();

        this.dicePanelClass = new DicePanel(controller);
		JPanel dicePanel = dicePanelClass.getDicePanel();

        // Add components to cup panel
        cupPanel.add(cupText3Panel);
        cupPanel.add(dicePanel);
        cupPanel.setPreferredSize(new Dimension(310, 0));
	}

	private void playerAndRollsLeftPanel() {
		cupText1Panel = new JPanel(new FlowLayout());
        cupText2Panel = new JPanel(new FlowLayout());
        cupText3Panel = new JPanel(new BorderLayout());
        cupText1Panel.setBackground(Color.GREEN);
        cupText2Panel.setBackground(Color.GREEN);

        // Initialize labels
        currentPlayerLabel = new JLabel("Player 1");
        currentPlayerLabel.setSize(165, 25);
        currentPlayerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        currentPlayerLabel.setBackground(Color.LIGHT_GRAY);
        currentPlayerLabel.setOpaque(true);
        currentPlayerLabel.setVerticalAlignment(JLabel.TOP);
        currentPlayerLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        numRollsLeftLabel = new JLabel("Rolls left: 3");
        numRollsLeftLabel.setFont(new Font("Arial", Font.BOLD, 20));
        numRollsLeftLabel.setBackground(Color.LIGHT_GRAY);
        numRollsLeftLabel.setOpaque(true);
        numRollsLeftLabel.setVerticalAlignment(JLabel.TOP);
        numRollsLeftLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Add labels to panels
        cupText1Panel.add(currentPlayerLabel, BorderLayout.NORTH);
        cupText2Panel.add(numRollsLeftLabel, BorderLayout.CENTER);
        cupText3Panel.add(cupText1Panel, BorderLayout.NORTH);
        cupText3Panel.add(cupText2Panel, BorderLayout.CENTER);
	}
	
	public JPanel getCupPanel() {
		return this.cupPanel;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.dicePanelClass.update(); // update the locked, unlocked, and face of the dice
		this.numRollsLeftLabel.setText("Rolls left: " + this.controller.getRolls()); // update number of Rolls left
		this.currentPlayerLabel.setText(this.controller.getCurrentPlayer()); // get current player
	}

}
