# 47. Permutations II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/permutations-ii/

---

## Solution: Backtracking with sort + duplicate skip — O(n!·n) time, O(n) space

**Idea:** Same used-set backtracking as problem 46, but sort first and skip a candidate at the current level if it equals the previous candidate and the previous candidate was not used in the current path. This ensures each value is placed at a given position at most once per recursion level, eliminating duplicate permutations without a set.

**Duplicate-skip rule:** `if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;`
- `nums[i] == nums[i-1]`: same value as previous sibling.
- `!used[i-1]`: the previous sibling was already explored and backtracked at this level (not carried forward from a parent call), so using `nums[i]` here would produce an identical branch.

**Algorithm:**
1. Sort `nums`.
2. Allocate `boolean[] used`, `List<Integer> path`, result list.
3. `backtrack`: if `path.size() == n`, add copy to result.
4. For each `i`: skip if `used[i]`, or if `i > 0 && nums[i] == nums[i-1] && !used[i-1]`. Otherwise mark, add, recurse, undo.

**Complexity:**

| | |
|---|---|
| Time | O(n!·n) — at most n! unique permutations, O(n) each to copy |
| Space | O(n) — recursion depth + `used` array (excluding output) |

---

## Solution 2: Backtracking with frequency map — O(n!·n) time, O(k) space

**Idea:** Build a frequency map of all values. At each recursion level, iterate over the map's distinct keys — decrement the count before recursing, increment after. Since we never pick the same key twice at the same level (we check `count > 0`), duplicates are naturally avoided without sorting or a `used[]` array.

**Algorithm:**
1. Build `Map<Integer, Integer> freq` from `nums`.
2. `backtrack(freq, n, path, result)`: if `path.size() == n`, record copy.
3. For each `(key, count)` in `freq`: if `count == 0`, skip. Otherwise decrement, add key to path, recurse, remove from path, increment.

**Complexity:**

| | |
|---|---|
| Time | O(n!·n) — same output size |
| Space | O(k) — k distinct values in the map (excluding output) |
