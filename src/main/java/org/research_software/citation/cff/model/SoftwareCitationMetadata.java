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
 * // TODO Add description
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
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getCffVersion();

	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getMessage();

	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getTitle();

	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getVersion();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getDoi();

	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public LocalDate getDateReleased();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getAbstract();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getCommit();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public List<String> getKeywords();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getLicense();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public URL getLicenseUrl();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public URL getRepository();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public URL getRepositoryCode();

	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public URL getRepositoryArtifact();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public URL getUrl();
	
	/* ######################################
	 * Object keys
	 * ######################################
	 */
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public List<Subject> getAuthors();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public List<Person> getPersonAuthors();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public List<Entity> getEntityAuthors();

	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public List<Subject> getContacts();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public List<Person> getPersonContacts();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public List<Entity> getEntityContacts();


	
	public List<Reference> getReferences();
	
}

