/**
 * 
 */
package org.research_software.citation.cff.model;

import java.time.LocalDate;
import java.util.List;

import org.research_software.citation.cff.model.objects.Entity;
import org.research_software.citation.cff.model.objects.Person;
import org.research_software.citation.cff.model.objects.Reference;
import org.research_software.citation.cff.model.objects.Subject;

/**
 * // TODO Add description
 * 
 * @version Citation File Format Version 1.0.3
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
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
	public String getLicenseUrl();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getRepository();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getRepositoryCode();

	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getRepositoryArtifact();
	
	/**
	 * // TODO Add description
	 * 
	 * @return
	 */
	public String getUrl();
	
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

