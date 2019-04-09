package org.newproject.messenger.model;

//import java.util.Date;

public class ProfileModel {
	private long id;
	private String profName;
	private String Fname;
	private String Lname;
	//private Date created ;
	public ProfileModel() {
		
	}
	public ProfileModel(long id, String profName, String fname, String lname) {
		super();
		this.profName=profName;
		this.id = id;
		this.Fname = fname;
		this.Lname = lname;
		//this.created = created;
	}
	
	public String getProfName() {
		return profName;
	}

	public void setProfName(String profName) {
		this.profName = profName;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	/*public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}*/	
}
