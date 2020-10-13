package com.skrypnik.searcher.service;

import com.skrypnik.searcher.data.ExtendedSearchResultDto;

public interface HtmlService {

	ExtendedSearchResultDto getSearchResultByTextAndUrl(String text, String url);
}
