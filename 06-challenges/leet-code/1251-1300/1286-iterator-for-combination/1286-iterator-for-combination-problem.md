# 1286. Iterator for Combination

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/iterator-for-combination/

---

## Problem Statement

Design the `CombinationIterator` class:
- `CombinationIterator(string characters, int combinationLength)` Initializes the object with a string `characters` of sorted distinct lowercase English letters and a number `combinationLength` as arguments.
- `next()` Returns the next combination of length `combinationLength` in lexicographical order.
- `hasNext()` Returns `true` if and only if there exists a next combination.

---

## Examples

**Example 1:**
```
Input:  ["CombinationIterator","next","hasNext","next","hasNext","next","hasNext"]
Output: [null,"ab",true,"ac",true,"bc",false]
```

---

## Constraints

- `minLength <= combinationLength <= characters.length <= 15`
- `There will be at most 10^4 function calls to next and hasNext`
