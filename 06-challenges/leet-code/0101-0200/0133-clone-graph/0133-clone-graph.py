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

# Solution 2: BFS with dict — O(V+E) time, O(V) space
class Solution2:
    def cloneGraph(self, node: 'Optional[Node]') -> 'Optional[Node]':
        if not node:
            return None

        # maps each original node to its clone
        cloned: dict['Node', 'Node'] = {}

        from collections import deque
        queue = deque([node])

        cloned[node] = Node(node.val)

        while queue:
            current = queue.popleft()

            for neighbor in current.neighbors:
                # clone the neighbor if not yet seen
                if neighbor not in cloned:
                    cloned[neighbor] = Node(neighbor.val)
                    queue.append(neighbor)

                # connect current clone to neighbor's clone
                cloned[current].neighbors.append(cloned[neighbor])
