# https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/

class Solution:
    def getMinSwaps(self, num: str, k: int) -> int:
        def next_perm(arr: list) -> None:
            n = len(arr)
            i = n - 2
            while i >= 0 and arr[i] >= arr[i + 1]:
                i -= 1
            if i >= 0:
                j = n - 1
                while arr[j] <= arr[i]:
                    j -= 1
                arr[i], arr[j] = arr[j], arr[i]
            arr[i + 1:] = arr[i + 1:][::-1]

        target = list(num)
        for _ in range(k):
            next_perm(target)

        curr = list(num)
        swaps = 0
        for i in range(len(curr)):
            if curr[i] != target[i]:
                j = i + 1
                while curr[j] != target[i]:
                    j += 1
                while j > i:
                    curr[j], curr[j - 1] = curr[j - 1], curr[j]
                    j -= 1
                    swaps += 1
        return swaps
