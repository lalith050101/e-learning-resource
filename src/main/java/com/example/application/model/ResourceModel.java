package com.example.application.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ResourceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resourceId;

    private String resourceName;

    private String resourceLink;

 	@Column(name = "imageUrl",columnDefinition = "text")
    private String imageUrl;
    
    private String resourceCategory;

    private Date createdOn;

    @ManyToOne
    private UserModel createdBy;
    
    private Boolean verified = false;
    
    private Boolean active = true;
    
    public ResourceModel() {
    	
    }

    
    
	public ResourceModel(Long resourceId, String resourceName, String resourceLink, String imageUrl,
			String resourceCategory, Date createdOn, UserModel createdBy, Boolean verified, Boolean active) {
		super();
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.resourceLink = resourceLink;
		this.imageUrl = imageUrl;
		this.resourceCategory = resourceCategory;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.verified = verified;
		this.active = active;
	}



	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getResourceLink() {
		return resourceLink;
	}

	public void setResourceLink(String resourceLink) {
		this.resourceLink = resourceLink;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getResourceCategory() {
		return resourceCategory;
	}

	public void setResourceCategory(String resourceCategory) {
		this.resourceCategory = resourceCategory;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public UserModel getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserModel createdBy) {
		this.createdBy = createdBy;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
    
    
}
