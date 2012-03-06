package muKuzja;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestInMemorySocialConnectionsServiceImpl {
    
    private InMemorySocialConnectionsServiceImpl service;
    private Node kuzjka = new Node(1, "Kuzjka");
    private Node ruel = new Node(2, "Ruel");
    private Node kulya = new Node(3, "Kulya");
    
    @Before
    public void setUp() {
        service = new InMemorySocialConnectionsServiceImpl();
    }

    @Test
    public void testAdd() {
        //tests adding and linking with null or self 
        //add allowed links
        service.addLink(kuzjka, ruel);
        service.addLink(kuzjka, kulya);
        
        //add improperly constructed links       
        service.addLink(kuzjka, null);
        service.addLink(kuzjka, kuzjka);
        
        //checks if kuzjka has only 2 links
        assertEquals(service.nodeListForId(1).size(), 2);
        
        //checks if kuzjka and kulya are directly connected
        assertEquals(service.getPathBetween(kuzjka, kulya).size(), 2);
    }
    
    @Test
    public void testDoubleLink() {
        //tests double linking and removeLink()
        service.addLink(kuzjka, ruel);
        service.addLink(ruel, kuzjka);
        assertEquals(service.nodeListForId(1).size(), 1);
        service.removeLink(kuzjka, ruel);
        assertNull(service.nodeListForId(1));
        assertNull(service.nodeListForId(2));
    }
    
    @Test
    public void testGetPathBetween() {
        service.addLink(kuzjka, ruel);
        service.addLink(kuzjka, kulya);
        //checks that getPathBetween() gives proper node chain
        LinkedList<Node> result = new LinkedList<Node>();
        result.add(ruel);
        result.add(kuzjka);
        result.add(kulya);
        assertEquals(service.getPathBetween(ruel, kulya), result);
    }
    
    @Test
    public void testNodeListForId() {
        service.addLink(kuzjka, ruel);
        service.addLink(kuzjka, kulya);
        //checks that nodeListForId() gives proper list;
        assertTrue(service.nodeListForId(1).contains(ruel));
        assertTrue(service.nodeListForId(1).contains(kulya));
        assertFalse(service.nodeListForId(1).contains(kuzjka));
        assertFalse(service.nodeListForId(2).contains(kulya));
    }

}
