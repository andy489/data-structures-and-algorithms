# 3926. Count Valid Word Occurrences

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/count-valid-word-occurrences/

## Problem

You are given an array of strings `chunks`. Concatenate all strings in `chunks` in order to form a string `s`.

You are also given an array of strings `queries`.

A **joiner hyphen** is a hyphen character `'-'` in `s` whose previous and next characters both exist and are lowercase English letters.

A **word** is a **maximal** substring of `s` consisting only of lowercase English letters and **joiner hyphens**.

All other characters, including spaces and hyphens that are not **joiner hyphens**, are treated as separators.

Return an integer array `ans`, where `ans[i]` is the number of times `queries[i]` appears as a word in `s`.

## Examples

**Example 1:**

```
Input: chunks = ["hello wor","ld hello"], queries = ["hello","world","wor"]
Output: [2,1,0]
Explanation: s = "hello world hello". Words: "hello", "world", "hello".
```

**Example 2:**

```
Input: chunks = ["a-b a--b ","a-","b"], queries = ["a-b","a","b"]
Output: [2,1,1]
Explanation: s = "a-b a--b a-b". Words: "a-b", "a", "b", "a-b".
```

**Example 3:**

```
Input: chunks = ["-cat dog- mouse"], queries = ["cat","dog","mouse","cat-dog"]
Output: [1,1,1,0]
Explanation: s = "-cat dog- mouse". Words: "cat", "dog", "mouse".
```

## Constraints

- `1 <= chunks.length <= 10^5`
- `1 <= chunks[i].length <= 10^5`
- Total length of all strings in `chunks` does not exceed `10^5`.
- `chunks[i]` consists only of lowercase English letters, spaces, and `'-'`.
- `1 <= queries.length <= 10^5`
- `1 <= queries[i].length <= 10^5`
- Total length of all strings in `queries` does not exceed `10^5`.
- `queries[i]` is a valid word: does not start or end with `'-'`, and does not contain two consecutive hyphens.
