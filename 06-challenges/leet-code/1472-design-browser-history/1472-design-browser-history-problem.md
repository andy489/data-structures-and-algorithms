# 1472. Design Browser History

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-browser-history/

---

## Problem Statement

Implement BrowserHistory: visit(url), back(steps), forward(steps).

---

## Examples

**Example 1:**
```
Input:  BrowserHistory(homepage), visit(url), visit(url2), back(1), back(1), forward(1), visit(url3), forward(2), back(2), back(7)
Output: [null,null,null,'url1','homepage','url1',null,'url3','url1','homepage']
```

---

## Constraints

- `1 <= homepage.length <= 20`
- `1 <= url.length <= 20`
- `1 <= steps <= 100`
- `At most 5000 calls`
