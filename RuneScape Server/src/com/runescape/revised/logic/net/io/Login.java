package com.runescape.revised.logic.net.io;

import com.runescape.revised.RevisionType;

/**
 * The Login class.
 * 
 * @author Josh
 *
 */
public class Login {

	/**
	 * Class constructor.
	 * 
	 * @param revisionType
	 * 			The type of revision.
	 */
	public Login(final RevisionType revisionType) {

		/* Switch between each revision. */
		switch (revisionType) {
		case THREE_ONE_SEVEN:
			new Login317();
			break;
		case FIVE_SIXTY_TWO:
			new Login562();
			break;
		default:
			System.out.println("Revision not supported!");
		}
	}
}