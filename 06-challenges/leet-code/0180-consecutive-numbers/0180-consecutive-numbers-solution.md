# 180. Consecutive Numbers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/consecutive-numbers/

---

## Solution 1: LAG window function — O(n) time, O(n) space

**Idea:** Use `LAG()` to look back 1 and 2 rows. If the current `num` equals both previous values, it has appeared at least three times consecutively. `DISTINCT` removes duplicates from the final result.

**Algorithm:**
1. In a CTE, select `num`, `LAG(num, 1) OVER (ORDER BY id)` as `prev1`, `LAG(num, 2) OVER (ORDER BY id)` as `prev2`.
2. Filter rows where `num = prev1 AND num = prev2`.
3. Return `DISTINCT num AS ConsecutiveNums`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single window function pass |
| Space | O(n) — CTE materialises all rows |

---

## Solution 2: Self-join on consecutive IDs — O(n) time, O(1) space

**Idea:** Join the table to itself twice on `l2.id = l1.id + 1` and `l3.id = l1.id + 2`, then filter where all three `num` values are equal. Works correctly only when `id` values are strictly consecutive (no gaps) — which is guaranteed by the problem's autoincrement constraint.

**Algorithm:**
1. `FROM Logs l1 JOIN Logs l2 ON l2.id = l1.id + 1 JOIN Logs l3 ON l3.id = l1.id + 2`
2. `WHERE l1.num = l2.num AND l2.num = l3.num`
3. `SELECT DISTINCT l1.num AS ConsecutiveNums`

**Complexity:**

| | |
|---|---|
| Time | O(n) — index seek per join when `id` is indexed |
| Space | O(1) — no intermediate materialisation beyond the result set |
