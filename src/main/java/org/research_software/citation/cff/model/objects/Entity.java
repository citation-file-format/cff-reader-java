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

	private String name;
	private String dateStart;
	private String dateEnd;
	private String location;

	/**
	 *
	 * @param location
	 * @param name
	 * @param dateEnd
	 * @param dateStart
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
	public Entity(
			@JsonProperty("name") String name, 
			@JsonProperty("date-start") String dateStart, 
			@JsonProperty("date-end") String dateEnd, 
			@JsonProperty("location") String location, 
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
	private void setName(String name) {
		this.name = name;
	}

	@JsonProperty("date-start")
	public String getDateStart() {
		return dateStart;
	}

	@JsonProperty("date-start")
	private void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	@JsonProperty("date-end")
	public String getDateEnd() {
		return dateEnd;
	}

	@JsonProperty("date-end")
	private void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("location")
	private void setLocation(String location) {
		this.location = location;
	}

}