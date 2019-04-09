package org.newproject.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.newproject.messenger.service.ProfileService;
import org.newproject.messenger.model.*;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	//private static final String profName = null;
	ProfileService profService = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProfileModel>  getAllProfiles(){
		return profService.getAllProfiles(); 
		//return profService.getAllProfile();
	}
	
	@GET
	@Path("/{ProfName}")
	public ProfileModel getProfile(@PathParam("ProfName") String ProfName) {
		return profService.getProfile(ProfName);
		//return ProfName;
	}
	
	@POST
	public ProfileModel addProfile(ProfileModel prof) {
		String ProfName = prof.getProfName();
		return profService.addProfile(prof);
	}
	
	@PUT
	@Path("/{ProfName}")
	public ProfileModel updateProfile(@PathParam("ProfName") String profName ,ProfileModel prof) {
		prof.setProfName(profName);
		return profService.updateProfile(prof);
	}
	
	@DELETE
	@Path("/{ProfName}")
	public ProfileModel removeProfile(@PathParam("ProfName")String profName) {
		return profService.removeProfile(profName);
	}
}
