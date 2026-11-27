# https://leetcode.com/problems/check-if-dfs-strings-are-palindromes/

class Solution:
    def findAnswer(self, parent: list[int], s: str) -> list[bool]:
        n = len(parent)
        children = [[] for _ in range(n)]
        for i in range(1, n):
            children[parent[i]].append(i)

        start = [0] * n
        end = [0] * n
        dfs_str = []

        # Iterative post-order DFS
        stack = [0]
        child_ptr = [0] * n
        visited = [False] * n
        pos = 0

        while stack:
            node = stack[-1]
            if not visited[node]:
                visited[node] = True
                start[node] = pos
            ch = children[node]
            if child_ptr[node] < len(ch):
                stack.append(ch[child_ptr[node]])
                child_ptr[node] += 1
            else:
                dfs_str.append(s[node])
                pos += 1
                end[node] = pos
                stack.pop()

        dfs_str = ''.join(dfs_str)

        MOD1, BASE1 = 10**9 + 7, 31
        MOD2, BASE2 = 998_244_353, 37

        h1 = [0] * (n + 1)
        h2 = [0] * (n + 1)
        rh1 = [0] * (n + 1)
        rh2 = [0] * (n + 1)
        pw1 = [1] * (n + 1)
        pw2 = [1] * (n + 1)

        for i in range(n):
            h1[i + 1] = (h1[i] * BASE1 + (ord(dfs_str[i]) - ord('a') + 1)) % MOD1
            h2[i + 1] = (h2[i] * BASE2 + (ord(dfs_str[i]) - ord('a') + 1)) % MOD2
            pw1[i + 1] = pw1[i] * BASE1 % MOD1
            pw2[i + 1] = pw2[i] * BASE2 % MOD2

        for i in range(n - 1, -1, -1):
            rh1[i] = (rh1[i + 1] * BASE1 + (ord(dfs_str[i]) - ord('a') + 1)) % MOD1
            rh2[i] = (rh2[i + 1] * BASE2 + (ord(dfs_str[i]) - ord('a') + 1)) % MOD2

        answer = [False] * n
        for i in range(n):
            l, r = start[i], end[i]
            length = r - l
            fwd1 = (h1[r] - h1[l] * pw1[length]) % MOD1
            fwd2 = (h2[r] - h2[l] * pw2[length]) % MOD2
            rev1 = (rh1[l] - rh1[r] * pw1[length]) % MOD1
            rev2 = (rh2[l] - rh2[r] * pw2[length]) % MOD2
            answer[i] = (fwd1 == rev1 and fwd2 == rev2)

        return answer
