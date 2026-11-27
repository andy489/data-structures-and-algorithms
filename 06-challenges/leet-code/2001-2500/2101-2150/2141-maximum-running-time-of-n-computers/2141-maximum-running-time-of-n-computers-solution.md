# 2141. Maximum Running Time of N Computers — Solution

**Link:** https://leetcode.com/problems/maximum-running-time-of-n-computers/

## Approach: Binary Search + Greedy Check

Binary search on the answer `t` (number of minutes all `n` computers run simultaneously).

**Feasibility check for time `t`:**
- Large batteries (capacity > `t`) can each power exactly one computer for `t` minutes.
- Small batteries (capacity <= `t`) can be freely shared among computers, contributing their full capacity.
- If we have `k` large batteries (each dedicated to one computer), the remaining `n - k` computers need to be powered by the pool of small batteries, whose total capacity must be at least `(n - k) * t`.

**Binary search range:** `[0, sum(batteries) / n]`.

## Complexity

| | Time | Space |
|---|---|---|
| **Binary Search + Greedy** | O(m log(sum/n)) | O(1) |

Where `m` is the number of batteries and `sum` is the total battery capacity.
