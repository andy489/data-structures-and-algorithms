# https://leetcode.com/problems/validate-binary-tree-nodes/

from collections import deque

class Solution:
    def validateBinaryTreeNodes(self, n, leftChild, rightChild) -> bool:
        parent = [-1] * n
        for i in range(n):
            for c in [leftChild[i], rightChild[i]]:
                if c == -1:
                    continue
                if parent[c] != -1:
                    return False
                parent[c] = i
        roots = [i for i in range(n) if parent[i] == -1]
        if len(roots) != 1:
            return False
        root = roots[0]
        visited = set([root])
        q = deque([root])
        while q:
            node = q.popleft()
            for c in [leftChild[node], rightChild[node]]:
                if c != -1:
                    if c in visited:
                        return False
                    visited.add(c)
                    q.append(c)
        return len(visited) == n
