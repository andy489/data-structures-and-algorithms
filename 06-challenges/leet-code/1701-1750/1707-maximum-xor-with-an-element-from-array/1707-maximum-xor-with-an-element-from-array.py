# https://leetcode.com/problems/maximum-xor-with-an-element-from-array/

class Solution:
    def maximizeXor(self, nums: list[int], queries: list[list[int]]) -> list[int]:
        nums.sort()
        indexed_queries = sorted(enumerate(queries), key=lambda t: t[1][1])
        trie = {}
        answer = [-1] * len(queries)
        ni = 0

        def insert(num: int) -> None:
            node = trie
            for i in range(29, -1, -1):
                bit = (num >> i) & 1
                if bit not in node:
                    node[bit] = {}
                node = node[bit]

        def query_max(x: int) -> int:
            node = trie
            result = 0
            for i in range(29, -1, -1):
                bit = (x >> i) & 1
                want = 1 - bit
                if want in node:
                    result |= (1 << i)
                    node = node[want]
                else:
                    node = node[bit]
            return result

        for qi, (x, m) in indexed_queries:
            while ni < len(nums) and nums[ni] <= m:
                insert(nums[ni])
                ni += 1
            if trie:
                answer[qi] = query_max(x)

        return answer
