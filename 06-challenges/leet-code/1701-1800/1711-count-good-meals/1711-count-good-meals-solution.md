# 1711. Count Good Meals — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-good-meals/

---

## Solution: HashMap — O(n log(max)) time, O(n) space

**Idea:** As we process each element, check for each power of two whether the complement (powerOf2 - current) has been seen before. Use a frequency map to count how many times each value has been seen.

**Algorithm:**
1. For each food item `d`, check all powers of two from 1 to 2^21.
2. For each power `p`, if `p - d` exists in the frequency map, add the count.
3. After checking, increment the frequency of `d`.

**Complexity:**

| | |
|---|---|
| Time | O(n * 22) = O(n log(max)) — 22 powers of 2 per element |
| Space | O(n) — frequency map |
