# 2977. Minimum Cost to Convert String II

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/minimum-cost-to-convert-string-ii/

## Problem

You are given two 0-indexed strings source and target, both of length n and consisting of lowercase English characters. You are also given two 0-indexed string arrays original and changed, and an integer array cost, where cost[i] represents the cost of converting the string original[i] to the string changed[i].

You start with the string source. In one operation, you can pick a substring x from the string, and change it to y at a cost of z if there exists any index j such that cost[j] == z, original[j] == x, and changed[j] == y. Any pair of operations must use disjoint or identical indices.

Return the minimum cost to convert the string source to the string target using any number of operations. If it is impossible to convert source to target, return -1.

## Examples

**Example 1:**
```
Input: source = "abcd", target = "acbe", original = ["a","b","c","c","e","d"], changed = ["b","c","b","e","b","e"], cost = [2,5,5,1,2,20]
Output: 28
```

**Example 2:**
```
Input: source = "abcdefgh", target = "acdeeghh", original = ["bcd","fgh","thh"], changed = ["cde","thh","ghh"], cost = [1,3,5]
Output: 9
```

**Example 3:**
```
Input: source = "abcdefgh", target = "addddddd", original = ["bcd","defgh"], changed = ["ddd","ddddd"], cost = [100,1578]
Output: -1
```

## Constraints

- `1 <= source.length == target.length <= 1000`
- source, target consist only of lowercase English characters.
- `1 <= cost.length == original.length == changed.length <= 100`
- `1 <= original[i].length == changed[i].length <= source.length`
- `1 <= cost[i] <= 10^6`
- `original[i] != changed[i]`
