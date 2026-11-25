# https://leetcode.com/problems/k-similar-strings/

from collections import deque

class Solution:
    def kSimilarity(self, s1: str, s2: str) -> int:
        queue = deque([s1])
        visited = {s1}
        steps = 0
        while queue:
            for _ in range(len(queue)):
                curr = queue.popleft()
                if curr == s2:
                    return steps
                i = 0
                while curr[i] == s2[i]:
                    i += 1
                arr = list(curr)
                for j in range(i + 1, len(arr)):
                    if arr[j] == s2[i]:
                        arr[i], arr[j] = arr[j], arr[i]
                        nxt = ''.join(arr)
                        if nxt not in visited:
                            visited.add(nxt)
                            queue.append(nxt)
                        arr[i], arr[j] = arr[j], arr[i]
            steps += 1
        return steps
