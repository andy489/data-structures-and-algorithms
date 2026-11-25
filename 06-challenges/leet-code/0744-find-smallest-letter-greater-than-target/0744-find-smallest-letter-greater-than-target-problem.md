# 744. Find Smallest Letter Greater Than Target

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-smallest-letter-greater-than-target/

---

## Problem Statement

You are given an array of characters `letters` that is sorted in **non-decreasing order**, and a character `target`. There are **at least two different** characters in `letters`.

Return the smallest character in `letters` that is **strictly greater** than `target`. If such a character does not exist, return the first character in `letters`.

---

## Examples

**Example 1:**
```
Input:  letters = ["c","f","j"], target = "a"
Output: "c"
```

**Example 2:**
```
Input:  letters = ["c","f","j"], target = "j"
Output: "c"
```

---

## Constraints

- `2 <= letters.length <= 10^4`
- `letters[i]` is a lowercase English letter.
- `letters` is sorted in **non-decreasing** order.
- `letters` has at least two **different** characters.
- `target` is a lowercase English letter.
