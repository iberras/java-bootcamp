package com.service.meeting;

import java.util.List;

/**
 * 
 * Proxy Patter to use locally the service
 *
 */

public class MeetingServiceProxy implements MeetingService {  
    private final MeetingService implementation;  
  
    public MeetingServiceProxy(MeetingService imp) {  
        this.implementation = imp;  
    }  

	public void addMeeting(Meeting m) {
		implementation.addMeeting(m);
		
	}

	public void deleteMeeting(Long id) {
		implementation.deleteMeeting(id);
		
	}

	public Meeting getMeeting(Long id) {
		return implementation.getMeeting(id);
	}

	public void updateMeeting(Meeting m) {
		implementation.updateMeeting(m);
		
	}

	public List<Meeting> getAllMeetings() {
		return implementation.getAllMeetings();
	} 
}  
