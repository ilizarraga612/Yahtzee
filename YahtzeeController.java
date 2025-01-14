/*
 *			Class: YahtzeeController
 *
 * 			Purpose: This class is the controller which acts as the way the GUI speaks to the model
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.JLabel;

public class YahtzeeController {

	private Game game;
	private ArrayList<String> names;
	
	/*
	 * Constructor for the controller which creates the game 
	 * 
	 * @param names - The array list of the names of the players
	 * @param isComputer - The type of computer the game uses
	 * 
	 * @pre names != null, type of computer == none, Easy, Hard
	 */
	public YahtzeeController (ArrayList<String> names, String typeOfComputer) {
		this.game = new Game(names, typeOfComputer);
		this.names = names;
	}
	
	/*
	 * Calls lock dice in the game
	 * 
	 * @param index - index of the die you wish to lock 
	 */
	public void lockDice(int index) {
		game.lockDice(index);
	}
	
	/*
	 * Calls unLockDice in the game
	 * 
	 * @param index - index of the die you wish to unlock
	 */
	public void unLockDice(int index) {
		game.unLockDice(index);
	}
	
	/*
	 * calls roll in the game
	 */
	public void roll() {
		game.roll();
	}
	
	/*
	 * calls setScoreCard in the game
	 *
	 * @param name - the SetName you wish to add to the score card
	 * @param score - the score of the set you wish to add to the score card
	 */
	public void setScore(SetName name, int score) {
		game.setScoreCard(name, score);;
	}
		
	/*
	 * calls possibleScore in the game
	 * 
	 * @return a copy of the possible scores
	 */
	public ArrayList<Integer> getPossibleScores() {
		ArrayList<Integer> possibleScores = (ArrayList<Integer>) game.possibleScores();
		ArrayList<Integer> copy = new ArrayList<Integer>();
		for (int score: possibleScores) {
			copy.add(score);
		}
		return copy;
	}
	
	/*
	 * calls the getScores in the game
	 * 
	 * @return the list of the scores
	 */
	public ArrayList<Integer> getScores() {
		return game.getScores();
	}
	
	/*
	 * calls addObserver in the game
	 * 
	 * @param o - the observer to add
	 */
	public void addObserver(Observer o) {
		game.addObserver(o);
	}
	
	/*
	 * calls removeObserver in the game
	 * 
	 * @param o - the observer to remove
	 */
	public void removeObserver(Observer o) {
		game.removeObserver(o);
	}
		
	/*
	 * Calls currentPlayerTurn in the game
	 * 
	 * @return the name of the current player
	 */
	public String getCurrentPlayer() {
		return game.currentPlayerTurn();
	}
	
	/*
	 * Calls getRolls in the game
	 * 
	 * @return the number of rolls of the current player
	 */
	public int getRolls() {
		return game.getRolls();
	}
	
	/*
	 * Calls getCup in the game
	 * 
	 * @return the cup of the current player
	 */
	public Cup getCup() {
		return this.game.getCup();
	}
	
	/*
	 * Calls rotateTurn in the game
	 */
	public void rotateTurn() {
		this.game.rotateTurn();
	}
	
	/*
	 * Calls getTotalScore in the game
	 * 
	 * @return the total score of the current player
	 */
	public int getTotalScore() {
		return this.game.getTotalScore();
	}
	
	/*
	 * Getter for a hash map of player names and their total scores
	 * 
	 * @return a hash map of player names and their scores
	 */
	public HashMap<String, String> getTotalScores() {
		return this.game.getTotalScores();	
	}
	
	/*
	 * Getter for names
	 * 
	 * @return a clone of names
	 */
	public ArrayList<String> getNames() {
		return (ArrayList<String>) names.clone();
	}
	
	/*
	 * Calls getHasBeenGraded in the game
	 * 
	 * @return an array list of the scored sets for current player
	 */
	public ArrayList<Boolean> getHasBeenScored() {
		return (ArrayList<Boolean>) game.getHasBeenScored().clone();
	}
	
	/*
	 * calls isOver in the game
	 * 
	 * @return whether or not a game is over
	 */
	public boolean isOver() {
		return this.game.isOver();
	}
}


