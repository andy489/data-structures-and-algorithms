# 646. Maximum Length of Pair Chain — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-length-of-pair-chain/

---

## Solution: Greedy (Sort by Right) — O(n log n) time, O(1) space

**Idea:** Sort by right endpoint. Greedily take each pair if its left > current chain end. Same as interval scheduling maximization.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sort |
| Space | O(1) |
