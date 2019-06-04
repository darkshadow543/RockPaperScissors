package com.revature.helloworld;
import com.revature.helloworld.Weapons;

public class Player {
	private Weapons choice;
	private int wins;
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void choose(Weapons selection) {
		this.choice = selection;
	}
	
	public Weapons getChoice() {
		return choice;
	}
	
	public int getWins() {
		return wins;
	}
	
	public void setWins(int par) {
		wins = par;
	}
	
	public void addWin() {
		wins++;
	}

	@Override
	public String toString() {
		return "Player [choice=" + choice + ", wins=" + wins + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((choice == null) ? 0 : choice.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + wins;
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
		Player other = (Player) obj;
		if (choice != other.choice)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (wins != other.wins)
			return false;
		return true;
	}

	public Player(Weapons choice, int wins, String name) {
		super();
		this.choice = choice;
		this.wins = wins;
		this.name = name;
	}
	
}
