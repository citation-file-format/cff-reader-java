/**
 * 
 */
package org.research_software.citation.cff.exceptions;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class CFFModelException extends IllegalArgumentException {

	/**
	 * The default serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * // TODO Add description
	 * 
	 * @param message
	 */
	public CFFModelException(String message) {
		this(message, null);
	}

	/**
	 * // TODO Add description
	 * 
	 * @param message
	 * @param cause
	 */
	public CFFModelException(String message, Throwable cause) {
		super(message, cause);
	}

}
