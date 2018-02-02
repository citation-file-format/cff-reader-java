/**
 * 
 */
package org.research_software.citation.cff.model;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;

import org.research_software.citation.cff.model.objects.Entity;
import org.research_software.citation.cff.model.objects.Person;
import org.research_software.citation.cff.model.objects.Reference;
import org.research_software.citation.cff.model.objects.Subject;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A set of software citation metadata for a specific software.
 * 
 * @see <https://citation-file-format.github.io/1.0.3/specifications/#/entity-objects>
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
	 * @return The version of CFF used to represent the sftware citation metadata
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
	 * @return The URL of the repository for the software version
	 */
	public URL getRepository();
	
	/**
	 * @return The URL of the source code repository for the software version
	 */
	public URL getRepositoryCode();

	/**
	 * @return The URL of the artifact repository for the software version
	 */
	public URL getRepositoryArtifact();
	
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

