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

	private String familyNames;
	private String givenNames;
	private String nameParticle;
	private String nameSuffix;
	private String affiliation;

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
	public Person(
			@JsonProperty("family-names") String familyNames,
			@JsonProperty("given-names") String givenNames,
			@JsonProperty("name-particle") String nameParticle,
			@JsonProperty("name-suffix") String nameSuffix,
			@JsonProperty("affiliation") String affiliation,
			@JsonProperty("address") String address,
			@JsonProperty("city") String city,
			@JsonProperty("region") String region,
			@JsonProperty("post-code") String postCode,
			@JsonProperty("country") String country,
			@JsonProperty("orcid") String orcid,
			@JsonProperty("email") String email,
			@JsonProperty("tel") String tel,
			@JsonProperty("fax") String fax,
			@JsonProperty("website") String website) {
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
	private void setFamilyNames(String familyNames) {
		this.familyNames = familyNames;
	}

	@JsonProperty("given-names")
	public String getGivenNames() {
		return givenNames;
	}

	@JsonProperty("given-names")
	private void setGivenNames(String givenNames) {
		this.givenNames = givenNames;
	}

	@JsonProperty("name-particle")
	public String getNameParticle() {
		return nameParticle;
	}

	@JsonProperty("name-particle")
	private void setNameParticle(String nameParticle) {
		this.nameParticle = nameParticle;
	}

	@JsonProperty("name-suffix")
	public String getNameSuffix() {
		return nameSuffix;
	}

	@JsonProperty("name-suffix")
	private void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	@JsonProperty("affiliation")
	public String getAffiliation() {
		return affiliation;
	}

	@JsonProperty("affiliation")
	private void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

}