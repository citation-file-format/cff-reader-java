[![Build Status](https://travis-ci.org/citation-file-format/cff-reader-java.svg?branch=master)](https://travis-ci.org/citation-file-format/cff-reader-java) 
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.research-software.citation/cff-reader-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.research-software.citation/cff-reader-java)
[![Coverage Status](https://coveralls.io/repos/github/citation-file-format/cff-reader-java/badge.svg?branch=master)](https://coveralls.io/github/citation-file-format/cff-reader-java?branch=master)
[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.1171249.svg)](https://doi.org/10.5281/zenodo.1171249)

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

// Inspect/re-use
citationMetadata.getTitle();
citationMetadata.getVersion();
...
for (author : citationMetadata.getPersonAuthors()) {
	author.getFamilyNames();
	author.getGivenNames();
	...
}
for (author : citationMetadata.getEntityAuthors()) {
	author.getName();
	...
}
for (reference : citationMetadata.getReferences()) {
	reference.getType();
	reference.getTitle();
	...
	for (author : reference.getPersonAuthors()) {
		author.getFamilyNames();
		author.getGivenNames();
	...
	}
	for (author : reference.getEntityAuthors()) {
		author.getName();
		...
	}
}

```

## Exceptions

Upon errors, the API will throw exceptions:

- `InvalidCFFFileNameException` -- thrown on attempted reads of files with an
invalid name (CFF file must be named `CITATION.cff`)
- `InvalidDataException` -- thrown on encountering invalid data in the CFF file,
as specified in the 
[Citation File Format specifications](https://citation-file-format.github.io/)
- `ReadException` -- thrown on encountering errors or exceptions during the
read process

`InvalidDataException` and `ReadException` may wrap cause exceptions.


## Installation

### Maven

The API is provided via the usual Sonatype Snapshot Repository (OSSRH) and Maven 
Central.

```xml
<dependencies>
    <dependency>
        <groupId>org.research-software.citation</groupId>
        <artifactId>cff-reader-java</artifactId>
        <version>1.0.1</version>
    </dependency>
</dependencies>

```

## Documentation

General documentation is maintained at <https://citation-file-format.github.io/cff-reader-java>,
including [API JavaDocs](https://citation-file-format.github.io/cff-reader-java/apidocs/index.html).

## Contribute!

For simple contributions guidelines, please see [CONTRIBUTING.md](CONTRIBUTING.md).

## Build

Build the project locally with `mvn {clean} install`.