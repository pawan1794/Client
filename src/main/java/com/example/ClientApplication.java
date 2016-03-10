package com.example;
 
import java.util.Arrays; 
 
import org.springframework.boot.CommandLineRunner; 
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;  
import org.springframework.context.annotation.Bean; 
import com.example.clientRepository.ClientRepository;
import com.example.clientRestcontroller.ClientController;
import com.example.client.Client;
 
@SpringBootApplication 

public class ClientApplication { 
 
 @Bean 
 public CommandLineRunner init(ClientRepository clientRepository) { 
  return args -> { 
  
   Arrays.asList("pwebb,jlong".split(",")).forEach(userId -> { 
     Arrays.asList("Stéphane,Maldini;Dave,Syer;Juergen,Hoeller;Rob,Winch;Mark,Fisher;Arjen,Poutsma".split(";")) 
      .stream() 
      .map(name -> name.split(",")) 
      .map(firstLastName -> new Client( 
        userId, 
        firstLastName[0], 
        firstLastName[1], 
        firstLastName[0].toLowerCase(),
        firstLastName[0])) 
      .forEach(clientRepository::save); 
    }); 
  }; 
 } 
 
 public static void main(String[] args) { 
  SpringApplication.run(ClientApplication.class, args); 
 } 
 
}