/*
 *    Class: Player
 *    
 *    Purpose: This class represents a single player and holds the information
 *    		   necessary for a player in Yahtzee
 */

import java.util.ArrayList;
import java.util.List;

public class Player {
	private final Cup cup;
	private final ScoreCard scoreCard;
	private final String name;
	private final boolean isComputer;
	private int rolls;
	private final ArrayList<Boolean> hasBeenScored = new ArrayList<Boolean>();

	/*
	 *  constructor for Player class
	 *  
	 *  @param name - name of the player
	 * 	@param cup - cup of the player
	 * 	@param scoreCard - scoreCard of the player
	 * 	@param isComputer - if the player is a computer
	 * 
	 * 	@pre name, cup and scoreCard != null
	 * 
	 *  @post Player will be made correctly
	 */
	public Player(String name, Cup cup, ScoreCard scoreCard, boolean isComputer) {
		this.name = name;
		this.cup = cup;
		this.scoreCard = scoreCard;
		this.isComputer = isComputer;
		this.rolls = 3;
		
	    for (int i = 0; i < 13; i++) {
	    	hasBeenScored.add(false);
	    }

	}

	/*
	 * calls helper methods to add potential scores to a list and returns it
	 *
	 * @return returns a list of the scores possible
	 *
	 * @pre cup has been rolled
	 * 
	 * @post list of scores will be returned
	 */
	public List<Integer> evaluate() {
	    ArrayList<Integer> scores = new ArrayList<Integer>();
	    
	    ArrayList<Die> sortedDice = this.cup.getSorted(); // Ensure cup is sorted if needed

	    scores.add(evaluateOnes(sortedDice));
	    scores.add(evaluateTwos(sortedDice));
	    scores.add(evaluateThrees(sortedDice));
	    scores.add(evaluateFours(sortedDice));
	    scores.add(evaluateFives(sortedDice));
	    scores.add(evaluateSixes(sortedDice));
	    scores.add(evaluateThreeOfAKind(sortedDice));
	    scores.add(evaluateFourOfAKind(sortedDice));
	    scores.add(evaluateFullHouse(sortedDice));
	    scores.add(evaluateSmallStraight(sortedDice));
	    scores.add(evaluateLargeStraight(sortedDice));
	    scores.add(evaluateYahtzee(sortedDice));
	    scores.add(evaluateChance(sortedDice));

	    return scores;
	}

	/*
	 *  evaluates scores possible from ones
	 *  
	 *  @return the integer value of the score possible from ones
	 */
	private Integer evaluateOnes(ArrayList<Die> sortedDice) {
		Integer count = 0;
		for (int i = 0; i < sortedDice.size(); i++) {
			if (sortedDice.get(i).getFace() == DieFace.ONE) {
				count += 1;
			}
		}
		return count;
	}

	/*
	 *  evaluates scores possible from Twos
	 *  
	 *  @return the integer value of the score possible from twos
	 */
	private Integer evaluateTwos(ArrayList<Die> sortedDice) {
		Integer count = 0;
		for (int i = 0; i < sortedDice.size(); i++) {
			if (sortedDice.get(i).getFace() == DieFace.TWO) {
				count += 2;
			}
		}
		return count;
	}

	/*
	 *  evaluates scores possible from Threes
	 *  
	 *  @return the integer value of the score possible from threes
	 */
	private Integer evaluateThrees(ArrayList<Die> sortedDice) {
		Integer count = 0;
		for (int i = 0; i < sortedDice.size(); i++) {
			if (sortedDice.get(i).getFace() == DieFace.THREE) {
				count += 3;
			}
		}
		return count;
	}

	/*
	 *  evaluates score possible from Fours
	 *  
	 *  @return the integer value of the score possible from fours
	 */
	private Integer evaluateFours(ArrayList<Die> sortedDice) {
		Integer count = 0;
		for (int i = 0; i < sortedDice.size(); i++) {
			if (sortedDice.get(i).getFace() == DieFace.FOUR) {
				count += 4;
			}
		}
		return count;
	}

