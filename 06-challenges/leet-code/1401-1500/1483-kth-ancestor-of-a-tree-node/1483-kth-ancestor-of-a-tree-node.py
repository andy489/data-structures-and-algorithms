# https://leetcode.com/problems/kth-ancestor-of-a-tree-node/

class TreeAncestor:
    def __init__(self, n: int, parent: list[int]):
        LOG = 16
        self.dp = [parent[:]]
        for j in range(1, LOG):
            prev = self.dp[j-1]
            self.dp.append([-1 if prev[i] == -1 else prev[prev[i]] for i in range(n)])
    def getKthAncestor(self, node: int, k: int) -> int:
        for j in range(len(self.dp)):
            if k >> j & 1:
                node = self.dp[j][node]
                if node == -1:
                    return -1
        return node
