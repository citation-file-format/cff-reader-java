package org.research_software.citation.cff.model.objects;

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
public final class Person extends Subject {

	@JsonProperty("family-names")
	private String familyNames;
	@JsonProperty("given-names")
	private String givenNames;
	@JsonProperty("name-particle")
	private String nameParticle;
	@JsonProperty("name-suffix")
	private String nameSuffix;
	@JsonProperty("affiliation")
	private String affiliation;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Person() {
	}

	/**
	 *
	 * @param nameSuffix
	 * @param familyNames
	 * @param nameParticle
	 * @param givenNames
	 * @param affiliation
	 * @param address 
	 * @param city 
	 * @param region 
	 * @param postCode 
	 * @param country 
	 * @param orcid 
	 * @param email 
	 * @param tel 
	 * @param fax 
	 * @param website 
	 */
	public Person(String familyNames, String givenNames, String nameParticle, String nameSuffix, String affiliation, String address, String city, String region, String postCode, String country, String orcid,
			String email, String tel, String fax, String website) {
		super(address, city, region, postCode, country, orcid, email, tel, fax, website);
		this.familyNames = familyNames;
		this.givenNames = givenNames;
		this.nameParticle = nameParticle;
		this.nameSuffix = nameSuffix;
		this.affiliation = affiliation;
	}

	@JsonProperty("family-names")
	public String getFamilyNames() {
		return familyNames;
	}

	@JsonProperty("family-names")
	public void setFamilyNames(String familyNames) {
		this.familyNames = familyNames;
	}

	@JsonProperty("given-names")
	public String getGivenNames() {
		return givenNames;
	}

	@JsonProperty("given-names")
	public void setGivenNames(String givenNames) {
		this.givenNames = givenNames;
	}

	@JsonProperty("name-particle")
	public String getNameParticle() {
		return nameParticle;
	}

	@JsonProperty("name-particle")
	public void setNameParticle(String nameParticle) {
		this.nameParticle = nameParticle;
	}

	@JsonProperty("name-suffix")
	public String getNameSuffix() {
		return nameSuffix;
	}

	@JsonProperty("name-suffix")
	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	@JsonProperty("affiliation")
	public String getAffiliation() {
		return affiliation;
	}

	@JsonProperty("affiliation")
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

}