	/*
	 *  evaluates scores possible from Fives
	 *  
	 *  @return the integer value of the score possible from fives
	 */
	private Integer evaluateFives(ArrayList<Die> sortedDice) {
		Integer count = 0;
		for (int i = 0; i < sortedDice.size(); i++) {
			if (sortedDice.get(i).getFace() == DieFace.FIVE) {
				count += 5;
			}
		}
		return count;
	}

	/*
	 *  evaluates scores possible from Sixes
	 *  
	 *  @return the integer value of the score possible from sixes
	 */
	private Integer evaluateSixes(ArrayList<Die> sortedDice) {
		Integer count = 0;
		for (int i = 0; i < sortedDice.size(); i++) {
			if (sortedDice.get(i).getFace() == DieFace.SIX) {
				count += 6;
			}
		}
		return count;
	}

	/*
	 *  evaluates scores possible from 3 of a kind
	 *  
	 *  @return the integer value of the score possible from 3 of a kind
	 */
	private Integer evaluateThreeOfAKind(ArrayList<Die> sortedDice) {
		for (int i = 0; i < sortedDice.size() - 2; i++) {
			if (sortedDice.get(i).getFace() == sortedDice.get(i + 1).getFace()
					&& sortedDice.get(i).getFace() == sortedDice.get(i + 2).getFace()) {
				return (sortedDice.get(0).getFace().ordinal() + 1)
						+ (sortedDice.get(1).getFace().ordinal() + 1)
						+ (sortedDice.get(2).getFace().ordinal() + 1)
						+ (sortedDice.get(3).getFace().ordinal() + 1)
						+ (sortedDice.get(4).getFace().ordinal() + 1);
			}
		}
		return 0;
	}

	/*
	 *  evaluates scores possible from 4 of a kind
	 *  
	 *  @return the integer value of the score possible from 4 of a kind
	 */
	private Integer evaluateFourOfAKind(ArrayList<Die> sortedDice) {
		for (int i = 0; i < sortedDice.size() - 3; i++) {
			if (sortedDice.get(i).getFace() == sortedDice.get(i + 1).getFace() && sortedDice.get(i).getFace() == sortedDice.get(i + 2).getFace() && sortedDice.get(i).getFace() == sortedDice.get(i + 3).getFace()) {
				return (sortedDice.get(0).getFace().ordinal() + 1) + (sortedDice.get(1).getFace().ordinal() + 1) + (sortedDice.get(2).getFace().ordinal() + 1) + (sortedDice.get(3).getFace().ordinal() + 1) + (sortedDice.get(4).getFace().ordinal() + 1);
			}
		}
		return 0;
	}

	/*
	 *  evaluates scores possible from full house
	 *  
	 *  @return the integer value of the score possible from full house
	 */
	private Integer evaluateFullHouse(ArrayList<Die> sortedDice) {
		if (sortedDice.get(0).getFace() == sortedDice.get(1).getFace()
				&& sortedDice.get(2).getFace() == sortedDice.get(3).getFace()
				&& sortedDice.get(3).getFace() == sortedDice.get(4).getFace()
				|| sortedDice.get(3).getFace() == sortedDice.get(4).getFace()
						&& sortedDice.get(0).getFace() == sortedDice.get(1).getFace()
						&& sortedDice.get(1).getFace() == sortedDice.get(2).getFace()) {
			return 25;
		}
		return 0;
	}

	/*
	 * evaluates scores possible from small straight
	 * 
	 * @return the integer value of the score possible from small straight
	 */
	private Integer evaluateSmallStraight(ArrayList<Die> sortedDice) {
		ArrayList<DieFace> diesNoDuplicates = new ArrayList<DieFace>();
		for (int i = 0; i < sortedDice.size(); i++) {
			if (!diesNoDuplicates.contains(sortedDice.get(i).getFace())) {
				diesNoDuplicates.add(sortedDice.get(i).getFace());
			}
		}

		if (diesNoDuplicates.size() < 4) {
			return 0;
		}

		if (diesNoDuplicates.get(0).getVal() == diesNoDuplicates.get(1).getVal() - 1
				&& diesNoDuplicates.get(1).getVal() == diesNoDuplicates.get(2).getVal() - 1
				&& diesNoDuplicates.get(2).getVal() == diesNoDuplicates.get(3).getVal() - 1) {
			return 30;
		}
		return 0;
	}

