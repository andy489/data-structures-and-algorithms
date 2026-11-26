# 1737. Change Minimum Characters to Satisfy One of Three Conditions — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/

---

## Solution: Frequency + Prefix Sums — O((|a|+|b|) + 26) time, O(26) space

**Idea:** Use character frequency arrays. For conditions 1 and 2 (all of `a` < all of `b`, or vice versa), try every split point `c` from 'a' to 'y': cost of making all `a` <= c and all `b` > c. For condition 3, try making both strings the same single character `c`: cost = `(len(a) - freq_a[c]) + (len(b) - freq_b[c])`.

**Algorithm:**
1. Build frequency arrays `fa[26]`, `fb[26]`.
2. For condition 1 (all a < all b): for each cut `c` from 1 to 25, cost = chars in `a` >= c + chars in `b` < c = `(|a| - prefA[c]) + prefB[c]`.
3. For condition 2: symmetric — `(|b| - prefB[c]) + prefA[c]`.
4. For condition 3: for each `c`, cost = `(|a| - fa[c]) + (|b| - fb[c])`.
5. Return global minimum.

**Complexity:**

| | |
|---|---|
| Time | O(n + m) — frequency counting plus O(26) enumeration |
| Space | O(26) — frequency arrays |
