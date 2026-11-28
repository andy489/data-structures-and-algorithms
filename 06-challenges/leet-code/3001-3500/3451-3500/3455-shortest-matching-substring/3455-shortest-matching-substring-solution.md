# 3455. Shortest Matching Substring — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/shortest-matching-substring/

---

## Solution: KMP + Two Pointers — O(n + m) time, O(n + m) space

**Idea:** Split pattern p on `'*'` into three parts: prefix (before first *), middle (between the two *), suffix (after second *). Use KMP to find all occurrences of each part in s, then use two pointers to find the shortest window containing all three in order.

**Algorithm:**
1. Split p into prefix, middle, suffix by the two '*' positions.
2. Use KMP to find all end positions in s where prefix ends, all start/end positions where middle occurs, all start positions where suffix starts.
3. Use two-pointer sweep: for each occurrence of middle, find the rightmost prefix ending before or at middle start, and the leftmost suffix starting at or after middle end.
4. The window length is suffix_end - prefix_start. Take the minimum over all valid combinations.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) |
| Space | O(n + m) |
