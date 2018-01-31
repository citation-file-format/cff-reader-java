package org.research_software.citation.cff.model.objects;

import java.net.MalformedURLException;
import java.time.DateTimeException;
import java.time.LocalDate;

import org.research_software.citation.cff.model.exceptions.CFFModelException;

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
	private LocalDate dateStart;
	private LocalDate dateEnd;
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
	 * @throws CFFModelException
	 * @throws MalformedURLException
	 */
	public Entity(@JsonProperty("name") String name, @JsonProperty("date-start") String dateStart,
			@JsonProperty("date-end") String dateEnd, @JsonProperty("location") String location,
			@JsonProperty("address") String address, @JsonProperty("city") String city,
			@JsonProperty("region") String region, @JsonProperty("post-code") String postCode,
			@JsonProperty("country") String country, @JsonProperty("orcid") String orcid,
			@JsonProperty("email") String email, @JsonProperty("tel") String tel, @JsonProperty("fax") String fax,
			@JsonProperty("website") String website) throws MalformedURLException, CFFModelException {
		super(address, city, region, postCode, country, orcid, email, tel, fax, website);
		if (name == null) {
			throw new NullPointerException("'name' is a required key in entities and must be present and not null!");
		}
		this.name = name;
		setDateStart(dateStart);
		setDateEnd(dateEnd);
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
	public LocalDate getDateStart() {
		return dateStart;
	}

	@JsonProperty("date-start")
	private void setDateStart(String dateStart) {
		if (dateStart != null) {
			try {
				this.dateStart = LocalDate.parse(dateStart);
			}
			catch (DateTimeException e) {
				throw new CFFModelException("DateTimeException in field 'date-start': " + e.getMessage());
			}
		}
	}

	@JsonProperty("date-end")
	public LocalDate getDateEnd() {
		return dateEnd;
	}

	@JsonProperty("date-end")
	private void setDateEnd(String dateEnd) {
		if (dateEnd != null) {
			try {
				this.dateEnd = LocalDate.parse(dateEnd);
			}
			catch (DateTimeException e) {
				throw new CFFModelException("DateTimeException in field 'date-end': " + e.getMessage());
			}
		}
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