/**
 * 
 */
package org.research_software.citation.cff.reader;

import java.io.IOException;

import org.research_software.citation.cff.model.objects.Entity;
import org.research_software.citation.cff.model.objects.Person;
import org.research_software.citation.cff.model.objects.Subject;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class SubjectDeserializer extends StdDeserializer<Subject> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected SubjectDeserializer() {
		this(null);
	}

	protected SubjectDeserializer(final Class<?> vc) {
		super(vc);
	}

	@Override
	public Subject deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		final JsonNode node = parser.getCodec().readTree(parser);
		final ObjectMapper mapper = (ObjectMapper) parser.getCodec();
		if (node.has("name")) {
			return mapper.treeToValue(node, Entity.class);
		}
		else {
			return mapper.treeToValue(node, Person.class);
		}
	}

}
