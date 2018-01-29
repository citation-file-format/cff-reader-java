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
public class SoftwareCitationReader implements ISoftwareCitationReader {

	/* (non-Javadoc)
	 * @see org.research_software.citation.cff.reader.ISoftwareCitationReader#readCFFFile(java.lang.String)
	 */
	public ISoftwareCitation readCFFFile(String pathString) {
//		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
////	CitationMetadata citation = null;
////	try {
////		citation = mapper.readValue(new File("CITATION.cff"), CitationMetadata.class);
////	}
////	catch (IOException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}
////	
		return null;
	}

	/* (non-Javadoc)
	 * @see org.research_software.citation.cff.reader.ISoftwareCitationReader#readCFFFile(java.nio.file.Path)
	 */
	public ISoftwareCitation readCFFFile(Path path) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.research_software.citation.cff.reader.ISoftwareCitationReader#readCFFFile(java.net.URI)
	 */
	public ISoftwareCitation readCFFFile(URI fileURI) {
		// TODO Auto-generated method stub
		return null;
	}

}
