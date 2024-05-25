package me.cuongngo.lf.msg;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class EntityMsg {

	@JsonProperty("id")
	protected Long id;
	
	@JsonProperty("created_at")
	protected OffsetDateTime createdAt;
	
	@JsonProperty("created_by")
	protected Long createdBy;
	
	@JsonProperty("updated_at")
	protected OffsetDateTime updatedAt;
	
	@JsonProperty("updated_by")
	protected Long updatedBy;
	
	@JsonProperty("version")
	protected Long version;
}
