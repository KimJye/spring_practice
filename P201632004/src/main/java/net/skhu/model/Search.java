package net.skhu.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.Data;

@Data
public class Search {
	int sb; //searchBy
	String st; //searchText
	int ob; //orderby


	public String getQueryString() {

		 String url = null;
		 try {
			 String temp = (st == null) ? "" : URLEncoder.encode(st, "UTF-8");
			 url = String.format("ob=%d&sb=%d&st=%s&di", ob, sb, st,temp);
			 }
		 catch (UnsupportedEncodingException e) { }
		 return url;

	}
}
