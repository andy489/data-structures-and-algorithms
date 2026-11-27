# https://leetcode.com/problems/odd-even-jump/

class Solution:
    def oddEvenJumps(self, arr: list[int]) -> int:
        n = len(arr)
        def make_next(sorted_idx):
            res = [-1] * n
            stack = []
            for i in sorted_idx:
                while stack and stack[-1] < i:
                    res[stack.pop()] = i
                stack.append(i)
            return res

        sorted_odd = sorted(range(n), key=lambda i: (arr[i], i))
        sorted_even = sorted(range(n), key=lambda i: (-arr[i], i))
        next_odd = make_next(sorted_odd)
        next_even = make_next(sorted_even)

        odd_ok = [False] * n
        even_ok = [False] * n
        odd_ok[-1] = even_ok[-1] = True
        ans = 1
        for i in range(n - 2, -1, -1):
            if next_odd[i] != -1:
                odd_ok[i] = even_ok[next_odd[i]]
            if next_even[i] != -1:
                even_ok[i] = odd_ok[next_even[i]]
            if odd_ok[i]:
                ans += 1
        return ans
