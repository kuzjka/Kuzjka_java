package muKuzja;

import java.util.*;

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
    public void addLink(Link<? extends Node> link);
    
    /**
     * Removes link from the network.
     * 
     * @param link {@link Link} object to be removed.
     */
    public void removeLink(Link<? extends Node> link);
    
    /**
     * Checks if nodes are connected (directly or not) and returns chain of links between them.
     * 
     * @param left
     *      {@link Node} to be checked for connection with {@code right}.
     *      Cannot be null or same as {@code right}.
     * @param right
     *      {@link Node} to be checked for connection with {@code left}.
     *      Cannot be null or same as {@code left}.
     *      
     * @return
     *      {@link Link} array, representing chain of links from {@code left} node
     *      to {@code right} node, or {@code null} if nodes are not connected.
     *      In case of direct connection, array will consist of one link.
     */
    public List<Link<? extends Node>> linkChainBetween(Node left, Node right);
    
    /**
     * Returns list of nodes directly connected with the certain node, specified by id.
     *  
     * @param id Id of the node connections are searched for.
     * 
     * @return
     *      {@link List} of {@link Node} objects representing list of nodes connected with the node
     *      specified by {@code id}, or {@code null} if the are no connections for this node.
     */
    public List<Node> nodeListForId(int id);
    
}
