package com.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class SignupRequest {

    private String username;

    private String email;
    
    private Set<String> role;

    private String password;


     public SignupRequest(String username, String email, String encode) {
     }
 }
