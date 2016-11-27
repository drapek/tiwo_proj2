// Co testujemy: ¯aden niezarejestrowany nie otrzymuje wiadomosci
// Co testujemy: Pojedynczy zarejestrowany klient powien otrzymac 
//               wiadomosc.
// Co testujemy: Ka¿dy zarejestrowany klient powinien otrzymac
//               wiadomosc
// Co testujemy: Czy wieloktnie rejestrowany klient dostaje tylko jedną wiadomość

package rrs;

import org.testng.annotations.*;
import static org.mockito.Mockito.*;

@Test
public class Test4 {
    private RaceResultsService raceResults;
    private Message message;
    private Client clientA;
    private Client clientB;
    
    @BeforeMethod
    public void setUp() {
        raceResults = new RaceResultsService();
        clientA = mock(Client.class);
        clientB = mock(Client.class);
        message = mock(Message.class);
    }
    // zero subscribers
    public void notSubscribedClientShouldNotReceiveMessage() {
        raceResults.send(message);
        
        verify(clientA, never()).receive(message);
        verify(clientB, never()).receive(message);
    }
    // one subscriber
    public void subscribedClientShouldReceiveMessage() {
        raceResults.addSubscriber(clientA);
        raceResults.send(message);
        
        verify(clientA).receive(message);
    }
    // two subscribers
    public void messageShouldBeSendToAllSubscribedClients() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message);
        
        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }
    // client subscribed more then once
    public void shouldSendOnlyOneMessageToMultiSubscriber() {
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientA);
        raceResults.send(message);
        
        verify(clientA).receive(message);
    }
}