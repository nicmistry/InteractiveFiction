/*
 * Player.java
 * Author: Nicole Mistry
 * Submission Date: April 12, 2019
 * 
 * Purpose: Player method class for the adventure driver. Allows the driver to set the x and y coordinates
 * of the player when they are within range, and set their key and lamp objects. It also allows the driver
 * to retrieve these values and objects.
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
public class Player {
	
	//instance variables
	private Lamp playerLamp;
	private int xCoord = 0;
	private int yCoord = 0;
	private Key playerKey;
	
	//setter methods
	
	//sets the player's lamp if it doesn't have one already
	public void setLamp(Lamp lamp) {
		
		if (this.playerLamp == null)
			this.playerLamp = lamp;
		else
			System.out.println("You already have a lamp.");
	}
	
	//sets the player's key if they don't already have one
	public void setKey(Key key) {
		
		if (this.playerKey == null) 
			this.playerKey = key;
		else 
			System.out.println("You already have a key.");
		
	}
	
	//sets the player's x coordinate if it is within the valid range
	public void setX(int newX) {
		
		if (newX >= 0 && newX <= 3)
			this.xCoord = newX;
		else
			System.out.println("Invalid X-coordinate.");
	}
	
	//sets the player's y coordinate if it is within the valid range
	public void setY(int newY) {
		
		if(newY >= 0 && newY <= 3)
			this.yCoord = newY;
		else
			System.out.println("Invalid Y-coordinate.");
	}
	
	//getter methods
	
	//returns the player's lamp object
	public Lamp getLamp() {
		
		return this.playerLamp;
		
	}
	
	
	//return's the player's key object
	public Key getKey() {
		
		return this.playerKey;
		
	}
	
	//returns the player's x coordinate
	public int getX() {
		
		return this.xCoord;
		
	}
	
	//returns the player's y coordinate
	public int getY() {
		
		return this.yCoord;
	}
	
}
