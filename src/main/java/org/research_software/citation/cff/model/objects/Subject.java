package org.research_software.citation.cff.model.objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * // TODO Add description
 * 
 * @version Citation File Format Version 1.0.3
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@JsonSubTypes({
@Type(value = Person.class),
@Type(value = Entity.class),
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Subject {

	private String address;
	private String city;
	private String region;
	private String postCode;
	private String country;
	private String orcid;
	private String email;
	private String tel;
	private String fax;
	private String website;

	/**
	 *
	 * @param region
	 * @param fax
	 * @param orcid
	 * @param website
	 * @param email
	 * @param address
	 * @param tel
	 * @param postCode
	 * @param country
	 * @param city
	 */
	public Subject(
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
		this.address = address;
		this.city = city;
		this.region = region;
		this.postCode = postCode;
		this.country = country;
		this.orcid = orcid;
		this.email = email;
		this.tel = tel;
		this.fax = fax;
		this.website = website;
	}

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	private void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	private void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	private void setRegion(String region) {
		this.region = region;
	}

	@JsonProperty("post-code")
	public String getPostCode() {
		return postCode;
	}

	@JsonProperty("post-code")
	private void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	private void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("orcid")
	public String getOrcid() {
		return orcid;
	}

	@JsonProperty("orcid")
	private void setOrcid(String orcid) {
		this.orcid = orcid;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	private void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("tel")
	public String getTel() {
		return tel;
	}

	@JsonProperty("tel")
	private void setTel(String tel) {
		this.tel = tel;
	}

	@JsonProperty("fax")
	public String getFax() {
		return fax;
	}

	@JsonProperty("fax")
	private void setFax(String fax) {
		this.fax = fax;
	}

	@JsonProperty("website")
	public String getWebsite() {
		return website;
	}

	@JsonProperty("website")
	private void setWebsite(String website) {
		this.website = website;
	}

}