package muKuzja;

/**
 * Representation of the main entity in social network 
 * @author Kuzjka
 */
public class Node {

    private int iId;
    private String iName;

    /**
     * Initializes the node.
     * 
     * @param id Id of the node.
     * @param name Name of the node.
     */
    public Node(int id, String name) {
        iId = id;
        iName = name;
    }

    /**
     * Gets id of this Node instance.
     * 
     * @return id of this Node instance.
     */
    public int id() {
        return iId;
    }

    /**
     * Gets name of this Node instance.
     * 
     * @return name of this Node instance.
     */
    public String name() {
        return iName;
    }
}