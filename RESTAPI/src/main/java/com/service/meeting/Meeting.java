package com.service.meeting;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Meeting {

    @JsonIgnore
    @ManyToOne
    private List<Attendee> attendees;
    
    @JsonIgnore
    @ManyToOne
    private Room room;
    
    @JsonIgnore
    @ManyToOne
    private TimeSlot slot;

    @Id
    @GeneratedValue
    private Long id;

    Meeting() { // jpa only
    }

    public Meeting(Room room, List<Attendee> attendees, TimeSlot slot, String uri, String description) {
        this.uri = uri;
        this.description = description;
        this.attendees = attendees;
        this.slot = slot;
    }

    public String uri;
    public String description;
    
    public List<Attendee> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<Attendee> attendees) {
		this.attendees = attendees;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public TimeSlot getSlot() {
		return slot;
	}

	public void setSlot(TimeSlot slot) {
		this.slot = slot;
	}

	public Long getId() {
        return id;
    }

    public String getUri() {
        return uri;
    }

    public String getDescription() {
        return description;
    }
}
