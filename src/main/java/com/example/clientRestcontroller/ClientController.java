package com.example.clientRestcontroller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController;

import com.example.clientRepository.ClientRepository;



import com.example.client.Client;
 
@RestController 
@RequestMapping("/{userId}/clients") 
public class ClientController { 
 
 @Autowired 
 private ClientRepository clientRepository; 
 
 @RequestMapping(method = RequestMethod.GET) 
 public Collection<Client> getClints(@PathVariable String userId) { 
  return this.clientRepository.findByUserId(userId); 
 } 
 
 @RequestMapping(value = "/{clientId}", method = RequestMethod.GET) 
 public Client getClient(@PathVariable String userId, 
   @PathVariable Long clientId) { 
  return this.clientRepository.findByUserIdAndId(userId, clientId); 
 } 
 
 @RequestMapping(method = RequestMethod.POST) 
 public Client createClient(@PathVariable String userId, @RequestBody Client client) { 
  return this.clientRepository.save( 
    new Client( 
      userId, 
      client.getFirstName(), 
      client.getLastName(), 
      client.getEmail(),
      client.getContact())); 
 } 
 
 @RequestMapping(value = "/{clientId}", method = RequestMethod.DELETE)
 public List<Client> delete(@PathVariable String userId, @PathVariable Long clientId) {
     clientRepository.delete(clientId);

     return this.clientRepository.findByUserId(userId);
 }
 
}
