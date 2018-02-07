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
package org.research_software.citation.cff.model.objects;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.research_software.citation.cff.exceptions.InvalidDataException;

/**
 * Unit tests for {@link Subject}.
 * 
 * Uses instances of type {@link Person} as proxy objects as {@link Subject} is `abstract`.
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class SubjectTest {

	/**
	 * Creates a new {@link Reference} object, passing an invalid ORCID iD into the constructor.
	 * 
	 * Expects an {@link InvalidDataException}.
	 * 
	 * @throws InvalidDataException 
	 */
	@Test(expected = InvalidDataException.class)
	public final void testBadOrcidPattern() throws InvalidDataException {
		new Person(null, null, null, null, null, null, null, null, null, null, "", null, null, null, null);
	}
	
	/**
	 * Creates a new {@link Person} object, passing an an invalid ORCID iD into the constructor.
	 * 
	 * Catches the expected {@link InvalidDataException} and asserts the exception message.
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
	 * Creates a new {@link Reference} object, passing an invalid country into the constructor.
	 * 
	 * Expects an {@link InvalidDataException}.
	 * 
	 * @throws InvalidDataException 
	 */
	@Test(expected = InvalidDataException.class)
	public final void testBadCountry() throws InvalidDataException {
		new Person(null, null, null, null, null, null, null, null, null, "NOMANSLAND", null, null, null, null, null);
	}
	
	/**
	 * Creates a new {@link Person} object, passing an an invalid country into the constructor.
	 * 
	 * Catches the expected {@link InvalidDataException} and asserts the exception message.
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
	 * Creates a new {@link Reference} object, passing an invalid website URL into the constructor.
	 * 
	 * Expects an {@link InvalidDataException}.
	 * 
	 * @throws InvalidDataException 
	 */
	@Test(expected = InvalidDataException.class)
	public final void testBadWebsite() throws InvalidDataException {
		new Person(null, null, null, null, null, null, null, null, null, null, null, null, null, null, "NOTAWEBSITEURL");
	}
	
	/**
	 * Creates a new {@link Person} object, passing an an invalid country into the constructor.
	 * 
	 * Catches the expected {@link InvalidDataException} and asserts the exception message.
	 */
	@Test
	public final void testBadWebsiteMessage() {
		try {
			new Person(null, null, null, null, null, null, null, null, null, null, null, null, null, null, "NOTAWEBSITEURL");
		}
		catch (InvalidDataException e) {
			assertThat(e, instanceOf(InvalidDataException.class));
			assertThat(e.getMessage(), is("The 'website' URL 'NOTAWEBSITEURL' is not valid."));
			return;
		}
		fail();
	}
	
	/**
	 * Creates new {@link Person} and {@link Entity} objects, passing only the required fields into the constructor.
	 * 
	 * In this scenario, no exceptions should be thrown.
	 * 
	 * @throws InvalidDataException
	 */
	@Test
	public final void testOnlyRequiredValues() throws InvalidDataException {
		new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null);
		new Entity("N", null, null, null, null, null, null, null, null, null, null, null, null, null);
	}

}
