package com.example.clientRepository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.client.Client; 
 
public interface ClientRepository extends JpaRepository<Client, Long> { 
 
 List<Client> findByUserId(String userId); 
 
 Client findByUserIdAndId(String userId, Long id); 
 
}