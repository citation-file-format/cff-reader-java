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

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.research_software.citation.cff.exceptions.InvalidDataException;
import org.research_software.citation.cff.model.objects.Entity;
import org.research_software.citation.cff.model.objects.Person;
import org.research_software.citation.cff.model.objects.Reference;
import org.research_software.citation.cff.model.objects.Subject;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A set of software citation metadata for a specific software.
 * 
 * @see <a href="https://citation-file-format.github.io/1.0.3/specifications/#/entity-objects">https://citation-file-format.github.io/1.0.3/specifications/#/entity-objects</a>
 * 
 * @version Citation File Format Version 1.0.3
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@JsonDeserialize(as = SoftwareCitationMetadataPojo.class)
public interface SoftwareCitationMetadata {
	
	/* ######################################
	 * Simple keys
	 * ######################################
	 */
	
	/**
	 * @return The version of CFF used to represent the software citation metadata
	 */
	public String getCffVersion();

	/**
	 * @return The message pertaining to the use of the software citation metadata
	 */
	public String getMessage();

	/**
	 * @return The title of the software
	 */
	public String getTitle();

	/**
	 * @return The exact version of the software
	 */
	public String getVersion();
	
	/**
	 * @return The DOI of the software version
	 */
	public String getDoi();

	/**
	 * @return The release date of the software version
	 */
	public LocalDate getDateReleased();
	
	/**
	 * Converts the passed date string into a {@link LocalDate} object
	 * via {@link LocalDate#parse(CharSequence)}.
	 * 
	 * If an exception is caught, it is wrapped into an
	 * {@link InvalidDataException}, which is then thrown instead.
	 * 
	 * @param dateReleasedString The value string for the field `date-released`
	 * @throws InvalidDataException on catching a {@link DateTimeParseException}
	 */
	public void convertAndSetDateReleased(String dateReleasedString) throws InvalidDataException;
	
	/**
	 * @return An abstract or description of the software version
	 */
	public String getAbstract();
	
	/**
	 * @return A commit hash or revision number for the version of the software
	 */
	public String getCommit();
	
	/**
	 * @return A list of keywords pertaining to the software version
	 */
	public List<String> getKeywords();
	
	/**
	 * @return The [SPDX short license identifier](https://spdx.org/licenses/)for the license under which the software version has been published
	 */
	public String getLicense();
	
	/**
	 * @return The URL pointing to the license text if the license is not included in the [SPDX License list](https://spdx.org/licenses/)
	 */
	public URL getLicenseUrl();
	
	/**
	 * Converts the passed URL string into a {@link URL} object.
	 * 
	 * If an exception is caught, it is wrapped into an
	 * {@link InvalidDataException}, which is then thrown instead.
	 * 
	 * @param licenseUrlString The value string for the field `license-url`
	 * @throws InvalidDataException on catching a {@link MalformedURLException}
	 */
	public void convertAndSetLicenseUrl(String licenseUrlString) throws InvalidDataException;

	
	/**
	 * @return The URL of the repository for the software version
	 */
	public URL getRepository();
	
	/**
	 * Converts the passed URL string into a {@link URL} object.
	 * 
	 * If an exception is caught, it is wrapped into an
	 * {@link InvalidDataException}, which is then thrown instead.
	 * 
	 * @param repositoryString The value string for the field `repository`
	 * @throws InvalidDataException on catching a {@link MalformedURLException}
	 */
	public void convertAndSetRepository(String repositoryString) throws InvalidDataException;

	/**
	 * @return The URL of the source code repository for the software version
	 */
	public URL getRepositoryCode();
	
	/**
	 * Converts the passed URL string into a {@link URL} object.
	 * 
	 * If an exception is caught, it is wrapped into an
	 * {@link InvalidDataException}, which is then thrown instead.
	 * 
	 * @param repositoryCodeString The value string for the field `repository-code`
	 * @throws InvalidDataException on catching a {@link MalformedURLException}
	 */
	public void convertAndSetRepositoryCode(String repositoryCodeString) throws InvalidDataException;

	/**
	 * @return The URL of the artifact repository for the software version
	 */
	public URL getRepositoryArtifact();
	
	/**
	 * Converts the passed URL string into a {@link URL} object.
	 * 
	 * If an exception is caught, it is wrapped into an
	 * {@link InvalidDataException}, which is then thrown instead.
	 * 
	 * @param repositoryArtifactString The value string for the field `repository-artifact`
	 * @throws InvalidDataException on catching a {@link MalformedURLException}
	 */
	public void convertAndSetRepositoryArtifact(String repositoryArtifactString) throws InvalidDataException;

	/**
	 * @return The URL of the software version landing page or website
	 */
	public URL getUrl();
	
	/* ######################################
	 * Object keys
	 * ######################################
	 */
	
	/**
	 * @return A list of authors of the software version
	 */
	public List<Subject> getAuthors();
	
	/**
	 * @return A filtered list of authors of the software version, containing only those of type {@link Person}
	 */
	public List<Person> getPersonAuthors();
	
	/**
	 * @return A filtered list of authors of the software version, containing only those of type {@link Entity}
	 */
	public List<Entity> getEntityAuthors();

	/**
	 * @return A list of contacts for the software version
	 */
	public List<Subject> getContacts();
	
	/**
	 * @return A filtered list of contacts of the software version, containing only those of type {@link Person}
	 */
	public List<Person> getPersonContacts();
	
	/**
	 * @return A filtered list of contacts of the software version, containing only those of type {@link Entity}
	 */
	public List<Entity> getEntityContacts();


	/**
	 * @return A list of additional references for the software version, e.g, software papers, or papers describing concepts or algorithms implemented in the software version
	 */
	public List<Reference> getReferences();
	
}

