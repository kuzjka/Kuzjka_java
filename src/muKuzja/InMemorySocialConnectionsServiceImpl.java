package muKuzja;

import java.util.*;

/**
 * In-memory implementation of the {@link SocialConnectionsService} interface. Provides methods
 * to manage social network.
 */
public class InMemorySocialConnectionsServiceImpl implements
        SocialConnectionsService {
    
    private HashSet<Link<Node>> linkSet = new HashSet<Link<Node>>();

    /**
     * Adds link between two nodes.
     *
     * @param left {@link Node} to link with {@code right}. Cannot be null or same as {@code right}
     * @param right {@link Node} to link with {@code left}. Cannot be null or same as {@code left}
     */
    public void addLink(Node left, Node right) {
        if (left == null || right == null || left.equals(right)) return;
        Link<Node> link = new Link<Node>(left, right);
        if (! linkSet.contains(link)) linkSet.add(link);
    }


    /**
     * Removes link between two nodes if one exists.
     *
     * @param left {@link Node} which link with {@code right} will be removed.
     * @param right {@link Node} which link with {@code left} will be removed.
     */
    public void removeLink(Node left, Node right) {
        Link<Node> link = new Link<Node>(left, right);
        if (linkSet.contains(link)) linkSet.remove(link);
    }

    /**
     * Checks if nodes are connected (directly or not) and returns chain of nodes which represent this connection.
     * Nodes will be searched recursively until chain length reaches {@code maxChain}.
     *
     * @param left
     *      {@link Node} to be checked for connection with {@code right}.
     *      Cannot be null or same as {@code right}.
     * @param right
     *      {@link Node} to be checked for connection with {@code left}.
     *      Cannot be null or same as {@code left}.
     * @param maxChain
     *      Maximum number of nodes in the chain before recursive search stops. Should be {@code 2} or higher.
     *
     * @return
     *      {@link Node} list, representing all nodes in connection from {@code left}
     *      to {@code right}, or {@code null} if nodes are not connected or the chain is
     *      longer then {@code maxChain};
     *      In case of direct connection, list will consist of only {@code left} and {@code right}.
     */
    public LinkedList<? extends Node> getPathBetween(Node left, Node right, int maxChain) {
        // return null if improper arguments or maxChain decreased
        if (left.equals(right) || maxChain < 2) return null;

        // adds left node
        LinkedList<Node> resultList = new LinkedList<Node>();
        resultList.add(left);

        // if there is direct connection - adds right node and returns result
        if (this.nodeListForId(left.getId()).contains(right)) {
            resultList.add(right);
            return resultList;
        }

        // otherwise recursively searches chain between right and children nodes of left
        // with the maxChain value decreased by 1
        for(Node middle : this.nodeListForId(left.getId())) {
            if (this.getPathBetween(middle, right, maxChain - 1) != null) {
                resultList.addAll(this.getPathBetween(middle, right, maxChain - 1));
            }
        }

        // if all nodes within range are searched and still nobody "knows" right node - returns null
        if (resultList.size() == 1) return null;

        // otherwise returns node chain
        return resultList;
    }

    /**
     * Returns list of nodes directly connected with the certain node, specified by id.
     *
     * @param id Id of the node connections are searched for.
     *
     * @return
     *      {@link List} of {@link Node} objects representing list of nodes connected with the node
     *      specified by {@code id}, or {@code null} if the are no connections for this node.
     */
    public List<Node> nodeListForId(long id) {
        List<Node> list = new ArrayList<Node>();
        for (Link<Node> link : linkSet) {
            if (link.left().getId() == id) list.add(link.right());
            if (link.right().getId() == id) list.add(link.left());
        }
        if (list.size() == 0) {
            return null;
        } else {
            return list;
        }
    }
}
