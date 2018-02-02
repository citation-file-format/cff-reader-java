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
 *
 *
 */
package org.research_software.citation.cff.model.objects;

import java.net.MalformedURLException;

import org.research_software.citation.cff.exceptions.CFFModelException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model element representing a person.
 * 
 * @see <a href="https://citation-file-format.github.io/1.0.3/specifications/#/person-objects">https://citation-file-format.github.io/1.0.3/specifications/#/person-objects</a>
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
	 * Constructor for databinding.
	 * 
	 * @param nameSuffix The suffix of the person's name
	 * @param familyNames The person's family names
	 * @param nameParticle The particle of the person's name
	 * @param givenNames The person's given names
	 * @param affiliation The person's affiliation 
	 * @param address The person's address  
	 * @param city The person's address city
	 * @param region The person's address region
	 * @param postCode The person's address post code ("zip code")
	 * @param country The person's address country
	 * @param orcid The person's ORCID iD
	 * @param email The person's email address
	 * @param tel The person's telephone number
	 * @param fax The person's telefax number
	 * @param website The person's website
	 * 
	 * @throws CFFModelException on invalid model values
	 * @throws MalformedURLException on malformed URLs according to Java specs
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
			@JsonProperty("website") String website) throws MalformedURLException, CFFModelException {
		super(address, city, region, postCode, country, orcid, email, tel, fax, website);
		if (familyNames == null) {
			throw new NullPointerException("'family-names' is a required key in persons and must be present and not null!");
		}
		this.familyNames = familyNames;
		if (givenNames == null) {
			throw new NullPointerException("'given-names' is a required key in persons and must be present and not null!");
		}
		this.givenNames = givenNames;
		this.nameParticle = nameParticle;
		this.nameSuffix = nameSuffix;
		this.affiliation = affiliation;
	}

	/**
	 * @return The person's family names
	 */
	@JsonProperty("family-names")
	public String getFamilyNames() {
		return familyNames;
	}

	@JsonProperty("family-names")
	private void setFamilyNames(String familyNames) {
		this.familyNames = familyNames;
	}

	/**
	 * @return The person's given names
	 */
	@JsonProperty("given-names")
	public String getGivenNames() {
		return givenNames;
	}

	@JsonProperty("given-names")
	private void setGivenNames(String givenNames) {
		this.givenNames = givenNames;
	}

	/**
	 * @return The particle of the person's name
	 */
	@JsonProperty("name-particle")
	public String getNameParticle() {
		return nameParticle;
	}

	@JsonProperty("name-particle")
	private void setNameParticle(String nameParticle) {
		this.nameParticle = nameParticle;
	}

	/**
	 * @return The person's name suffix
	 */
	@JsonProperty("name-suffix")
	public String getNameSuffix() {
		return nameSuffix;
	}

	@JsonProperty("name-suffix")
	private void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	/**
	 * @return The person's affiliation
	 */
	@JsonProperty("affiliation")
	public String getAffiliation() {
		return affiliation;
	}

	@JsonProperty("affiliation")
	private void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

}