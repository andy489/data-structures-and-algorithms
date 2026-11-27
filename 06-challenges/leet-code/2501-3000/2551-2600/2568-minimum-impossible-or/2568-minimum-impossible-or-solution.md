# 2568. Minimum Impossible OR — Solution

## Approach: Check Powers of 2

**Key Insight:** The minimum non-expressible number is determined by checking powers of 2. If `1` is not in `nums`, the answer is `1`. If `1` is in `nums` but `2` is not, the answer is `2`. If both `1` and `2` are present, we can express any value up to `3`, so we check if `4` is present, etc.

**Why this works:** If all powers of 2 up to `2^k` are present in `nums`, then all integers from `1` to `2^(k+1) - 1` are expressible (since any number's binary representation can be OR'd together from individual powers of 2). The first missing power of 2 becomes the minimum non-expressible integer.

**Algorithm:**
1. Put all elements in a HashSet.
2. Check `1, 2, 4, 8, ...` in order. Return the first power of 2 not in the set.

## Complexity

- **Time:** O(n + log(max_val)) — building set, then checking 30 powers of 2
- **Space:** O(n) — for the HashSet