	/*
	 *  evaluates scores possible from large straight
	 *  
	 *  @return the integer value of the score possible from large straight
	 */
	private Integer evaluateLargeStraight(ArrayList<Die> sortedDice) {
		if (sortedDice.get(0).getFace().ordinal() == sortedDice.get(1).getFace().ordinal() - 1
				&& sortedDice.get(1).getFace().ordinal() == sortedDice.get(2).getFace().ordinal() - 1
				&& sortedDice.get(2).getFace().ordinal() == sortedDice.get(3).getFace().ordinal() - 1
				&& sortedDice.get(3).getFace().ordinal() == sortedDice.get(4).getFace().ordinal() - 1) {
			return 40;
		}
		return 0;
	}

	/*
	 *  evaluates scores possible from yahtzee
	 *  
	 *  @return the integer value of the score possible from yahtzee
	 */
	private Integer evaluateYahtzee(ArrayList<Die> sortedDice) {
		if (sortedDice.get(0).getFace().ordinal() == sortedDice.get(1).getFace().ordinal()
				&& sortedDice.get(1).getFace().ordinal() == sortedDice.get(2).getFace().ordinal()
				&& sortedDice.get(2).getFace().ordinal() == sortedDice.get(3).getFace().ordinal()
				&& sortedDice.get(3).getFace().ordinal() == sortedDice.get(4).getFace().ordinal()) {
			return 50;
		}
		return 0;
	}

	/*
	 *  evaluates scores possible from chance
	 *  
	 *  @return the integer value of the score possible from chance
	 */
	private Integer evaluateChance(ArrayList<Die> sortedDice) {
		return (sortedDice.get(0).getFace().ordinal() + 1) + (sortedDice.get(1).getFace().ordinal() + 1)
				+ (sortedDice.get(2).getFace().ordinal() + 1)
				+ (sortedDice.get(3).getFace().ordinal() + 1)
				+ (sortedDice.get(4).getFace().ordinal() + 1);
	}

	/* 
	 * adds a score to the players score card
	 * 
	 * @param setName is the SetName of the set you want to score
	 * @param value is the score of the set you want to score
	 */
	public void score(SetName setName, int value) {
		if (this.scoreCard.getScoreValues().get(11) == 50 && evaluate().get(11) == 50) {
			this.scoreCard.incrYahtzeeBonus();
		}

		this.scoreCard.addScore(setName, value);
		this.hasBeenScored.set(setName.ordinal(), true);
	}


	/*
	 *  returns a players cup
	 *  
	 *  @return cup of the player
	 */
	public Cup getCup() {
		return this.cup;
	}

	/*
	 *  returns a players name
	 *  
	 *  @return name of the player
	 */
	public String getName() {
		return this.name;
	}

	/*
	 *  returns a players score card
	 *  
	 *  @return scoreCard of the player
	 */
	public ScoreCard getScoreCard() {
		return this.scoreCard;
	}

	/*
	 *  returns a players rolls
	 *  
	 *  @return rolls for the player
	 */
	public int getRolls() {
		return this.rolls;
	}

	/*
	 *  decrements rolls by 1
	 */
	public void decrRolls() {
		if (rolls > 0) {
			this.rolls--;
		}
	}

	/*
	 *  sets rolls to 3
	 */
	public void resetRolls() {
		this.rolls = 3;
	}

	/*
	 * returns isComputer
	 * 
	 * @return if the player isComputer
	 */
	public boolean isComputer() {
		return this.isComputer;
	}
	
	/*
	 * resets all dice in the players cup
	 */
	public void resetDice() {
		this.cup.resetDice();
	}
	
	/*
	 * Getter for hasBeenScored
	 * 
	 * @return an array list of what sets have been scored
	 */
	public ArrayList<Boolean> getHasBeenScored() {
		return hasBeenScored;
	}
}
