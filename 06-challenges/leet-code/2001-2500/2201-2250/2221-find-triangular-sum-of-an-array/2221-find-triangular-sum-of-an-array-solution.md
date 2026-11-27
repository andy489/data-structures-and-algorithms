# 2221. Find Triangular Sum of an Array — Solution

**Approach:** Simulation

Repeatedly reduce the array by computing pairwise `(nums[i] + nums[i+1]) % 10` until one element remains. Since `n <= 1000`, this is efficient enough.

**Time Complexity:** O(n^2) — n rounds, each shorter by 1.

**Space Complexity:** O(n) — for the in-place modification or auxiliary array.
