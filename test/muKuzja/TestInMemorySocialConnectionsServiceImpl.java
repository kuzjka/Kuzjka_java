package muKuzja;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestInMemorySocialConnectionsServiceImpl {
    
    private InMemorySocialConnectionsServiceImpl service = new InMemorySocialConnectionsServiceImpl();
    
    private Node kuzjka = new Node(1, "Kuzjka");
    private Node ruel = new Node(2, "Ruel");
    private Node kulya = new Node(3, "Kulya");
    private Link<Node> linkKuzjkaRuel = new Link<Node>(kuzjka, ruel);
    private Link<Node> linkKuzjkaKulya = new Link<Node>(kuzjka, ruel);
    
    @Test
    public void testAdd() {
        // add allowed links
        service.addLink(linkKuzjkaRuel);
        service.addLink(linkKuzjkaKulya);
        
        // add improperly constructed links
        Link<Node> linkKuzjkaKuzjka = new Link<Node>(kuzjka, kuzjka); //why cannot I make it private?
        Link<Node> linkKuzjkaNull = new Link<Node>(kuzjka, null);
        Link<Node> linkNullNull = new Link<Node>(null, null);
        service.addLink(linkKuzjkaKuzjka);
        service.addLink(linkKuzjkaNull);
        service.addLink(linkNullNull);
        
        // ??! How to assert that improper links were not added? We have no methods to show contents of our service.
        // By the way, we also should assert that real links were added.
        
    }

}
