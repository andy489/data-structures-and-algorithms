# 1773. Count Items Matching a Rule — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-items-matching-a-rule/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Map `ruleKey` to an index (type=0, color=1, name=2). Then count items where the item at that index equals `ruleValue`.

**Algorithm:**
1. Determine the target index from `ruleKey`.
2. Iterate through `items`, counting those where `item[index] == ruleValue`.
3. Return the count.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — no extra storage |
