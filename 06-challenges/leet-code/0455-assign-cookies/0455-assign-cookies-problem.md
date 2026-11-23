# 455. Assign Cookies

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/assign-cookies/

---

## Problem Statement

Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

Each child `i` has a greed factor `g[i]`, which is the minimum size of a cookie that the child will be content with; and each cookie `j` has a size `s[j]`. If `s[j] >= g[i]`, we can assign the cookie `j` to the child `i`, and the child `i` will be content. Your goal is to maximize the number of your content children and output the maximum number.

---

## Examples

**Example 1:**
```
Input:  g = [1,2,3], s = [1,1]
Output: 1
```

**Example 2:**
```
Input:  g = [1,2], s = [1,2,3]
Output: 2
```

---

## Constraints

- `1 <= g.length <= 3 * 10^4`
- `0 <= s.length <= 3 * 10^4`
- `1 <= g[i], s[j] <= 2^31 - 1`
