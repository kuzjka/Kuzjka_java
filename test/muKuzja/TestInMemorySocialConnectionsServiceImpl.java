package muKuzja;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestInMemorySocialConnectionsServiceImpl {
    
    private InMemorySocialConnectionsServiceImpl service;
    private Node kuzjka = new Person(1, "Kuzjka");
    private Node ruel = new Person(2, "Ruel");
    private Node kulya = new Person(3, "Kulya");
    
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
        assertEquals(2, service.nodeListForId(1).size());
        
        //checks if kuzjka and kulya are directly connected
        assertEquals(2, service.getPathBetween(kuzjka, kulya, 5).size());
    }
    
    @Test
    public void testDoubleLink() {
        //tests double linking and removeLink()
        service.addLink(kuzjka, ruel);
        service.addLink(ruel, kuzjka);
        assertEquals(1, service.nodeListForId(1).size());
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
        assertEquals(result, service.getPathBetween(ruel, kulya, 5));
        assertNull(service.getPathBetween(ruel, kulya, 2));
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
