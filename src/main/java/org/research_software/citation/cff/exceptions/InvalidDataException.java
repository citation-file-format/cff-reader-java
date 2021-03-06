/**
 * Copyright (c) 2018ff. Stephan Druskat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
	 * @param message The message accompanying a throw of the exception
	 * @param cause The cause of the exception
	 */
	public InvalidDataException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * The default serial version UID.
	 */
	private static final long serialVersionUID = 1L;

}
