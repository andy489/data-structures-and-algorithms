# https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

from collections import deque

class Solution:
    def distanceK(self, root, target, k: int) -> list[int]:
        parent = {}
        def build_parent(node, par):
            if not node:
                return
            parent[node] = par
            build_parent(node.left, node)
            build_parent(node.right, node)
        build_parent(root, None)

        queue = deque([target])
        visited = {target}
        dist = 0
        while queue:
            if dist == k:
                return [node.val for node in queue]
            for _ in range(len(queue)):
                node = queue.popleft()
                for neighbor in (node.left, node.right, parent.get(node)):
                    if neighbor and neighbor not in visited:
                        visited.add(neighbor)
                        queue.append(neighbor)
            dist += 1
        return []
