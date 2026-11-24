# 648. Replace Words

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/replace-words/

---

## Problem Statement

In English, we have a concept called **root**, which can be followed by some other word to form another longer word — let's call this word **successor**. For example, when the root `"an"` is followed by the successor word `"other"`, we can form a new word `"another"`.

Given a `dictionary` consisting of many roots and a `sentence` consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has **the shortest length**.

Return the `sentence` after the replacement.

---

## Examples

**Example 1:**
```
Input:  dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
```

**Example 2:**
```
Input:  dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"
```

---

## Constraints

- `1 <= dictionary.length <= 1000`
- `1 <= dictionary[i].length <= 100`
- `dictionary[i]` consists of only lower-case letters
- `1 <= sentence.length <= 10^6`
- `sentence` consists of only lower-case letters and spaces
- The number of words in `sentence` is in the range `[1, 1000]`
- The length of each word in `sentence` is in the range `[1, 1000]`
