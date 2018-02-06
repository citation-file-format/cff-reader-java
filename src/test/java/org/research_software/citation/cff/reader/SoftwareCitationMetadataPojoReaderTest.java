/**
 * 
 */
package org.research_software.citation.cff.reader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.research_software.citation.cff.model.SoftwareCitationMetadata;
import org.research_software.citation.cff.exceptions.InvalidCFFFileNameException;
import org.research_software.citation.cff.exceptions.InvalidDataException;
import org.research_software.citation.cff.exceptions.ReadException;
import org.research_software.citation.cff.model.objects.Entity;
import org.research_software.citation.cff.model.objects.Person;
import org.research_software.citation.cff.model.objects.Reference;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class SoftwareCitationMetadataPojoReaderTest {

	private static final String CITATION_FILE_PATH = "CITATION.cff";
	private static final String INVALID_CITATION_FILE_PATH = "invalid-files/CITATION.cff";
	private static final String CITATION_FILE_PATH_WITH_PRECEDING_SLASH = "/" + CITATION_FILE_PATH;
	private static final String INVALID_CITATION_FILE_PATH_WITH_PRECEDING_SLASH = "/" + INVALID_CITATION_FILE_PATH;
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
	 * @throws InvalidCFFFileNameException
	 * @throws ReadException
	 * @throws MalformedURLException
	 */
	@Test
	public final void testReadFromFile() throws InvalidCFFFileNameException, ReadException, MalformedURLException {
		File cffFile = new File(getClass().getClassLoader().getResource(CITATION_FILE_PATH).getFile());
		SoftwareCitationMetadata citation = null;
		citation = getFixture().readFromFile(cffFile);
		test(citation);
	}

	/**
	 * // TODO Add description
	 * 
	 * @throws ReadException
	 * @throws MalformedURLException
	 */
	@Test
	public final void testReadFromStream() throws ReadException, MalformedURLException {
		InputStream stream = this.getClass().getResourceAsStream(CITATION_FILE_PATH_WITH_PRECEDING_SLASH);
		SoftwareCitationMetadata citation = null;
		citation = getFixture().readFromStream(stream);
		test(citation);
	}
	
	/**
	 * // TODO Add description
	 * 
	 * @throws InvalidCFFFileNameException
	 * @throws ReadException
	 */
	@Test(expected = InvalidCFFFileNameException.class)
	public final void testBadCFFFileName() throws InvalidCFFFileNameException, ReadException {
		File file = new File("CITATION.xff");
		getFixture().readFromFile(file);
	}
	
	/**
	 * // TODO Add description
	 * 
	 * @throws ReadException
	 * @throws InvalidCFFFileNameException
	 */
	@Test(expected = ReadException.class)
	public final void testInvalidFile() throws ReadException, InvalidCFFFileNameException {
		File file = new File(INVALID_CITATION_FILE_PATH);
		getFixture().readFromFile(file);
	}
	
	/**
	 * // TODO Add description
	 * 
	 * @throws InvalidCFFFileNameException
	 * @throws ReadException
	 */
	@Test(expected = ReadException.class)
	public final void testInvalidStream() throws InvalidCFFFileNameException, ReadException {
		InputStream stream = this.getClass().getResourceAsStream(INVALID_CITATION_FILE_PATH_WITH_PRECEDING_SLASH);
		getFixture().readFromStream(stream);
	}
	
	/**
	 * // TODO Add description
	 * 
	 * @throws InvalidDataException
	 */
	@Test
	public final void testBadCFFFileNameMessage() throws InvalidDataException {
		File file = new File("CITATION.xff");
		try {
			getFixture().readFromFile(file);
		}
		catch (InvalidCFFFileNameException | ReadException e) {
			assertThat(e, instanceOf(InvalidCFFFileNameException.class));
			assertThat(e.getMessage(), is("File name of CFF file must be 'CITATION.cff' (is 'CITATION.xff')!"));
			return;
		}
		fail();
	}
	
	private void test(SoftwareCitationMetadata citation) throws MalformedURLException {
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
		assertThat(citation.getLicenseUrl(), is(new URL("https://spdx.org/licenses/CC-BY-SA-4.0.html#licenseText")));
		assertThat(citation.getRepository(), is(new URL("https://www.example.com/foo/?bar=baz&inga=42&quux")));
		assertThat(citation.getRepositoryCode(), is(new URL("http://foo.com/blah_(wikipedia)_blah#cite-1")));
		assertThat(citation.getRepositoryArtifact(), is(new URL("http://उदाहरण.परीक्षा")));
		assertThat(citation.getTitle(), is("Citation File Format 1.0.0"));
		assertThat(citation.getUrl(), is(new URL("http://userid:password@example.com:8080/")));
		assertThat(citation.getVersion(), is("1.0.0"));

		// Test authors
		assertThat(citation.getAuthors().size(), is(2));
		assertThat(citation.getPersonAuthors().size(), is(1));
		assertThat(citation.getEntityAuthors().size(), is(1));
		assertTrue(citation.getAuthors().containsAll(citation.getPersonAuthors()));
		assertTrue(citation.getAuthors().containsAll(citation.getEntityAuthors()));

		// Test person author
		Person personAuthor = citation.getPersonAuthors().get(0);
		testPerson(personAuthor);

		// Test entity author
		Entity entityAuthor = citation.getEntityAuthors().get(0);
		testEntity(entityAuthor);

		// Test contact
		assertThat(citation.getContacts().size(), is(2));
		assertThat(citation.getPersonContacts().size(), is(1));
		assertThat(citation.getEntityContacts().size(), is(1));
		assertTrue(citation.getContacts().containsAll(citation.getPersonContacts()));
		assertTrue(citation.getContacts().containsAll(citation.getEntityContacts()));

		// Test person contact
		Person personContact = citation.getPersonContacts().get(0);
		testPerson(personContact);

		// Test entity contat
		Entity entityContact = citation.getEntityContacts().get(0);
		testEntity(entityContact);

		// Test references
		assertThat(citation.getReferences().size(), is(1));
		Reference reference = citation.getReferences().get(0);
		assertThat(reference.getType(), is("book"));
		assertThat(reference.getTitle(), is("Book Title"));
		assertThat(reference.getAbbreviation(), is("Abbr"));
		assertThat(reference.getAbstract(), is("Description of the book."));
		assertThat(reference.getCollectionDoi(), is("10.5281/zenodo.1003150"));
		assertThat(reference.getCollectionTitle(), is("Collection Title"));
		assertThat(reference.getCollectionType(), is("Collection Type"));
		assertThat(reference.getCommit(), is("156a04c74a8a79d40c5d705cddf9d36735feab4d"));
		assertThat(reference.getCopyright(), is("2017 Stephan Druskat"));
		assertThat(reference.getDataType(), is("Data Type"));
		assertThat(reference.getDatabase(), is("Database"));
		assertThat(reference.getDateAccessed(), is(LocalDate.parse("2017-10-31")));
		assertThat(reference.getDateDownloaded(), is(LocalDate.parse("2017-10-31")));
		assertThat(reference.getDateReleased(), is(LocalDate.parse("2017-10-31")));
		assertThat(reference.getDatePublished(), is(LocalDate.parse("2017-10-31")));
		assertThat(reference.getDepartment(), is("Department"));
		assertThat(reference.getDoi(), is("10.5281/zenodo.1003150"));
		assertThat(reference.getEdition(), is("2nd edition"));
		assertThat(reference.getEnd(), is(123));
		assertThat(reference.getEntry(), is("Chapter 9"));
		assertThat(reference.getFilename(), is("book.zip"));
		assertThat(reference.getFormat(), is("Printed book"));
		assertThat(reference.getIsbn(), is("978-1-89183-044-0"));
		assertThat(reference.getIssn(), is("1234-543X"));
		assertThat(reference.getIssue(), is("123"));
		assertThat(reference.getIssueDate(), is("December"));
		assertThat(reference.getIssueTitle(), is("Special Issue on Software Citation"));
		assertThat(reference.getJournal(), is("PeerJ"));
		assertThat(reference.getKeywords(), is(Arrays.asList(new String[] { "Software", "Citation" })));
		assertThat(reference.getLanguages(), is(Arrays.asList(new String[] { "aaa", "zu" })));
		assertThat(reference.getLicense(), is("Apache-2.0"));
		assertThat(reference.getLicenseUrl(), is(new URL("https://spdx.org/licenses/Apache-2.0.html#licenseText")));
		assertThat(reference.getLocStart(), is(14));
		assertThat(reference.getLocEnd(), is(54));
		assertThat(reference.getMedium(), is("hardcover book"));
		assertThat(reference.getMonth(), is(03));
		assertThat(reference.getNihmsid(), is("Don't know what format a NIHMSID is in"));
		assertThat(reference.getNotes(),
				is("A field for general notes about the reference, usable in other formats such as BibTeX."));
		assertThat(reference.getNumber(),
				is("A general-purpose field for accession numbers, cf. the specifications for examples."));
		assertThat(reference.getNumberVolumes(), is(7));
		assertThat(reference.getPages(), is(765));
		assertThat(reference.getPatentStates(), is(Arrays
				.asList(new String[] { "Germany", "ROI", "but also for example US states, such as:", "IL", "RI" })));
		assertThat(reference.getPmcid(), is("PMC1234567"));
		assertThat(reference.getRepository(), is(new URL("http://code.google.com/events/#&product=browser")));
		assertThat(reference.getRepositoryCode(), is(new URL("http://142.42.1.1:8080/")));
		assertThat(reference.getRepositoryArtifact(), is(new URL("http://مثال.إختبار")));
		assertThat(reference.getScope(), is(
				"Cite this book if you want to reference the general concepts implemented in Citation File Format 1.0.0."));
		assertThat(reference.getSection(), is("Chapter 2 - \"Reference keys\""));
		assertThat(reference.getStatus(), is("advance-online"));
		assertThat(reference.getStart(), is(123));
		assertThat(reference.getThesisType(), is("Doctoral dissertation"));
		assertThat(reference.getUrl(), is(new URL("http://j.mp")));
		assertThat(reference.getVersion(), is("0.0.1423-BETA"));
		assertThat(reference.getVolume(), is(2));
		assertThat(reference.getVolumeTitle(), is("Advances in Software Citation"));
		assertThat(reference.getYear(), is(2017));
		assertThat(reference.getYearOriginal(), is(2012));

	}

	private void testEntity(Entity entityAuthor) throws MalformedURLException {
		assertThat(entityAuthor.getName(), is("Entity Project Team Conference entity"));
		assertThat(entityAuthor.getAddress(), is("22 Acacia Avenue"));
		assertThat(entityAuthor.getCity(), is("Citationburgh"));
		assertThat(entityAuthor.getRegion(), is("Renfrewshire"));
		assertThat(entityAuthor.getPostCode(), is("C13 7X7"));
		assertThat(entityAuthor.getCountry(), is("GB"));
		assertThat(entityAuthor.getOrcid(), is(new URL("https://orcid.org/0000-0001-2345-6789")));
		assertThat(entityAuthor.getEmail(), is("project@entity.com"));
		assertThat(entityAuthor.getTel(), is("+44(0)141-323 4567"));
		assertThat(entityAuthor.getFax(), is("+44(0)141-323 45678"));
		assertThat(entityAuthor.getWebsite(), is(new URL("https://www.entity-project-team.io")));
		assertThat(entityAuthor.getDateStart(), is(LocalDate.parse("2017-01-01")));
		assertThat(entityAuthor.getDateEnd(), is(LocalDate.parse("2017-01-31")));
		assertThat(entityAuthor.getLocation(), is("The team garage"));
	}

	private void testPerson(Person person) throws MalformedURLException {
		assertThat(person.getAddress(), is("22 Acacia Avenue"));
		assertThat(person.getAffiliation(), is("Excellent University, Niceplace, Arcadia"));
		assertThat(person.getCity(), is("Citationburgh"));
		assertThat(person.getCountry(), is("GB"));
		assertThat(person.getEmail(), is("project@entity.com"));
		assertThat(person.getFamilyNames(), is("Real Person"));
		assertThat(person.getFax(), is("+44(0)141-323 45678"));
		assertThat(person.getGivenNames(), is("One Truly"));
		assertThat(person.getNameParticle(), is("van der"));
		assertThat(person.getNameSuffix(), is("IV"));
		assertThat(person.getOrcid(), is(new URL("https://orcid.org/0000-0001-2345-6789")));
		assertThat(person.getPostCode(), is("C13 7X7"));
		assertThat(person.getRegion(), is("Renfrewshire"));
		assertThat(person.getTel(), is("+44(0)141-323 4567"));
		assertThat(person.getWebsite(), is(new URL("https://www.entity-project-team.io")));
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
