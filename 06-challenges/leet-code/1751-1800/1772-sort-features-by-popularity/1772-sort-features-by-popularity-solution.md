# 1772. Sort Features by Popularity — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sort-features-by-popularity/

---

## Solution: Hash Map + Stable Sort — O(R*W + F log F) time, O(F + R*W) space

**Idea:** For each response, extract unique words (use a set per response to count each feature at most once per response). Count frequencies in a map. Sort features by descending frequency, with original index as a tiebreaker.

**Algorithm:**
1. Build a frequency map: for each response, convert to a set of words, then increment count for each feature word found in that set.
2. Sort `features` indices by `(-count, originalIndex)`.
3. Return features in the sorted order.

**Complexity:**

| | |
|---|---|
| Time | O(R*W + F log F) — R responses with W words each, F features sorted |
| Space | O(F + R*W) — frequency map and word sets |
