/*
 * 		Class: Game
 *
 *		Purpose: This class is the class that allows the game to run and calls all of the methods
 *				 in the other classes in the game
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

	private ArrayList<Player> players; // list of active players
	private int turn; // intialize to turn 0
	private List<Observer> aObservers = new ArrayList<Observer>();
	
	/*
	 * Constructor for the game that sets the players, and if it is a game versus a computer
	 * 
	 * @param names - an array list of names of the players
	 * @param computerGame - is the type of the computer
	 * 
	 * @pre names != null, typeOfComputer == none || Easy || Hard
	 * 
	 * @post Game will be made correctly
	 */
	public Game(ArrayList<String> names, String typeOfComputer) {
		this.players = new ArrayList<Player>(); 
		if (typeOfComputer.equals("none")) { // create game with no computer
			for (String name : names) {
				this.players.add(new Player(name, new Cup(), new ScoreCard(), false));
			}		
		} else { // create a match with a computer
				players.add(new Player(names.get(0), new Cup(), new ScoreCard(), false));	
			if (typeOfComputer.equals("Easy"))	{
				players.add(new ComputerStrategy_ChooseFirst("Computer", new Cup(), new ScoreCard(), true));
			} else {
				players.add(new ComputerStrategy_ChooseBest("Computer", new Cup(), new ScoreCard(), true));
			}
		}
		
		players.get(0).getCup().roll();
		this.turn = names.size() * 13;
	}
	
	/*
	 * getter for current player
	 * 
	 * @return the name of the current player
	 */
	public String currentPlayerTurn() {
		return players.get(0).getName();

	}
	
	/*
	 *  Take Player index 0 and move to the back, then push everything else forward if it is a computer 
	 * 		it then plays a round and rotates the players one more time
	 */
	public void rotateTurn() {
		Player firstElement = players.remove(0);
		firstElement.resetRolls();
		firstElement.resetDice();
	    players.add(firstElement);
	    Player currentPlayer = players.get(0);
	    currentPlayer.getCup().roll();
	    turn--;

		// if next player is a computer plays round and rotates players
		if (currentPlayer.isComputer()) {

			if (currentPlayer instanceof ComputerStrategy_ChooseBest) {
				ComputerStrategy_ChooseBest computer = (ComputerStrategy_ChooseBest) currentPlayer;
				computer.playRound();
			}
			if (currentPlayer instanceof ComputerStrategy_ChooseFirst) {
				ComputerStrategy_ChooseFirst computer = (ComputerStrategy_ChooseFirst) currentPlayer;
				computer.playRound();
			}

			firstElement = players.remove(0);
			firstElement.resetRolls();
			firstElement.resetDice();
			players.add(firstElement);
			currentPlayer = players.get(0);
			currentPlayer.getCup().roll();
			turn--;
		}
		notifyObservers();
	}
	
	
	/*
	 * Lock current players given dice and notifies observers
	 * 
	 * @param id - the id of the dice to be locked
	 * 
	 * @pre id is in the current players cup
	 * 
	 * @post die will be set correctly
	 */
	public void lockDice(int id) {
		players.get(0).getCup().unsaveDie(id);
		notifyObservers();
	}
	
	/*
	 * Unlock current players given dice and notifies observers
	 * 
	 * @param id - the id of the dice to be locked
	 * 
	 * @pre id is in the current players cup
	 * 
	 * @post die will be set correctly
	 */
	public void unLockDice(int id) {
		players.get(0).getCup().saveDie(id);
		notifyObservers();
	}
	
	/* 
	 * Get the current players total score
	 * 
	 * @return the score for the current player
	 */
	public int totalScore() {
		return players.get(0).getScoreCard().getTotalScore();
	}
	
	/*
	 * Roll all unlocked dice
	 */
	public void roll() {
		if (players.get(0).getRolls() > 0) {
			players.get(0).getCup().roll();
			players.get(0).decrRolls();
			notifyObservers();
		}
	}
	
	/*
	 * See Dice of the Current Players turn
	 * 
	 * @return the cup of the current player
	 */
	public Cup getCup() {
		return players.get(0).getCup();
	}
	
	/*
	 * See ScoreCard of current player
	 * 
	 * @return scoreCard of the current player
	 */
	public ScoreCard getScoreCard() {
		return players.get(0).getScoreCard();
	}
	
	/*
	 * Set ScoreCard set for the Current Player
	 * 
	 * @param setName - the name of the setName you want to add to score card
	 * @param score - the score you want to add to score card
	 * 
	 * @pre setName != null, score is in players.get(0).evaluate()
	 * 
	 * @post score will be set correctly
	 */
	public void setScoreCard(SetName setName, int score) {
		players.get(0).score(setName, score);
		notifyObservers();
	}
	
	/*
	 * returns a list of integers of all the possible scores
	 * 
	 * @return the scores possible with current players dice
	 */
	public List<Integer> possibleScores() {
		return players.get(0).evaluate();
	}

	/*
	 * getter for the scores of the current player
	 * 
	 * @return the scores of current player
	 */
	public ArrayList<Integer> getScores() {
		return players.get(0).getScoreCard().getScoreValues();
	}
	
	/*
	 * Add an observer
	 * 
	 * @param observer - the observer you wish to add
	 * 
	 * @pre observer != null
	 * 
	 * @post observer will be added
	 */
    public void addObserver(Observer observer) {
        if (!aObservers.contains(observer)) {
            aObservers.add(observer);
        }
    }
    
    /*
     * Remove an observer
     * 
     * @param observer - the observer you wish to remove
	 * 
	 * @pre observer != null
	 * 
	 * @post observer will be removed
     */
    public void removeObserver(Observer observer) {
        aObservers.remove(observer);
    }
    
    /*
     * notify all observers and update them
     */
    public void notifyObservers() {
        for (Observer observer : aObservers) {
            observer.update(); // Pass the current Game state to the observer
        }
    }
	
    /*
     * getter for the current players rolls
     * 
     * @return the rolls the current player has
     */
	public int getRolls () {
		return players.get(0).getRolls();
	}
	
	/*
	 * getter for the current players total score
	 * 
	 * @return the total score of the current player
	 */
	public int getTotalScore() {
		return players.get(0).getScoreCard().getTotalScore();
	}

	/*
	 * getter for all players
	 * 
	 * @return an array list of all players
	 */
	public ArrayList<Player> getPlayers() {
		ArrayList<Player> copy = new ArrayList<Player>();
		for (Player player : players) {
			copy.add(player);
		}
		return copy;
	}
	
	/*
	 * Getter for list of booleans of what sets have been scored
	 * 
	 * @return a list of whether or not what sets have been scored
	 */
	public ArrayList<Boolean> getHasBeenScored() {
		return players.get(0).getHasBeenScored();
	}
	
	/*
	 * end current game by removing all observers
	 */
	public void removeAllObservers() {
		aObservers.clear();
	}

	/*
	 * Getter for a hash map of player names and their total scores
	 * 
	 * @return a hash map of player names and their scores
	 */
	public HashMap<String, String> getTotalScores() {
		HashMap<String, String> totalScores = new HashMap<String, String>();
		for (Player player : players) {		
			totalScores.put(player.getName(), player.getName() +":" + player.getScoreCard().getTotalScore() + "");
		}
		
		return totalScores;	
	}

	/*
	 * returns a boolean of if the game is complete
	 * 
	 * @return a boolean of if a game is complete
	 */
	public boolean isOver() {
		if (turn <= 0) {
			return true;
		}
		return false;
	}
}