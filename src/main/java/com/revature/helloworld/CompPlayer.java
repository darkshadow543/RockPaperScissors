/**
 * 
 */
package com.revature.helloworld;

import java.util.Random;

/**
 * @author sbeng
 *
 */
public class CompPlayer extends Player {
	public static Random rand = new Random();
	
	public CompPlayer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param choice
	 * @param wins
	 * @param name
	 */
	public CompPlayer(Weapons choice, int wins, String name) {
		super(choice, wins, name);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Weapons getChoice() {
		int pick = rand.nextInt(Weapons.values().length);
		Weapons choice = Weapons.values()[pick];
		this.choose(choice);;
		return choice;
	}

	/**
	 * @param args
	 */
}
