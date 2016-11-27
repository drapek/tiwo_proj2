package rrs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

// Co testujemy: Pojedynczy zarejestrowany klient powien otrzymac 
//               wiadomosc.


import org.testng.annotations.*;
import static org.mockito.Mockito.*;

@Test
public class Test1 {
    
    public void subscribedClientShouldReceiveMessage() {
        RaceResultsService raceResults = new RaceResultsService();
        Client client = mock(Client.class);
        Message message = mock(Message.class);
        
        raceResults.addSubscriber(client);
        raceResults.send(message);
        
        verify(client).receive(message);
    }
}