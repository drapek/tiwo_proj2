package rrs;

import java.util.Collection;
import java.util.HashSet;

public class RaceResultsService {
    private Collection<Client> clients = new HashSet<>();
    
    public void addSubscriber(Client client) {
        clients.add(client);
    }
    public void removeSubscriber(Client client) {
        clients.remove(client);
    }
    public void send(Message message) {
        for( Client client:clients) {
            client.receive(message);
        }
    }
}