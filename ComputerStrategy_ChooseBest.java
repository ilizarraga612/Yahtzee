/*
 *    Class: ComputerStrategy_ChooseBest
 *    
 *    Purpose: This class extends the player class and adds an extra method
 *    				that plays a round by choosing the slot that gives the most points
 */

import java.util.ArrayList;

public class ComputerStrategy_ChooseBest extends Player {

	private ArrayList<Boolean> scoresAvailable;

	/*
	 *  constructor for the computer that also creates the player class
	 *  
	 *  @param name - name of the player
	 * 	@param cup - cup of the player
	 * 	@param scoreCard - scoreCard of the player
	 * 	@param isComputer - if the player is a computer
	 */
	public ComputerStrategy_ChooseBest(String name, Cup cup, ScoreCard scoreCard, boolean isComputer) {
		super(name, cup, scoreCard, isComputer);

		scoresAvailable = new ArrayList<Boolean>();
		for (int i = 0; i < 13; i++) {
			scoresAvailable.add(false);
		}
	}

	/*
	 *  plays a round of yahtzee by selecting the score that is the max possible
	 *  
	 *  @pre is the players turn to play
	 */
	public void playRound() {
		this.getCup().roll();

		int max = 0;
		
		for (int i = 0; i < scoresAvailable.size(); i++) {
			if (scoresAvailable.get(i) == false) {
				max = i;
				break;
			}
		}

		for (int i = 0; i < scoresAvailable.size(); i++) {
			if (scoresAvailable.get(i) == false && this.evaluate().get(i) > this.evaluate().get(max)) {
				max = i;
			}
		}
		
		this.score(SetName.values()[max], this.evaluate().get(max));
		scoresAvailable.set(max, true);
	}
}