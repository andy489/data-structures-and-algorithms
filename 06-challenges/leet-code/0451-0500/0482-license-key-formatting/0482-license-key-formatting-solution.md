# 482. License Key Formatting — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/license-key-formatting/

---

## Solution: Reverse Traversal — O(N) time, O(N) space

**Idea:** Strip dashes, process characters right-to-left grouping into k-sized chunks. Reverse at end.

**Algorithm:**
1. Remove all dashes, uppercase everything.
2. Build groups of k from the right; first group may be shorter.
3. Join with dashes.

**Complexity:**

| | |
|---|---|
| Time | O(N) |
| Space | O(N) — result string |
