# 748. Shortest Completing Word

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/shortest-completing-word/

---

## Problem Statement

Given a string `licensePlate` and an array of strings `words`, find the **shortest completing word** in `words`.

A **completing word** is a word that **contains all the letters** in `licensePlate`. Ignore numbers and spaces in `licensePlate`, and treat letters as **case insensitive**. If a letter appears more than once in `licensePlate`, then it must appear in the word the same number of times or more.

Return the shortest completing word in `words`. It is guaranteed an answer exists. If there are multiple shortest completing words, return the first one that occurs in `words`.

---

## Examples

**Example 1:**
```
Input:  licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
Output: "steps"
```

**Example 2:**
```
Input:  licensePlate = "1s3 456", words = ["looks","pest","stew","show"]
Output: "pest"
```

---

## Constraints

- `1 <= licensePlate.length <= 8`
- `licensePlate` consists of digits, uppercase or lowercase English letters, or spaces.
- `1 <= words.length <= 1000`
- `1 <= words[i].length <= 15`
- `words[i]` consists of lowercase English letters.
