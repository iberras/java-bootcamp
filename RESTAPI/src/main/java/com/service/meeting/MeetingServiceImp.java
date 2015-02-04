package com.service.meeting;

import java.util.List;

/**
 * 
 * Teh local implementation of the service
 *
 */

public class MeetingServiceImp implements MeetingService{

	private DBSingleton db = DBSingleton.getinstance();

	@Override
	public void addMeeting(Meeting m) {
		db.addMeeting(m);
		
	}

	@Override
	public void deleteMeeting(Long id) {
		db.deleteMeeting(id);
		
	}

	@Override
	public Meeting getMeeting(Long id) {
		return db.getMeeting(id);
	}

	@Override
	public void updateMeeting(Meeting m) {
		db.modifyMeeting(m);
	}

	@Override
	public java.util.List<Meeting> getAllMeetings() {
		return db.getAllMeetings();
	}
	
}
