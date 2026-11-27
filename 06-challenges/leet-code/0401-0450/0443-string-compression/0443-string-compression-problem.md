# 443. String Compression

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/string-compression/

---

## Problem Statement

Given an array of characters `chars`, compress it using the following algorithm:

Begin with an empty string `s`. For each group of **consecutive repeating characters** in `chars`:
- If the group's length is 1, append the character to `s`.
- Otherwise, append the character followed by the group's length.

The compressed string `s` **should not be returned separately**, but instead, be stored in the input character array `chars`. Note that group lengths that are 10 or longer will be split into multiple characters in `chars`.

After you are done **modifying the input array**, return the **new length** of the array.

You must write an algorithm that uses only constant extra space.

---

## Examples

**Example 1:**
```
Input:  chars = ["a","a","b","b","c","c","c"]
Output: 6
Explanation: ["a","2","b","2","c","3"]
```

**Example 2:**
```
Input:  chars = ["a"]
Output: 1
```

**Example 3:**
```
Input:  chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: 4
Explanation: ["a","b","1","2"]
```

---

## Constraints

- `1 <= chars.length <= 2000`
- `chars[i]` is a lowercase English letter, uppercase English letter, digit, or symbol.
