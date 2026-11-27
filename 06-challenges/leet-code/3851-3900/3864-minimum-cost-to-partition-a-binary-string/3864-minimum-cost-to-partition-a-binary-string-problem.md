# 3864. Minimum Cost to Partition a Binary String

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/minimum-cost-to-partition-a-binary-string/

## Problem

You are given a binary string `s` and two integers `encCost` and `flatCost`.

For each index `i`, `s[i] = '1'` indicates that the `i`th element is sensitive, and `s[i] = '0'` indicates that it is not.

The string must be partitioned into segments. Initially, the entire string forms a single segment.

For a segment of length `L` containing `X` sensitive elements:
- If `X = 0`, the cost is `flatCost`.
- If `X > 0`, the cost is `L * X * encCost`.

If a segment has even length, you may split it into two contiguous segments of equal length and the cost of this split is the sum of costs of the resulting segments.

Return an integer denoting the minimum possible total cost over all valid partitions.

## Examples

**Example 1:**
```
Input: s = "1010", encCost = 2, flatCost = 1
Output: 6
Explanation:
- Full "1010": cost = 4 * 2 * 2 = 16
- Split to "10","10": each 2*1*2=4, total 8
- Split all to singles "1","0","1","0": cost = 2+1+2+1 = 6 (minimum)
```

**Example 2:**
```
Input: s = "1010", encCost = 3, flatCost = 10
Output: 12
Explanation: Splitting into "10","10" gives 2*1*3 + 2*1*3 = 12.
```

**Example 3:**
```
Input: s = "00", encCost = 1, flatCost = 2
Output: 2
Explanation: "00" as single segment: flatCost = 2.
```

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists only of `'0'` and `'1'`.
- `1 <= encCost, flatCost <= 10^5`
