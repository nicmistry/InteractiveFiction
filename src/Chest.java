/*
 * Chest.java
 * Author: Nicole Mistry
 * Submission Date: April 12, 2019
 * 
 * Purpose: Chest method class for the adventure driver, allows the driver to set whether the chest is locked,
 * unlocked, and the chest's contents. It also allows the driver to retrieve these characteristics.
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

public class Chest {
	
	/*
	 * Instance variables go here, you're responsible for choosing
	 * which ones are needed and naming them
	 */
		boolean locked;
		String contents;
		Key lockedKey;
		
		
	/**
	 * This method is used by the Map class, you won't need to call it yourself
	 * It should result in this chest being locked and storing which key locked it.
	 */
	public void lock(Key theKey) {
		this.locked = true;
		lockedKey = theKey;
	}
	
	/**
	 * If theKey is the same key that was used to lock this chest, then
	 * the chest is unlocked.  Otherwise this method does nothing.
	 */
	public void unLock(Key theKey) {
		if (theKey == lockedKey)
			this.locked = false;
	}
	
	/**
	 * Should return true if the chest is locked, false otherwise
	 */
	public boolean isLocked() {
		if (locked)
			return true;
		else 
			return false;
	}
	
	/**
	 * Return a string describing the contents of the chest.
	 */
	public String getContents() {
		return this.contents;
	}
	
	/**
	 * Set the contents of the chest to this string.  You should not need to call
	 * this method in your program (though you have to implement it anyway).
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	
}
