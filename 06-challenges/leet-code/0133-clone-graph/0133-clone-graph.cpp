// https://leetcode.com/problems/clone-graph/

// Solution: DFS with unordered_map — O(V+E) time, O(V) space
class Solution {
public:
    unordered_map<Node*, Node*> map;

    Node* cloneGraph(Node* node) {
        if (!node) return nullptr;
        if (map.count(node)) return map[node];

        Node* clone = new Node(node->val);
        map[node] = clone;

        for (Node* neighbor : node->neighbors) {
            clone->neighbors.push_back(cloneGraph(neighbor));
        }

        return clone;
    }
};
