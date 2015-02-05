package com.service.meeting;

import java.util.List;
/**
* Interface for User Service
*/
public interface MeetingService {
	/**
	 * Add a meeting to the database
	 * @param u
	 */
	public void addMeeting(Meeting m);
	/**
	 * delete a meeting from the database
	 * @param id
	 */
	public void deleteMeeting(Long id); 
	/**
	 * get a meeting from the database
	 * @param id
	 * @return
	 */
	public Meeting getMeeting(Long id); 
	/**
	 * update the data of a certain meeting
	 * @param u
	 */
	public void updateMeeting(Meeting m); 
	
	public List<Meeting> getAllMeetings();
	
}
