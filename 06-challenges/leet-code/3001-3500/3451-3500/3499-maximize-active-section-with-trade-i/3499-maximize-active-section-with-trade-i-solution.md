# 3499. Maximize Active Section with Trade I — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/maximize-active-section-with-trade-i/

---

## Solution: Run-Length Encoding with Sliding Window — O(n) time, O(n) space

**Idea:** Augment the string with '1' at both ends. Encode runs of consecutive characters. The trade converts a '1' block surrounded by '0' blocks to '0', then converts the merged '0' region (which now includes adjacent '0' blocks) to '1'. So we look at triplets `0-block, 1-block, 0-block` and can gain the two surrounding '0' lengths. We want to maximize total 1s = (original 1s) - (traded 1-block size) + (left-0 size + 1-block size + right-0 size).

Equivalent: for each '1'-block, gain = left_zero + right_zero (since we lose the 1-block but gain left_zero + 1-block + right_zero). Net gain = left_zero + right_zero. Maximize over all valid '1'-blocks (those surrounded by '0' blocks in augmented string).

**Algorithm:**
1. Count total '1's in original string.
2. Build run-length encoding of augmented string `t = '1' + s + '1'`.
3. For each internal '1'-run (not the augmented endpoints) that is surrounded by '0'-runs, compute gain = left_0_len + right_0_len.
4. Return `total_ones + max(0, best_gain)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
