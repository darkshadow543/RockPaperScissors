/**
 * 
 */
package com.revature.helloworld;
import java.util.Scanner;

import com.revature.helloworld.Player;
import com.revature.helloworld.Weapons;
/**
 * @author sbeng
 *
 */
public class Engine {


	private Player player1 = new Player();
	private Player player2 = new Player();
	private Player winner;
	public static Scanner scanner = new Scanner(System.in);
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((player1 == null) ? 0 : player1.hashCode());
		result = prime * result + ((player2 == null) ? 0 : player2.hashCode());
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Engine other = (Engine) obj;
		if (player1 == null) {
			if (other.player1 != null)
				return false;
		} else if (!player1.equals(other.player1))
			return false;
		if (player2 == null) {
			if (other.player2 != null)
				return false;
		} else if (!player2.equals(other.player2))
			return false;
		if (winner == null) {
			if (other.winner != null)
				return false;
		} else if (!winner.equals(other.winner))
			return false;
		return true;
	}

	public Engine() {
		// TODO Auto-generated constructor stub
	}
	
	public void play() {
		String input = "";
		System.out.println("Welcome to Rock Paper Scissors\n");
		System.out.println("Player1, please enter your name:");
		input = scanner.nextLine();
		player1.setName(input);
		System.out.println("\nPlayer2, please enter your name:");
		input = scanner.nextLine();
		player2.setName(input);
		while(true) {
			this.makeChoice(player1);
			this.makeChoice(player2);
			winner = this.determineWinner();
			if (winner == null) {
				System.out.println("Tie");
			} else {
				System.out.println(winner.getName() + " wins!");
				winner.addWin();
			}
			System.out.println("Scoreboard");
			System.out.println(player1.getName() + ": " + player1.getWins());
			System.out.println(player2.getName() + ": " + player2.getWins() + "\n\n");
			if (this.askQuit()) {
				System.out.println("Thanks for Playing!");
				break;
			}
		}
	}
	
	public void playSingle() {
		String input = "";
		System.out.println("Welcome to Rock Paper Scissors\n");
		System.out.println("Player1, please enter your name:");
		input = scanner.nextLine();
		player1.setName(input);
		player2 = new CompPlayer();
		player2.setName("Comp");
		while(true) {
			this.makeChoice(player1);
			player2.getChoice();
			winner = this.determineWinner();
			if (winner == null) {
				System.out.println("Tie");
			} else {
				System.out.println(winner.getName() + " wins!");
				winner.addWin();
			}
			System.out.println("Scoreboard");
			System.out.println(player1.getName() + ": " + player1.getWins());
			System.out.println(player2.getName() + ": " + player2.getWins() + "\n\n");
			if (this.askQuit()) {
				System.out.println("Thanks for Playing!");
				break;
			}
		}
	}
	
	//Selects player who won, returns null if it is a tie
	public Player determineWinner() {
		if (player1.getChoice() == player2.getChoice()) {
			return null;
		}
		if(((player1.getChoice() == Weapons.ROCK) && player2.getChoice()==Weapons.SCISSORS) || 
		((player1.getChoice() == Weapons.PAPER) && player2.getChoice()==Weapons.ROCK) ||
		((player1.getChoice() == Weapons.SCISSORS) && player2.getChoice()==Weapons.PAPER)){
			return player1;
		} else {
			return player2;
		}
	}
	//gets the player to make a choice 
	public void makeChoice(Player player) {
		String input = "";
		boolean loop = true;
		while(loop) {
			System.out.println(player.getName() + ": Please Enter Your Choice");
			input = scanner.next();
			input = input.toUpperCase();
			if(input.equals("ROCK")) {
				player.choose(Weapons.ROCK);
				loop = false;
			} else if(input.equals("PAPER")) {
				player.choose(Weapons.PAPER);
				loop = false;
			} else if (input.equals("SCISSORS")) {
				player.choose(Weapons.SCISSORS);
				loop = false;
			} else {
				System.out.println("Please enter a Valid Choice.  Rock, Paper or Scissors");
			} 
		}
	}
	
	public Engine(Player player1, Player player2, Player winner) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		this.winner = winner;
	}

	private boolean askQuit() {
		String input = "";
		do {
			System.out.println("Would you like to play again? [Y/N]");
			input = scanner.next();
			input = input.toUpperCase();
			if (input.equals("Y") || input.equals("YES")) {
				return false;
			} else if(input.equals("N") || input.equals("NO")) {
				return true;
			}
		}while(true);
	}
	
	@Override
	public String toString() {
		return "Engine [player1=" + player1.toString() + ", player2=" + player2.toString() + ", winner=" + winner.toString()
				+ "]";
	}
}
