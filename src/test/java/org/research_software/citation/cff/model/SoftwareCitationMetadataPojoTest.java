package org.research_software.citation.cff.model;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.research_software.citation.cff.exceptions.InvalidDataException;
import org.research_software.citation.cff.model.objects.Person;
import org.research_software.citation.cff.model.objects.Subject;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class SoftwareCitationMetadataPojoTest {

	/**
	 * // TODO Add description
	 * 
	 * @throws InvalidDataException
	 */
	@Test(expected = InvalidDataException.class)
	public final void testWrongCFFVersion() throws InvalidDataException {
		new SoftwareCitationMetadataPojo("1.0.2", "message", new ArrayList<Subject>(Arrays.asList(new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null))), "2018-01-31", "Title", "1.0.0", null, null, null, null, null, null, null, null, null, null, null, null);
	}
	
	/**
	 * // TODO Add description
	 * 
	 */
	@Test
	public final void testWrongCFFVersionMessage() {
		try {
			new SoftwareCitationMetadataPojo("1.0.2", "message", new ArrayList<Subject>(Arrays.asList(new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null))), "2018-01-31", "Title", "1.0.0", null, null, null, null, null, null, null, null, null, null, null, null);
		}
		catch (InvalidDataException e) {
			assertThat(e, instanceOf(InvalidDataException.class));
			assertThat(e.getMessage(), is("'cff-version' must be 1.0.3!"));
			return;
		}
		fail();
	}


	/**
	 * // TODO Add description
	 * 
	 * @throws InvalidDataException
	 */
	@Test
	public final void testOnlyRequiredValues() throws InvalidDataException {
		new SoftwareCitationMetadataPojo("1.0.3", "message", new ArrayList<Subject>(Arrays.asList(new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null))), "2018-01-31", "Title", "1.0.0", null, null, null, null, null, null, null, null, null, null, null, null);
	}

}
