# 692. Top K Frequent Words

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/top-k-frequent-words/

---

## Problem Statement

Given an array of strings `words` and an integer `k`, return the `k` most frequent strings.

Return the answer **sorted** by the frequency from highest to lowest. Sort the words with the same frequency by their **lexicographical order**.

---

## Examples

**Example 1:**
```
Input:  words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words. Note that "i" comes before "love" due to a lower alphabetical order.
```

**Example 2:**
```
Input:  words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
```

---

## Constraints

- `1 <= words.length <= 500`
- `1 <= words[i].length <= 10`
- `words[i]` consists of lowercase English letters.
- `k` is in the range `[1, The number of unique words[i]]`
