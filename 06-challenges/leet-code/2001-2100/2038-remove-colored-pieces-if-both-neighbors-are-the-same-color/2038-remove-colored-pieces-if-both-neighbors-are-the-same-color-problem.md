# 2038. Remove Colored Pieces if Both Neighbors Are the Same Color

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/

---

## Problem Statement

Alice and Bob alternate turns removing pieces. Alice removes 'A' pieces where both neighbors are 'A'; Bob removes 'B' pieces where both neighbors are 'B'. Alice goes first. Return true if Alice wins (more moves).

---

## Examples

**Example 1:**
```
Input:  colors = "AAABABB"
Output: true
```
Explanation: Alice: 3 moves, Bob: 1 move.

**Example 2:**
```
Input:  colors = "AA"
Output: false
```

**Example 3:**
```
Input:  colors = "ABBBBBBBAAA"
Output: false
```

---

## Constraints

- `1 <= colors.length <= 10^5`
- `colors[i] is 'A' or 'B'`
