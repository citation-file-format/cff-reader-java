/**
 * 
 */
package org.research_software.citation.cff.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.research_software.citation.cff.model.objects.Entity;
import org.research_software.citation.cff.model.objects.Person;
import org.research_software.citation.cff.model.objects.Reference;
import org.research_software.citation.cff.model.objects.Subject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * // TODO Add description
 * 
 * @version Citation File Format Version 1.0.3
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
final class SoftwareCitationMetadataPojo implements SoftwareCitationMetadata {

	private String cffVersion;
	private String message;
	private String abstractString; // "abstract" is a reserved term
	private List<Subject> authors = new ArrayList<Subject>();
	private String commit;
	private List<Subject> contact = new ArrayList<Subject>();
	private LocalDate dateReleased;
	private String doi;
	private List<String> keywords = new ArrayList<String>();
	private String license;
	private URL licenseUrl;
	private URL repository;
	private URL repositoryCode;
	private URL repositoryArtifact;
	private String title;
	private URL url;
	private String version;
	private List<Reference> references = new ArrayList<Reference>();

	/**
	 *
	 * @param repositoryArtifact
	 * @param dateReleased
	 * @param keywords
	 * @param contact
	 * @param url
	 * @param version
	 * @param message
	 * @param authors
	 * @param references
	 * @param title
	 * @param repositoryCode
	 * @param commit
	 * @param repository
	 * @param license
	 * @param doi
	 * @param licenseUrl
	 * @param cffVersion
	 * @param abstractString
	 * @throws MalformedURLException 
	 * @throws NullPointerException
	 * @throws DateTimeParseException
	 */
	public SoftwareCitationMetadataPojo (
			@JsonProperty("cff-version") String cffVersion,
			@JsonProperty("message") String message,
			@JsonProperty("abstract") String abstractString,
			@JsonProperty(value="authors", required=true) List<Subject> authors,
			@JsonProperty("commit") String commit,
			@JsonProperty("contact") List<Subject> contact,
			@JsonProperty("date-released") String dateReleased,
			@JsonProperty("doi") String doi,
			@JsonProperty("keywords") List<String> keywords,
			@JsonProperty("license") String license,
			@JsonProperty("license-url") String licenseUrl,
			@JsonProperty("repository") String repository,
			@JsonProperty("repository-code") String repositoryCode,
			@JsonProperty("repository-artifact") String repositoryArtifact,
			@JsonProperty("title") String title,
			@JsonProperty("url") String url,
			@JsonProperty("version") String version,
			@JsonProperty("references") List<Reference> references) throws MalformedURLException, DateTimeParseException, NullPointerException {
		super();
		if (cffVersion == null) {
			throw new NullPointerException("'cff-version' is a required key and must be present and not null!");
		}
		this.cffVersion = cffVersion;
		if (message == null) {
			throw new NullPointerException("'message' is a required key and must be present and not null!");
		}
		this.message = message;
		this.abstractString = abstractString;
		if (authors == null) {
			throw new NullPointerException("'authors' is a required key and must be present and not null!");
		}
		this.authors = authors;
		this.commit = commit;
		this.contact = contact;
		if (dateReleased == null) {
			throw new NullPointerException("'date-released' is a required key and must be present and not null!");
		}
		setDateReleased(dateReleased);
		this.doi = doi;
		this.keywords = keywords;
		this.license = license;
		setLicenseUrl(licenseUrl);
		setRepository(repository);
		setRepositoryCode(repositoryCode);
		setRepositoryArtifact(repositoryArtifact);
		if (title == null) {
			throw new NullPointerException("'title' is a required key and must be present and not null!");
		}
		this.title = title;
		setUrl(url);
		if (version == null) {
			throw new NullPointerException("'version' is a required key and must be present and not null!");
		}
		this.version = version;
		this.references = references;
	}

	@JsonProperty("cff-version")
	public String getCffVersion() {
		return cffVersion;
	}

