# 3019. Number Of Changing Keys

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-changing-keys/

---

## Problem Statement

You are given a 0-indexed string `s` typed by a user. Changing a key is defined as using a key different from the last used key. For example, `s = "ab"` has a change of a key while `s = "bBBb"` does not have any.

Return the number of times the user had to change the key, case insensitive.

---

## Examples

**Example 1:**
```
Input:  s = "aAbBcC"
Output: 2
```
Explanation: Lowercase and uppercase of same key don't count. Changes at index 2 (a→b) and 4 (b→c).

**Example 2:**
```
Input:  s = "AaAaAaaA"
Output: 0
```
Explanation: All same key.

---

## Constraints

- `1 <= s.length <= 100`
- `s consists of only upper case and lower case English letters.`
