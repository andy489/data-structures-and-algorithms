# 2076. Process Restricted Friend Requests

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/process-restricted-friend-requests/

---

## Problem Statement

You have `n` people (0-indexed). `restrictions[i] = [x, y]` means x and y cannot be in the same friend group. `requests[j] = [u, v]` means u and v want to be friends. Approve a request if neither person in any restriction pair would end up in the same group. Return array of boolean answers.

---

## Examples

**Example 1:**
```
Input:  n = 3, restrictions = [[0,1]], requests = [[0,2],[2,1]]
Output: [true,false]
```

**Example 2:**
```
Input:  n = 3, restrictions = [[0,1]], requests = [[1,2],[0,2]]
Output: [true,false]
```

**Example 3:**
```
Input:  n = 5, restrictions = [[0,1],[1,2],[2,3]], requests = [[0,4],[1,2],[3,4],[2,4],[0,2]]
Output: [true,false,true,false,true]
```

---

## Constraints

- `2 <= n <= 1000`
- `0 <= restrictions.length <= 1000`
- `restrictions[i].length == 2`
- `0 <= requests.length <= 1000`
