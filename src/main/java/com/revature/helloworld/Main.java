package com.revature.helloworld;

/*
 * @author - Shannon Bengel
 * Written: 6/3/2019*/

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println("Hello Again!");
		Engine engine = new Engine();
		String input;
		int choice;
		do {
			System.out.println("How Many players are playing[1, 2]");
			input = Engine.scanner.nextLine();
			try {
				choice = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a number");
				continue;
			}
			switch(choice) {
			case 1:
				engine.playSingle();
				break;
			case 2:
				engine.play();
				break;
			default:
				System.out.println("The game only suports one to two players");
				continue;
			}
			break;
		}while(true);
	}
}
