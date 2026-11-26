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

// Solution 2: BFS with unordered_map — O(V+E) time, O(V) space
class Solution2 {
public:
    Node* cloneGraph(Node* node) {
        if (!node) {
            return nullptr;
        }

        // maps each original node to its clone
        unordered_map<Node*, Node*> cloned;

        queue<Node*> q;

        cloned[node] = new Node(node->val);
        q.push(node);

        while (!q.empty()) {
            Node* current = q.front();
            q.pop();

            for (Node* neighbor : current->neighbors) {
                // clone the neighbor if not yet seen
                if (!cloned.count(neighbor)) {
                    cloned[neighbor] = new Node(neighbor->val);
                    q.push(neighbor);
                }

                // connect current clone to neighbor's clone
                cloned[current]->neighbors.push_back(cloned[neighbor]);
            }
        }

        return cloned[node];
    }
};
