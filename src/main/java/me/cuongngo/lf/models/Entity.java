package me.cuongngo.lf.models;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public abstract class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5949283262443288159L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id = 0l;
	
	@Column(name = "created_at")
	private OffsetDateTime createdAt = OffsetDateTime.now();
	
	@Column(name = "created_by")
	private long createdBy = 0;
	
	@Column(name = "updated_at")
	private OffsetDateTime updatedAt = OffsetDateTime.now();
	
	@Column(name = "updated_by")
	private long updatedBy = 0;
	
	@Column(name = "version")
	private long version = 0;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public OffsetDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(OffsetDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}
	
	@PreUpdate
	private void setUpdateTime() {
		this.updatedAt = OffsetDateTime.now();
	}
	
	@PrePersist
	private void setCreatedTime() {
		this.createdAt = OffsetDateTime.now();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		return Objects.equals(id, other.id);
	}
	
}
