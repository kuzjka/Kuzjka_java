package muKuzja;

import static org.junit.Assert.*;
import org.junit.*;

public class TestLink {
    
    private Node kuzjka, ruel;

    @Before
    public void setUp() {
        kuzjka = new Person(1, "kuzjka");
        ruel = new Person(2, "ruel");
    }

    @Test
    public void testContainsOther() {
        // test contains() and otherNode()
        Link<Node> link = new Link<Node>(kuzjka, ruel);
        assertTrue(link.contains(kuzjka));
        assertTrue(link.contains(ruel));
        assertTrue(link.otherNode(kuzjka).equals(ruel));
        assertEquals(ruel, link.otherNode(kuzjka));
    }
    
    @Test
    public void testEquals() {
        // test equality of two mirror links
        Link<Node> link1 = new Link<Node>(kuzjka, ruel);
        Link<Node> link2 = new Link<Node>(ruel, kuzjka);
        assertEquals(link1, link1);
        assertTrue(link1.equals(link1));
        assertTrue(link1.equals(new Link<Node>(kuzjka, ruel)));
        assertTrue(link1.equals(link2));
        assertEquals(link1.hashCode(), link2.hashCode());
        assertEquals(link1, link2);

    }

}
