package com.skrypnik.searcher.service.impl;

import com.skrypnik.searcher.data.ExtendedSearchResultDto;
import com.skrypnik.searcher.data.SearchStatus;
import com.skrypnik.searcher.service.HtmlService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DefaultHtmlService implements HtmlService {

	@Override
	public ExtendedSearchResultDto getSearchResultByTextAndUrl(String text, String url) {
		Document document = null;
		String errorMessage = null;

		try {
			document = Jsoup.connect(url).get();
		} catch (IOException e) {
			errorMessage = e.getMessage();
		}

		SearchStatus searchStatus;

		if (document != null) {
			searchStatus = document.text().contains(text)
					? SearchStatus.FOUND
					: SearchStatus.NOT_FOUND;
		} else {
			searchStatus = SearchStatus.ERROR;
		}

		return new ExtendedSearchResultDto(url, searchStatus, errorMessage, document);
	}
}