	@JsonProperty("cff-version")
	public void setCffVersion(String cffVersion) {
		this.cffVersion = cffVersion;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("abstract")
	public String getAbstract() {
		return abstractString;
	}

	@JsonProperty("abstract")
	public void setAbstract(String _abstract) {
		this.abstractString = _abstract;
	}

	@JsonProperty("authors")
	public List<Subject> getAuthors() {
		return authors;
	}
	
	/* (non-Javadoc)
	 * @see org.research_software.citation.cff.model.SoftwareCitationMetadata#getPersonAuthors()
	 */
	@Override
	public List<Person> getPersonAuthors() {
		return filterPersons(getAuthors());
	}

	/* (non-Javadoc)
	 * @see org.research_software.citation.cff.model.SoftwareCitationMetadata#getEntityAuthors()
	 */
	@Override
	public List<Entity> getEntityAuthors() {
		return filterEntities(getAuthors());
	}

	@JsonProperty("authors")
	public void setAuthors(List<Subject> authors) {
		this.authors = authors;
	}

	@JsonProperty("commit")
	public String getCommit() {
		return commit;
	}

	@JsonProperty("commit")
	public void setCommit(String commit) {
		this.commit = commit;
	}

	@JsonProperty("contact")
	public List<Subject> getContacts() {
		return contact;
	}
	
	/* (non-Javadoc)
	 * @see org.research_software.citation.cff.model.SoftwareCitationMetadata#getPersonContacts()
	 */
	@Override
	public List<Person> getPersonContacts() {
		return filterPersons(getContacts());
	}

	/* (non-Javadoc)
	 * @see org.research_software.citation.cff.model.SoftwareCitationMetadata#getEntityContacts()
	 */
	@Override
	public List<Entity> getEntityContacts() {
		return filterEntities(getContacts());
	}

	/**
	 * // TODO Add description
	 * 
	 * @param contact
	 */
	@JsonProperty("contact")
	public void setContact(List<Subject> contact) {
		this.contact = contact;
	}

	@JsonProperty("date-released")
	public LocalDate getDateReleased() {
		return dateReleased;
	}

	@JsonProperty("date-released")
	public void setDateReleased(String dateReleased) throws DateTimeParseException {
		try {
			this.dateReleased = LocalDate.parse(dateReleased);
		}
		catch (DateTimeParseException e) {
			throw new DateTimeParseException("DateTimeParseException in field 'date-released'!", e.getParsedString(), e.getErrorIndex(), e);
		}
	}

	@JsonProperty("doi")
	public String getDoi() {
		return doi;
	}

	@JsonProperty("doi")
	public void setDoi(String doi) {
		this.doi = doi;
	}

	@JsonProperty("keywords")
	public List<String> getKeywords() {
		return keywords;
	}

	@JsonProperty("keywords")
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	@JsonProperty("license")
	public String getLicense() {
		return license;
	}

	@JsonProperty("license")
	public void setLicense(String license) {
		this.license = license;
	}

	@JsonProperty("license-url")
	public URL getLicenseUrl() {
		return licenseUrl;
	}

	@JsonProperty("license-url")
	private void setLicenseUrl(String licenseUrl) throws MalformedURLException {
		try {
			this.licenseUrl = new URL(licenseUrl);
		}
		catch (MalformedURLException e) {
			throw new MalformedURLException("The citation metadata for '" + getTitle() + "' contains an invalid URL in field 'license-url': " + e.getMessage());
		}
	}

	@JsonProperty("repository")
	public URL getRepository() {
		return repository;
	}

	@JsonProperty("repository")
	private void setRepository(String repository) throws MalformedURLException {
		try {
			this.repository = new URL(repository);
		}
		catch (MalformedURLException e) {
			throw new MalformedURLException("The citation metadata for '" + getTitle() + "' contains an invalid URL in field 'repository': " + e.getMessage());
		}
	}

	@JsonProperty("repository-code")
	public URL getRepositoryCode() {
		return repositoryCode;
	}

	@JsonProperty("repository-code")
	private void setRepositoryCode(String repositoryCode) throws MalformedURLException {
		try {
			this.repositoryCode = new URL(repositoryCode);
		}
		catch (MalformedURLException e) {
			throw new MalformedURLException("The citation metadata for '" + getTitle() + "' contains an invalid URL in field 'repository-code': " + e.getMessage());
		}
	}

	@JsonProperty("repository-artifact")
	public URL getRepositoryArtifact() {
		return repositoryArtifact;
	}

	@JsonProperty("repository-artifact")
	private void setRepositoryArtifact(String repositoryArtifact) throws MalformedURLException {
		try {
			this.repositoryArtifact = new URL(repositoryArtifact);
		}
		catch (MalformedURLException e) {
			throw new MalformedURLException("The citation metadata for '" + getTitle() + "' contains an invalid URL in field 'repository-artifact': " + e.getMessage());

		}
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("url")
	public URL getUrl() {
		return url;
	}

	@JsonProperty("url")
	private void setUrl(String url) throws MalformedURLException {
		try {
			this.url = new URL(url);
		}
		catch (MalformedURLException e) {
			throw new MalformedURLException("The citation metadata for '" + getTitle() + "' contains an invalid URL in field 'url': " + e.getMessage());
		}
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(String version) {
		this.version = version;
	}

	@JsonProperty("references")
	public List<Reference> getReferences() {
		return references;
	}

	@JsonProperty("references")
	public void setReferences(List<Reference> references) {
		this.references = references;
	}
	
	/*
	 * HELPER METHODS
	 */

	private List<Person> filterPersons(List<Subject> subjects) {
		List<Person> personList = new ArrayList<>();
		for (Subject subject : subjects) {
			if (subject instanceof Person) {
				personList.add((Person) subject);
			}
		}
		return personList;
	}

	private List<Entity> filterEntities(List<Subject> subjects) {
		List<Entity> entityList = new ArrayList<>();
		for (Subject subject : subjects) {
			if (subject instanceof Entity) {
				entityList.add((Entity) subject);
			}
		}
		return entityList;
	}

}