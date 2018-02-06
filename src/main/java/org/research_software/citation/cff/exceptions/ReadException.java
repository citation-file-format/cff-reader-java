/**
 * 
 */
package org.research_software.citation.cff.exceptions;


/**
 * Exception thrown on failing read processes.
 * 
 * Exceptions of this type may wrap the original exception
 * for inspection by the client.
 * 
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class ReadException extends Exception {

	/**
	 * The default serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor accepting a message and a cause for the exception.
	 * 
	 * @param message The message accompanying a throw of the exception.
	 * @param cause The cause of the exception (another {@link Exception}).
	 */
	public ReadException(String message, Exception cause) {
		super(message, cause);
	}

}
