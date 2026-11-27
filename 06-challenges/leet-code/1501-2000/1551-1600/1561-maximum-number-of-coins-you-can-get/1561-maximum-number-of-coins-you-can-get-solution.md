# 1561. Maximum Number of Coins You Can Get — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-coins-you-can-get/

---

## Solution: Greedy Sort — O(n log n) time, O(1) space

**Idea:** Sort all piles. In each triplet, Alice gets the max, Bob gets the min, and we get the second max. Optimally, Bob always gets the smallest pile (use up the n/3 smallest piles for Bob). So pair each of the n/3 smallest with pairs from the top. Picking piles at indices n/3, n/3+2, n/3+4, ... maximizes our total.

**Algorithm:**
1. Sort piles ascending.
2. Skip first n/3 piles (Bob's).
3. Take every other pile from position n/3 upward (the second largest in each group of 3).
4. Sum them up.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — dominated by sorting |
| Space | O(1) — sort in place |
