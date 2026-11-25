# 811. Subdomain Visit Count

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/subdomain-visit-count/

---

## Problem Statement

A website domain like `discuss.leetcode.com` consists of subdomains. When you visit `discuss.leetcode.com`, you also visit `leetcode.com` and `com`.

Given an array of `cpdomains` strings like `"9001 discuss.leetcode.com"`, return an array of the count of visits for every subdomain. The order does not matter.

---

## Examples

**Example 1:**
```
Input:  cpdomains = ["9001 discuss.leetcode.com"]
Output: ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
```

---

## Constraints

- `1 <= cpdomain.length <= 100`
- `1 <= cpdomain[i].length <= 100`
- `cpdomain[i]` follows either `"repi d1i"` or `"repi d1i.d2i"` or `"repi d1i.d2i.d3i"` format.
- `repi` is an integer.
