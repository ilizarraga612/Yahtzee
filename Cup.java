/*
 * Name: Cup
 * 
 * This class represents a cup that each player has that contains all the dice,
 * 		saved dice and, unsaved dice for the player
 */

import java.util.ArrayList;
import java.util.Collections;

public class Cup {

	private ArrayList<Die> dice;
	private ArrayList<Die> saved;
	private ArrayList<Die> unsaved;
	
	/*
	 * The normal constructor for the Cup that sets and adds the dice to the cup
	 */
	public Cup() {
		dice = new ArrayList<Die>();
		saved = new ArrayList<Die>();
		unsaved = new ArrayList<Die>();
		
		dice.add(new Die(DieFace.ONE, 0));
		dice.add(new Die(DieFace.TWO, 1));
		dice.add(new Die(DieFace.THREE, 2));
		dice.add(new Die(DieFace.FOUR, 3));
		dice.add(new Die(DieFace.FIVE, 4));
		
		for (Die die : dice) {
			unsaved.add(die);
		}
		roll();
	}

	/*
	 * The constructor that is used for test that sets the dice in the cup to specific dice
	 * 
	 * @param die1 - a die added to the cup
	 * @param die2 - a die added to the cup
	 * @param die3 - a die added to the cup
	 * @param die4 - a die added to the cup
	 * @param die5 - a die added to the cup
	 * 
	 * @pre all parameters are not null
	 * 
	 * @post all will be set correctly
	 */
	public Cup(DieFace die1, DieFace die2, DieFace die3, DieFace die4, DieFace die5) {
		dice = new ArrayList<Die>();
		saved = new ArrayList<Die>();
		unsaved = new ArrayList<Die>();

		
		dice.add(new Die(die1, 0));
		dice.add(new Die(die2, 1));
		dice.add(new Die(die3, 2));
		dice.add(new Die(die4, 3));
		dice.add(new Die(die5, 4));
	}
	
	/*
	 * rolls every dice in the cup
	 */
	public void roll() {
		for (Die curDie: unsaved) {
			curDie.roll();
		}
	}

	/*
	 * a getter for savedDice
	 * 
	 * @return the savedDice for the player
	 */
	public ArrayList<Die> getSavedDice() {
		return (ArrayList<Die>) saved.clone();
	}
	
	/*
	 * a getter for unsavedDice
	 * 
	 * @return the unsavedDice for the player
	 */
	public ArrayList<Die> getUnsavedDice() {
		return (ArrayList<Die>) unsaved.clone();
	}
	
	/*
	 * a getter for dice
	 * 
	 * @return the dice for the player
	 */
	public ArrayList<Die> getDice() {
		return (ArrayList<Die>) dice.clone();
	}
	
	/*
	 * saves a die and removes it from unsaved
	 * 
	 * @param id - the id of the die to save
	 * 
	 * @pre id is in die
	 * 
	 * @post correct die is set correctly
	 */
	public void saveDie(int id) {
		for (Die die : unsaved) {
			if (die.getId() == id) {
				unsaved.remove(die);
				break;
			}		
		}
		
		if (!saved.contains(dice.get(id))) {
			saved.add(dice.get(id));
		}
		
	}
	 
	/*
	 * unsaves a die and removes it from saved
	 *
	 * @param id - the id of the die to unsave
	 * 
	 * @pre id is in die
	 * 
	 * @post correct die is set correctly
	 */
	public void unsaveDie(int id) {
		for (Die die : saved) {
			if (die.getId() == id) {
				saved.remove(die);
				break;
			}		
		}
		
		if (!unsaved.contains(dice.get(id))) {
			unsaved.add(dice.get(id));
		}
	}
	
	/*
	 * getter for a sorted array list of dice
	 *
	 * @return the dice in a sorted array list
	 */
	public ArrayList<Die> getSorted() {
		ArrayList<Die> sortedDice = new ArrayList<Die>();
		for (Die d : dice) {
			sortedDice.add(d);
		}
		Collections.sort(sortedDice);
		return (ArrayList<Die>) sortedDice.clone();
	}
	
	/*
	 * Prints out dice for testing purposes
	 */
	public void displayDice() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Die " + i + ": " + dice.get(i));
		}
	}
	
	/*
	 * resets the dice, saved, and unsaved lists
	 */
	public void resetDice() {
		dice = new ArrayList<Die>();
		saved = new ArrayList<Die>();
		unsaved = new ArrayList<Die>();
		
		dice.add(new Die(DieFace.ONE, 0));
		dice.add(new Die(DieFace.TWO, 1));
		dice.add(new Die(DieFace.THREE, 2));
		dice.add(new Die(DieFace.FOUR, 3));
		dice.add(new Die(DieFace.FIVE, 4));
		
		for (Die die : dice) {
			unsaved.add(die);
		}
		roll();
	}
}