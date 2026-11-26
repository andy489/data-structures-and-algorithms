# 1733. Minimum Number of People to Teach — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-people-to-teach/

---

## Solution: Enumerate Language + Count Teaching — O(n · m) time, O(m) space

**Idea:** Only users involved in "broken" friendships (pairs that share no language) are candidates for teaching. For each candidate language `l`, count how many of these candidate users don't already know `l`. Pick the minimum count over all languages.

**Algorithm:**
1. Convert each user's language list to a set.
2. Find all "broken" friendship pairs (no common language). Collect the unique set of involved users.
3. For each language `l` from `1` to `n`, count how many candidate users don't know `l`.
4. Return the minimum such count (or 0 if no broken pairs).

**Complexity:**

| | |
|---|---|
| Time | O(n · m + f · L) — L = max languages per user, f = friendships |
| Space | O(m) — user sets |
