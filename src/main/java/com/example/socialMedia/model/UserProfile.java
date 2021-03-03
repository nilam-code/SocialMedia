package com.example.socialMedia.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name="UserProfile")
public class UserProfile extends AuditModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(max = 200)
	private String about;
	
	@NotNull
	@Size(max = 200)
	private String profilePicUrl;
	
	@NotNull
	private boolean gender;
	
	@NotNull
    @Size(max = 50)
    private String location;

    @NotNull
    @Size(max = 100)
    private String interests;

    @NotNull
    @Size(max = 100 )
    private String languages;
	
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	

}
