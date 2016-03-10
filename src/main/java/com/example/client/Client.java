package com.example.client;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.Id; 
 
@Entity
public class Client { 
 
 @Id 
 @GeneratedValue 
 private Long id; 
 
 private String userId; 
 
 private String firstName; 
 
 private String lastName; 
 
 private String email; 
 
 private String contact;
  
 
 
 public Client() { 
 } 
 
 public Client(String userId, String firstName, String lastName, 
   String email, String contact) { 
  this.userId = userId; 
  this.firstName = firstName; 
  this.lastName = lastName; 
  this.email = email;  
  this.contact=contact;
 } 
 
 public Long getId() { 
  return id; 
 } 
 
 public String getUserId() { 
  return userId; 
 } 
 
 public String getFirstName() { 
  return firstName; 
 } 
 
 public String getContact() { 
	  return contact; 
	 } 
 
 public String getLastName() { 
  return lastName; 
 } 
 
 public String getEmail() { 
  return email; 
 } 
 
 
}