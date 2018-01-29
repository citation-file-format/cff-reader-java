/**
 * 
 */
package org.research_software.citation.cff.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "cff-version", "message", "authors", "title", "version", "doi", "date-released" })
final public class SoftwareCitation {
	
		@JsonProperty("cff-version")
		private String cffVersion;
		@JsonProperty("message")
		private String message;
		@JsonProperty("authors")
		private List<Author> authors = new ArrayList<Author>();
		@JsonProperty("title")
		private String title;
		@JsonProperty("version")
		private String version;
		@JsonProperty("doi")
		private String doi;
		@JsonProperty("date-released")
		private LocalDate dateReleased;

		/**
		 * No args constructor for use in serialization
		 *
		 */
		public SoftwareCitation() {
		}

		/**
		 *
		 * @param message
		 * @param authors
		 * @param dateReleased
		 * @param title
		 * @param doi
		 * @param version
		 * @param cffVersion
		 */
		public SoftwareCitation(String cffVersion, String message, List<Author> authors, String title, String version,
				String doi, String dateReleased) {
			super();
			this.cffVersion = cffVersion;
			this.message = message;
			this.authors = authors;
			this.title = title;
			this.version = version;
			this.doi = doi;
			this.dateReleased = LocalDate.parse(dateReleased);
		}

		@JsonProperty("cff-version")
		public String getCffVersion() {
			return cffVersion;
		}

		@JsonProperty("cff-version")
		public void setCffVersion(String cffVersion) {
			this.cffVersion = cffVersion;
		}

		@JsonProperty("message")
		public String getMessage() {
			return message;
		}

		@JsonProperty("message")
		public void setMessage(String message) {
			this.message = message;
		}

		@JsonProperty("authors")
		public List<Author> getAuthors() {
			return authors;
		}

		@JsonProperty("authors")
		public void setAuthors(List<Author> authors) {
			this.authors = authors;
		}

		@JsonProperty("title")
		public String getTitle() {
			return title;
		}

		@JsonProperty("title")
		public void setTitle(String title) {
			this.title = title;
		}

		@JsonProperty("version")
		public String getVersion() {
			return version;
		}

		@JsonProperty("version")
		public void setVersion(String version) {
			this.version = version;
		}

		@JsonProperty("doi")
		public String getDoi() {
			return doi;
		}

		@JsonProperty("doi")
		public void setDoi(String doi) {
			this.doi = doi;
		}

		@JsonProperty("date-released")
		public LocalDate getDateReleased() {
			return dateReleased;
		}

		@JsonProperty("date-released")
		public void setDateReleased(String dateReleased) {
			this.dateReleased = LocalDate.parse(dateReleased);
		}

}
