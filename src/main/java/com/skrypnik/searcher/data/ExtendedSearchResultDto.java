package com.skrypnik.searcher.data;

import org.jsoup.nodes.Document;

public class ExtendedSearchResultDto extends SearchResultDto {

	private Document document;

	public ExtendedSearchResultDto(String url, SearchStatus status, String errorMessage, Document document) {
		super(url, status, errorMessage);
		this.document = document;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
