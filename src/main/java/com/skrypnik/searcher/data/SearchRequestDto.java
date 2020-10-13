package com.skrypnik.searcher.data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SearchRequestDto {

	@NotBlank(message = "should not be blank")
	private String text;
	@Pattern(regexp = "((http|https)://)(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)")
	private String url;
	@NotNull
	@Min(1)
	private Integer threadNum;
	@NotNull
	@Min(1)
	private Integer pageNum;

	public SearchRequestDto(String text, String url, Integer threadNum, Integer pageNum) {
		this.text = text;
		this.url = url;
		this.threadNum = threadNum;
		this.pageNum = pageNum;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getThreadNum() {
		return threadNum;
	}

	public void setThreadNum(Integer threadNum) {
		this.threadNum = threadNum;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
}
