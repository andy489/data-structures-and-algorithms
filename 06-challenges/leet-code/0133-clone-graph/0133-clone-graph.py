# https://leetcode.com/problems/clone-graph/

# Solution: DFS with dict — O(V+E) time, O(V) space
class Solution:
    def cloneGraph(self, node: 'Optional[Node]') -> 'Optional[Node]':
        visited: dict['Node', 'Node'] = {}

        def dfs(n: 'Node') -> 'Node':
            if n in visited:
                return visited[n]
            clone = Node(n.val)
            visited[n] = clone
            for neighbor in n.neighbors:
                clone.neighbors.append(dfs(neighbor))
            return clone

        return dfs(node) if node else None
