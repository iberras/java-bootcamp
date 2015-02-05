package com.service.meeting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBSingleton {
	
	private Map<Long, Meeting> meetings;
	private static DBSingleton instance = new DBSingleton();
	
	private  DBSingleton(){
		meetings = new HashMap<Long, Meeting>();
	}
	
	public static DBSingleton getinstance(){
		return instance;
	}
	
	public void addMeeting(Meeting m){
		meetings.put(m.getId(), m);
	}

	public Meeting getMeeting(Long id) {
		return meetings.get(id);
	}

	public void deleteMeeting(Long id) {
		meetings.remove(id);
	}
	
	public void modifyMeeting(Meeting m){
		meetings.remove(m.getId());
		meetings.put(m.getId(), m);
	}
	
	public List<Meeting> getAllMeetings() {
		return (List<Meeting>) meetings.values();
	}
	
}
