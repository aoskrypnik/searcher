package com.skrypnik.searcher.service.impl;

import com.skrypnik.searcher.data.ExtendedSearchResultDto;
import com.skrypnik.searcher.data.SearchResultDto;
import com.skrypnik.searcher.service.HtmlService;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchWorkerThread implements Runnable {

	private static final String HTTPS = "https://";
	private static final String HREF = "href";
	private static final String A_TAG = "a";

	private final String searchUrl;
	private final String searchText;
	private final AtomicInteger insertedPageNum;
	private final int allowedPageNum;
	private final BlockingQueue<String> urls;
	private final List<SearchResultDto> results;
	private final HtmlService htmlService;

	public SearchWorkerThread(String searchUrl, String searchText, AtomicInteger insertedPageNum, int allowedPageNum,
							  BlockingQueue<String> urls, List<SearchResultDto> results, HtmlService htmlService) {
		this.searchUrl = searchUrl;
		this.searchText = searchText;
		this.insertedPageNum = insertedPageNum;
		this.allowedPageNum = allowedPageNum;
		this.urls = urls;
		this.results = results;
		this.htmlService = htmlService;
	}

	@Override
	public void run() {
		ExtendedSearchResultDto searchResult = htmlService.getSearchResultByTextAndUrl(searchText, searchUrl);
		results.add(new SearchResultDto(searchResult.getUrl(), searchResult.getStatus(), searchResult.getErrorMessage()));

		if (insertedPageNum.get() != allowedPageNum && searchResult.getDocument() != null) {
			searchResult.getDocument().select(A_TAG).stream()
					.map(link -> {
						String value = link.attr(HREF);
						if (!value.startsWith(HTTPS)) {
							value = searchUrl + value;
						}
						return value;
					})
					.distinct()
					.forEach(link -> {
						if (insertedPageNum.get() != allowedPageNum) {
							insertedPageNum.addAndGet(1);
							urls.add(link);
						}
					});
		}
	}
}
