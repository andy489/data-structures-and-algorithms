# 811. Subdomain Visit Count — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/subdomain-visit-count/

---

## Solution: HashMap — O(n·L) time, O(n·L) space

**Idea:** For each entry, parse count and domain, then add count to each suffix subdomain.

**Algorithm:**
1. Split each entry into count and domain.
2. For each domain (and each suffix by splitting at '.'), increment count in map.
3. Return formatted results.

**Complexity:**

| | |
|---|---|
| Time | O(n·L) — n entries, L max domain length |
| Space | O(n·L) — map entries |
