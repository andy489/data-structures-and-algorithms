// https://leetcode.com/problems/clone-graph/

// Solution: DFS with unordered_map — O(V+E) time, O(V) space
class Solution {
public:
    unordered_map<Node*, Node*> cloned;

    Node* cloneGraph(Node* node) {
        if (!node) {
            return nullptr;
        }
        if (cloned.count(node)) {
            return cloned[node];
        }

        Node* clone = new Node(node->val);
        cloned[node] = clone;

        for (Node* neighbor : node->neighbors) {
            clone->neighbors.push_back(cloneGraph(neighbor));
        }

        return clone;
    }
};
