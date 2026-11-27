# 2209. Minimum White Tiles After Covering With Carpets

## Approach

Dynamic programming with prefix sums.

Let prefix[i] = number of white tiles in floor[0..i-1].

Define dp[i][j] = minimum white tiles visible considering the first i tiles using j carpets.

Transition:
- Don't place carpet ending at i: dp[i][j] = dp[i-1][j] + (floor[i-1] == '1' ? 1 : 0)
- Place carpet ending at i (covering positions i-carpetLen to i-1): dp[i][j] = dp[max(0, i-carpetLen)][j-1]

Answer: dp[n][numCarpets]

We can optimize space using prefix sums.

**Time Complexity:** O(n * numCarpets)  
**Space Complexity:** O(n * numCarpets)
