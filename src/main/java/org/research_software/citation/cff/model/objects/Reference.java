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

import java.net.MalformedURLException;
import java.net.URL;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.research_software.citation.cff.exceptions.InvalidDataException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model element representing an additional reference to the software.
 * 
 * @see <a href="https://citation-file-format.github.io/1.0.3/specifications/#/references-optional">https://citation-file-format.github.io/1.0.3/specifications/#/references-optional</a>
 * 
 * @version Citation File Format Version 1.0.3
 * 
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@SuppressWarnings("javadoc")
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
	 * Constructor for databinding.
	 *
	 * @param dateDownloaded The date the reference has been downloaded
	 * @param edition The edition of the reference
	 * @param nihmsid The NIHMSID of the reference
	 * @param location The location of the reference (e.g., for art)
	 * @param databaseProvider The database provider providing the reference
	 * @param dateAccessed The date the reference has been accessed
	 * @param editors The editors of the reference
	 * @param type The reference type
	 * @param authors The authors of the reference
	 * @param languages The languages the reference is composed in
	 * @param translators The translators of the reference
	 * @param commit The commit hash for the version of the reference
	 * @param year The year the reference has been published
	 * @param collectionTitle The title of the collection containing the reference
	 * @param conference The conference of which the reference is part
	 * @param senders The senders of the reference (e.g., for personal communications)
	 * @param keywords The keywords pertaining to the reference
	 * @param status The publication status of the reference
	 * @param datePublished The date the reference has been published
	 * @param number The accession number of the work (multi-purpose for different reference types)
	 * @param format The format of the reference
	 * @param copyright The copyright information pertaining to the reference
	 * @param url The URL of the reference
	 * @param locStart The line number in the source code file where the reference starts
	 * @param collectionDoi The DOI of the collection containing the reference
	 * @param repositoryCode The URL of the code repository for the reference
	 * @param start The page number where the reference starts
	 * @param month The month in which the reference has been published
	 * @param locEnd The line number in the source code file where the reference ends
	 * @param patentStates The states for which a patent is granted
	 * @param licenseUrl The URL pointing to the license text if the license is not included in the [SPDX License list](https://spdx.org/licenses/)
	 * @param collectionType The type of the collection containing the reference
	 * @param scope A string describing the scope of the reference in relation to the software
	 * @param issn The ISSN of the reference
	 * @param department The department where the reference has been produced
	 * @param issue The issue of a periodical in which the reference has been published
	 * @param contact The contacts for the reference
	 * @param volumeTitle The title of the volume in which the reference has been published
	 * @param thesisType The type of the reference, if it is a thesis
	 * @param publisher The publisher which has published the reference
	 * @param version The version of the reference
	 * @param journal The name of the journal in which the reference has been published 
	 * @param title The title of the reference
	 * @param repository The URL of the repository for the reference
	 * @param isbn The ISBN of the reference
	 * @param license The SPDX license short identifier for the license under which the reference has been published
	 * @param end The page number where the reference ends
	 * @param institution The institution where the reference has been produced or published
	 * @param repositoryArtifact The URL of the artifact repository for the reference
	 * @param dateReleased The date on which the reference has been released
	 * @param recipients The recipients of the reference (e.g., for personal communications)
	 * @param numberVolumes The number of volumes making up the collection in which the reference has been published
	 * @param pages The total number of pages of the reference
	 * @param issueDate The publication date of the issue of a periodical in which the reference has been published
	 * @param editorsSeries The editors of the series in which the reference has been published
	 * @param abbreviation The abbreviation for the reference
	 * @param abstractString An abstract or description for the reference
	 * @param database The database which provides the reference
	 * @param medium The medium of the reference
	 * @param section The section of a work which is the reference (e.g., for book sections)
	 * @param issueTitle The title of the issue of a periodical in which the reference has been published
	 * @param pmcid The PMCID of the reference
	 * @param dataType The data type of the reference (e.g., for data sets)
	 * @param yearOriginal The year in which the reference has originally been published
	 * @param entry An entry in a collection which constitutes the reference
	 * @param volume The volume of a periodical in which the reference has been published
	 * @param filename The filename of the reference
	 * @param notes Notes pertaining to the reference
	 * @param doi The DOI of the reference
	 * 
	 * @throws InvalidDataException on invalid data and resulting parse errors, e.g., for date/time parses or malformed URLs
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
			throws InvalidDataException {
		super();
		if (type == null) {
			throw new InvalidDataException("'type' is a required key in references and must be present and not null!");
		}
		else if (!DefinedValues.REFERENCE_TYPES.contains(type)) {
			throw new InvalidDataException("The reference type '" + type + "' is not defined in the CFF format specifications.");
		}
		this.type = type;
		if (title == null) {
			throw new InvalidDataException("'title' is a required key in references and must be present and not null!");
		}
		this.title = title;
		if (authors == null || authors.isEmpty()) {
			throw new InvalidDataException(
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

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	private void setType(String type) {
		this.type = type;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	private void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("abbreviation")
	public String getAbbreviation() {
		return abbreviation;
	}

	@JsonProperty("abbreviation")
	private void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("abstract")
	public String getAbstract() {
		return abstractString;
	}

	@JsonProperty("abstract")
	private void setAbstract(String _abstract) {
		this.abstractString = _abstract;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("collection-doi")
	public String getCollectionDoi() {
		return collectionDoi;
	}

	@JsonProperty("collection-doi")
	private void setCollectionDoi(String collectionDoi) {
		this.collectionDoi = collectionDoi;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("collection-title")
	public String getCollectionTitle() {
		return collectionTitle;
	}

	@JsonProperty("collection-title")
	private void setCollectionTitle(String collectionTitle) {
		this.collectionTitle = collectionTitle;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("collection-type")
	public String getCollectionType() {
		return collectionType;
	}

	@JsonProperty("collection-type")
	private void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("commit")
	public String getCommit() {
		return commit;
	}

	@JsonProperty("commit")
	private void setCommit(String commit) {
		this.commit = commit;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("copyright")
	public String getCopyright() {
		return copyright;
	}

	@JsonProperty("copyright")
	private void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("data-type")
	public String getDataType() {
		return dataType;
	}

	@JsonProperty("data-type")
	private void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("database")
	public String getDatabase() {
		return database;
	}

	@JsonProperty("database")
	private void setDatabase(String database) {
		this.database = database;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("date-accessed")
	public LocalDate getDateAccessed() {
		return dateAccessed;
	}

	@JsonProperty("date-accessed")
	private void setDateAccessed(String dateAccessed) throws InvalidDataException {
		if (dateAccessed != null) {
			try {
				this.dateAccessed = LocalDate.parse(dateAccessed);
			}
			catch (DateTimeException e) {
				throw new InvalidDataException("DateTimeException in field 'date-accessed'!", e);
			}
		}
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("date-downloaded")
	public LocalDate getDateDownloaded() {
		return dateDownloaded;
	}

	@JsonProperty("date-downloaded")
	private void setDateDownloaded(String dateDownloaded) throws InvalidDataException {
		if (dateDownloaded != null) {
			try {
				this.dateDownloaded = LocalDate.parse(dateDownloaded);
			}
			catch (DateTimeException e) {
				throw new InvalidDataException("DateTimeException in field 'date-downloaded'!", e);
			}
		}
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("date-released")
	public LocalDate getDateReleased() {
		return dateReleased;
	}

	@JsonProperty("date-released")
	private void setDateReleased(String dateReleased) throws InvalidDataException {
		if (dateReleased != null) {
			try {
				this.dateReleased = LocalDate.parse(dateReleased);
			}
			catch (DateTimeException e) {
				throw new InvalidDataException("DateTimeException in field 'date-released'!", e);
			}
		}
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("date-published")
	public LocalDate getDatePublished() {
		return datePublished;
	}

	@JsonProperty("date-published")
	private void setDatePublished(String datePublished) throws InvalidDataException {
		if (datePublished != null) {
			try {
				this.datePublished = LocalDate.parse(datePublished);
			}
			catch (DateTimeException e) {
				throw new InvalidDataException("DateTimeException in field 'date-published'!", e);
			}
		}
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("department")
	public String getDepartment() {
		return department;
	}

	@JsonProperty("department")
	private void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("doi")
	public String getDoi() {
		return doi;
	}

	@JsonProperty("doi")
	private void setDoi(String doi) {
		this.doi = doi;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("edition")
	public String getEdition() {
		return edition;
	}

	@JsonProperty("edition")
	private void setEdition(String edition) {
		this.edition = edition;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("end")
	public Integer getEnd() {
		return end;
	}

	@JsonProperty("end")
	private void setEnd(Integer end) {
		this.end = end;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("entry")
	public String getEntry() {
		return entry;
	}

	@JsonProperty("entry")
	private void setEntry(String entry) {
		this.entry = entry;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("filename")
	public String getFilename() {
		return filename;
	}

	@JsonProperty("filename")
	private void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("format")
	public String getFormat() {
		return format;
	}

	@JsonProperty("format")
	private void setFormat(String format) {
		this.format = format;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("isbn")
	public String getIsbn() {
		return isbn;
	}

	@JsonProperty("isbn")
	private void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("issn")
	public String getIssn() {
		return issn;
	}

	@JsonProperty("issn")
	private void setIssn(String issn) {
		this.issn = issn;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("issue")
	public String getIssue() {
		return issue;
	}

	@JsonProperty("issue")
	private void setIssue(String issue) {
		this.issue = issue;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("issue-date")
	public String getIssueDate() {
		return issueDate;
	}

	@JsonProperty("issue-date")
	private void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("issue-title")
	public String getIssueTitle() {
		return issueTitle;
	}

	@JsonProperty("issue-title")
	private void setIssueTitle(String issueTitle) {
		this.issueTitle = issueTitle;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("journal")
	public String getJournal() {
		return journal;
	}

	@JsonProperty("journal")
	private void setJournal(String journal) {
		this.journal = journal;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("keywords")
	public List<String> getKeywords() {
		return keywords;
	}

	@JsonProperty("keywords")
	private void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("languages")
	public List<String> getLanguages() {
		return languages;
	}

	@JsonProperty("languages")
	private void setLanguages(List<String> languages) throws InvalidDataException {
		if (languages != null) {
			for (String language : languages) {
				if (language.length() > 3 || language.length() <= 1) {
					throw new InvalidDataException("The language '" + language + "' is not a valid ISO 639-1 or 639-3 code.");
				}
				if (!DefinedValues.isLanguageValid(language)) {
					throw new InvalidDataException(
							"The language '" + language + "' is not a valid ISO 639-1 or 639-3 code.");
				}
			}
		}
		this.languages = languages;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("license")
	public String getLicense() {
		return license;
	}

	@JsonProperty("license")
	private void setLicense(String license) {
		this.license = license;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("license-url")
	public URL getLicenseUrl() {
		return licenseUrl;
	}

	@JsonProperty("license-url")
	private void setLicenseUrl(String licenseUrl) throws InvalidDataException {
		if (licenseUrl != null) {
			try {
				this.licenseUrl = new URL(licenseUrl);
			}
			catch (MalformedURLException e) {
				throw new InvalidDataException("The reference '" + getTitle() + "' of type '" + getType()
						+ "' contains an invalid URL in field 'license-url': " + e.getMessage(), e);
			}
		}
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("loc-start")
	public Integer getLocStart() {
		return locStart;
	}

	@JsonProperty("loc-start")
	private void setLocStart(Integer locStart) {
		this.locStart = locStart;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("loc-end")
	public Integer getLocEnd() {
		return locEnd;
	}

	@JsonProperty("loc-end")
	private void setLocEnd(Integer locEnd) {
		this.locEnd = locEnd;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("medium")
	public String getMedium() {
		return medium;
	}

	@JsonProperty("medium")
	private void setMedium(String medium) {
		this.medium = medium;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("month")
	public Integer getMonth() {
		return month;
	}

	@JsonProperty("month")
	private void setMonth(Integer month) {
		this.month = month;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("nihmsid")
	public String getNihmsid() {
		return nihmsid;
	}

	@JsonProperty("nihmsid")
	private void setNihmsid(String nihmsid) {
		this.nihmsid = nihmsid;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("notes")
	public String getNotes() {
		return notes;
	}

	@JsonProperty("notes")
	private void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("number")
	public String getNumber() {
		return number;
	}

	@JsonProperty("number")
	private void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("number-volumes")
	public Integer getNumberVolumes() {
		return numberVolumes;
	}

	@JsonProperty("number-volumes")
	private void setNumberVolumes(Integer numberVolumes) {
		this.numberVolumes = numberVolumes;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("pages")
	public Integer getPages() {
		return pages;
	}

	@JsonProperty("pages")
	private void setPages(Integer pages) {
		this.pages = pages;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("patent-states")
	public List<String> getPatentStates() {
		return patentStates;
	}

	@JsonProperty("patent-states")
	private void setPatentStates(List<String> patentStates) {
		this.patentStates = patentStates;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("pmcid")
	public String getPmcid() {
		return pmcid;
	}

	@JsonProperty("pmcid")
	private void setPmcid(String pmcid) {
		this.pmcid = pmcid;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("repository")
	public URL getRepository() {
		return repository;
	}

	@JsonProperty("repository")
	private void setRepository(String repository) throws InvalidDataException {
		if (repository != null) {
			try {
				this.repository = new URL(repository);
			}
			catch (MalformedURLException e) {
				throw new InvalidDataException("The reference '" + getTitle() + "' of type '" + getType()
						+ "' contains an invalid URL in field 'repository': " + e.getMessage(), e);
			}
		}
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("repository-code")
	public URL getRepositoryCode() {
		return repositoryCode;
	}

	@JsonProperty("repository-code")
	private void setRepositoryCode(String repositoryCode) throws InvalidDataException {
		if (repositoryCode != null) {
			try {
				this.repositoryCode = new URL(repositoryCode);
			}
			catch (MalformedURLException e) {
				throw new InvalidDataException("The reference '" + getTitle() + "' of type '" + getType()
						+ "' contains an invalid URL in field 'repository-code': " + e.getMessage(), e);
			}
		}
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("repository-artifact")
	public URL getRepositoryArtifact() {
		return repositoryArtifact;
	}

	@JsonProperty("repository-artifact")
	private void setRepositoryArtifact(String repositoryArtifact) throws InvalidDataException {
		if (repositoryArtifact != null) {
			try {
				this.repositoryArtifact = new URL(repositoryArtifact);
			}
			catch (MalformedURLException e) {
				throw new InvalidDataException("The reference '" + getTitle() + "' of type '" + getType()
						+ "' contains an invalid URL in field 'repository-artifact': " + e.getMessage(), e);
			}
		}
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("scope")
	public String getScope() {
		return scope;
	}

	@JsonProperty("scope")
	private void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("section")
	public String getSection() {
		return section;
	}

	@JsonProperty("section")
	private void setSection(String section) {
		this.section = section;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	private void setStatus(String status) throws InvalidDataException {
		if (status != null) {
			if (!DefinedValues.REFERENCE_STATUS.contains(status)) {
				throw new InvalidDataException("The status '" + status + "' is not defined in the CFF format specifications.");
			}
		}
		this.status = status;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("start")
	public Integer getStart() {
		return start;
	}

	@JsonProperty("start")
	private void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("thesis-type")
	public String getThesisType() {
		return thesisType;
	}

	@JsonProperty("thesis-type")
	private void setThesisType(String thesisType) {
		this.thesisType = thesisType;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("url")
	public URL getUrl() {
		return url;
	}

	@JsonProperty("url")
	private void setUrl(String url) throws InvalidDataException {
		if (url != null) {
			try {
				this.url = new URL(url);
			}
			catch (MalformedURLException e) {
				throw new InvalidDataException("The reference '" + getTitle() + "' of type '" + getType()
						+ "' contains an invalid URL in field 'url': " + e.getMessage(), e);
			}
		}
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("version")
	private void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("volume")
	public Integer getVolume() {
		return volume;
	}

	@JsonProperty("volume")
	private void setVolume(Integer volume) {
		this.volume = volume;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("volume-title")
	public String getVolumeTitle() {
		return volumeTitle;
	}

	@JsonProperty("volume-title")
	private void setVolumeTitle(String volumeTitle) {
		this.volumeTitle = volumeTitle;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("year")
	public Integer getYear() {
		return year;
	}

	@JsonProperty("year")
	private void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("year-original")
	public Integer getYearOriginal() {
		return yearOriginal;
	}

	@JsonProperty("year-original")
	private void setYearOriginal(Integer yearOriginal) {
		this.yearOriginal = yearOriginal;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("conference")
	public Entity getConference() {
		return conference;
	}

	@JsonProperty("conference")
	private void setConference(Entity conference) {
		this.conference = conference;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("authors")
	public List<Subject> getAuthors() {
		return authors;
	}

	@JsonProperty("authors")
	private void setAuthors(List<Subject> authors) {
		this.authors = authors;
	}
	
	/**
	 * @return A filtered list of authors, containing only those of type {@link Person}.
	 */
	public List<Person> getPersonAuthors() {
		return filterPersons(getAuthors());
	}
	
	/**
	 * @return A filtered list of authors, containing only those of type {@link Entity}.
	 */
	public List<Entity> getEntityAuthors() {
		return filterEntities(getAuthors());
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("contact")
	public List<Subject> getContact() {
		return contact;
	}

	@JsonProperty("contact")
	private void setContact(List<Subject> contact) {
		this.contact = contact;
	}

	/**
	 * @return A filtered list of contacts, containing only those of type {@link Person}.
	 */
	public List<Person> getPersonContacts() {
		return filterPersons(getContact());
	}
	
	/**
	 * @return A filtered list of contacts, containing only those of type {@link Entity}.
	 */
	public List<Entity> getEntityContacts() {
		return filterEntities(getContact());
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("database-provider")
	public Entity getDatabaseProvider() {
		return databaseProvider;
	}

	@JsonProperty("database-provider")
	private void setDatabaseProvider(Entity databaseProvider) {
		this.databaseProvider = databaseProvider;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("editors")
	public List<Subject> getEditors() {
		return editors;
	}

	@JsonProperty("editors")
	private void setEditors(List<Subject> editors) {
		this.editors = editors;
	}

	/**
	 * @return A filtered list of editors, containing only those of type {@link Person}.
	 */
	public List<Person> getPersonEditors() {
		return filterPersons(getEditors());
	}
	
	/**
	 * @return A filtered list of editors, containing only those of type {@link Entity}.
	 */
	public List<Entity> getEntityEditors() {
		return filterEntities(getEditors());
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("editors-series")
	public List<Subject> getEditorsSeries() {
		return editorsSeries;
	}

	@JsonProperty("editors-series")
	private void setEditorsSeries(List<Subject> editorsSeries) {
		this.editorsSeries = editorsSeries;
	}

	/**
	 * @return A filtered list of series editors, containing only those of type {@link Person}.
	 */
	public List<Person> getPersonEditorsSeries() {
		return filterPersons(getEditorsSeries());
	}
	
	/**
	 * @return A filtered list of series editors, containing only those of type {@link Entity}.
	 */
	public List<Entity> getEntityEditorsSeries() {
		return filterEntities(getEditorsSeries());
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("institution")
	public Entity getInstitution() {
		return institution;
	}

	@JsonProperty("institution")
	private void setInstitution(Entity institution) {
		this.institution = institution;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("location")
	public Entity getLocation() {
		return location;
	}

	@JsonProperty("location")
	private void setLocation(Entity location) {
		this.location = location;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("publisher")
	public Entity getPublisher() {
		return publisher;
	}

	@JsonProperty("publisher")
	private void setPublisher(Entity publisher) {
		this.publisher = publisher;
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("recipients")
	public List<Subject> getRecipients() {
		return recipients;
	}

	@JsonProperty("recipients")
	private void setRecipients(List<Subject> recipients) {
		this.recipients = recipients;
	}

	/**
	 * @return A filtered list of recipients, containing only those of type {@link Person}.
	 */
	public List<Person> getPersonRecipients() {
		return filterPersons(getRecipients());
	}
	
	/**
	 * @return A filtered list of recipients, containing only those of type {@link Entity}.
	 */
	public List<Entity> getEntityRecipients() {
		return filterEntities(getRecipients());
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("senders")
	public List<Subject> getSenders() {
		return senders;
	}

	@JsonProperty("senders")
	private void setSenders(List<Subject> senders) {
		this.senders = senders;
	}

	/**
	 * @return A filtered list of senders, containing only those of type {@link Person}.
	 */
	public List<Person> getPersonSenders() {
		return filterPersons(getSenders());
	}
	
	/**
	 * @return A filtered list of senders, containing only those of type {@link Entity}.
	 */
	public List<Entity> getEntitySenders() {
		return filterEntities(getSenders());
	}

	/**
	 * Getter for the field value.
	 * 
	 * @see Reference#Reference(String, String, List, Entity, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, String, Integer, String, String, String, String, String, String, String, String, String, List, List, String, String, Integer, Integer, String, Integer, String, String, String, Integer, Integer, List, String, String, String, String, String, String, String, Integer, String, String, String, Integer, String, Integer, Integer, List, Entity, List, List, Entity, Entity, Entity, List, List, List)
	 */
	@JsonProperty("translators")
	public List<Subject> getTranslators() {
		return translators;
	}

	@JsonProperty("translators")
	private void setTranslators(List<Subject> translators) {
		this.translators = translators;
	}

	/**
	 * @return A filtered list of translators, containing only those of type {@link Person}.
	 */
	public List<Person> getPersonTranslators() {
		return filterPersons(getTranslators());
	}
	
	/**
	 * @return A filtered list of translators, containing only those of type {@link Entity}.
	 */
	public List<Entity> getEntityTranslators() {
		return filterEntities(getTranslators());
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
