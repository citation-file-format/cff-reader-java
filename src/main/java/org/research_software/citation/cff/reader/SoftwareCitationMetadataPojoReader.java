/**
 * 
 */
package org.research_software.citation.cff.reader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.research_software.citation.cff.model.SoftwareCitationMetadata;
import org.research_software.citation.cff.model.objects.Subject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class SoftwareCitationMetadataPojoReader implements SoftwareCitationMetadataReader {

	/* (non-Javadoc)
	 * @see org.research_software.citation.cff.reader.SoftwareCitationMetadataReader#readFromFile(java.io.File)
	 */
	public SoftwareCitationMetadata readFromFile(File cffFile)
			throws JsonParseException, JsonMappingException, IOException, NullPointerException, MalformedURLException {
		SoftwareCitationMetadata citation = null;
		try {
			citation = getMapper().readValue(cffFile, SoftwareCitationMetadata.class);
		}
		catch (JsonMappingException e) {
			if (e.getCause() instanceof NullPointerException) {
				try {
					throw e.getCause();
				}
				catch (Throwable e1) {
					// TODO
					e1.printStackTrace();
				}
			}
			else {
				throw e;
			}
		}
		return citation;
	}

	/* (non-Javadoc)
	 * @see org.research_software.citation.cff.reader.SoftwareCitationMetadataReader#readFromStream(java.io.InputStream)
	 */
	public SoftwareCitationMetadata readFromStream(InputStream cffInputStream)
			throws JsonParseException, JsonMappingException, IOException, NullPointerException, MalformedURLException {
		SoftwareCitationMetadata citation = null;
		try {
			citation = getMapper().readValue(cffInputStream, SoftwareCitationMetadata.class);
		}
		catch (JsonMappingException e) {
			if (e.getCause() instanceof NullPointerException) {
				try {
					throw e.getCause();
				}
				catch (Throwable e1) {
					// TODO
					e1.printStackTrace();
				}
			}
			else {
				throw e;
			}
		}
		return citation;
	}

	private ObjectMapper getMapper() {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		final SimpleModule module = new SimpleModule();
		// Add custom deserializer for Subject
		module.addDeserializer(Subject.class, new SubjectDeserializer());
		mapper.registerModule(module);
		return mapper;
	}

}
