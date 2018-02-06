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
 * A custom deserializer for {@link Subject} objects, which
 * can either be of type {@link Person} or of type {@link Entity}.
 * 
 * The deserializer decides this based on the presence of the
 * field `name`, which is present in {@link Entity} objects but
 * not in {@link Person} objects.
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
class SubjectDeserializer extends StdDeserializer<Subject> {

	/**
	 * The default serial version UID.
	 */
	private static final long serialVersionUID = 1L;

	protected SubjectDeserializer() {
		this(null);
	}

	protected SubjectDeserializer(final Class<?> vc) {
		super(vc);
	}

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
	 */
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
