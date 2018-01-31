/**
 * 
 */
package org.research_software.citation.cff.reader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.research_software.citation.cff.exceptions.CFFReaderException;
import org.research_software.citation.cff.model.SoftwareCitationMetadata;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public interface SoftwareCitationMetadataReader {
	
	/**
	 * // TODO Add description
	 * 
	 * @param cffFile
	 * @return
	 * @throws MalformedURLException 
	 * @throws NullPointerException 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws CFFReaderException 
	 */
	public SoftwareCitationMetadata readFromFile(File cffFile) throws JsonParseException, JsonMappingException, IOException, NullPointerException, MalformedURLException, CFFReaderException;
	
	/**
	 * // TODO Add description
	 * 
	 * @param cffInputStream
	 * @return
	 * @throws MalformedURLException 
	 * @throws NullPointerException 
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public SoftwareCitationMetadata readFromStream(InputStream cffInputStream) throws JsonParseException, JsonMappingException, IOException, NullPointerException, MalformedURLException;

}
