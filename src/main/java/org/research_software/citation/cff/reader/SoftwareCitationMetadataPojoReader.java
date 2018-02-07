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
package org.research_software.citation.cff.reader;

import java.io.File;
import java.io.InputStream;
import org.research_software.citation.cff.exceptions.InvalidCFFFileNameException;
import org.research_software.citation.cff.exceptions.InvalidDataException;
import org.research_software.citation.cff.exceptions.ReadException;
import org.research_software.citation.cff.model.SoftwareCitationMetadata;
import org.research_software.citation.cff.model.objects.Subject;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

/**
 * An POJO-basd implementation of {@link SoftwareCitationMetadataReader}.
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class SoftwareCitationMetadataPojoReader implements SoftwareCitationMetadataReader {

	private static final String CFF_FILE_NAME = "CITATION.cff";

	/* (non-Javadoc)
	 * @see org.research_software.citation.cff.reader.SoftwareCitationMetadataReader#readFromFile(java.io.File)
	 */
	public SoftwareCitationMetadata readFromFile(File cffFile) throws InvalidCFFFileNameException, ReadException, InvalidDataException {
		if (!cffFile.getName().equals(CFF_FILE_NAME)) {
			throw new InvalidCFFFileNameException("File name of CFF file must be '" + CFF_FILE_NAME + "' (is '" + cffFile.getName() + "')!");
		}
		SoftwareCitationMetadata citation = null;
		try {
			citation = getMapper().readValue(cffFile, SoftwareCitationMetadata.class);
		}
		catch (JsonMappingException e) {
			if (e.getCause() instanceof InvalidDataException) {
				throw new InvalidDataException(e.getCause().getMessage(), e.getCause().getCause());
			}
		}
		catch (Exception e) {
			throw new ReadException("The read process failed due to an exception.", e);
		}
		return citation;
	}

	/* (non-Javadoc)
	 * @see org.research_software.citation.cff.reader.SoftwareCitationMetadataReader#readFromStream(java.io.InputStream)
	 */
	public SoftwareCitationMetadata readFromStream(InputStream cffInputStream) throws ReadException, InvalidDataException {
		SoftwareCitationMetadata citation = null;
		try {
			citation = getMapper().readValue(cffInputStream, SoftwareCitationMetadata.class);
		}
		catch (JsonMappingException e) {
			if (e.getCause() instanceof InvalidDataException) {
				throw new InvalidDataException(e.getCause().getMessage(), e.getCause().getCause());
			}
		}
		catch (Exception e) {
			throw new ReadException("The read process failed due to an exception.", e);
		}
		return citation;
	}

	/**
	 * Construct the mapper to use for reading the file or stream.
	 * 
	 * Attaches a custom deserializer of type {@link SubjectDeserializer} to
	 * the mapper.
	 * 
	 * @return The constructed mapper
	 */
	private ObjectMapper getMapper() {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

		final SimpleModule module = new SimpleModule();
		// Add custom deserializer for Subject
		module.addDeserializer(Subject.class, new SubjectDeserializer());
		mapper.registerModule(module);
		return mapper;
	}

}
