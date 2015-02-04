package com.topic6;
//tag::runner[]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.service.meeting.Attendee;
import com.service.meeting.Meeting;
import com.service.meeting.MeetingService;
import com.service.meeting.Room;
import com.service.meeting.TimeSlot;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	@Bean
	CommandLineRunner init(MeetingService service) {
		return (evt) -> Arrays.asList(
				"1,2,3,4,5,6,7,8".split(","))
				.forEach(
						a -> {
							service.addMeeting(new Meeting(new Room(), new ArrayList<Attendee>(),new TimeSlot(),
									"http://meetings.com/" + a+ "/", "description of the meeting"));
						});
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
//end::runner[]

@RestController
@RequestMapping("/meetings")
class MeetingRestController {
	
	@Autowired
	private final MeetingService service;
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> create(@RequestBody Meeting input) {
		
		service.addMeeting(input);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(input.getId()).toUri());
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET)
	Meeting getMeeting(@PathVariable Long meetingId) {
		return service.getMeeting(meetingId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	List<Meeting> getAllMeetings() {
		return service.getAllMeetings();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	void deleteMeeting(@PathVariable Long meetingId) {
		service.deleteMeeting(meetingId);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	void updateMeeting(@RequestBody Meeting m) {
		service.updateMeeting(m);
	}

	@Autowired
	MeetingRestController(MeetingService service) {
		this.service = service;
	}
}
