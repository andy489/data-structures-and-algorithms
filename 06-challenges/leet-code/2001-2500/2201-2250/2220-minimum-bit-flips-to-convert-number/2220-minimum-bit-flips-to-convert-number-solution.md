# 2220. Minimum Bit Flips to Convert Number — Solution

**Approach:** Bit Manipulation (Hamming Distance)

XOR `start` and `goal`. The number of set bits in the result equals the number of positions where the two numbers differ, which is exactly the minimum number of flips needed.

**Time Complexity:** O(log(max(start, goal)))

**Space Complexity:** O(1)
