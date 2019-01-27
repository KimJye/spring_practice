package net.skhu.summernote.model;

import lombok.Data;

@Data
public class Option {
	int value;
	String label;

	public Option(int value, String label) {
		super();
		this.value = value;
		this.label = label;
	}

}
