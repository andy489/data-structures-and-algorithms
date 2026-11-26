# 2070. Most Beautiful Item for Each Query

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/most-beautiful-item-for-each-query/

---

## Problem Statement

You have items `[price, beauty]`. For each query price, find the maximum beauty of items with price <= query. Return answers for all queries.

---

## Examples

**Example 1:**
```
Input:  items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
Output: [2,4,5,5,6,6]
```

**Example 2:**
```
Input:  items = [[1,2],[1,2],[1,3],[1,4]], queries = [1]
Output: [4]
```

**Example 3:**
```
Input:  items = [[10,1000]], queries = [5]
Output: [0]
```

---

## Constraints

- `1 <= items.length, queries.length <= 10^5`
- `items[i].length == 2`
- `1 <= pricei, beautyj, queryj <= 10^9`
