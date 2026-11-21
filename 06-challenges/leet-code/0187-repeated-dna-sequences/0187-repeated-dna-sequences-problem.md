# 187. Repeated DNA Sequences

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/repeated-dna-sequences/

---

## Problem Statement

The **DNA sequence** is composed of a series of nucleotides abbreviated as `'A'`, `'C'`, `'G'`, and `'T'`.

Given a string `s` that represents a DNA sequence, return all the **10-letter-long** substrings (sequences) that occur more than once in a DNA molecule. You may return the answer in **any order**.

---

## Examples

**Example 1:**
```
Input:  s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
```

**Example 2:**
```
Input:  s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s[i]` is either `'A'`, `'C'`, `'G'`, or `'T'`
