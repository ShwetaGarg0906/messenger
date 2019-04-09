package org.newproject.messenger.resource;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;

import org.newproject.messenger.beans.MessengerBean;
import org.newproject.messenger.model.Message;
import org.newproject.messenger.service.MessageService;

@Path("/message_resource")
public class MessageResource {
	
	/*MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)*/
	/*public List<Message> getMessage(@QueryParam("year") int year,
									@QueryParam("size") int size,
									@QueryParam("start") int start) {
		if(year>0) {
		return messageService.getAllMessagesForYear(year);
		}
		else 
		if(start>=0&&size>0){
			return messageService.getMessageforSize(start, size);
		}
		else {
		return messageService.getMessages();
		}
	}*/
	
	//another way of taking params by using beans 
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAllMessages(@BeanParam MessengerBean messengerBean){
		if(messengerBean.getYear()>0) {
			return messageService.getAllMessagesForYear(messengerBean.getYear());
			}
			else 
			if(messengerBean.getStart()>=0&&messengerBean.getSize()>0){
				return messageService.getMessageforSize(messengerBean.getStart(), messengerBean.getSize());
			}
			else {
			return messageService.getMessages();
			}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message addMessage(Message msg) {
		return (Message) messageService.addMessage(msg);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") Long messageId,Message msg) {
		msg.setId(messageId);
		return messageService.updateMessage(msg);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{MessageId}")
	public Message deleteMessage(@PathParam("MessageId") Long messageId) {
		return messageService.removeMessage(messageId);
	}
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	//@Produces(MediaType.TEXT_PLAIN)
	public Message test(@PathParam("messageId") Long msgId,@Context UriInfo uriInfo){
		
		//Long id = Long.parseLong(msgId);
		Message msg= messageService.getMessage(msgId);
		//msg = getSelfLink(msgId, uriInfo);
		String uri = getUriForSelf(msgId, uriInfo);
		msg.addLink(uri,"self");
		msg.addLink(getUriForProfile(msg, uriInfo),"profile");
		return msg;
	}

	private String getUriForProfile(Message msg,UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(""+msg.getAuthor()).build().toString();
		return uri;
	}

	private String getUriForSelf(Long msgId, UriInfo uriInfo) {
		String uri=uriInfo.getBaseUriBuilder().path(MessageResource.class).path(""+msgId).build().toString();
		return uri;
	}
}
