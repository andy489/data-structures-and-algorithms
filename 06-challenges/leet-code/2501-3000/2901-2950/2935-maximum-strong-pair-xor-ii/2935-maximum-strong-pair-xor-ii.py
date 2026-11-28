# https://leetcode.com/problems/maximum-strong-pair-xor-ii/

class Solution:
    def maximumStrongPairXor(self, nums: list[int]) -> int:
        BITS = 20
        nums.sort()
        n = len(nums)
        # Trie nodes: children[node][0/1], cnt[node]
        children = [[0, 0] for _ in range(n * (BITS + 1) + 5)]
        cnt = [0] * (n * (BITS + 1) + 5)
        trie_size = [1]

        def update(num: int, delta: int) -> None:
            node = 0
            for i in range(BITS - 1, -1, -1):
                bit = (num >> i) & 1
                if children[node][bit] == 0:
                    children[node][bit] = trie_size[0]
                    trie_size[0] += 1
                node = children[node][bit]
                cnt[node] += delta

        def query(num: int) -> int:
            node = 0
            result = 0
            for i in range(BITS - 1, -1, -1):
                bit = (num >> i) & 1
                want = 1 - bit
                if children[node][want] != 0 and cnt[children[node][want]] > 0:
                    result |= (1 << i)
                    node = children[node][want]
                else:
                    node = children[node][bit]
            return result

        ans = 0
        l = 0
        for r in range(n):
            update(nums[r], 1)
            while nums[l] * 2 < nums[r]:
                update(nums[l], -1)
                l += 1
            ans = max(ans, query(nums[r]))
        return ans
