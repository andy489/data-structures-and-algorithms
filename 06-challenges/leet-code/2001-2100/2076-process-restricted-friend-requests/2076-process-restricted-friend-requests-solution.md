# 2076. Process Restricted Friend Requests — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/process-restricted-friend-requests/

---

## Solution: Union-Find with Restriction Check — O(r * q) time, O(n) space

**Idea:** Union-Find. For each request, check if merging violates any restriction.

**Algorithm:**
1. Maintain DSU.
2. For each request (u, v): find roots, check all restrictions. If no violation, union.
3. Output true/false per request.

**Complexity:**

| | |
|---|---|
| Time | O(r * q) |
| Space | O(n) |
