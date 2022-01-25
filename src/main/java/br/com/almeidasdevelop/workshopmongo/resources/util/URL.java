package br.com.almeidasdevelop.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class URL {
	
	public static String decodeParam(String param) {
		try {
			return URLDecoder.decode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static LocalDate convertDate(String date, LocalDate defaultDate) {
		try {
			return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}catch (DateTimeParseException e) {
			return defaultDate;
		}
	}

}
