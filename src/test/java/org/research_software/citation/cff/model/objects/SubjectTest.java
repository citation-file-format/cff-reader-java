/**
 * 
 */
package org.research_software.citation.cff.model.objects;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.research_software.citation.cff.exceptions.InvalidDataException;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class SubjectTest {

	/**
	 * // TODO Add description
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * // TODO Add description
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.research_software.citation.cff.model.objects.Subject#Subject(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws InvalidDataException 
	 */
	@Test(expected = InvalidDataException.class)
	public final void testBadOrcidPattern() throws InvalidDataException {
		new Person(null, null, null, null, null, null, null, null, null, null, "", null, null, null, null);
	}
	
	/**
	 * // TODO Add description
	 * 
	 */
	@Test
	public final void testBadOrcidPatternMessage() {
		try {
			new Person(null, null, null, null, null, null, null, null, null, null, "BAD ORCID", null, null, null, null);
		}
		catch (InvalidDataException e) {
			assertThat(e, instanceOf(InvalidDataException.class));
			assertThat(e.getMessage(), is("ORCID id BAD ORCID is not a valid ORCID URL with pattern 'https://orcid.org/[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}'!"));
			return;
		}
		fail();
	}
	
	/**
	 * Test method for {@link org.research_software.citation.cff.model.objects.Subject#Subject(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 * @throws InvalidDataException 
	 */
	@Test(expected = InvalidDataException.class)
	public final void testBadCountry() throws InvalidDataException {
		new Person(null, null, null, null, null, null, null, null, null, "NOMANSLAND", null, null, null, null, null);
	}
	
	/**
	 * // TODO Add description
	 * 
	 */
	@Test
	public final void testBadCountryMessage() {
		try {
			new Person(null, null, null, null, null, null, null, null, null, "NOMANSLAND", null, null, null, null, null);
		}
		catch (InvalidDataException e) {
			assertThat(e, instanceOf(InvalidDataException.class));
			assertThat(e.getMessage(), is("'country' value 'NOMANSLAND' is not a valid ISO 3166-1 alpha-2 code."));
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
		new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null);
		new Entity("N", null, null, null, null, null, null, null, null, null, null, null, null, null);
	}

}
