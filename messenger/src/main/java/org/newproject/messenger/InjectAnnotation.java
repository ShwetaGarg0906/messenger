package org.newproject.messenger;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injectAnnot")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InjectAnnotation {
	
	@GET
	public String hellomsg() {
		return "hello";
	}
	
	@GET
	@Path("/extra")
	public String getExtraParam(@MatrixParam("matparamvalue") String matvalue,@HeaderParam ("header") String headerval,@CookieParam("cokkiename") String cookieval) {
		return "matparavalue:  " + matvalue + " \n header value : " + headerval +" CookieParamName :" + cookieval;
	}
	
	@GET
	@Path("/context")
	public String getContextParam(@Context UriInfo uriinfo,@Context HttpHeaders header) {
		String headerval = header.getHeaderString("name");
		String uri = uriinfo.getAbsolutePath().toString();
		return "uri value: "+ uri + " header value" +headerval ;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
