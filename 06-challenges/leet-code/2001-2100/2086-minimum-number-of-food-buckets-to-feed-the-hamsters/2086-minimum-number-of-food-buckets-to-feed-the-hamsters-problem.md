# 2086. Minimum Number of Food Buckets to Feed the Hamsters

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/

---

## Problem Statement

Given a street of `hamsters[i]`: 'H' (hamster), 'E' (empty). Place food buckets on empty cells such that each hamster has at least one adjacent bucket. Return minimum buckets needed, or -1 if impossible.

---

## Examples

**Example 1:**
```
Input:  hamsters = "H##H"
Output: 2
```
Explanation: Place at index 1 and 2.

**Example 2:**
```
Input:  hamsters = "H#H"
Output: 1
```
Explanation: Place at index 1 (shared).

**Example 3:**
```
Input:  hamsters = "##H"
Output: 1
```
Explanation: Place at index 1.

**Example 4:**
```
Input:  hamsters = "HH"
Output: -1
```
Explanation: No empty cell between hamsters.

---

## Constraints

- `1 <= hamsters.length <= 10^5`
- `hamsters[i] is either 'H' or '#'.`
