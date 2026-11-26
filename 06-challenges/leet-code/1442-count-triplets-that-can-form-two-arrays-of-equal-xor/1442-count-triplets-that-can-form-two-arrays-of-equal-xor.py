# https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/

class Solution:
    def countTriplets(self, arr: list[int]) -> int:
        n = len(arr)
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i+1] = pre[i] ^ arr[i]
        ans = 0
        for i in range(n):
            for k in range(i+1, n):
                if pre[i] == pre[k+1]:
                    ans += k - i
        return ans
