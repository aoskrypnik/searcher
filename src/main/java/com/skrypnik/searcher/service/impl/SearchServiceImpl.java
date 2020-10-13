package com.skrypnik.searcher.service.impl;

import com.skrypnik.searcher.data.SearchRequestDto;
import com.skrypnik.searcher.data.SearchResultDto;
import com.skrypnik.searcher.service.HtmlService;
import com.skrypnik.searcher.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.Executors.newFixedThreadPool;

@Service
public class SearchServiceImpl implements SearchService {

	private static final int INITIAL_VALUE = 1;

	@Override
	public List<SearchResultDto> search(SearchRequestDto searchRequest) throws InterruptedException {
		HtmlService htmlService = new DefaultHtmlService();
		List<SearchResultDto> results = new ArrayList<>();
		BlockingQueue<String> urlsQueue = new LinkedBlockingDeque<>(searchRequest.getPageNum());
		AtomicInteger counter = new AtomicInteger(INITIAL_VALUE);

		ExecutorService executorService = newFixedThreadPool(searchRequest.getThreadNum());

		urlsQueue.add(searchRequest.getUrl());

		for (int i = 0; i < searchRequest.getPageNum(); i++) {
			Runnable searchWorkerThread = new SearchWorkerThread(urlsQueue.take(), searchRequest.getText(),
					counter, searchRequest.getPageNum(), urlsQueue, results, htmlService);
			executorService.execute(searchWorkerThread);
		}

		executorService.shutdown();
		while (!executorService.isTerminated()) {
		}

		return results;
	}
}
