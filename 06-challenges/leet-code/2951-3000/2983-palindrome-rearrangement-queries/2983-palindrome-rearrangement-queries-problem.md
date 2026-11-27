# 2983. Palindrome Rearrangement Queries

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/palindrome-rearrangement-queries/

## Problem

You are given a 0-indexed string s having an even length n.

You are also given a 0-indexed 2D integer array, queries, where queries[i] = [ai, bi, ci, di].

For each query i, you are allowed to perform the following operations:
- Rearrange the characters within the substring s[ai:bi], where `0 <= ai <= bi < n / 2`.
- Rearrange the characters within the substring s[ci:di], where `n / 2 <= ci <= di < n`.

For each query, your task is to determine whether it is possible to make s a palindrome by performing the operations.

Each query is answered independently of the others.

Return a 0-indexed array answer, where answer[i] == true if it is possible to make s a palindrome by performing operations specified by the ith query, and false otherwise.

## Examples

**Example 1:**
```
Input: s = "abcabc", queries = [[1,1,3,5],[0,2,5,5]]
Output: [true,true]
```

**Example 2:**
```
Input: s = "abbcdecbba", queries = [[0,2,7,9]]
Output: [false]
```

**Example 3:**
```
Input: s = "acbcab", queries = [[1,2,4,5]]
Output: [true]
```

## Constraints

- `2 <= n == s.length <= 10^5`
- `1 <= queries.length <= 10^5`
- queries[i].length == 4
- `0 <= ai <= bi < n / 2`
- `n / 2 <= ci <= di < n`
- n is even
- s consists of only lowercase English letters.
