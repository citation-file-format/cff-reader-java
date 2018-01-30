/**
 * 
 */
package org.research_software.citation.cff.reader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.research_software.citation.cff.model.SoftwareCitationMetadata;
import org.research_software.citation.cff.model.SoftwareCitationMetadataPojo;
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

	@Override
	public SoftwareCitationMetadata readFromFile(File cffFile) throws JsonParseException, JsonMappingException, IOException {
		SoftwareCitationMetadata citation = null;
		citation = getMapper().readValue(cffFile, SoftwareCitationMetadataPojo.class);
		return citation;
	}

	@Override
	public SoftwareCitationMetadata readFromStream(InputStream cffInputStream) throws JsonParseException, JsonMappingException, IOException {
		SoftwareCitationMetadata citation = null;
		citation = getMapper().readValue(cffInputStream, SoftwareCitationMetadataPojo.class);
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
