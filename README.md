[![Build Status](https://travis-ci.org/citation-file-format/cff-reader-java.svg?branch=feature%2Fpojo-implementation)](https://travis-ci.org/citation-file-format/cff-reader-java)

# cff-reader-java

A Java API for reading software citation metadata files in the 
[Citation File Format](https://citation-file-format.github.io/)
The API provides POJO models for software citation metadata for inspection and 
re-use.

## Entry point

The main entry point to the API is via the `SoftwareCitationMetadataReader` 
interface. For example:

```java
SoftwareCitationMetadataReader reader = new SoftwareCitationMetadataPojoReader();
		
File cffFile = new File(...);
SoftwareCitationMetadata citationMetadata = reader.readFromFile(cffFile);

/* 
 * Alternatively, e.g., for reading files from the
 * class loader via 
 * `this.getClass().getResourceAsStream("/CITATION.cff")`
 */
InputStream cffInputStream = ...;
citationMetadata = reader.readFromStream(cffInputStream);

```

## Exceptions

Upon errors, the API will throw exceptions:

- `com.fasterxml.jackson.core.JsonParseException` -- Malformed `CITATION.cff` 
file.
- `com.fasterxml.jackson.databind.JsonMappingException` -- Fatal problems with 
mapping of content.
- `IOException` -- Fatal problems with reading from a source.
- `NullPointerException` -- Wrapped exception, missing required CFF keys.
- `MalformedURLException` -- Invalid URL provided in one of the CFF keys 
expecting a URL.
- `DateTimeParseException` -- Invalid date provided in one of the CFF keys 
expecting a date.

## Installation

### Maven

The API is provided via Maven Central.

```xml
<dependencies>
    <dependency>
        <groupId>org.research-software.citation</groupId>
        <artifactId>cff-reader-java</artifactId>
        <version>0.1.0</version>
    </dependency>
</dependencies>

```