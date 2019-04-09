package org.newproject.messenger.database;

import org.newproject.messenger.model.*;
import java.util.*;
public class DatabaseClass {
	private static Map<Long,Message> messages = new HashMap<>();
	private static Map<String,ProfileModel> profiles = new HashMap<>();
	
	public static Map<Long,Message> getMessage(){
		return messages;
	}
	public static Map<String,ProfileModel> getProfile(){
		return profiles;
	}
}
