package muKuzja;

/**
 * Provides links between two nodes.
 * @author Kuzjka
 */
public class Link {

    private Node iFirstNode;
    private Node iSecondNode;

    /**
     * Initializes the link.
     *
     * @param firstNode {@link Node} object. Cannot be null or same as {@code secondNode}.
     * @param secondNode {@link Node} object. Cannot be null or same as {@code firstNode}.
     */

    public Link(Node firstNode, Node secondNode) {
        iFirstNode = firstNode;
        iSecondNode = secondNode;
    }

    /**
     * Checks if this Link instance contains the node.
     *
     * @param node {@link Node} object to search in this Link instance.
     * 
     * @return {@code true} if link contains node, otherwise {@code false}.
     */
    public boolean contains (Node node) {
        return(iFirstNode.equals(node) || iSecondNode.equals(node));
    }

    /** 
     * Returns {@link Node} object which is linked with {@code node} or {@code null}
     * if the Link instance doesn't contain the {@code node}.
     * 
     * @param node {@link Node} to search in this Link instance.
     * 
     * @return
     *      {@link Node} object which is linked with {@code node} or {@code null}
     *      if the Link instance doen't contain the {@code node}. 
     */
    public Node otherNode (Node node) {
        if (iFirstNode.equals(node)) return iSecondNode;
        if (iSecondNode.equals(node)) return iFirstNode;
        return null;
    }
}