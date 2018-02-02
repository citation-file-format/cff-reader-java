/**
 * 
 */
package org.research_software.citation.cff.reader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.research_software.citation.cff.exceptions.CFFModelException;
import org.research_software.citation.cff.exceptions.CFFReaderException;
import org.research_software.citation.cff.model.SoftwareCitationMetadata;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * A reader for software citation metadata files in the
 * [Citation File Format](https://citation-file-format.github.io).
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public interface SoftwareCitationMetadataReader {
	
	/**
	 * Reads the software citation metadata from a {@link File} object,
	 * which represents a valid `CITATION.cff` file.
	 * 
	 * @param cffFile The object representing the valid `CITATION.cff` file 
	 * @return The software citation metadata as a Java object of type {@link SoftwareCitationMetadata}
	 * 
	 * @throws MalformedURLException If a URL provided in the software citation metadata is not a valid URL as specified by Java 
	 * @throws NullPointerException If a required value is not present in the software citation metadata file
	 * @throws JsonParseException If an error has occurred parsing the `CITATION.cff` file
	 * @throws JsonMappingException If an error has occurred during the process of mapping the metadata from the file onto the Java object (usually wrapped in a {@link CFFModelException}).
	 * @throws IOException If an error occurred reading the `CITATION.cff` file 
	 * @throws CFFReaderException If an error occurred during the read of the `CITATION.cff` file, e.g., when the client is trying to read a file with another name
	 */
	public SoftwareCitationMetadata readFromFile(File cffFile) throws JsonParseException, JsonMappingException, IOException, NullPointerException, MalformedURLException, CFFReaderException;
	
	/**
	 * Reads the software citation metadata from an {@link InputStream} object,
	 * which streams a valid `CITATION.cff` file.
	 * 
	 * @param cffInputStream The {@link InputStream} providing the contents of a valid `CITATION.cff` file
	 * @return The software citation metadata as a Java object of type {@link SoftwareCitationMetadata}
	 * @throws MalformedURLException If a URL provided in the software citation metadata is not a valid URL as specified by Java 
	 * @throws NullPointerException If a required value is not present in the software citation metadata file
	 * @throws JsonParseException If an error has occurred parsing the `CITATION.cff` file
	 * @throws JsonMappingException If an error has occurred during the process of mapping the metadata from the file onto the Java object (usually wrapped in a {@link CFFModelException}).
	 * @throws IOException If an error occurred reading the `CITATION.cff` file 
	 */
	public SoftwareCitationMetadata readFromStream(InputStream cffInputStream) throws JsonParseException, JsonMappingException, IOException, NullPointerException, MalformedURLException;

}
