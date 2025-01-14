/*
 * 			Class: ScoreCard
 * 	
 * 			Purpose: This class represent a score card for each player and holds score for them
 */
import java.util.ArrayList;

public class ScoreCard {
	private ArrayList<Set>scores = new ArrayList<Set>();
    private int totalScore;
    private int upperScore;
    private int lowerScore;
    private int bonus;
    private int yahtzeeBonus;
    private ArrayList<Integer> scoreValues = new ArrayList<Integer>();
    
    /*
     * Constructor for ScoreCard that sets all default values
     */
	public ScoreCard() {
		this.totalScore = 0;
		this.upperScore = 0;
		this.lowerScore = 0;
		this.bonus = 0;
		this.yahtzeeBonus = 0;
		for (int i = 0; i < 13; i++) {
			scoreValues.add(0);
		}
	}
	
	/*
	 * Adds score to score card
	 * 
	 * @param setName - the name of the set you wish to score to
	 * @param scoreToAdd - the score you wish to add to the set
	 * 
	 * @pre setName != null
	 * 
	 * @post set will be added
	 */
	public void addScore(SetName setName, int scoreToAdd) {
		for (Set set : scores) {
			if(set.getName() == setName) {
				// avoids rewriting scores, maybe add an exception?
			}
		}
		scoreValues.set(setName.ordinal(), scoreToAdd);
		Set newSet = new Set(setName,0);
		newSet.score(scoreToAdd);
		scores.add(newSet);
		// claculateScore() here to keep the gui updated each move
		calculateScore();
		}
	
	/*
	 * calculates the upper score of the score card
	 */
	private void calculateUpperScore() {
		upperScore = 0;
		for (Set set : scores) {
			if (set.getName() == SetName.ONES || set.getName() == SetName.TWOS || set.getName() == SetName.THREES
					|| set.getName() == SetName.FOURS || set.getName() == SetName.FIVES
					|| set.getName() == SetName.SIXES) {
				upperScore += set.getValue();
			}
		}
	}
	
	/*
	 * calculates the lower score of the score card
	 */
	private void calculateLowerScore() {
		lowerScore = 0;
		for (Set set : scores) {
			if (set.getName() == SetName.THREE_OF_A_KIND || set.getName() == SetName.FOUR_OF_A_KIND
					|| set.getName() == SetName.FULL_HOUSE || set.getName() == SetName.SMALL_STRAIGHT
					|| set.getName() == SetName.LARGE_STRAIGHT || set.getName() == SetName.YAHTZEE
					|| set.getName() == SetName.CHANCE) {
				lowerScore += set.getValue();
			}
		}
	}
	
	/*
	 * Adds bonus points if the upper score card is >= 63
	 */
	private void calculateBonus() {
		if (upperScore >= 63) {
			bonus = 35;
		}
	}
	
	/*
	 *  calculate total score by calling other calculate methods
	 */
	private void calculateScore() {
		calculateUpperScore();
		calculateLowerScore();
		calculateBonus();
		totalScore = upperScore + lowerScore + bonus + (yahtzeeBonus * 100);
	}
	
	/*
	 * Getter for total score
	 * 
	 * @return the total score currently
	 */
	public int getTotalScore() {
		calculateScore();
		return totalScore;
	}

	/*
	 * Getter for the sets of scores
	 */
	public ArrayList<Set> getScores() {
		return (ArrayList<Set>) this.scores.clone();
	}
	
	/*
	 * getter for the bonus
	 */
	public Integer getBonus() {
		return bonus;
	}
	
	/*
	 * Getter for scoreValues
	 * 
	 * @return an array list of scores in the score card
	 */
	public ArrayList<Integer> getScoreValues() {
		return (ArrayList<Integer>) scoreValues.clone();
	}

	/*
	 * increments yahtzeeBonus by 1
	 */
	public void incrYahtzeeBonus() {
		this.yahtzeeBonus++;
	}
}