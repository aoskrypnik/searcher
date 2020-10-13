package com.skrypnik.searcher.controller;

import com.skrypnik.searcher.controller.util.ControllerUtil;
import com.skrypnik.searcher.data.SearchRequestDto;
import com.skrypnik.searcher.service.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class SearchController {

	@Resource
	private SearchService searchService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/search")
	public String search(@Valid SearchRequestDto searchRequest,
						 BindingResult bindingResult,
						 Model model) throws InterruptedException {
		if (bindingResult.hasErrors()) {
			model.addAllAttributes(ControllerUtil.getErrors(bindingResult));
			return "index";
		}
		model.addAttribute("searchResults", searchService.search(searchRequest));
		return "search";
	}

}
