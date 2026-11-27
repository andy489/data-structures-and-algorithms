# https://leetcode.com/problems/count-pairs-with-xor-in-a-range/

class Solution:
    def countPairs(self, nums: list[int], low: int, high: int) -> int:
        trie = {}

        def insert(num):
            node = trie
            for i in range(14, -1, -1):
                bit = (num >> i) & 1
                if bit not in node:
                    node[bit] = {'cnt': 0}
                node = node[bit]
                node['cnt'] += 1

        def count_less(num, limit):
            node = trie
            res = 0
            for i in range(14, -1, -1):
                nb = (num >> i) & 1
                lb = (limit >> i) & 1
                if lb == 1:
                    if nb in node:
                        res += node[nb].get('cnt', 0)
                    nxt = nb ^ 1
                    if nxt not in node:
                        break
                    node = node[nxt]
                else:
                    if nb not in node:
                        break
                    node = node[nb]
            return res

        ans = 0
        for num in nums:
            ans += count_less(num, high + 1) - count_less(num, low)
            insert(num)
        return ans
