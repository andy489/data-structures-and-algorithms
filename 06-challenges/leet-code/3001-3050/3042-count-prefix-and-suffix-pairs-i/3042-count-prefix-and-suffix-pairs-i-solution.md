# 3042. Count Prefix and Suffix Pairs I — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/

---

## Solution: Brute Force — O(n² * L) time, O(1) space

**Idea:** For each pair (i,j) with i<j, check if words[i] is a prefix AND suffix of words[j].

**Algorithm:**
1. For each i < j: check words[j].startsWith(words[i]) && words[j].endsWith(words[i]).
2. Count and return.

**Complexity:**

| | |
|---|---|
| Time | O(n² * L) — n² pairs, L = string length comparison |
| Space | O(1) |
