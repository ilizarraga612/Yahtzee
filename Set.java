/*
 *  	Class: Set
 *  
 *  	Purpose: This class represents a set for the Yahtzee game
 */
public class Set {
	private SetName name;
	private int value;
	private boolean isScored;
	
	/*
	 * Constructor for Set that sets its default values and its name and value
	 * 
	 * @param set - the SetName of the current set
	 * @param value - the value of the current set
	 * 
	 * @pre set != null
	 * 
	 * @post set will be instantiated correctly
	 */
	public Set(SetName set, int value) {
		this.isScored = false;
		this.value = value;
		this.name = set;
	}
	
	/*
	 * Adds the score to the set
	 * 
	 * @param score - the score to be added
	 */
	public void score(int score) {
		this.value = score;
        this.isScored = true;
        
    }
	
	/*
	 * resets the set to before it was scored
	 */
	public void reset() {
		this.isScored = false;
		this.value = 0;
	}

	/*
	 * Getter for the name
	 * 
	 * @return the SetName of the class
	 */
	public SetName getName() {
		return name;
	}

	/*
	 * Getter for the value of the class
	 * 
	 * @return the value of the set
	 */
	public int getValue() {
		return value;
	}
	
	/*
	 * Getter for if it is scored
	 * 
	 * @return if isScored is true or not
	 */
	public boolean isScored() {
		return isScored;
	}
	
	
	
}
