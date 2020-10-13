package com.skrypnik.searcher.service;

import com.skrypnik.searcher.data.SearchRequestDto;
import com.skrypnik.searcher.data.SearchResultDto;

import java.util.List;

public interface SearchService {

	List<SearchResultDto> search(SearchRequestDto searchRequest) throws InterruptedException;
}
