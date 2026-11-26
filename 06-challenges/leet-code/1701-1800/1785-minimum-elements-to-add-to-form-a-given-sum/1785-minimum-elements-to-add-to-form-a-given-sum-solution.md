# 1785. Minimum Elements to Add to Form a Given Sum — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-elements-to-add-to-form-a-given-sum/

---

## Solution: Greedy Ceiling Division — O(n) time, O(1) space

**Idea:** Compute the difference `diff = goal - sum(nums)`. Each element we add can contribute at most `limit` towards closing this gap. So the minimum number of elements is `ceil(abs(diff) / limit)`.

**Algorithm:**
1. Compute the current sum of `nums`.
2. Compute `diff = abs(goal - sum)`.
3. Return `ceil(diff / limit)` which equals `(diff + limit - 1) / limit`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass to compute sum |
| Space | O(1) — constant extra space |
