/*
 *    Class: ComputerStrategy_ChooseFirst
 *    
 *    Purpose: This class extends the player class and adds an extra method
 *    				that plays a round by choosing the first slot that will
 *    				score points for the computer
 */

import java.util.ArrayList;

public class ComputerStrategy_ChooseFirst extends Player {
	
	private ArrayList<Boolean> scoresAvailable;

	/*
	 *  constructor for the computer that also creates the player class
	 *  
	 *  @param name - name of the player
	 * 	@param cup - cup of the player
	 * 	@param scoreCard - scoreCard of the player
	 * 	@param isComputer - if the player is a computer
	 */
	public ComputerStrategy_ChooseFirst(String name, Cup cup, ScoreCard scoreCard, boolean isComputer) {
		super(name, cup, scoreCard, isComputer);

		scoresAvailable = new ArrayList<Boolean>();
		for (int i = 0; i < 13; i++) {
			scoresAvailable.add(false);
		}
	}

	/*
	 *  plays a round of yahtzee by selecting the score that is first available
	 *  
	 *  @pre is the players turn to play
	 */
	public void playRound() {
		this.getCup().roll();
		
		boolean flag = false;
		
		for (int i = 0; i < scoresAvailable.size(); i++) {
			if (scoresAvailable.get(i) == false && this.evaluate().get(i) != 0 ) {
				score(SetName.values()[i], this.evaluate().get(i));
				flag = true;
				scoresAvailable.set(i, true);
				break;
			}
		}

		if (!flag) {
			for (int i = 0; i < scoresAvailable.size(); i++) {
				if (scoresAvailable.get(i) == false) {
					score(SetName.values()[i], this.evaluate().get(i));
					scoresAvailable.set(i, true);
					break;
				}
			}
		}
	}
}
