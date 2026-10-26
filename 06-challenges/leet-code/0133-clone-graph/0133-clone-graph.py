# https://leetcode.com/problems/clone-graph/

# Solution: DFS with dict — O(V+E) time, O(V) space
class Solution:
    def cloneGraph(self, node: 'Optional[Node]') -> 'Optional[Node]':
        cloned: dict['Node', 'Node'] = {}

        def dfs(n: 'Node') -> 'Node':
            if n in cloned:
                return cloned[n]
            clone = Node(n.val)
            cloned[n] = clone
            for neighbor in n.neighbors:
                clone.neighbors.append(dfs(neighbor))
            return clone

        return dfs(node) if node else None
