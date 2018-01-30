/**
 * 
 */
package org.research_software.citation.cff.reader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.research_software.citation.cff.model.SoftwareCitationMetadata;
import org.research_software.citation.cff.model.objects.Entity;
import org.research_software.citation.cff.model.objects.Person;
import org.research_software.citation.cff.model.objects.Subject;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class SoftwareCitationMetadataPojoReaderTest {

	private static final String CITATION_FILE_PATH_WITH_PRECEDING_BACKSLASH = "/CITATION.cff";
	private SoftwareCitationMetadataPojoReader fixture = null;

	/**
	 * // TODO Add description
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		setFixture(new SoftwareCitationMetadataPojoReader());
	}

	/**
	 * // TODO Add description
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	// /**
	// * Test method for {@link
	// org.research_software.citation.cff.reader.SoftwareCitationMetadataPojoReader#readFromFile(java.io.File)}.
	// */
	// @Test
	// public final void testReadFromFile() {
	// fail("Not yet implemented"); // TODO
	// }

	/**
	 * Test method for
	 * {@link org.research_software.citation.cff.reader.SoftwareCitationMetadataPojoReader#readFromStream(java.io.InputStream)}.
	 */
	@Test
	public final void testReadFromStream() {
		InputStream stream = this.getClass().getResourceAsStream(CITATION_FILE_PATH_WITH_PRECEDING_BACKSLASH);
		SoftwareCitationMetadata citation = null;
		try {
			citation = getFixture().readFromStream(stream);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		test(citation);
	}

	private void test(SoftwareCitationMetadata citation) {
		assertNotNull(citation);
		
		// Test basic values
		
		assertThat(citation.getCffVersion(), is("1.0.3"));
		assertThat(citation.getMessage(), is("If you use this software, please cite it as below."));
		assertThat(citation.getAbstract(), is("This is an awesome piece of research software!"));
		assertThat(citation.getCommit(), is("156a04c74a8a79d40c5d705cddf9d36735feab4d"));
		assertThat(citation.getDateReleased(), is(LocalDate.parse("2017-12-11")));
		assertThat(citation.getDoi(), is("10.5281/zenodo.1003150"));
		assertThat(citation.getKeywords(), containsInAnyOrder("One", "Two", "Three", "4"));
		assertThat(citation.getLicense(), is("CC-BY-SA-4.0"));
		assertThat(citation.getLicenseUrl(), is("https://spdx.org/licenses/CC-BY-SA-4.0.html#licenseText"));
		assertThat(citation.getRepository(), is("https://www.example.com/foo/?bar=baz&inga=42&quux"));
		assertThat(citation.getRepositoryCode(), is("http://foo.com/blah_(wikipedia)_blah#cite-1"));
		assertThat(citation.getRepositoryArtifact(), is("http://उदाहरण.परीक्षा"));
		assertThat(citation.getTitle(), is("Citation File Format 1.0.0"));
		assertThat(citation.getUrl(), is("http://userid:password@example.com:8080/"));
		assertThat(citation.getVersion(), is("1.0.0"));
		
		// Test authors
		assertThat(citation.getAuthors().size(), is(2));
		assertThat(citation.getPersonAuthors().size(), is(1));
		assertThat(citation.getEntityAuthors().size(), is(1));
		assertTrue(citation.getAuthors().containsAll(citation.getPersonAuthors()));
		assertTrue(citation.getAuthors().containsAll(citation.getEntityAuthors()));
		
		// Test person author
		Person personAuthor = citation.getPersonAuthors().get(0);
		assertThat(personAuthor.getAddress(), is("22 Acacia Avenue"));
		assertThat(personAuthor.getAffiliation(), is("Excellent University, Niceplace, Arcadia"));
		assertThat(personAuthor.getCity(), is("Citationburgh"));
		assertThat(personAuthor.getCountry(), is("GB"));
		assertThat(personAuthor.getEmail(), is("project@entity.com"));
		assertThat(personAuthor.getFamilyNames(), is("Real Person"));
		assertThat(personAuthor.getFax(), is("+44(0)141-323 45678"));
		assertThat(personAuthor.getGivenNames(), is("One Truly"));
		assertThat(personAuthor.getNameParticle(), is("van der"));
		assertThat(personAuthor.getNameSuffix(), is("IV"));
		assertThat(personAuthor.getOrcid(), is("https://orcid.org/0000-0001-2345-6789"));
		assertThat(personAuthor.getPostCode(), is("C13 7X7"));
		assertThat(personAuthor.getRegion(), is("Renfrewshire"));
		assertThat(personAuthor.getTel(), is("+44(0)141-323 4567"));
		assertThat(personAuthor.getWebsite(), is("https://www.entity-project-team.io"));
		
		// Test contact
		assertThat(citation.getContacts().size(), is(2));
		assertThat(citation.getPersonContacts().size(), is(1));
		assertThat(citation.getEntityContacts().size(), is(1));
		
	}

	/**
	 * @return the fixture
	 */
	private final SoftwareCitationMetadataPojoReader getFixture() {
		return fixture;
	}

	/**
	 * @param fixture
	 *            the fixture to set
	 */
	private final void setFixture(SoftwareCitationMetadataPojoReader fixture) {
		this.fixture = fixture;
	}

}
