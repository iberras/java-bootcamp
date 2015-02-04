package com.service.meeting;

public class MeetingServiceFactory {  
    private MeetingServiceFactory() {}  
  
    public static MeetingService getLocalService(){  
        return new MeetingServiceImp ();  
    }    
} 
