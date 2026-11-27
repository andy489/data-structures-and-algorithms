# 1575. Count All Possible Routes

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-all-possible-routes/

---

## Problem Statement

You are given an array of **distinct** positive integers locations where `locations[i]` represents the position of city `i`. You are also given integers `start`, `finish` and `fuel` representing the starting city, ending city, and the initial amount of fuel you have, respectively.

At each step, if you are at city `i`, you can pick any city `j` such that `j != i` and `0 <= j < locations.length` and move to city `j`. Moving from city `i` to city `j` reduces the amount of fuel you have by `|locations[i] - locations[j]|`. Please notice that if the fuel becomes 0, you can still move to any city as long as the distance between cities `i` and `j` is 0.

There's no limit to the number of times you can visit any city, but you cannot visit the `finish` city at step 0.

Return the count of all possible routes from `start` to `finish`. Since the answer may be too large, return it modulo `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input: locations = [2,3,6,8,4], start = 1, finish = 3, fuel = 5
Output: 4
Explanation: The following are all possible routes, each uses 5 units of fuel:
1 -> 3
1 -> 2 -> 3
1 -> 4 -> 3
1 -> 4 -> 2 -> 3
```

**Example 2:**
```
Input: locations = [4,3,1], start = 1, finish = 0, fuel = 6
Output: 5
```

---

## Constraints
- `2 <= locations.length <= 100`
- `1 <= locations[i] <= 10^9`
- All integers in `locations` are **distinct**.
- `0 <= start, finish < locations.length`
- `1 <= fuel <= 200`
