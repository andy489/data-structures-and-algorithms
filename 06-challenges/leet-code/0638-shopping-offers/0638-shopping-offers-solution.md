# 638. Shopping Offers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shopping-offers/

---

## Solution: DFS + Memoization — O(k · m · n) time, O(k · n) space

**Idea:** Recursively try applying each special offer (if it doesn't exceed needs) or buying individually. Use memoization keyed by remaining needs.

**Algorithm:**
1. Base case: cost of buying remaining needs at individual prices.
2. Try each special offer; if applicable, recurse with reduced needs.
3. Return minimum of all options.

**Complexity:**

| | |
|---|---|
| Time | O(k · m · n) — k states, m offers, n items |
| Space | O(k · n) — memoization (k = 11^n states) |
