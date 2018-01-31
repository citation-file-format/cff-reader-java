/**
 * 
 */
package org.research_software.citation.cff.model.objects;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.research_software.citation.cff.exceptions.CFFModelException;

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
	 * @throws MalformedURLException 
	 * @throws CFFModelException 
	 */
	@Test(expected = CFFModelException.class)
	public final void testBadOrcidPattern() throws CFFModelException, MalformedURLException {
		new Person(null, null, null, null, null, null, null, null, null, null, "", null, null, null, null);
	}
	
	@Test
	public final void testBadOrcidPatternMessage() {
		try {
			new Person(null, null, null, null, null, null, null, null, null, null, "BAD ORCID", null, null, null, null);
		}
		catch (CFFModelException | MalformedURLException e) {
			assertThat(e, instanceOf(CFFModelException.class));
			assertThat(e.getMessage(), is("ORCID id BAD ORCID is not a valid ORCID URL with pattern 'https://orcid.org/[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}'!"));
		}
	}
	
	@Test
	public final void testOnlyRequiredValues() throws CFFModelException, MalformedURLException {
		new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null);
		new Entity("N", null, null, null, null, null, null, null, null, null, null, null, null, null);
	}

}
