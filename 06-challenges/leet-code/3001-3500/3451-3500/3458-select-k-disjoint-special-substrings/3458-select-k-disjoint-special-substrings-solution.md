# 3458. Select K Disjoint Special Substrings — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/select-k-disjoint-special-substrings/

---

## Solution: Greedy Interval Counting — O(n) time, O(1) space

**Idea:** A character's "special" group spans from its first to last occurrence. For a valid special substring, all characters within that span must only appear within it. Group characters by their spans and greedily count non-overlapping valid special substrings.

**Algorithm:**
1. For each character, compute its first and last occurrence in s.
2. For each character, determine its valid span: extend the span to include all characters within [first, last] that appear in this range.
3. If a character's span matches its valid special substring interval and is not the whole string, it contributes one valid special substring.
4. Count non-overlapping valid intervals greedily (sort by end, pick greedily).
5. Return count >= k.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
