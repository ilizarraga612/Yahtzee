import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoringPanel implements Observer {
	// Instance variables for buttons
	private YahtzeeController controller;
	private JPanel scoringPanel;
	private JPanel Labels;
	private JPanel Buttons;

	private JLabel OneL, TwoL, ThreeL, FourL, FiveL, SixL, ThreeKindL, FourKindL, FullHouseL, SmallStraightL,
			LargeStraightL, YahtzeeL, ChanceL; // all labels for score card
	
	private JButton OneB, TwoB, ThreeB, FourB, FiveB, SixB, ThreeKindB, FourKindB, FullHouseB, SmallStraightB, LargeStraightB, YahtzeeB, ChanceB; // all buttons for score card
	private ArrayList<JButton> buttonList = new ArrayList<JButton>();
	
	public ScoringPanel(YahtzeeController controller) {
		this.controller = controller;
		setUp(controller);
	}

	private void setUp(YahtzeeController controller) {
	    // Initialize dice panel
	    this.scoringPanel = new JPanel(new BorderLayout());
	    this.Labels = new JPanel(new GridLayout(13, 1));
	    this.Buttons = new JPanel(new GridLayout(13, 1));

	    this.OneB = new JButton("Ones");
	    buttonList.add(this.OneB);
	    this.Buttons.add(this.OneB);
	    OneB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setScore(SetName.ONES, controller.getPossibleScores().get(0));
				OneB.setEnabled(false);
				OneB.setForeground(Color.BLACK);
				controller.rotateTurn();
			}
		});
	    

	    this.TwoB = new JButton("Twos");
	    buttonList.add(this.TwoB);
	    this.Buttons.add(this.TwoB);
	    TwoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setScore(SetName.TWOS, controller.getPossibleScores().get(1));
				TwoB.setEnabled(false);
				TwoB.setForeground(Color.BLACK);
				controller.rotateTurn();
			}
		});
	    
	    
	    this.ThreeB = new JButton("Threes");
	    buttonList.add(this.ThreeB);
	    this.Buttons.add(this.ThreeB);
	    ThreeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setScore(SetName.THREES, controller.getPossibleScores().get(2));
				ThreeB.setEnabled(false);
				ThreeB.setForeground(Color.BLACK);
				controller.rotateTurn();
			}
		});
	    
	    
	    this.FourB = new JButton("Fours");
	    buttonList.add(this.FourB);
	    this.Buttons.add(this.FourB);
	    FourB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setScore(SetName.FOURS, controller.getPossibleScores().get(3));
				FourB.setEnabled(false);
				FourB.setForeground(Color.BLACK);
				controller.rotateTurn();
			}
		});
	    
	    
	    this.FiveB = new JButton("Fives");
	    buttonList.add(this.FiveB);
	    this.Buttons.add(this.FiveB);
	    FiveB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setScore(SetName.FIVES, controller.getPossibleScores().get(4));
				FiveB.setEnabled(false);
				FiveB.setForeground(Color.BLACK);
				controller.rotateTurn();
			}
		});
	    
	    
	    this.SixB = new JButton("Sixes");
	    buttonList.add(this.SixB);
	    this.Buttons.add(this.SixB);
	    SixB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setScore(SetName.SIXES, controller.getPossibleScores().get(5));
				SixB.setEnabled(false);
				SixB.setForeground(Color.BLACK);
				controller.rotateTurn();
			}
		});
	    
	    
	    this.ThreeKindB = new JButton("Three of a Kind");
	    buttonList.add(this.ThreeKindB);
	    this.Buttons.add(this.ThreeKindB);
	    ThreeKindB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setScore(SetName.THREE_OF_A_KIND, controller.getPossibleScores().get(6));
				ThreeKindB.setEnabled(false);
				ThreeKindB.setForeground(Color.BLACK);
				controller.rotateTurn();
			}
		});
	    
	    
	    this.FourKindB = new JButton("Four of a Kind");
	    buttonList.add(this.FourKindB);
	    this.Buttons.add(this.FourKindB);
	    FourKindB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setScore(SetName.FOUR_OF_A_KIND, controller.getPossibleScores().get(7));
				FourKindB.setEnabled(false);
				FourKindB.setForeground(Color.BLACK);
				controller.rotateTurn();
			}
		});
	    
	    
	    this.FullHouseB = new JButton("Full House");
	    buttonList.add(this.FullHouseB);
	    this.Buttons.add(this.FullHouseB);
	    FullHouseB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setScore(SetName.FULL_HOUSE, controller.getPossibleScores().get(8));
				FullHouseB.setEnabled(false);
				FullHouseB.setForeground(Color.BLACK);
				controller.rotateTurn();
			}
		});
	    
	    
	    this.SmallStraightB = new JButton("Small Straight");
	    buttonList.add(this.SmallStraightB);
	    this.Buttons.add(this.SmallStraightB);
	    SmallStraightB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setScore(SetName.SMALL_STRAIGHT, controller.getPossibleScores().get(9));
				SmallStraightB.setEnabled(false);
				SmallStraightB.setForeground(Color.BLACK);
				controller.rotateTurn();
			}
		});
	    
	    
	    this.LargeStraightB = new JButton("Large Straight");
	    buttonList.add(this.LargeStraightB);
	    this.Buttons.add(this.LargeStraightB);
	    LargeStraightB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setScore(SetName.LARGE_STRAIGHT, controller.getPossibleScores().get(10));
				LargeStraightB.setEnabled(false);
				LargeStraightB.setForeground(Color.BLACK);
				controller.rotateTurn();
			}
		});
	    
	    
	    this.YahtzeeB = new JButton("Yahtzee");
	    buttonList.add(this.YahtzeeB);
	    this.Buttons.add(this.YahtzeeB);
	    YahtzeeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setScore(SetName.YAHTZEE, controller.getPossibleScores().get(11));
				YahtzeeB.setEnabled(false);
				YahtzeeB.setForeground(Color.BLACK);
				controller.rotateTurn();
			}
		});
	    
	    
	    this.ChanceB = new JButton("Chance");
	    buttonList.add(this.ChanceB);
	    this.Buttons.add(this.ChanceB);
	    ChanceB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setScore(SetName.CHANCE, controller.getPossibleScores().get(12));
				ChanceB.setEnabled(false);
				ChanceB.setForeground(Color.BLACK);
				controller.rotateTurn();
			}
		});       
	        
	    
	    this.OneL = new JLabel();
	    this.OneL.setText("Ones");
	    this.Labels.add(this.OneL);

	    this.TwoL = new JLabel();
	    this.TwoL.setText("Twos");
	    this.Labels.add(this.TwoL);

	    this.ThreeL = new JLabel();
	    this.ThreeL.setText("Threes");
	    this.Labels.add(this.ThreeL);

	    this.FourL = new JLabel();
	    this.FourL.setText("Fours");
	    this.Labels.add(this.FourL);

	    this.FiveL = new JLabel();
	    this.FiveL.setText("Fives");
	    this.Labels.add(this.FiveL);

	    this.SixL = new JLabel();
	    this.SixL.setText("Sixes");
	    this.Labels.add(this.SixL);

	    this.ThreeKindL = new JLabel();
	    this.ThreeKindL.setText("Three of a Kind");
	    this.Labels.add(this.ThreeKindL);

	    this.FourKindL = new JLabel();
	    this.FourKindL.setText("Four of a Kind");
	    this.Labels.add(this.FourKindL);

	    this.FullHouseL = new JLabel();
	    this.FullHouseL.setText("Full House");
	    this.Labels.add(this.FullHouseL);

	    this.SmallStraightL = new JLabel();
	    this.SmallStraightL.setText("Small Straight");
	    this.Labels.add(this.SmallStraightL);

	    this.LargeStraightL = new JLabel();
	    this.LargeStraightL.setText("Large Straight");
	    this.Labels.add(this.LargeStraightL);

	    this.YahtzeeL = new JLabel();
	    this.YahtzeeL.setText("Yahtzee");
	    this.Labels.add(this.YahtzeeL);

	    this.ChanceL = new JLabel();
	    this.ChanceL.setText("Chance");
	    this.Labels.add(this.ChanceL);
	    
	    this.scoringPanel.add(Labels, BorderLayout.WEST);
	    this.scoringPanel.add(Buttons, BorderLayout.EAST);
	}


	public JPanel getScoringPanel() {
		return this.scoringPanel;
	}

	private void updateUI() {
		ArrayList<Integer> possibleScores = controller.getPossibleScores();
		List<Integer> scores = controller.getScores();
		for (int i = 0; i < 13; i++) {
			if (controller.getHasBeenScored().get(i) == false) {
				buttonList.get(i).setEnabled(true);
				this.buttonList.get(i).setText(Integer.toString(possibleScores.get(i)));
			} else {
				this.buttonList.get(i).setText(Integer.toString(scores.get(i)));
				buttonList.get(i).setEnabled(false);
			}
			
		}
		
	}
	
	public void update() {
		// Update the UI or logic based on the new controller state
		updateUI();
	}


}