# 451. Sort Characters By Frequency — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sort-characters-by-frequency/

---

## Solution: Frequency Map + Bucket Sort — O(n) time, O(n) space

**Idea:** Count character frequencies, then use bucket sort (index = frequency) to group characters. Build result by iterating buckets from high to low frequency.

**Algorithm:**
1. Count frequency of each character in a HashMap.
2. Create buckets array of size `n+1`; bucket[i] contains chars with frequency i.
3. Iterate from bucket[n] down to bucket[1], appending each char repeated its frequency.

**Complexity:**

| | |
|---|---|
| Time | O(n) — counting + bucket fill + result build all O(n) |
| Space | O(n) — frequency map and buckets |

---

## Solution 2: Frequency Map + Sort — O(n log n) time, O(n) space

**Idea:** Count frequencies, sort characters by frequency descending, build result.

**Algorithm:**
1. Count frequency of each character.
2. Sort unique characters by frequency descending.
3. Append each character repeated by its frequency.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — sorting distinct chars (at most 62) is O(1), overall O(n) |
| Space | O(n) — output string |
