# 1452. People Whose List Of Favorite Companies Is Not A Subset Of Another List

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/

---

## Problem Statement

Return indices of people whose favorite company lists are not a subset of any other person's list. Return in sorted order.

---

## Examples

**Example 1:**
```
Input:  favoriteCompanies=[["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
Output: [0,1,4]
```

---

## Constraints

- `1 <= favoriteCompanies.length <= 100`
- `1 <= favoriteCompanies[i].length <= 500`
- `All strings consist of lowercase letters and have length 1-20`
- `All companies in favoriteCompanies[i] are distinct`
- `The order of elements does not matter`
