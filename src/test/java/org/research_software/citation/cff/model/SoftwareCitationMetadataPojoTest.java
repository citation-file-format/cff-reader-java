package org.research_software.citation.cff.model;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.research_software.citation.cff.exceptions.CFFModelException;
import org.research_software.citation.cff.model.objects.Person;
import org.research_software.citation.cff.model.objects.Subject;

public class SoftwareCitationMetadataPojoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test(expected = CFFModelException.class)
	public final void testWrongCFFVersion() throws CFFModelException, MalformedURLException {
		new SoftwareCitationMetadataPojo("1.0.2", "message", new ArrayList<Subject>(Arrays.asList(new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null))), "2018-01-31", "Title", "1.0.0", null, null, null, null, null, null, null, null, null, null, null, null);
	}
	
	@Test
	public final void testWrongCFFVersionMessage() {
		try {
			new SoftwareCitationMetadataPojo("1.0.2", "message", new ArrayList<Subject>(Arrays.asList(new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null))), "2018-01-31", "Title", "1.0.0", null, null, null, null, null, null, null, null, null, null, null, null);
		}
		catch (CFFModelException | MalformedURLException e) {
			assertThat(e, instanceOf(CFFModelException.class));
			assertThat(e.getMessage(), is("'cff-version' must be 1.0.3!"));
			return;
		}
		fail();
	}


	@Test
	public final void testOnlyRequiredValues() throws DateTimeParseException, MalformedURLException, NullPointerException {
		new SoftwareCitationMetadataPojo("1.0.3", "message", new ArrayList<Subject>(Arrays.asList(new Person("FN", "GN", null, null, null, null, null, null, null, null, null, null, null, null, null))), "2018-01-31", "Title", "1.0.0", null, null, null, null, null, null, null, null, null, null, null, null);
	}

}
