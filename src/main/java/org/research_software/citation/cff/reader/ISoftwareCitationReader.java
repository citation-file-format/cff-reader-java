/**
 * 
 */
package org.research_software.citation.cff.reader;

import java.net.URI;
import java.nio.file.Path;

import org.research_software.citation.cff.model.ISoftwareCitation;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public interface ISoftwareCitationReader {
	
	public ISoftwareCitation readCFFFile(String pathString);
	public ISoftwareCitation readCFFFile(Path path);
	public ISoftwareCitation readCFFFile(URI fileURI);

}
