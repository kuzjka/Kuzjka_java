package muKuzja;

/**
 * Representation of the main entity in social network 
 * @author Kuzjka
 */
public class Person implements Node{

    private final long id;
    private String name;

    /**
     * Initializes the node.
     * 
     * @param id Id of the node.
     * @param name Name of the node.
     */
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets id of this Node instance.
     * 
     * @return id of this Node instance.
     */
    public long getId() {
        return id;
    }

    /**
     * Gets name of this Node instance.
     * 
     * @return name of this Node instance.
     */
    public String name() {
        return name;
    }
}