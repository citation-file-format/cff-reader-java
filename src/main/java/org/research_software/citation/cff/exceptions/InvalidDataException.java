/**
 * 
 */
package org.research_software.citation.cff.exceptions;

/**
 * Exception thrown on encountering invalid data.
 * 
 * Exceptions of this type may wrap the original exception
 * for inspection by the client.
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class InvalidDataException extends Exception {

	/**
	 * Constructor accepting a message.
	 * 
	 * @param message The message accompanying a throw of the exception.
	 */
	public InvalidDataException(String message) {
		super(message);
	}

	/**
	 * Constructor accepting a message and a cause for the exception.
	 * 
	 * @param message The message accompanying a throw of the exception.
	 * @param cause The cause of the exception (another {@link Exception}).
	 */
	public InvalidDataException(String message, Exception cause) {
		super(message, cause);
	}

	/**
	 * The default serial version UID.
	 */
	private static final long serialVersionUID = 1L;

}
