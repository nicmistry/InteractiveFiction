/*
 * Adventure.java
 * Author: Nicole Mistry
 * Submission Date: April , 2019
 * 
 * Purpose: The main method for the interactive fiction game, which allows the player to travel through rooms, 
 * and, if not careful, be eaten by a grue. They can also collect objects and use them if they do have them. 
 * Allows the player to continue playing until they are eaten or they open the chest.
 * 
 * Statement of Academic Honesty: 
 * The following code represents my own work. I have neither received nor given inappropriate assistance. 
 * I have not copied or modified code from any source other than the course webpage or the course textbook. 
 * I recognize that any unauthorized assistance or plagiarism will be handled in accordance with the University 
 * of Georgia's Academic Honesty Policy and the policies of this course. I recognize that my work is on an 
 * assignment created by the Department of Computer Science at the University of Georgia. Any publishing or 
 * posting of source code for this project is strictly prohibited unless you have written consent from the 
 * Department of Computer Science at the University of Georgia. 
 */
import java.util.Scanner;

public class Adventure {
	public static void main(String[]args) {
		
	//initializing scanner
	Scanner key = new Scanner(System.in);
	
	//instance variables
	String playerCommand;
	Player player1 = new Player();
	Map player1Map = new Map();
	boolean gameOver = false;
	
	//initializing variables
	player1.setX(0);
	player1.setY(0);

	//print the introduction
	System.out.println("Welcome to the UGA Adventures: Episode 1");
	System.out.println("The Adventure of the of Cave Redundancy Adventure");
	System.out.println("By: Nicole Mistry \n");
	System.out.println((player1Map.getRoom(player1.getX(), player1.getY()).getDescription()));
	
	//ensure that the game keeps going if you're alive
	while (gameOver == false) {
		
		playerCommand = key.nextLine().trim();
		//*DIFFERENT COMMANDS*//
		
		//if the player's command is to get the lamp  
		if (playerCommand.equalsIgnoreCase("get lamp")) {
			if ((player1Map.getRoom(player1.getX(), player1.getY())).getLamp() == null)
				System.out.println("No lamp present.");
			else {
				player1.setLamp((player1Map.getRoom(player1.getX(), player1.getY())).getLamp()); //moves the lamp from the room to the player
				(player1Map.getRoom(player1.getX(), player1.getY())).clearLamp(); //clears the lamp from the room
				System.out.println("OK.");
			}
		}
		
		//if the player's command is to light the lamp
		else if (playerCommand.equalsIgnoreCase("light lamp")) {
			if (player1.getLamp() == null)
				System.out.println("You don't have the lamp to light."); //if they don't have a lamp
			else {
				System.out.println("OK.");
				player1.getLamp().setIsLit(true); //lights the lamp
			}		
		}
		
		//if the player's command is to go north
		else if (playerCommand.equalsIgnoreCase("north")) {
			if ((player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
				if (player1.getLamp() == null) {
					System.out.println("You have stumbled into a passing grue, and have been eaten.");
					gameOver = true;
				}
				else if (player1.getLamp() != null && !player1.getLamp().getIsLit()) {
					System.out.println("You have been stumbled into a passing grue, and have been eaten.");
					gameOver = true;
				}
				else if (player1.getLamp() != null && player1.getLamp().getIsLit()) {
					if (player1Map.getRoom(player1.getX(), player1.getY()).canGoNorth()) { 
						player1.setY(player1.getX() - 1);
						//prints the conditions of the new room
						if ((!player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
							System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
						}
						else if ((player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
							if (player1.getLamp() == null) 
								System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
							else if (player1.getLamp() != null && !player1.getLamp().getIsLit()) 
								System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
							else if (player1.getLamp() != null && player1.getLamp().getIsLit())
								System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
						}
					}
					else if ((!player1Map.getRoom(player1.getX(), player1.getY()).canGoNorth()))
						System.out.println("Can't go that way.");
				}
			}
			//if the player can move without getting eaten, prints their new location description
			else if (player1Map.getRoom(player1.getX(), player1.getY()).canGoNorth()) { 
				player1.setY(player1.getX() - 1);
				//prints the conditions of the new room
				if ((!player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
					System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
				}
				else if ((player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
					if (player1.getLamp() == null) 
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					else if (player1.getLamp() != null && !player1.getLamp().getIsLit()) 
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					else if (player1.getLamp() != null && player1.getLamp().getIsLit())
						System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
				}
			}
			else if ((!player1Map.getRoom(player1.getX(), player1.getY()).canGoNorth()))
				System.out.println("Can't go that way.");
		}
	
		
		//if the player's command is to go south
		else if (playerCommand.equalsIgnoreCase("south")) {
			if ((player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
				if (player1.getLamp() == null) {
					System.out.println("You have stumbled into a passing grue, and have been eaten.");
					gameOver = true;
				}
				else if (player1.getLamp() != null && !player1.getLamp().getIsLit()) {
					System.out.println("You have been stumbled into a passing grue, and have been eaten.");
					gameOver = true;
				}
				else if (player1.getLamp() != null && player1.getLamp().getIsLit()) {
					if (player1Map.getRoom(player1.getX(), player1.getY()).canGoSouth()) { 
						player1.setY(player1.getX() + 1);
						//prints the conditions of the new room
						if ((!player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
							System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
						}
						else if ((player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
							if (player1.getLamp() == null) 
								System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
							else if (player1.getLamp() != null && !player1.getLamp().getIsLit()) 
								System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
							else if (player1.getLamp() != null && player1.getLamp().getIsLit())
								System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
						}
					}
					else if ((!player1Map.getRoom(player1.getX(), player1.getY()).canGoSouth()))
						System.out.println("Can't go that way.");
				}
			}
			//if the player can move without getting eaten, prints their new location description
			else if (player1Map.getRoom(player1.getX(), player1.getY()).canGoSouth()) { 
				player1.setY(player1.getX() + 1);
				//prints the conditions of the new room
				if ((!player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
					System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
				}
				else if ((player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
					if (player1.getLamp() == null) {
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					}
					else if (player1.getLamp() != null && !player1.getLamp().getIsLit()) {
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					}
				}
			}
			else if ((!player1Map.getRoom(player1.getX(), player1.getY()).canGoSouth()))
				System.out.println("Can't go that way.");
		}
	
		
		//if the player's command is to go west
		else if (playerCommand.equalsIgnoreCase("west")) {
			if ((player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
				if (player1.getLamp() == null) {
					System.out.println("You have stumbled into a passing grue, and have been eaten.");
					gameOver = true;
				}
				else if (player1.getLamp() != null && !player1.getLamp().getIsLit()) {
					System.out.println("You have been stumbled into a passing grue, and have been eaten.");
					gameOver = true;
				}
				else if (player1.getLamp() != null && player1.getLamp().getIsLit()) {
					if (player1Map.getRoom(player1.getX(), player1.getY()).canGoWest()) { 
						player1.setY(player1.getY() - 1);
						//prints the conditions of the new room
						if ((!player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
							System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
						}
						else if ((player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
							if (player1.getLamp() == null) 
								System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
							else if (player1.getLamp() != null && !player1.getLamp().getIsLit()) 
								System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
							else if (player1.getLamp() != null && player1.getLamp().getIsLit())
								System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
						}
					}
					else if ((!player1Map.getRoom(player1.getX(), player1.getY()).canGoWest()))
						System.out.println("Can't go that way.");
				}
			}
			//if the player can move without getting eaten, prints their new location description
			else if (player1Map.getRoom(player1.getX(), player1.getY()).canGoWest()) { 
				player1.setY(player1.getY() - 1);
				//prints the conditions of the new room
				if ((!player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
					System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
				}
				else if ((player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
					if (player1.getLamp() == null) 
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					else if (player1.getLamp() != null && !player1.getLamp().getIsLit()) 
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					else if (player1.getLamp() != null && player1.getLamp().getIsLit())
						System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
				}
			}
			else if ((!player1Map.getRoom(player1.getX(), player1.getY()).canGoWest()))
				System.out.println("Can't go that way.");
		}
	
		
		//if the player's command is to go east
		else if (playerCommand.equalsIgnoreCase("east")) {
			if ((player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
				if (player1.getLamp() == null) {
					System.out.println("You have stumbled into a passing grue, and have been eaten.");
					gameOver = true;
				}
				else if (player1.getLamp() != null && !player1.getLamp().getIsLit()) {
					System.out.println("You have been stumbled into a passing grue, and have been eaten.");
					gameOver = true;
				}
				else if (player1.getLamp() != null && player1.getLamp().getIsLit()) {
					if (player1Map.getRoom(player1.getX(), player1.getY()).canGoEast()) { 
						player1.setY(player1.getY() + 1);
						//prints the conditions of the new room
						if ((!player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
							System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
						}
						else if ((player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
							if (player1.getLamp() == null) 
								System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
							else if (player1.getLamp() != null && !player1.getLamp().getIsLit()) 
								System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
							else if (player1.getLamp() != null && player1.getLamp().getIsLit())
								System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
						}
					}
					else if ((!player1Map.getRoom(player1.getX(), player1.getY()).canGoEast()))
						System.out.println("Can't go that way.");
				}
			}
			//if the player can move without getting eaten, prints their new location description
			else if (player1Map.getRoom(player1.getX(), player1.getY()).canGoEast()) { 
				player1.setY(player1.getY() + 1);
				//prints the conditions of the new room
				if ((!player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
					System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
				}
				else if ((player1Map.getRoom(player1.getX(), player1.getY()).isDark())) {
					if (player1.getLamp() == null) 
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					else if (player1.getLamp() != null && !player1.getLamp().getIsLit()) 
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					else if (player1.getLamp() != null && player1.getLamp().getIsLit())
						System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
				}
			}
			else if ((!player1Map.getRoom(player1.getX(), player1.getY()).canGoEast()))
				System.out.println("Can't go that way.");
		}
	
		
		//if the player's command is to look
			else if (playerCommand.equalsIgnoreCase("look")) {
				//if the room is dark to begin with
				if (player1Map.getRoom(player1.getX(), player1.getY()).isDark()) {
					if (player1.getLamp() == null || !player1.getLamp().getIsLit()) 
						System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
					else if (player1.getLamp() != null && player1.getLamp().getIsLit()){
						System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
						//prints whether there is a chest, key, or lamp in the room
						if (player1Map.getRoom(player1.getX(), player1.getY()).getChest() == null);
						else 
							System.out.println("There is a large, wooden, massive, oaken chest here with the word “CHEST” carved into it.");
						if (player1Map.getRoom(player1.getX(), player1.getY()).getLamp() == null);
						else
							System.out.println("There is an old oil lamp here that was made long ago.");
						if (player1Map.getRoom(player1.getX(), player1.getY()).getKey() == null);
						else 
							System.out.println("You see the outline of a key on a dusty shelf that's covered in dust.");
						//prints the available exits and concatenates them on separate lines
						String exits = "Exits are: ";
						if (player1Map.getRoom(player1.getX(), player1.getY()).canGoNorth()) 
							exits += "north\n";
						if (player1Map.getRoom(player1.getX(), player1.getY()).canGoSouth())
							exits += "south\n";
						if (player1Map.getRoom(player1.getX(), player1.getY()).canGoEast())
							exits += "east\n";
						if (player1Map.getRoom(player1.getX(), player1.getY()).canGoWest())
							exits += "west\n";
						System.out.print(exits);
					}
				}
				//if the room was not dark to begin with
				else if (!player1Map.getRoom(player1.getX(), player1.getY()).isDark()){
					System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getDescription());
					//prints whether there is a chest, key, or lamp in the room
					if (player1Map.getRoom(player1.getX(), player1.getY()).getChest() == null);
					else 
						System.out.println("There is a large, wooden, massive, oaken chest here with the word “CHEST” carved into it.");
					if (player1Map.getRoom(player1.getX(), player1.getY()).getLamp() == null);
					else
						System.out.println("There is an old oil lamp here that was made long ago.");
					if (player1Map.getRoom(player1.getX(), player1.getY()).getKey() == null);
					else 
						System.out.println("You see the outline of a key on a dusty shelf that's covered in dust.");
					//prints the available exits and concatenates them on separate lines
					String exits = "Exits are: ";
					if (player1Map.getRoom(player1.getX(), player1.getY()).canGoNorth()) 
						exits += "north\n";
					if (player1Map.getRoom(player1.getX(), player1.getY()).canGoSouth())
						exits += "south\n";
					if (player1Map.getRoom(player1.getX(), player1.getY()).canGoEast())
						exits += "east\n";
					if (player1Map.getRoom(player1.getX(), player1.getY()).canGoWest())
						exits += "west\n";
					System.out.print(exits);
				}
			}
				
		//if the player's command is to get the key
			else if (playerCommand.equalsIgnoreCase("get key")) {
				if (player1Map.getRoom(player1.getX(), player1.getY()).getKey() == null) //moves the key object to the player
					System.out.println("No key present.");
				else 
					System.out.println("OK.");
					player1.setKey(player1Map.getRoom(player1.getX(), player1.getY()).getKey()); //sets the key object the player got to the player
			}
		
		//if the player's command is to open the chest
			else if (playerCommand.equalsIgnoreCase("open chest")) {
				if (player1Map.getRoom(player1.getX(), player1.getY()).getChest() != null && !player1Map.getRoom(player1.getX(), player1.getY()).getChest().isLocked()) {
					System.out.println(player1Map.getRoom(player1.getX(), player1.getY()).getChest().getContents());
					gameOver = true;
				}
				else if (player1Map.getRoom(player1.getX(), player1.getY()).getChest() == null) 
					System.out.println("No chest present.");
				else if (player1Map.getRoom(player1.getX(), player1.getY()).getChest().isLocked())
					System.out.println("The chest is locked.");
			}
		
		//if the player's command is to unlock the chest
			else if (playerCommand.equalsIgnoreCase("unlock chest")) {
				if (player1.getKey() != null && player1Map.getRoom(player1.getX(), player1.getY()).getChest() != null) {
					System.out.println("OK.");
					player1Map.getRoom(player1.getX(), player1.getY()).getChest().unLock(player1.getKey()); 
				}
				else if (player1Map.getRoom(player1.getX(), player1.getY()).getChest() == null)
					System.out.println("No chest present.");
				else if (player1.getKey() == null)
					System.out.println("You need a key to do any unlocking!");
			}
		
		//any other input lets you try again with another command
			else
				System.out.println("I'm sorry I don't know how to do that, try again.");
		}
	}
}