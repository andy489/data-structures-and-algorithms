# 2044. Count Number of Maximum Bitwise-OR Subsets — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/

---

## Solution: Bitmask Enumeration — O(2^n) time, O(1) space

**Idea:** Compute max OR (OR of all). Count subsets with OR = max using bitmasks.

**Algorithm:**
1. Compute maxOR = OR of all elements.
2. Enumerate all 2^n non-empty subsets, count those with OR == maxOR.

**Complexity:**

| | |
|---|---|
| Time | O(2^n) |
| Space | O(1) |
