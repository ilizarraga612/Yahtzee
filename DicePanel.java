import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DicePanel implements Observer {
    // Instance variables for buttons
    private JButton dice1, dice2, dice3, dice4, dice5;
    private JButton dice11, dice22, dice33, dice44, dice55;
    private JButton rollButton;
    
    private JPanel dicePanel;
    private JPanel savedDicePanel, unsavedDicePanel, rollButtonPanel;
    
    private YahtzeeController controller;
    
    private ImageIcon[] dice_PNGs;
    
    public DicePanel (YahtzeeController controller) {
    	this.controller = controller;
    	setUp(controller);
    }
    
	private void setUp(YahtzeeController controller) {
		// Initialize dice panel
        dicePanel = new JPanel(new GridLayout(3, 1));
        dicePanel.setBackground(Color.GREEN);

        // Create pathway to PNGs
        this.dice_PNGs = new ImageIcon[6];
        String[] dicePaths = {
            "/dice_one.png", "/dice_two.png", "/dice_three.png",
            "/dice_four.png", "/dice_five.png", "/dice_six.png"
        };

        // Resize each icon to 50x50
        for (int i = 0; i < dice_PNGs.length; i++) {
            ImageIcon originalIcon = new ImageIcon(getClass().getResource(dicePaths[i]));
            Image resizedImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            dice_PNGs[i] = new ImageIcon(resizedImage);
        }

        // Initialize buttons
        dice1 = new JButton(dice_PNGs[0]);
        dice2 = new JButton(dice_PNGs[1]);
        dice3 = new JButton(dice_PNGs[2]);
        dice4 = new JButton(dice_PNGs[3]);
        dice5 = new JButton(dice_PNGs[4]);


        dice11 = new JButton(dice_PNGs[0]);
        dice22 = new JButton(dice_PNGs[1]);
        dice33 = new JButton(dice_PNGs[2]);
        dice44 = new JButton(dice_PNGs[3]);
        dice55 = new JButton(dice_PNGs[4]);


        rollButton = new JButton("Roll Dice");
        
        // Initialize saved dice panel
        savedDicePanel = new JPanel(new FlowLayout());
        savedDicePanel.add(dice1);
        savedDicePanel.add(dice2);
        savedDicePanel.add(dice3);
        savedDicePanel.add(dice4);
        savedDicePanel.add(dice5);

        savedDicePanel.setBackground(Color.GREEN);

        // set dimensions
        dice1.setPreferredSize(new Dimension(50, 50));
		dice2.setPreferredSize(new Dimension(50, 50));
		dice3.setPreferredSize(new Dimension(50, 50));
		dice4.setPreferredSize(new Dimension(50, 50));
		dice5.setPreferredSize(new Dimension(50, 50));
		
		dice1.setVisible(false);
		dice2.setVisible(false);
		dice3.setVisible(false);
		dice4.setVisible(false);
		dice5.setVisible(false);
		
        // Initialize unsaved dice panel
        unsavedDicePanel = new JPanel(new FlowLayout());
        unsavedDicePanel.add(dice11);
        unsavedDicePanel.add(dice22);
        unsavedDicePanel.add(dice33);
        unsavedDicePanel.add(dice44);
        unsavedDicePanel.add(dice55);

        unsavedDicePanel.setBackground(Color.GREEN);

        // set dimensions
        dice11.setPreferredSize(new Dimension(50, 50));
		dice22.setPreferredSize(new Dimension(50, 50));
		dice33.setPreferredSize(new Dimension(50, 50));
		dice44.setPreferredSize(new Dimension(50, 50));
		dice55.setPreferredSize(new Dimension(50, 50));
		
        // Initialize roll button panel
        rollButtonPanel = new JPanel(new FlowLayout());
        rollButtonPanel.setBackground(Color.GREEN);
        rollButtonPanel.add(rollButton);
        rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.roll();
			}
		});

        // Add components to dice panel
        dicePanel.add(unsavedDicePanel, BorderLayout.NORTH);
        dicePanel.add(rollButtonPanel, BorderLayout.CENTER);
        dicePanel.add(savedDicePanel, BorderLayout.SOUTH);
        
        // add action listioner
        dice1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.lockDice(0);
			}
		});
        
        // add action listioner
        dice2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.lockDice(1);
			}
		});
        
        // add action listioner
        dice3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.lockDice(2);
			}
		});
        
        // add action listioner
        dice4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.lockDice(3);
			}
		});
        
        // add action listioner
        dice5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.lockDice(4);
			}
		});
        
        // add action listioner
        dice11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.unLockDice(0);
			}
		});
        
        // add action listioner
        dice22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.unLockDice(1);
			}
		});
        
        // add action listioner
        dice33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.unLockDice(2);
			}
		});
        
        // add action listioner
        dice44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.unLockDice(3);
			}
		});
        
        // add action listioner
        dice55.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.unLockDice(4);
			}
		});
        updateUI();
        
	}
	
	
	private void updateUI() {
		
		// TODO Auto-generated method stub
		Cup c = this.controller.getCup();
		ArrayList<Die> savedDice = c.getSavedDice();
		ArrayList<Die> unSavedDice = c.getUnsavedDice();
		
		// set visibility for unsaved dice
		for (Die die : unSavedDice) {
			
			int id = die.getId();
			int face = die.getValue() - 1;
			if (id == 0) {
				dice1.setIcon(dice_PNGs[face]);
				dice11.setIcon(dice_PNGs[face]);
				dice1.setVisible(false);
				dice11.setVisible(true);
				this.dicePanel.revalidate();
				this.dicePanel.repaint();
			} else if (id == 1) {
				dice2.setIcon(dice_PNGs[face]);
				dice22.setIcon(dice_PNGs[face]);
				dice2.setVisible(false);
				dice22.setVisible(true);
			} else if (id == 2) {
				dice3.setIcon(dice_PNGs[face]);
				dice33.setIcon(dice_PNGs[face]);
				dice3.setVisible(false);
				dice33.setVisible(true);
			} else if (id == 3) {
				dice4.setIcon(dice_PNGs[face]);
				dice44.setIcon(dice_PNGs[face]);
				dice4.setVisible(false);
				dice44.setVisible(true);
			} else if (id == 4) {
				dice5.setIcon(dice_PNGs[face]);
				dice55.setIcon(dice_PNGs[face]);
				dice5.setVisible(false);
				dice55.setVisible(true);
			} 
		}
		
		// set visibilty for saved dice
		for (Die die : savedDice) {
			int id = die.getId();
			int face = die.getValue() - 1; // makes the index match the corresponding icon
			if (id == 0) {
				dice1.setIcon(dice_PNGs[face]);
				dice11.setIcon(dice_PNGs[face]);
				dice1.setVisible(true);
				dice11.setVisible(false);
			} else if (id == 1) {
				dice2.setIcon(dice_PNGs[face]);
				dice22.setIcon(dice_PNGs[face]);
				dice2.setVisible(true);
				dice22.setVisible(false);
			} else if (id == 2) {
				dice3.setIcon(dice_PNGs[face]);
				dice33.setIcon(dice_PNGs[face]);
				dice3.setVisible(true);
				dice33.setVisible(false);
			} else if (id == 3) {
				dice4.setIcon(dice_PNGs[face]);
				dice44.setIcon(dice_PNGs[face]);
				dice4.setVisible(true);
				dice44.setVisible(false);
			} else if (id == 4) {
				dice5.setIcon(dice_PNGs[face]);
				dice55.setIcon(dice_PNGs[face]);
				dice5.setVisible(true);
				dice55.setVisible(false);
 
			} 
		}
	}

	public JPanel getDicePanel() {
		return dicePanel;
	}
	public void update() {
        // Update the UI or logic based on the new controller state
        updateUI();
    }

	


}
