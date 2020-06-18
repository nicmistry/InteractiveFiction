/*
 * Lamp.java
 * Author: Nicole Mistry
 * Submission Date: April 12, 2019
 * 
 * Purpose: The lamp method class for the adventure driver, allows the driver to set the lamp as lit or unlit, 
 * and retrieve whether or not it is lit via boolean value. 
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

public class Lamp {

	/*
	 * Instance variables and methods go here, you're responsible for 
	 * choosing and naming them.
	 */
	
	//instance variable
	private boolean lit;
	
	
	//methods
	
	//sets whether or not the lamp is lit up
	public void setIsLit(boolean status) {
		this.lit = status;
	}
	
	//returns whether the lamp is lit up or not
	public boolean getIsLit() {
		if (this.lit == true) {
			return true;
		}
		else 
			return false;
	}	
}
