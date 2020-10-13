package com.skrypnik.searcher.controller.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Map;
import java.util.stream.Collectors;

public final class ControllerUtil {

	private static final String ERROR = "Error";

	private ControllerUtil() {
	}

	public static Map<String, String> getErrors(BindingResult bindingResult) {
		return bindingResult.getFieldErrors().stream()
				.collect(Collectors.toMap(
						fieldError -> fieldError.getField() + ERROR,
						FieldError::getDefaultMessage
				));
	}
}
