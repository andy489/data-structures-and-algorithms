# 169. Majority Element — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/majority-element/

---

## Solution: Boyer–Moore Voting — O(n) time, O(1) space

**Idea:** The majority element appears more than n/2 times, so it outvotes all other elements combined. Maintain a `candidate` and a `count`. When `count` hits 0, adopt the current element as the new candidate. A vote for the candidate increments `count`; any other element decrements it. The surviving candidate is guaranteed to be the majority element.

**Algorithm:**
1. Initialize `candidate = nums[0]`, `count = 0`.
2. For each `num` in `nums`:
   - If `count == 0`, set `candidate = num`.
   - If `num == candidate`, increment `count`; else decrement `count`.
3. Return `candidate`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — two variables only |

---

## Solution 2: HashMap Count — O(n) time, O(n) space

**Idea:** Count occurrences of each element. Return the first element whose count exceeds n/2.

**Algorithm:**
1. Build a frequency map over `nums`.
2. Return the key whose value exceeds `n / 2`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — one pass to build map, one pass to find winner |
| Space | O(n) — map stores up to n distinct elements |

---

## Solution 3: Sorting — O(n log n) time, O(1) or O(n) space

**Idea:** If the array is sorted, the majority element always occupies `nums[n/2]` because it fills more than half the array.

**Algorithm:**
1. Sort `nums`.
2. Return `nums[n / 2]`.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) — dominated by sort |
| Space | O(1) — in-place sort (Java/C++); O(n) for Python (Timsort on input copy) |
