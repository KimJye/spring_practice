package net.skhu.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.Data;

@Data
public class Search {

	int pg=1; //현재 페이지
	int sz=15; //페이지당 레코드 수
	int sb; //searchBy
	String st; //searchText
	int recordCount;

	public String getQueryString() {

		 String url = null;
		 try {
			 String temp = (st == null) ? "" : URLEncoder.encode(st, "UTF-8");
			 url = String.format("sb=%d&st=%s&di",sb, st,temp);
			 }
		 catch (UnsupportedEncodingException e) { }
		 return url;

	}
}
