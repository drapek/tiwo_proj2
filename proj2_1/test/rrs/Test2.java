package rrs;

import org.testng.annotations.*;
import static org.mockito.Mockito.*;

@Test
public class Test2 {
    private RaceResultsService raceResults;
    private Message message;
    private Client clientA;
    private Client clientB;
    
    @BeforeMethod	// wykonywane przed kazdym testem!!!!!
    public void setUp() {
        raceResults = new RaceResultsService();
        clientA = mock(Client.class);
        clientB = mock(Client.class);
        message = mock(Message.class);
    }
    public void subscribedClientShouldReceiveMessage() {
        raceResults.addSubscriber(clientA);
        raceResults.send(message);
        
        verify(clientA).receive(message);
    }
    
    public void messageShouldBeSendToAllSubscribedClients() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message);
        
        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }
}