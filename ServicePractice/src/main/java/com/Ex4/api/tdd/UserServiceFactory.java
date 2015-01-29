package com.Ex4.api.tdd;

public class UserServiceFactory {  
    private UserServiceFactory() {}  
  
    public static UserService getLocalService(){  
        return new UserServiceImp ();  
    }    
} 
