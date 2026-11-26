# 3014. Minimum Number of Pushes to Type Word I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/

---

## Solution: Greedy Assignment — O(n) time, O(1) space

**Idea:** Since all letters are distinct, assign the most frequent letters to position 1 (first 8 letters need 1 push each), next 8 to position 2, etc. With distinct letters in `word`, each letter appears once, so we have n letters to assign across 8 keys. Letters 1–8 need 1 push, 9–16 need 2 pushes, 17–24 need 3 pushes, 25–26 need 4 pushes.

**Algorithm:**
1. n = len(word). For i in 0..n-1: pushes += (i/8) + 1.
2. Return total pushes.

**Complexity:**

| | |
|---|---|
| Time | O(n) — iterate over word length |
| Space | O(1) |
