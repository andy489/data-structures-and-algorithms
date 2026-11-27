# https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

class Solution:
    def findMaximumXOR(self, nums: list[int]) -> int:
        BITS = 31
        root = [None, None]

        def insert(num):
            node = root
            for bit in range(BITS, -1, -1):
                b = (num >> bit) & 1
                if not node[b]:
                    node[b] = [None, None]
                node = node[b]

        def max_xor_with(num):
            node = root
            result = 0
            for bit in range(BITS, -1, -1):
                b = (num >> bit) & 1
                want = 1 - b
                if node[want]:
                    result |= (1 << bit)
                    node = node[want]
                else:
                    node = node[b]
            return result

        for num in nums:
            insert(num)

        return max(max_xor_with(num) for num in nums)
