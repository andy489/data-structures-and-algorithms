// https://leetcode.com/problems/clone-graph/

// Solution: DFS with HashMap — O(V+E) time, O(V) space
class Solution {
    private Map<Node, Node> cloned = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // already cloned — return existing copy to preserve graph structure
        if (cloned.containsKey(node)) {
            return cloned.get(node);
        }

        Node clone = new Node(node.val);
        cloned.put(node, clone); // register before recursing to handle cycles

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
