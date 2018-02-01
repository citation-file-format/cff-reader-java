/**
 * 
 */
package org.research_software.citation.cff.model.objects;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.research_software.citation.cff.exceptions.CFFModelException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Reference {

	private String type;
	private String title;
	private String abbreviation;
	private String abstractString; // "abstract" is a reserved term
	private String collectionDoi;
	private String collectionTitle;
	private String collectionType;
	private String commit;
	private String copyright;
	private String dataType;
	private String database;
	private LocalDate dateAccessed;
	private LocalDate dateDownloaded;
	private LocalDate dateReleased;
	private LocalDate datePublished;
	private String department;
	private String doi;
	private String edition;
	private Integer end;
	private String entry;
	private String filename;
	private String format;
	private String isbn;
	private String issn;
	private String issue;
	private String issueDate;
	private String issueTitle;
	private String journal;
	private List<String> keywords = new ArrayList<String>();
	private List<String> languages = new ArrayList<String>();
	private String license;
	private URL licenseUrl;
	private Integer locStart;
	private Integer locEnd;
	private String medium;
	private Integer month;
	private String nihmsid;
	private String notes;
	private String number;
	private Integer numberVolumes;
	private Integer pages;
	private List<String> patentStates = new ArrayList<String>();
	private String pmcid;
	private URL repository;
	private URL repositoryCode;
	private URL repositoryArtifact;
	private String scope;
	private String section;
	private String status;
	private Integer start;
	private String thesisType;
	private URL url;
	private String version;
	private Integer volume;
	private String volumeTitle;
	private Integer year;
	private Integer yearOriginal;
	private Entity conference;
	private List<Subject> authors;
	private List<Subject> contact;
	private Entity databaseProvider;
	private List<Subject> editors;
	private List<Subject> editorsSeries;
	private Entity institution;
	private Entity location;
	private Entity publisher;
	private List<Subject> recipients;
	private List<Subject> senders;
	private List<Subject> translators;

	/**
	 *
	 * @param dateDownloaded
	 * @param edition
	 * @param nihmsid
	 * @param location
	 * @param databaseProvider
	 * @param dateAccessed
	 * @param editors
	 * @param type
	 * @param authors
	 * @param languages
	 * @param translators
	 * @param commit
	 * @param year
	 * @param collectionTitle
	 * @param conference
	 * @param senders
	 * @param keywords
	 * @param status
	 * @param datePublished
	 * @param number
	 * @param format
	 * @param copyright
	 * @param url
	 * @param locStart
	 * @param collectionDoi
	 * @param repositoryCode
	 * @param start
	 * @param month
	 * @param locEnd
	 * @param patentStates
	 * @param licenseUrl
	 * @param collectionType
	 * @param scope
	 * @param issn
	 * @param department
	 * @param issue
	 * @param contact
	 * @param volumeTitle
	 * @param thesisType
	 * @param publisher
	 * @param version
	 * @param journal
	 * @param title
	 * @param repository
	 * @param isbn
	 * @param license
	 * @param end
	 * @param institution
	 * @param repositoryArtifact
	 * @param dateReleased
	 * @param recipients
	 * @param numberVolumes
	 * @param pages
	 * @param issueDate
	 * @param editorsSeries
	 * @param abbreviation
	 * @param abstractString
	 * @param database
	 * @param medium
	 * @param section
	 * @param issueTitle
	 * @param pmcid
	 * @param dataType
	 * @param yearOriginal
	 * @param entry
	 * @param volume
	 * @param filename
	 * @param notes
	 * @param doi
	 * @throws MalformedURLException
	 * @throws NullPointerException
	 * @throws CFFModelException
	 */
	public Reference(@JsonProperty("type") String type,
			@JsonProperty("title") String title,
			@JsonProperty("authors") List<Subject> authors,
			@JsonProperty("conference") Entity conference,
			@JsonProperty("abbreviation") String abbreviation,
			@JsonProperty("abstract") String abstractString,
			@JsonProperty("collection-doi") String collectionDoi,
			@JsonProperty("collection-title") String collectionTitle,
			@JsonProperty("collection-type") String collectionType,
			@JsonProperty("commit") String commit,
			@JsonProperty("copyright") String copyright,
			@JsonProperty("data-type") String dataType,
			@JsonProperty("database") String database,
			@JsonProperty("date-accessed") String dateAccessed,
			@JsonProperty("date-downloaded") String dateDownloaded,
			@JsonProperty("date-released") String dateReleased,
			@JsonProperty("date-published") String datePublished,
			@JsonProperty("department") String department,
			@JsonProperty("doi") String doi,
			@JsonProperty("edition") String edition,
			@JsonProperty("end") Integer end,
			@JsonProperty("entry") String entry,
			@JsonProperty("filename") String filename,
			@JsonProperty("format") String format,
			@JsonProperty("isbn") String isbn,
			@JsonProperty("issn") String issn,
			@JsonProperty("issue") String issue,
			@JsonProperty("issue-date") String issueDate,
			@JsonProperty("issue-title") String issueTitle,
			@JsonProperty("journal") String journal,
			@JsonProperty("keywords") List<String> keywords,
			@JsonProperty("languages") List<String> languages,
			@JsonProperty("license") String license,
			@JsonProperty("license-url") String licenseUrl,
			@JsonProperty("loc-start") Integer locStart,
			@JsonProperty("loc-end") Integer locEnd,
			@JsonProperty("medium") String medium,
			@JsonProperty("month") Integer month,
			@JsonProperty("nihmsid") String nihmsid,
			@JsonProperty("notes") String notes,
			@JsonProperty("number") String number,
			@JsonProperty("number-volumes") Integer numberVolumes,
			@JsonProperty("pages") Integer pages,
			@JsonProperty("patent-states") List<String> patentStates,
			@JsonProperty("pmcid") String pmcid,
			@JsonProperty("repository") String repository,
			@JsonProperty("repository-code") String repositoryCode,
			@JsonProperty("repository-artifact") String repositoryArtifact,
			@JsonProperty("scope") String scope,
			@JsonProperty("section") String section,
			@JsonProperty("status") String status,
			@JsonProperty("start") Integer start,
			@JsonProperty("thesis-type") String thesisType,
			@JsonProperty("url") String url,
			@JsonProperty("version") String version,
			@JsonProperty("volume") Integer volume,
			@JsonProperty("volume-title") String volumeTitle,
			@JsonProperty("year") Integer year,
			@JsonProperty("year-original") Integer yearOriginal,
			@JsonProperty("contact") List<Subject> contact,
			@JsonProperty("database-provider") Entity databaseProvider,
			@JsonProperty("editors") List<Subject> editors,
			@JsonProperty("editors-series") List<Subject> editorsSeries,
			@JsonProperty("institution") Entity institution,
			@JsonProperty("location") Entity location,
			@JsonProperty("publisher") Entity publisher,
			@JsonProperty("recipients") List<Subject> recipients,
			@JsonProperty("senders") List<Subject> senders,
			@JsonProperty("translators") List<Subject> translators)
			throws MalformedURLException, NullPointerException, CFFModelException {
		super();
		if (type == null) {
			throw new NullPointerException("'type' is a required key in references and must be present and not null!");
		}
		else if (!DefinedValues.REFERENCE_TYPES.contains(type)) {
			throw new CFFModelException("The reference type '" + type + "' is not defined.");
		}
		this.type = type;
		if (title == null) {
			throw new NullPointerException("'title' is a required key in references and must be present and not null!");
		}
		this.title = title;
		if (authors == null || authors.isEmpty()) {
			throw new NullPointerException(
					"'authors' is a required key in references and must be present and not null!");
		}
		this.abbreviation = abbreviation;
		this.abstractString = abstractString;
		this.collectionDoi = collectionDoi;
		this.collectionTitle = collectionTitle;
		this.collectionType = collectionType;
		this.commit = commit;
		this.copyright = copyright;
		this.dataType = dataType;
		this.database = database;
		setDateAccessed(dateAccessed);
		setDateDownloaded(dateDownloaded);
		setDateReleased(dateReleased);
		setDatePublished(datePublished);
		this.department = department;
		this.doi = doi;
		this.edition = edition;
		this.end = end;
		this.entry = entry;
		this.filename = filename;
		this.format = format;
		this.isbn = isbn;
		this.issn = issn;
		this.issue = issue;
		this.issueDate = issueDate;
		this.issueTitle = issueTitle;
		this.journal = journal;
		this.keywords = keywords;
		setLanguages(languages);
		this.license = license;
		setLicenseUrl(licenseUrl);
		this.locStart = locStart;
		this.locEnd = locEnd;
		this.medium = medium;
		this.month = month;
		this.nihmsid = nihmsid;
		this.notes = notes;
		this.number = number;
		this.numberVolumes = numberVolumes;
		this.pages = pages;
		this.patentStates = patentStates;
		this.pmcid = pmcid;
		setRepository(repository);
		setRepositoryCode(repositoryCode);
		setRepositoryArtifact(repositoryArtifact);
		this.scope = scope;
		this.section = section;
		setStatus(status);
		this.start = start;
		this.thesisType = thesisType;
		setUrl(url);
		this.version = version;
		this.volume = volume;
		this.volumeTitle = volumeTitle;
		this.year = year;
		this.yearOriginal = yearOriginal;
		this.conference = conference;
		this.authors = authors;
		this.contact = contact;
		this.databaseProvider = databaseProvider;
		this.editors = editors;
		this.editorsSeries = editorsSeries;
		this.institution = institution;
		this.location = location;
		this.publisher = publisher;
		this.recipients = recipients;
		this.senders = senders;
		this.translators = translators;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	private void setType(String type) {
		this.type = type;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	private void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("abbreviation")
	public String getAbbreviation() {
		return abbreviation;
	}

	@JsonProperty("abbreviation")
	private void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	@JsonProperty("abstract")
	public String getAbstract() {
		return abstractString;
	}

	@JsonProperty("abstract")
	private void setAbstract(String _abstract) {
		this.abstractString = _abstract;
	}

	@JsonProperty("collection-doi")
	public String getCollectionDoi() {
		return collectionDoi;
	}

	@JsonProperty("collection-doi")
	private void setCollectionDoi(String collectionDoi) {
		this.collectionDoi = collectionDoi;
	}

	@JsonProperty("collection-title")
	public String getCollectionTitle() {
		return collectionTitle;
	}

	@JsonProperty("collection-title")
	private void setCollectionTitle(String collectionTitle) {
		this.collectionTitle = collectionTitle;
	}

	@JsonProperty("collection-type")
	public String getCollectionType() {
		return collectionType;
	}

	@JsonProperty("collection-type")
	private void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	@JsonProperty("commit")
	public String getCommit() {
		return commit;
	}

	@JsonProperty("commit")
	private void setCommit(String commit) {
		this.commit = commit;
	}

	@JsonProperty("copyright")
	public String getCopyright() {
		return copyright;
	}

	@JsonProperty("copyright")
	private void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	@JsonProperty("data-type")
	public String getDataType() {
		return dataType;
	}

	@JsonProperty("data-type")
	private void setDataType(String dataType) {
		this.dataType = dataType;
	}

	@JsonProperty("database")
	public String getDatabase() {
		return database;
	}

	@JsonProperty("database")
	private void setDatabase(String database) {
		this.database = database;
	}

	@JsonProperty("date-accessed")
	public LocalDate getDateAccessed() {
		return dateAccessed;
	}

	@JsonProperty("date-accessed")
	private void setDateAccessed(String dateAccessed) throws CFFModelException {
		if (dateAccessed != null) {
			try {
				this.dateAccessed = LocalDate.parse(dateAccessed);
			}
			catch (DateTimeException e) {
				throw new CFFModelException("DateTimeException in field 'date-accessed': " + e.getMessage());
			}
		}
	}

	@JsonProperty("date-downloaded")
	public LocalDate getDateDownloaded() {
		return dateDownloaded;
	}

	@JsonProperty("date-downloaded")
	private void setDateDownloaded(String dateDownloaded) throws CFFModelException {
		if (dateDownloaded != null) {
			try {
				this.dateDownloaded = LocalDate.parse(dateDownloaded);
			}
			catch (DateTimeException e) {
				throw new CFFModelException("DateTimeException in field 'date-downloaded': " + e.getMessage());
			}
		}
	}

	@JsonProperty("date-released")
	public LocalDate getDateReleased() {
		return dateReleased;
	}

	@JsonProperty("date-released")
	private void setDateReleased(String dateReleased) throws CFFModelException {
		if (dateReleased != null) {
			try {
				this.dateReleased = LocalDate.parse(dateReleased);
			}
			catch (DateTimeException e) {
				throw new CFFModelException("DateTimeException in field 'date-released': " + e.getMessage());
			}
		}
	}

	@JsonProperty("date-published")
	public LocalDate getDatePublished() {
		return datePublished;
	}

	@JsonProperty("date-published")
	private void setDatePublished(String datePublished) throws CFFModelException {
		if (datePublished != null) {
			try {
				this.datePublished = LocalDate.parse(datePublished);
			}
			catch (DateTimeException e) {
				throw new CFFModelException("DateTimeException in field 'date-published': " + e.getMessage());
			}
		}
	}

	@JsonProperty("department")
	public String getDepartment() {
		return department;
	}

	@JsonProperty("department")
	private void setDepartment(String department) {
		this.department = department;
	}

	@JsonProperty("doi")
	public String getDoi() {
		return doi;
	}

	@JsonProperty("doi")
	private void setDoi(String doi) {
		this.doi = doi;
	}

	@JsonProperty("edition")
	public String getEdition() {
		return edition;
	}

	@JsonProperty("edition")
	private void setEdition(String edition) {
		this.edition = edition;
	}

	@JsonProperty("end")
	public Integer getEnd() {
		return end;
	}

	@JsonProperty("end")
	private void setEnd(Integer end) {
		this.end = end;
	}

	@JsonProperty("entry")
	public String getEntry() {
		return entry;
	}

	@JsonProperty("entry")
	private void setEntry(String entry) {
		this.entry = entry;
	}

	@JsonProperty("filename")
	public String getFilename() {
		return filename;
	}

	@JsonProperty("filename")
	private void setFilename(String filename) {
		this.filename = filename;
	}

	@JsonProperty("format")
	public String getFormat() {
		return format;
	}

	@JsonProperty("format")
	private void setFormat(String format) {
		this.format = format;
	}

	@JsonProperty("isbn")
	public String getIsbn() {
		return isbn;
	}

	@JsonProperty("isbn")
	private void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@JsonProperty("issn")
	public String getIssn() {
		return issn;
	}

	@JsonProperty("issn")
	private void setIssn(String issn) {
		this.issn = issn;
	}

	@JsonProperty("issue")
	public String getIssue() {
		return issue;
	}

	@JsonProperty("issue")
	private void setIssue(String issue) {
		this.issue = issue;
	}

	@JsonProperty("issue-date")
	public String getIssueDate() {
		return issueDate;
	}

	@JsonProperty("issue-date")
	private void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	@JsonProperty("issue-title")
	public String getIssueTitle() {
		return issueTitle;
	}

	@JsonProperty("issue-title")
	private void setIssueTitle(String issueTitle) {
		this.issueTitle = issueTitle;
	}

	@JsonProperty("journal")
	public String getJournal() {
		return journal;
	}

	@JsonProperty("journal")
	private void setJournal(String journal) {
		this.journal = journal;
	}

	@JsonProperty("keywords")
	public List<String> getKeywords() {
		return keywords;
	}

	@JsonProperty("keywords")
	private void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	@JsonProperty("languages")
	public List<String> getLanguages() {
		return languages;
	}

	@JsonProperty("languages")
	private void setLanguages(List<String> languages) throws CFFModelException {
		if (languages != null) {
			for (String language : languages) {
				if (language.length() > 3 || language.length() <= 1) {
					throw new CFFModelException("The language '" + language + "' is not a valid ISO 639-1 or 639-3 code.");
				}
				if (!DefinedValues.isLanguageValid(language)) {
					throw new CFFModelException(
							"The language '" + language + "' is not a valid ISO 639-1 or 639-3 code.");
				}
//				if (!DefinedValues.LANGUAGES.contains(language)) {
//					throw new CFFModelException(
//							"The language '" + language + "' is not a valid ISO 639-1 or 639-3 code.");
//				}
			}
		}
		this.languages = languages;
	}

	@JsonProperty("license")
	public String getLicense() {
		return license;
	}

	@JsonProperty("license")
	private void setLicense(String license) {
		this.license = license;
	}

	@JsonProperty("license-url")
	public URL getLicenseUrl() {
		return licenseUrl;
	}

	@JsonProperty("license-url")
	private void setLicenseUrl(String licenseUrl) throws MalformedURLException {
		if (licenseUrl != null) {
			try {
				this.licenseUrl = new URL(licenseUrl);
			}
			catch (MalformedURLException e) {
				throw new MalformedURLException("The reference '" + getTitle() + "' of type '" + getType()
						+ "' contains an invalid URL in field 'license-url': " + e.getMessage());
			}
		}
	}

	@JsonProperty("loc-start")
	public Integer getLocStart() {
		return locStart;
	}

	@JsonProperty("loc-start")
	private void setLocStart(Integer locStart) {
		this.locStart = locStart;
	}

	@JsonProperty("loc-end")
	public Integer getLocEnd() {
		return locEnd;
	}

	@JsonProperty("loc-end")
	private void setLocEnd(Integer locEnd) {
		this.locEnd = locEnd;
	}

	@JsonProperty("medium")
	public String getMedium() {
		return medium;
	}

	@JsonProperty("medium")
	private void setMedium(String medium) {
		this.medium = medium;
	}

	@JsonProperty("month")
	public Integer getMonth() {
		return month;
	}

	@JsonProperty("month")
	private void setMonth(Integer month) {
		this.month = month;
	}

	@JsonProperty("nihmsid")
	public String getNihmsid() {
		return nihmsid;
	}

	@JsonProperty("nihmsid")
	private void setNihmsid(String nihmsid) {
		this.nihmsid = nihmsid;
	}

	@JsonProperty("notes")
	public String getNotes() {
		return notes;
	}

	@JsonProperty("notes")
	private void setNotes(String notes) {
		this.notes = notes;
	}

	@JsonProperty("number")
	public String getNumber() {
		return number;
	}

	@JsonProperty("number")
	private void setNumber(String number) {
		this.number = number;
	}

	@JsonProperty("number-volumes")
	public Integer getNumberVolumes() {
		return numberVolumes;
	}

	@JsonProperty("number-volumes")
	private void setNumberVolumes(Integer numberVolumes) {
		this.numberVolumes = numberVolumes;
	}

	@JsonProperty("pages")
	public Integer getPages() {
		return pages;
	}

	@JsonProperty("pages")
	private void setPages(Integer pages) {
		this.pages = pages;
	}

	@JsonProperty("patent-states")
	public List<String> getPatentStates() {
		return patentStates;
	}

	@JsonProperty("patent-states")
	private void setPatentStates(List<String> patentStates) {
		this.patentStates = patentStates;
	}

	@JsonProperty("pmcid")
	public String getPmcid() {
		return pmcid;
	}

	@JsonProperty("pmcid")
	private void setPmcid(String pmcid) {
		this.pmcid = pmcid;
	}

	@JsonProperty("repository")
	public URL getRepository() {
		return repository;
	}

	@JsonProperty("repository")
	private void setRepository(String repository) throws MalformedURLException {
		if (repository != null) {
			try {
				this.repository = new URL(repository);
			}
			catch (MalformedURLException e) {
				throw new MalformedURLException("The reference '" + getTitle() + "' of type '" + getType()
						+ "' contains an invalid URL in field 'repository': " + e.getMessage());
			}
		}
	}

	@JsonProperty("repository-code")
	public URL getRepositoryCode() {
		return repositoryCode;
	}

	@JsonProperty("repository-code")
	private void setRepositoryCode(String repositoryCode) throws MalformedURLException {
		if (repositoryCode != null) {
			try {
				this.repositoryCode = new URL(repositoryCode);
			}
			catch (MalformedURLException e) {
				throw new MalformedURLException("The reference '" + getTitle() + "' of type '" + getType()
						+ "' contains an invalid URL in field 'repository-code': " + e.getMessage());
			}
		}
	}

	@JsonProperty("repository-artifact")
	public URL getRepositoryArtifact() {
		return repositoryArtifact;
	}

	@JsonProperty("repository-artifact")
	private void setRepositoryArtifact(String repositoryArtifact) throws MalformedURLException {
		if (repositoryArtifact != null) {
			try {
				this.repositoryArtifact = new URL(repositoryArtifact);
			}
			catch (MalformedURLException e) {
				throw new MalformedURLException("The reference '" + getTitle() + "' of type '" + getType()
						+ "' contains an invalid URL in field 'repository-artifact': " + e.getMessage());
			}
		}
	}

	@JsonProperty("scope")
	public String getScope() {
		return scope;
	}

	@JsonProperty("scope")
	private void setScope(String scope) {
		this.scope = scope;
	}

	@JsonProperty("section")
	public String getSection() {
		return section;
	}

	@JsonProperty("section")
	private void setSection(String section) {
		this.section = section;
	}

	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	private void setStatus(String status) throws CFFModelException {
		if (status != null) {
			if (!DefinedValues.REFERENCE_STATUS.contains(status)) {
				throw new CFFModelException("The status '" + status + "' is not defined.");
			}
		}
		this.status = status;
	}

	@JsonProperty("start")
	public Integer getStart() {
		return start;
	}

	@JsonProperty("start")
	private void setStart(Integer start) {
		this.start = start;
	}

	@JsonProperty("thesis-type")
	public String getThesisType() {
		return thesisType;
	}

	@JsonProperty("thesis-type")
	private void setThesisType(String thesisType) {
		this.thesisType = thesisType;
	}

	@JsonProperty("url")
	public URL getUrl() {
		return url;
	}

	@JsonProperty("url")
	private void setUrl(String url) throws MalformedURLException {
		if (url != null) {
			try {
				this.url = new URL(url);
			}
			catch (MalformedURLException e) {
				throw new MalformedURLException("The reference '" + getTitle() + "' of type '" + getType()
						+ "' contains an invalid URL in field 'url': " + e.getMessage());
			}
		}
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("version")
	private void setVersion(String version) {
		this.version = version;
	}

	@JsonProperty("volume")
	public Integer getVolume() {
		return volume;
	}

	@JsonProperty("volume")
	private void setVolume(Integer volume) {
		this.volume = volume;
	}

	@JsonProperty("volume-title")
	public String getVolumeTitle() {
		return volumeTitle;
	}

	@JsonProperty("volume-title")
	private void setVolumeTitle(String volumeTitle) {
		this.volumeTitle = volumeTitle;
	}

	@JsonProperty("year")
	public Integer getYear() {
		return year;
	}

	@JsonProperty("year")
	private void setYear(Integer year) {
		this.year = year;
	}

	@JsonProperty("year-original")
	public Integer getYearOriginal() {
		return yearOriginal;
	}

	@JsonProperty("year-original")
	private void setYearOriginal(Integer yearOriginal) {
		this.yearOriginal = yearOriginal;
	}

	@JsonProperty("conference")
	public Entity getConference() {
		return conference;
	}

	@JsonProperty("conference")
	private void setConference(Entity conference) {
		this.conference = conference;
	}

	@JsonProperty("authors")
	public List<Subject> getAuthors() {
		return authors;
	}

	@JsonProperty("authors")
	private void setAuthors(List<Subject> authors) {
		this.authors = authors;
	}

	@JsonProperty("contact")
	public List<Subject> getContact() {
		return contact;
	}

	@JsonProperty("contact")
	private void setContact(List<Subject> contact) {
		this.contact = contact;
	}

	@JsonProperty("database-provider")
	public Entity getDatabaseProvider() {
		return databaseProvider;
	}

	@JsonProperty("database-provider")
	private void setDatabaseProvider(Entity databaseProvider) {
		this.databaseProvider = databaseProvider;
	}

	@JsonProperty("editors")
	public List<Subject> getEditors() {
		return editors;
	}

	@JsonProperty("editors")
	private void setEditors(List<Subject> editors) {
		this.editors = editors;
	}

	@JsonProperty("editors-series")
	public List<Subject> getEditorsSeries() {
		return editorsSeries;
	}

	@JsonProperty("editors-series")
	private void setEditorsSeries(List<Subject> editorsSeries) {
		this.editorsSeries = editorsSeries;
	}

	@JsonProperty("institution")
	public Entity getInstitution() {
		return institution;
	}

	@JsonProperty("institution")
	private void setInstitution(Entity institution) {
		this.institution = institution;
	}

	@JsonProperty("location")
	public Entity getLocation() {
		return location;
	}

	@JsonProperty("location")
	private void setLocation(Entity location) {
		this.location = location;
	}

	@JsonProperty("publisher")
	public Entity getPublisher() {
		return publisher;
	}

	@JsonProperty("publisher")
	private void setPublisher(Entity publisher) {
		this.publisher = publisher;
	}

	@JsonProperty("recipients")
	public List<Subject> getRecipients() {
		return recipients;
	}

	@JsonProperty("recipients")
	private void setRecipients(List<Subject> recipients) {
		this.recipients = recipients;
	}

	@JsonProperty("senders")
	public List<Subject> getSenders() {
		return senders;
	}

	@JsonProperty("senders")
	private void setSenders(List<Subject> senders) {
		this.senders = senders;
	}

	@JsonProperty("translators")
	public List<Subject> getTranslators() {
		return translators;
	}

	@JsonProperty("translators")
	private void setTranslators(List<Subject> translators) {
		this.translators = translators;
	}

}
