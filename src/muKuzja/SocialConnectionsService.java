package muKuzja;

/**
 * This interface defines methods to create and manage the social network.
 * @author Kuzjka
 */
public interface SocialConnectionsService {
    
    /**
     * Adds link to the network.
     * 
     * @param link {@link Link} object to be added.
     */
    public void addLink(Link link);
    
    /**
     * Removes link from the network.
     * 
     * @param link {@link Link} object to be removed.
     */
    public void removeLink(Link link);
    
    /**
     * Checks if nodes are connected with the link.
     * 
     * @param firstNode {@link Node} object to be checked if connected with {@code secondNode}.
     * @param secondNode {@link Node} object to be checked if connected with {@code firstNode}.
     * 
     * @return {@code true} if {@code firstNode} is connected with {@code secondNode}, otherwise {@code false}.
     */
    public boolean areConnected(Node firstNode, Node secondNode);
    
    /**
     * Returns an array of {@link Node} objects which are connected to the {@code node}.
     * 
     * @param node {@link Node} object whose link will be searched.
     * 
     * @return Array of {@link Node} objects which are connected to the {@code node}.
     */
    public Node[] hisNodeList(Node node);
    
}
