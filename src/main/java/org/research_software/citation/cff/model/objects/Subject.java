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

import org.research_software.citation.cff.exceptions.InvalidDataException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * An abstract super class for {@link Person} and {@link Entity},
 * providing databinding for shared keys.
 * 
 * @version Citation File Format Version 1.0.3
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@JsonSubTypes({ @Type(value = Person.class), @Type(value = Entity.class), })
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Subject {

	private String address;
	private String city;
	private String region;
	private String postCode;
	private String country;
	private URL orcid;
	private String email;
	private String tel;
	private String fax;
	private URL website;

	/**
	 * Constructor for databinding
	 *
	 * @param region The region where the subject is located
	 * @param fax The telefax number of the subject
	 * @param orcid The ORCID iD of the subject
	 * @param website The website of the subject
	 * @param email The email address of the subject
	 * @param address The address of the subject
	 * @param tel The telephone number of the subject
	 * @param postCode The post code ("zip code") of the city where the subject is located
	 * @param country The country where the subject is located
	 * @param city The city where the subject is located
	 * 
	 * @throws InvalidDataException on invalid data and resulting parse errors, e.g., for date/time parses 
	 */
	public Subject(@JsonProperty("address") String address, @JsonProperty("city") String city,
			@JsonProperty("region") String region, @JsonProperty("post-code") String postCode,
			@JsonProperty("country") String country, @JsonProperty("orcid") String orcid,
			@JsonProperty("email") String email, @JsonProperty("tel") String tel, @JsonProperty("fax") String fax,
			@JsonProperty("website") String website) throws InvalidDataException {
		this.address = address;
		this.city = city;
		this.region = region;
		this.postCode = postCode;
		setCountry(country);
		setOrcid(orcid);
		this.email = email;
		this.tel = tel;
		this.fax = fax;
		setWebsite(website);
	}

	/**
	 * @return the address
	 */
	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	private void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	private void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the region
	 */
	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	private void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the postCode
	 */
	@JsonProperty("post-code")
	public String getPostCode() {
		return postCode;
	}

	@JsonProperty("post-code")
	private void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the country
	 */
	@JsonProperty("country")
	public String getCountry() {
		return country;
	}

	@JsonProperty("country")
	private void setCountry(String country) throws InvalidDataException {
		if (country != null) {
			if (!DefinedValues.COUNTRY.contains(country)) {
				throw new InvalidDataException("'country' value '" + country + "' is not a valid ISO 3166-1 alpha-2 code.");
			}
		}
		this.country = country;
	}

	/**
	 * @return the orcid
	 */
	@JsonProperty("orcid")
	public URL getOrcid() {
		return orcid;
	}

	@JsonProperty("orcid")
	private void setOrcid(String orcid) throws InvalidDataException {
		if (orcid != null) {
			if (!orcid.matches(DefinedValues.ORCID_URL_PATTERN)) {
				throw new InvalidDataException("ORCID id " + orcid
						+ " is not a valid ORCID URL with pattern 'https://orcid.org/[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}'!");
			}
			try {
				this.orcid = new URL(orcid);
			}
			catch (MalformedURLException e) {
				throw new InvalidDataException("The ORCID URL '" + orcid + "' is not valid!", e);
			}
		}
	}

	/**
	 * @return the email
	 */
	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	private void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tel
	 */
	@JsonProperty("tel")
	public String getTel() {
		return tel;
	}

	@JsonProperty("tel")
	private void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the fax
	 */
	@JsonProperty("fax")
	public String getFax() {
		return fax;
	}

	@JsonProperty("fax")
	private void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the website
	 */
	@JsonProperty("website")
	public URL getWebsite() {
		return website;
	}

	@JsonProperty("website")
	private void setWebsite(String website) throws InvalidDataException {
		if (website != null) {
			try {
				this.website = new URL(website);
			}
			catch (MalformedURLException e) {
				throw new InvalidDataException("The 'website' URL '" + website + "' is not valid.", e);
			}
		}
	}

}