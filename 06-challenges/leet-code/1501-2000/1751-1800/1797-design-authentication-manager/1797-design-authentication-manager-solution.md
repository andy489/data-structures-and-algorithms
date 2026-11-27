# 1797. Design Authentication Manager — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-authentication-manager/

---

## Solution: HashMap of Expiry Times — O(n) per count, O(1) per generate/renew — O(n) space

**Idea:** Store each token's expiry time in a hash map. For `generate` and `renew`, update the expiry. For `countUnexpiredTokens`, scan the map and count entries where expiry > currentTime.

**Algorithm:**
1. Maintain `Map<String, Integer> expiry` and `timeToLive`.
2. `generate(id, t)`: put `(id, t + timeToLive)` in map.
3. `renew(id, t)`: if `id` exists and `expiry[id] > t`, update to `t + timeToLive`.
4. `count(t)`: count map values > `t`.

**Complexity:**

| | |
|---|---|
| Time | O(1) for generate/renew, O(n) for count |
| Space | O(n) — one entry per active token |
