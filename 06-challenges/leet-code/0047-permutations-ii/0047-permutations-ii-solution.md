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
