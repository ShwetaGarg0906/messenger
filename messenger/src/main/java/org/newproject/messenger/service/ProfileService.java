package org.newproject.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.newproject.messenger.database.DatabaseClass;
import org.newproject.messenger.model.Message;
import org.newproject.messenger.model.ProfileModel;


public class ProfileService {
	private Map<String,ProfileModel> profiles  = DatabaseClass.getProfile();
	
	public ProfileService() {
		ProfileModel profile1 = new ProfileModel(1,"Shweta","shweta","Garg");
		ProfileModel profile2 = new ProfileModel(2,"Simran","simran","kukreja");
		profiles.put("Shweta", profile1);
		profiles.put("Simran", profile2);
	}
	
	public List<ProfileModel> getAllProfiles(){
		List<ProfileModel> profileList = new ArrayList(profiles.values());
		return profileList;
		//return profiles.get("Shweta");
	}
	
	public ProfileModel getProfile(String name) {
		return profiles.get(name);
	}
	
	public ProfileModel addProfile(ProfileModel prof) {
		prof.setId(profiles.size()+1);
		profiles.put(prof.getProfName(),prof);
		return prof;
	}
	
	public ProfileModel updateProfile(ProfileModel prof) {
		if(prof.getProfName().isEmpty()) {
			return null;
		}
		profiles.put(prof.getProfName(), prof);
		return prof;
	}
	
	public ProfileModel removeProfile(String profName) {
		return profiles.remove(profName);
	}
	
}
