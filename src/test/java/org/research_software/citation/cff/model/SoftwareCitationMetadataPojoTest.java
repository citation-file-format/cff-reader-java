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
 * Unit tests for {@link SoftwareCitationMetadataPojo}.
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@SuppressWarnings("javadoc")
public class SoftwareCitationMetadataPojoTest {

	/**
	 * Creates a new {@link SoftwareCitationMetadataPojo} object, passing an invalid CFF version into the constructor.
	 * 
	 * Expects an {@link InvalidDataException}.
	 * 
	 * @throws InvalidDataException
	 */
	@Test(expected = InvalidDataException.class)
	public final void testWrongCFFVersion() throws InvalidDataException {
		new SoftwareCitationMetadataPojo("1.0.2", "message", new ArrayList<Subject>(Arrays.asList(new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null))), "2018-01-31", "Title", "1.0.0", null, null, null, null, null, null, null, null, null, null, null, null);
	}
	
	/**
	 * Creates a new {@link SoftwareCitationMetadataPojo} object, passing an invalid CFF version into the constructor.
	 * 
	 * Catches the expected {@link InvalidDataException} and asserts the exception message.
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
