/*
 * 			Class: Die
 * 
 * 			Purpose: This class represents a single Die
 */

public class Die implements Comparable<Die> {

	private DieFace curVal;
	private int id;
	
	/*
	 * Constructor for the die by rolling the die
	 */
	public Die(){
		roll(); //each die needs to have a value when initialized
	}
	
	/*
	 * Constructor for the die that sets the Die manually
	 * 
	 * @param value - The DieFace of the die you wish to set
	 * @param id - The id of the die 
	 * 
	 * @pre value != null
	 * 
	 * @post die will be made correctly
	 */
	public Die(DieFace value, int id) {
		curVal = value;
		this.id = id;
	}
	
	/*
	 * Rolls the die and sets the value to a random DieFace
	 */
	public void roll() {
		int randIdx = (int) (Math.random() * 6);
		curVal = DieFace.values()[randIdx];
	}
	
	/*
	 * Getter for the value of the die
	 * 
	 * @return the integer value of the die
	 */
	public int getValue() {
		return curVal.getVal();
	}
	
	/*
	 * Getter for the face of the die
	 * 
	 * @return the die face of the die
	 */
	public DieFace getFace() {
		return curVal;
	} 
	
	/*
	 * Getter for the id of the die
	 * 
	 * @return the id of the die
	 */
	public int getId() {
		return this.id;
	}

	/*
	 * Overrides the comapreTo method and compares the integer value
	 * 
	 * @param other- the die you wish to compare it to
	 * 
	 * @return -1 if this is less than 0 if equal or 1 if this is greater
	 * 
	 * @pre other != null
	 * 
	 * @post die will be compared correctly
	 */
	@Override
	public int compareTo(Die other) {
		return Integer.compare(this.getValue(), other.getValue());
	}
	
	
	@Override
	public String toString() {
		return "[Die Face: " + Integer.toString(curVal.getVal()) +"]: Id: " + id;
	}
	
	
}