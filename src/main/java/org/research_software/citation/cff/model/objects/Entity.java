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
public final class Entity extends Subject {

	@JsonProperty("name")
	private String name;
	@JsonProperty("date-start")
	private String dateStart;
	@JsonProperty("date-end")
	private String dateEnd;
	@JsonProperty("location")
	private String location;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Entity() {
	}

	/**
	 *
	 * @param location
	 * @param name
	 * @param dateEnd
	 * @param dateStart
	 */
	public Entity(String name, String dateStart, String dateEnd, String location, String address, String city, String region, String postCode, String country, String orcid,
			String email, String tel, String fax, String website) {
		super(address, city, region, postCode, country, orcid, email, tel, fax, website);
		this.name = name;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.location = location;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("date-start")
	public String getDateStart() {
		return dateStart;
	}

	@JsonProperty("date-start")
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	@JsonProperty("date-end")
	public String getDateEnd() {
		return dateEnd;
	}

	@JsonProperty("date-end")
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

}