# 1963. Minimum Number of Swaps to Make the String Balanced

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/

## Description

You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.

A string is called balanced if and only if:
- It is the empty string, or
- It can be written as AB, where both A and B are balanced strings, or
- It can be written as [C], where C is a balanced string.

You may swap the brackets at any two indices any number of times.

Return the minimum number of swaps to make s balanced.

## Examples

**Example 1:**
```
Input: s = "][]["
Output: 1
Explanation: You can make the string balanced by swapping index 0 with index 3.
The resulting string is "[[]]".
```

**Example 2:**
```
Input: s = "]]][[["
Output: 2
```

**Example 3:**
```
Input: s = "[]"
Output: 0
```

## Constraints

- n == s.length
- 2 <= n <= 10^6
- n is even.
- s[i] is either '[' or ']'.
- The number of opening brackets '[' equals n / 2, and the number of closing brackets ']' equals n / 2.
