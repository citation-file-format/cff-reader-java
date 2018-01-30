/**
 * 
 */
package org.research_software.citation.cff.model;

import java.time.LocalDate;
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
final public class SoftwareCitationMetadataPojo implements SoftwareCitationMetadata {

	@JsonProperty("cff-version")
	private String cffVersion;
	@JsonProperty("message")
	private String message;
	@JsonProperty("abstract")
	private String abstractString; // "abstract" is a reserved term
	@JsonProperty("authors")
	private List<Subject> authors = new ArrayList<Subject>();
	@JsonProperty("commit")
	private String commit;
	@JsonProperty("contact")
	private List<Subject> contact = new ArrayList<Subject>();
	@JsonProperty("date-released")
	private LocalDate dateReleased;
	@JsonProperty("doi")
	private String doi;
	@JsonProperty("keywords")
	private List<String> keywords = new ArrayList<String>();
	@JsonProperty("license")
	private String license;
	@JsonProperty("license-url")
	private String licenseUrl;
	@JsonProperty("repository")
	private String repository;
	@JsonProperty("repository-code")
	private String repositoryCode;
	@JsonProperty("repository-artifact")
	private String repositoryArtifact;
	@JsonProperty("title")
	private String title;
	@JsonProperty("url")
	private String url;
	@JsonProperty("version")
	private String version;
	@JsonProperty("references")
	private List<Reference> references = new ArrayList<Reference>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public SoftwareCitationMetadataPojo() {
	}

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
	 * @param _abstract
	 * @param license
	 * @param doi
	 * @param licenseUrl
	 * @param cffVersion
	 */
	public SoftwareCitationMetadataPojo(String cffVersion, String message, String _abstract, List<Subject> authors,
			String commit, List<Subject> contact, String dateReleased, String doi, List<String> keywords,
			String license, String licenseUrl, String repository, String repositoryCode, String repositoryArtifact,
			String title, String url, String version, List<Reference> references) {
		super();
		this.cffVersion = cffVersion;
		this.message = message;
		this.abstractString = _abstract;
		this.authors = authors;
		this.commit = commit;
		this.contact = contact;
		setDateReleased(dateReleased);
		this.doi = doi;
		this.keywords = keywords;
		this.license = license;
		this.licenseUrl = licenseUrl;
		this.repository = repository;
		this.repositoryCode = repositoryCode;
		this.repositoryArtifact = repositoryArtifact;
		this.title = title;
		this.url = url;
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
	public void setDateReleased(String dateReleased) {
		this.dateReleased = LocalDate.parse(dateReleased);
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
	public String getLicenseUrl() {
		return licenseUrl;
	}

	@JsonProperty("license-url")
	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	@JsonProperty("repository")
	public String getRepository() {
		return repository;
	}

	@JsonProperty("repository")
	public void setRepository(String repository) {
		this.repository = repository;
	}

	@JsonProperty("repository-code")
	public String getRepositoryCode() {
		return repositoryCode;
	}

	@JsonProperty("repository-code")
	public void setRepositoryCode(String repositoryCode) {
		this.repositoryCode = repositoryCode;
	}

	@JsonProperty("repository-artifact")
	public String getRepositoryArtifact() {
		return repositoryArtifact;
	}

	@JsonProperty("repository-artifact")
	public void setRepositoryArtifact(String repositoryArtifact) {
		this.repositoryArtifact = repositoryArtifact;
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
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
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