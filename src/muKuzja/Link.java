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
}