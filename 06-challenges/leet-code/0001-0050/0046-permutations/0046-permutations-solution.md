# 46. Permutations — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/permutations/

---

## Solution: Backtracking with used-set — O(n!·n) time, O(n) space

**Idea:** Recursively build each permutation by choosing one unused element at each position. Track which elements are already in the current path with a boolean `used[]` array. When the path reaches length `n`, record it.

**Algorithm:**
1. Allocate `boolean[] used` of size `n`, `List<Integer> path`, result list.
2. Call `backtrack(nums, used, path, result)`.
3. In `backtrack`: if `path.size() == n`, add a copy to result and return.
4. For each `i` from 0 to `n-1`: if `used[i]`, skip. Otherwise mark `used[i]=true`, add `nums[i]` to path, recurse, then undo both.

**Complexity:**

| | |
|---|---|
| Time | O(n!·n) — n! permutations, O(n) each to copy |
| Space | O(n) — recursion depth + `used` array (excluding output) |

---

## Solution 2: Backtracking via in-place swapping with Collections.swap — O(n!·n) time, O(n) space

**Idea:** Convert `int[]` to `List<Integer>` to use `Collections.swap`. At depth `start`, swap `list.get(start)` with each `list.get(i)` for `i >= start`, recurse for `start+1`, then swap back.

**Algorithm:**
1. Box `nums` into `List<Integer> list`.
2. `backtrack(list, start, result)`: if `start == list.size()`, record a copy.
3. For `i` from `start` to `list.size()-1`: `Collections.swap(list, start, i)`, recurse with `start+1`, swap back.

**Complexity:**

| | |
|---|---|
| Time | O(n!·n) — same output size |
| Space | O(n) — recursion stack only |
