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

// Solution 2: BFS with HashMap — O(V+E) time, O(V) space
class Solution2 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // maps each original node to its clone
        Map<Node, Node> cloned = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();

        cloned.put(node, new Node(node.val));
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (Node neighbor : current.neighbors) {
                // clone the neighbor if not yet seen
                if (!cloned.containsKey(neighbor)) {
                    cloned.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }

                // connect current clone to neighbor's clone
                cloned.get(current).neighbors.add(cloned.get(neighbor));
            }
        }

        return cloned.get(node);
    }
}
