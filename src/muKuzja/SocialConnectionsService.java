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
     * @param left {@link Node} to link with {@code right}.
     * @param right {@link Node} to link with {@code left}.
     */
    public void addLink(Node left, Node right);
    
    /**
     * Removes link from the network.
     * 
     * @param left {@link Node} which link with {@code right} will be removed.
     * @param right {@link Node} which link with {@code left} will be removed.
     */
    public void removeLink(Node left, Node right);
    
    /**
     * Checks if nodes are connected (directly or not) and returns chain of nodes which represent this connection.
     * 
     * @param left
     *      {@link Node} to be checked for connection with {@code right}.
     *      Cannot be null or same as {@code right}.
     * @param right
     *      {@link Node} to be checked for connection with {@code left}.
     *      Cannot be null or same as {@code left}.
     *      
     * @return
     *      {@link Node} list, representing all nodes in connection from {@code left}
     *      to {@code right}, or {@code null} if nodes are not connected.
     *      In case of direct connection, list will consist of only {@code left} and {@code right}.
     */
    public LinkedList<? extends Node> getPathBetween(Node left, Node right);
    
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
