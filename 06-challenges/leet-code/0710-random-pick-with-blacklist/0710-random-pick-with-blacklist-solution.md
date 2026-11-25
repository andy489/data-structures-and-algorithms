# 710. Random Pick with Blacklist — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/random-pick-with-blacklist/

---

## Solution: Remapping — O(b) init, O(1) pick, O(b) space

**Idea:** The valid range has size `m = n - |blacklist|`. Use `random.nextInt(m)` and pick from `[0, m)`. Any blacklisted number in `[0, m)` needs to be remapped to a non-blacklisted number in `[m, n)`. Build a map from blacklisted numbers in `[0, m)` to non-blacklisted numbers in `[m, n)`.

**Algorithm:**
1. Compute `m = n - blacklist.length`.
2. Build a set of blacklisted numbers in `[m, n)`.
3. For each blacklisted number `b` in `[0, m)`, map it to the next available non-blacklisted number from `[m, n)`.
4. `pick()`: draw `r = random(0, m-1)`; if `r` is in the remap, return remap[r]; else return `r`.

**Complexity:**

| | |
|---|---|
| Time | O(b) init, O(1) pick — b = blacklist length |
| Space | O(b) — the remap has at most b entries |
