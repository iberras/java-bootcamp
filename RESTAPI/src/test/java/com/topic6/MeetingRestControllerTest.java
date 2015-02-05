package com.topic6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.service.meeting.Attendee;
import com.service.meeting.Meeting;
import com.service.meeting.MeetingService;
import com.service.meeting.Room;
import com.service.meeting.TimeSlot;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author Josh Long
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MeetingRestControllerTest {


    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private MeetingService meetingService;

    @Autowired
    private WebApplicationContext webApplicationContext;
    
    @Autowired
    private MockService mockService;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream().filter(
                hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();

        Assert.assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

       meetingService.addMeeting(new Meeting(new Room(), new ArrayList<Attendee>(),new TimeSlot(),
				"http://meetings.com/1/", "description of the meeting"));
        meetingService.addMeeting(new Meeting(new Room(), new ArrayList<Attendee>(),new TimeSlot(),
				"http://meetings.com/2/", "description of the meeting"));    
    }

    @Test
    public void getSingleMeeting() throws Exception {
    	Meeting m = new Meeting(new Room(), new ArrayList<Attendee>(),new TimeSlot(),
				"http://meetings.com/1/", "description of the meeting");
    	
    	meetingService.addMeeting(m);
    	
        mockMvc.perform(get("/meetings/"
                + m.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType));
    }

    @Test
    public void getMeetings() throws Exception {
    	Meeting m = new Meeting(new Room(), new ArrayList<Attendee>(),new TimeSlot(),
				"http://meetings.com/1/", "description of the meeting");
    	
    	meetingService.addMeeting(m);
    	
        mockMvc.perform(get("/meetings/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType));
    }

    @Test
    public void createMeeting() throws Exception {    	
        String meetingJson = json(new Meeting(mockService.getRoomAvailable(), mockService.getAttendees(), mockService.getAvailableTimeSlot(),
                 "http://meeting.com", "a very good description"));
        this.mockMvc.perform(post("/meetings/")
                .contentType(contentType)
                .content(meetingJson))
                .andExpect(status().isCreated());
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
