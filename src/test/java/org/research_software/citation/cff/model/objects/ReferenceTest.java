/**
 * 
 */
package org.research_software.citation.cff.model.objects;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.research_software.citation.cff.model.exceptions.CFFModelException;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class ReferenceTest {

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
	 * Test method for {@link org.research_software.citation.cff.model.objects.Reference#Reference(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, org.research_software.citation.cff.model.objects.Entity, org.research_software.citation.cff.model.objects.Entity, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, java.util.List)}.
	 * @throws NullPointerException 
	 * @throws MalformedURLException 
	 * @throws CFFModelException 
	 */
	@Test(expected = CFFModelException.class)
	public final void testReferenceBadType() throws CFFModelException, MalformedURLException, NullPointerException {
		new Reference("singularity", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	}

	/**
	 * Test method for {@link org.research_software.citation.cff.model.objects.Reference#Reference(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, org.research_software.citation.cff.model.objects.Entity, org.research_software.citation.cff.model.objects.Entity, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, java.util.List)}.
	 * @throws NullPointerException 
	 * @throws MalformedURLException 
	 * @throws CFFModelException 
	 */
	@Test
	public final void testReferenceBadTypeMessage() {
		try {
			new Reference("singularity", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		}
		catch (CFFModelException | MalformedURLException | NullPointerException e) {
			assertThat(e, instanceOf(CFFModelException.class));
			assertThat(e.getMessage(), is("The reference type 'singularity' is not defined."));
		}
	}

	/**
	 * Test method for {@link org.research_software.citation.cff.model.objects.Reference#Reference(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, org.research_software.citation.cff.model.objects.Entity, org.research_software.citation.cff.model.objects.Entity, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, java.util.List)}.
	 * @throws NullPointerException 
	 * @throws MalformedURLException 
	 * @throws CFFModelException 
	 */
	@Test(expected = CFFModelException.class)
	public final void testReferenceBadLanguage() throws CFFModelException, MalformedURLException, NullPointerException {
		new Reference("book", "title", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ArrayList<String>(Arrays.asList("BAD LANGUAGE!")), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	}

	/**
	 * Test method for {@link org.research_software.citation.cff.model.objects.Reference#Reference(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, org.research_software.citation.cff.model.objects.Entity, org.research_software.citation.cff.model.objects.Entity, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, java.util.List)}.
	 * @throws NullPointerException 
	 * @throws CFFModelException 
	 */
	@Test
	public final void testReferenceBadLanguageMessage() {
		try {
			new Reference("book", "title", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ArrayList<String>(Arrays.asList("BAD LANGUAGE!")), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		}
		catch (CFFModelException | MalformedURLException | NullPointerException e) {
			assertThat(e, instanceOf(CFFModelException.class));
			assertThat(e.getMessage(), is("The language 'BAD LANGUAGE!' is not a valid ISO 639-1 or 639-3 code."));
		}
	}

	/**
	 * Test method for {@link org.research_software.citation.cff.model.objects.Reference#Reference(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, org.research_software.citation.cff.model.objects.Entity, org.research_software.citation.cff.model.objects.Entity, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, java.util.List)}.
	 * @throws NullPointerException 
	 * @throws MalformedURLException 
	 * @throws CFFModelException 
	 */
	@Test(expected = CFFModelException.class)
	public final void testReferenceBadStatus() throws CFFModelException, MalformedURLException, NullPointerException {
		new Reference("book", "title", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	}

	/**
	 * Test method for {@link org.research_software.citation.cff.model.objects.Reference#Reference(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, org.research_software.citation.cff.model.objects.Entity, org.research_software.citation.cff.model.objects.Entity, org.research_software.citation.cff.model.objects.Entity, java.util.List, java.util.List, java.util.List)}.
	 * @throws NullPointerException 
	 * @throws CFFModelException 
	 */
	@Test
	public final void testReferenceBadStatusMessage() {
		try {
			new Reference("book", "title", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "BAD STATUS!", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		}
		catch (CFFModelException | MalformedURLException | NullPointerException e) {
			assertThat(e, instanceOf(CFFModelException.class));
			assertThat(e.getMessage(), is("The status 'BAD STATUS!' is not defined."));
		}
	}

}
