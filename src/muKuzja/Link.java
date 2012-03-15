package muKuzja;

/**
 * Provides links between two nodes.
 * @author Kuzjka
 */
public class Link<T extends Node> {

    private final T left;
    private final T right;

    /**
     * Initializes the link.
     *
     * @param left {@link Node} object. Cannot be null or same as {@code right}.
     * @param right {@link Node} object. Cannot be null or same as {@code left}.
     */
    public Link(T left, T right) {
        this.left = left;
        this.right = right;
    }
    
    /**
     * Gets left node.
     * 
     * @return {$link Node} object - left node.
     */
    public T left() {
        return left;
    }
    
    /**
     * Gets right node.
     * 
     * @return {$link Node} object - right node.
     */
    public T right() {
        return right;
    }

    /**
     * Checks if this Link instance contains {@code node}
     * @param node {@link Node} object to be searched                  
     * @return {@code true} if this Link instance contains {@code node}, otherwise {@code false}
     */
    public boolean contains(Node node) {
        if (node == null) return false;
        return (left.equals(node) || right.equals(node));
    }

    /**
     * Returns {@link Node} object which is connected with {@code node} by this link. 
     * @param node {@link Node} object which connection will be searched.
     * @return
     *      {@link Node} which is connected with {@code node} by this link,
     *      or {@code null} if {@code node} is not present in this link.
     */
    public Node otherNode(Node node) {
        if (node == null) return null;
        if (left.equals(node)) return right;
        if (right.equals(node)) return left;
        return null;
    }

    /**
     * Overrides Object.equals().
     * @param anObject Link object to be checked for equality
     * @return {@code true} if links contain same nodes (no matter in which order), otherwise {@code false}
     */
    public boolean equals(Object anObject) {
        if (anObject instanceof Link<?>) {
            Link link = (Link)anObject;
            return (link.contains(left) && link.otherNode(left).equals(right));
        }
        return false;
    }

    /**
     * Overrides Object.hashCode().
     * @return Hash code of the link
     */
    public int hashCode() {
        return (left.hashCode() / 2  + right.hashCode() / 2);
    }
}