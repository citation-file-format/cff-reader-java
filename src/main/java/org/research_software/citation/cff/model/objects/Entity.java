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

import java.time.DateTimeException;
import java.time.LocalDate;

import org.research_software.citation.cff.exceptions.InvalidDataException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model element representing an entity, e.g., a project group,
 * organization, publishing house, conference, or similar.
 * 
 * @see <a href="https://citation-file-format.github.io/1.0.3/specifications/#/entity-objects">https://citation-file-format.github.io/1.0.3/specifications/#/entity-objects</a>
 * 
 * @version Citation File Format Version 1.0.3
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Entity extends Subject {

	private String name;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	private String location;

	/**
	 * Constructor for databinding.
	 * 
	 * @param location The location of the entity
	 * @param name The name of the entity (**required**)
	 * @param dateEnd The end date, if the entity is an event, e.g., a conference
	 * @param dateStart The start date, if the entity is an event, e.g., a conference
	 * @param address The address of the entity
	 * @param city The city where the entity is located
	 * @param region The region where the entity is located
	 * @param postCode The post code ("zip code") of the city where the entity is located
	 * @param country The country where the entity is located
	 * @param orcid The ORCID iD of the entity
	 * @param email The email address of the entity
	 * @param tel The telephone number of the entity
	 * @param fax The telefax number of the entity 
	 * @param website The website of the entity
	 * 
	 * @throws InvalidDataException on invalid data and resulting parse errors, e.g., for date/time parses
	 */
	public Entity(@JsonProperty("name") String name, @JsonProperty("date-start") String dateStart,
			@JsonProperty("date-end") String dateEnd, @JsonProperty("location") String location,
			@JsonProperty("address") String address, @JsonProperty("city") String city,
			@JsonProperty("region") String region, @JsonProperty("post-code") String postCode,
			@JsonProperty("country") String country, @JsonProperty("orcid") String orcid,
			@JsonProperty("email") String email, @JsonProperty("tel") String tel, @JsonProperty("fax") String fax,
			@JsonProperty("website") String website) throws InvalidDataException {
		super(address, city, region, postCode, country, orcid, email, tel, fax, website);
		if (name == null) {
			throw new InvalidDataException("'name' is a required key in entities and must be present and not null!");
		}
		this.name = name;
		setDateStart(dateStart);
		setDateEnd(dateEnd);
		this.location = location;
	}

	/**
	 * @return The name of the entity
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * @return The start date of the entity
	 */
	@JsonProperty("date-start")
	public LocalDate getDateStart() {
		return dateStart;
	}

	@JsonProperty("date-start")
	private void setDateStart(String dateStart) throws InvalidDataException {
		if (dateStart != null) {
			try {
				this.dateStart = LocalDate.parse(dateStart);
			}
			catch (DateTimeException e) {
				throw new InvalidDataException("DateTimeException in field 'date-start'!", e);
			}
		}
	}

	/**
	 * @return The end date of the entity
	 */
	@JsonProperty("date-end")
	public LocalDate getDateEnd() {
		return dateEnd;
	}

	@JsonProperty("date-end")
	private void setDateEnd(String dateEnd) throws InvalidDataException {
		if (dateEnd != null) {
			try {
				this.dateEnd = LocalDate.parse(dateEnd);
			}
			catch (DateTimeException e) {
				throw new InvalidDataException("DateTimeException in field 'date-end'!", e);
			}
		}
	}

	/**
	 * @return The location of the entity
	 */
	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("location")
	private void setLocation(String location) {
		this.location = location;
	}

}