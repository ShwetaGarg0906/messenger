package org.newproject.messenger.beans;

import javax.ws.rs.QueryParam;

public class MessengerBean {
	 @QueryParam("year") private int year;
	 @QueryParam("size") private int size;
	 @QueryParam("start") private int start;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	
}
