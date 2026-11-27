# https://leetcode.com/problems/longest-subsequence-repeated-k-times/

class Solution:
    def longestSubsequenceRepeatedK(self, s: str, k: int) -> str:
        from collections import Counter, deque
        freq = Counter(s)
        cands = [c for c in 'abcdefghijklmnopqrstuvwxyz' if freq[c] >= k]
        def is_sub_rep(t):
            ti, rep = 0, 0
            for c in s:
                if c == t[ti]:
                    ti += 1
                    if ti == len(t):
                        ti = 0
                        rep += 1
                        if rep == k:
                            return True
            return False
        res = ''
        q = deque([''])
        while q:
            cur = q.popleft()
            for c in cands:
                nxt = cur + c
                if is_sub_rep(nxt):
                    if len(nxt) > len(res) or (len(nxt) == len(res) and nxt > res):
                        res = nxt
                    q.append(nxt)
        return res
