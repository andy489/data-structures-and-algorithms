# 1805. Number of Different Integers in a String

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-different-integers-in-a-string/

---

## Problem Statement

You are given a string `word` that consists of digits and lowercase English letters.

You will replace every non-digit character with a space. For example, `"a123bc34d8ef34"` will become `" 123  34 8  34"`. Notice that you are left with some integers and many spaces. You will then find the **different** integers.

Two integers are considered the same if their decimal representations **without any leading zeros** are the same.

Return the number of **different** integers after performing the replacement operations on `word`.

---

## Examples

**Example 1:**
```
Input: word = "a123bc34d8ef34"
Output: 3
Explanation: The three different integers are "123", "34", and "8".
```

**Example 2:**
```
Input: word = "leet1234code234"
Output: 2
Explanation: The two different integers are "1234" and "234".
```

**Example 3:**
```
Input: word = "a1b01c001"
Output: 1
Explanation: The three integers "1", "01", and "001" all represent the integer 1.
```

---

## Constraints

- `1 <= word.length <= 1000`
- `word` consists of digits and lowercase English letters
