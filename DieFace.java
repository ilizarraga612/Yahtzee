/*
 * 			Class: DieFace
 * 
 * 			Purpose: An enum class that represents the faces of a die
 */
public enum DieFace {
	
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);
	
	private int value;
	
	/* 
	 * Constructor for the enum that holds the value of the face
	 * 
	 * @param value - the value of the die face
	 * 
	 * @pre value is between 1 and 6
	 * 
	 * @post dieface will be made correctly
	 */
	DieFace(int value) {
		this.value = value;
	}
	
	/*
	 * Getter for the die value
	 * 
	 * @return the value of the die face
	 */
	public int getVal() {
		return value;
	}
}