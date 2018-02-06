/**
 * 
 */
package org.research_software.citation.cff.model.objects;

import static org.hamcrest.Matchers.*; 
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.research_software.citation.cff.exceptions.InvalidDataException;

/**
 * Unit tests for {@link Reference}.
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class ReferenceTest {

	/**
	 * Creates a new {@link Reference} object, passing an undefined reference type into the constructor.
	 * 
	 * Expects an {@link InvalidDataException}.
	 * 
	 * @throws InvalidDataException 
	 */
	@Test(expected = InvalidDataException.class)
	public final void testReferenceBadType() throws InvalidDataException {
		new Reference("singularity", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	}

	/**
	 * Creates a new {@link Reference} object, passing an undefined reference type into the constructor.
	 * 
	 * Catches the expected {@link InvalidDataException} and asserts the exception message.
	 * 
	 */
	@Test
	public final void testReferenceBadTypeMessage() {
		try {
			new Reference("singularity", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		}
		catch (InvalidDataException e) {
			assertThat(e, instanceOf(InvalidDataException.class));
			assertThat(e.getMessage(), is("The reference type 'singularity' is not defined in the CFF format specifications."));
			return;
		}
		fail();
	}

	/**
	 * Creates a new {@link Reference} object, passing an undefined reference language into the constructor.
	 * 
	 * Expects an {@link InvalidDataException}.
	 * @throws InvalidDataException 
	 */
	@Test(expected = InvalidDataException.class)
	public final void testReferenceBadLanguage() throws InvalidDataException {
		new Reference("book", "title", new ArrayList<Subject>(Arrays.asList(new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null))), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ArrayList<String>(Arrays.asList("BAD LANGUAGE!")), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	}

	/**
	 * Creates a new {@link Reference} object, passing an undefined reference language into the constructor.
	 * 
	 * Catches the expected {@link InvalidDataException} and asserts the exception message.
	 */
	@Test
	public final void testReferenceBadLanguageMessage() {
		try {
			new Reference("book", "title", new ArrayList<Subject>(Arrays.asList(new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null))), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ArrayList<String>(Arrays.asList("BAD LANGUAGE!")), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		}
		catch (InvalidDataException e) {
			assertThat(e, instanceOf(InvalidDataException.class));
			assertThat(e.getMessage(), is("The language 'BAD LANGUAGE!' is not a valid ISO 639-1 or 639-3 code."));
			return;
		}
		fail();
	}

	/**
	 * Creates a new {@link Reference} object, passing a too short (and undefined) reference language into the constructor.
	 * 
	 * Catches the expected {@link InvalidDataException} and asserts the exception message.
	 */
	@Test
	public final void testReferenceBadNonAlphabeticalLanguageMessage() {
		try {
			new Reference("book", "title", new ArrayList<Subject>(Arrays.asList(new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null))), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new ArrayList<String>(Arrays.asList("ö")), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		}
		catch (InvalidDataException e) {
			assertThat(e, instanceOf(InvalidDataException.class));
			assertThat(e.getMessage(), is("The language 'ö' is not a valid ISO 639-1 or 639-3 code."));
			return;
		}
		fail();
	}

	/**
	 * Creates a new {@link Reference} object, passing an undefined reference status into the constructor.
	 * 
	 * Expects an {@link InvalidDataException}.
	 * @throws InvalidDataException 
	 */
	@Test(expected = InvalidDataException.class)
	public final void testReferenceBadStatus() throws InvalidDataException {
			new Reference("book", "title", new ArrayList<Subject>(Arrays.asList(new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null))), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "BAD STATUS!", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	}

	/**
	 * Creates a new {@link Reference} object, passing an undefined reference status into the constructor.
	 * 
	 * Catches the expected {@link InvalidDataException} and asserts the exception message.
	 */
	@Test
	public final void testReferenceBadStatusMessage() {
		try {
			new Reference("book", "title", new ArrayList<Subject>(Arrays.asList(new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null))), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "BAD STATUS!", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		}
		catch (InvalidDataException e) {
			assertThat(e, instanceOf(InvalidDataException.class));
			assertThat(e.getMessage(), is("The status 'BAD STATUS!' is not defined in the CFF format specifications."));
			return;
		}
		fail();
	}
	
	/**
	 * Creates a new {@link Reference} object, passing only the required fields into the constructor.
	 * 
	 * In this scenario, no exceptions should be thrown.
	 * 
	 * @throws InvalidDataException 
	 */
	@Test
	public final void testOnlyRequiredValues() throws InvalidDataException {
		new Reference("book", "title", new ArrayList<Subject>(Arrays.asList(new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null))), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	}


}
