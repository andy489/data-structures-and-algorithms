# 2216. Minimum Deletions to Make Array Beautiful — Solution

**Approach:** Greedy

Iterate through the array tracking how many elements have been deleted. After each deletion, the index of the current element effectively shifts. For every even index position (considering prior deletions), if the current element equals the next, we delete the current. At the end, if the resulting length is odd, increment the deletion count by 1.

**Time Complexity:** O(n)

**Space Complexity:** O(1)
