package com.skrypnik.searcher.data;

public class SearchResultDto {
	private String url;
	private SearchStatus status;
	private String errorMessage;

	public SearchResultDto(String url, SearchStatus status, String errorMessage) {
		this.url = url;
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public SearchStatus getStatus() {
		return status;
	}

	public void setStatus(SearchStatus status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
