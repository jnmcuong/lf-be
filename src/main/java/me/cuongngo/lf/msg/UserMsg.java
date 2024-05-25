package me.cuongngo.lf.msg;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserMsg {

	@JsonProperty("id")
	private int id;
	
	@JsonProperty("name")
	private String name;
}
