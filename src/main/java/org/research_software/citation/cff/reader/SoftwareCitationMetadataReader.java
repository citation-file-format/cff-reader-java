/**
 * 
 */
package org.research_software.citation.cff.reader;

import java.io.File;
import java.io.InputStream;

import org.research_software.citation.cff.exceptions.InvalidCFFFileNameException;
import org.research_software.citation.cff.exceptions.InvalidDataException;
import org.research_software.citation.cff.exceptions.ReadException;
import org.research_software.citation.cff.model.SoftwareCitationMetadata;

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
	 * @throws InvalidDataException on invalid data, resulting parse errors (e.g., for date/time parses), or malformed URLs 
	 * @throws InvalidCFFFileNameException If an error occurred during the read of the `CITATION.cff` file, e.g., when the client is trying to read a file with another name
	 * @throws ReadException on failing read processes
	 */
	public SoftwareCitationMetadata readFromFile(File cffFile) throws InvalidCFFFileNameException, InvalidDataException, ReadException;
	
	/**
	 * Reads the software citation metadata from an {@link InputStream} object,
	 * which streams a valid `CITATION.cff` file.
	 * 
	 * @param cffInputStream The {@link InputStream} providing the contents of a valid `CITATION.cff` file
	 * @return The software citation metadata as a Java object of type {@link SoftwareCitationMetadata}
	 * @throws InvalidDataException on invalid data, resulting parse errors (e.g., for date/time parses), or malformed URLs
	 * @throws ReadException on failing read processes
	 */
	public SoftwareCitationMetadata readFromStream(InputStream cffInputStream) throws InvalidDataException, ReadException;

}
