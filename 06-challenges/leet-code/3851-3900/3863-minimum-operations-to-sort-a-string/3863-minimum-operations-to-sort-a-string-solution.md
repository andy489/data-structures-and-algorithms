# 3863. Minimum Operations to Sort a String — Solution

**Link:** https://leetcode.com/problems/minimum-operations-to-sort-a-string/

## Approach: Observation — Count Unsorted Positions

**Key insight:** 
- If the string has length 2 and is not sorted (e.g., "gf"), it's impossible (we can only sort a proper substring, but a 1-char substring is already sorted and swapping is not possible).
- For length >= 3, we can always sort the full string with at most 2 operations: sort a prefix and then sort a suffix. Actually we can always achieve sorted order.

**Why impossible for length 2 and not sorted:** With `s = "gf"`, the only proper substrings are `"g"` (index 0) and `"f"` (index 1), each of length 1 — sorting them does nothing.

**For length >= 3:** We can count the number of "descents" (positions i where s[i] > s[i+1]). Each sort operation on a contiguous range can fix multiple descents.

**Minimum operations = number of "blocks" that are out of order relative to the global sorted string.** 

Actually the answer is the number of "maximal sorted segments" minus 1 when the string is sortable, which equals the number of descents. If the string is of length 2 and has a descent, return -1.

## Complexity

- **Time:** O(n log n) for checking sortability
- **Space:** O(n)
