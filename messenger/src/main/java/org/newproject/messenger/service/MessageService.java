package org.newproject.messenger.service;

import org.newproject.messenger.database.*;
import org.newproject.messenger.exception.DataNotFoundException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.newproject.messenger.model.Message;

public class MessageService {
	
	private Map<Long,Message> messages  = DatabaseClass.getMessage();
	
	public MessageService() {
		Message msg1 = new Message(1,"hello world","kaushik");
		Message msg12 = new Message(2,"hello shweta","Shweta");
		messages.put(msg1.getId(),msg1);
		messages.put(msg12.getId(),msg12);
	}

	/*public List<Message> getAllMessages(){
		Message m1 = new Message(1,"Hello World","kaushik");
		Message m2 = new Message(1,"hey there!","shweta");
		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		return list;
	}*/
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> msgs = new ArrayList();
		Calendar cal = Calendar.getInstance();
		for(Message mesg:messages.values()) {
			cal.setTime(mesg.getCreated());
			if(cal.get(Calendar.YEAR)==year) {
				msgs.add(mesg);
			}
		}
		return msgs;
	}
	
	public List<Message> getMessageforSize(int start,int size){
		List<Message> msgs = new ArrayList(messages.values());
		if(start+size>msgs.size()) {
			return new ArrayList<Message>();
		}
		return msgs.subList(start, start+size);
	}
	
	public List<Message> getMessages(){
		List<Message> messagesList = new ArrayList(messages.values());
		return messagesList;
	}
	
	public Message getMessage(long id) {
		if(id==0) {
			throw new DataNotFoundException(id);
		}
		return messages.get(id);
	}
	
	public Message addMessage(Message msg) {
		msg.setId( messages.size()+1);
		messages.put(msg.getId(), msg);
		return msg;
	}
	
	public Message updateMessage(Message msg) {
		if(msg.getId()<=0) {
			return null;
		}
		else {
			messages.put(msg.getId(), msg);
			return msg;
		}
	}
	public Message removeMessage(long id ) {
		return messages.remove(id);
	}
}
