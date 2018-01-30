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

	@JsonProperty("address")
	private String address;
	@JsonProperty("city")
	private String city;
	@JsonProperty("region")
	private String region;
	@JsonProperty("post-code")
	private String postCode;
	@JsonProperty("country")
	private String country;
	@JsonProperty("orcid")
	private String orcid;
	@JsonProperty("email")
	private String email;
	@JsonProperty("tel")
	private String tel;
	@JsonProperty("fax")
	private String fax;
	@JsonProperty("website")
	private String website;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Subject() {
	}

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
	public Subject(String address, String city, String region, String postCode, String country, String orcid,
			String email, String tel, String fax, String website) {
		super();
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
	public void setAddress(String address) {
		this.address = address;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
		this.region = region;
	}

	@JsonProperty("post-code")
	public String getPostCode() {
		return postCode;
	}

	@JsonProperty("post-code")
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	public void setCountry(String country) {
		this.country = country;
	}

	@JsonProperty("orcid")
	public String getOrcid() {
		return orcid;
	}

	@JsonProperty("orcid")
	public void setOrcid(String orcid) {
		this.orcid = orcid;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("tel")
	public String getTel() {
		return tel;
	}

	@JsonProperty("tel")
	public void setTel(String tel) {
		this.tel = tel;
	}

	@JsonProperty("fax")
	public String getFax() {
		return fax;
	}

	@JsonProperty("fax")
	public void setFax(String fax) {
		this.fax = fax;
	}

	@JsonProperty("website")
	public String getWebsite() {
		return website;
	}

	@JsonProperty("website")
	public void setWebsite(String website) {
		this.website = website;
	}

}