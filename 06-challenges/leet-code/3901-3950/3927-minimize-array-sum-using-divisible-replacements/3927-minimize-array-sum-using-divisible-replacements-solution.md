# 3927. Minimize Array Sum Using Divisible Replacements — Solution

## Approach: Greedy — Replace Each Element with Its Minimum Divisor Present in Array

**Key insight:** For each element `nums[a]`, we can replace it with any `nums[b]` where `nums[b]` divides `nums[a]`. We can apply this transitively — if `b` divides `a` and `c` divides `b`, then we can get `c` for the value of `a` (replace `a` with `b`, then `a` with `c`... but actually we replace the element itself).

Actually the operation replaces `nums[a]` with `nums[b]`'s value. So after replacement, `nums[a]` becomes `nums[b]`'s original value. We can then use this new value further.

**Observation:** The minimum value achievable for each element is the smallest value in the array that divides it (directly or through a chain). With the full set of values available, for any element `v`, we want the smallest value in the array that is a divisor of `v` (considering all values, as replacements preserve divisibility relationships).

Build a set of all values in `nums`. For each element `v`, find the smallest value in the set that divides `v`. The minimum of all such values overall drives each element down.

Actually: we build a frequency set of values. For each value `v` in `nums`, the minimum replacement is the smallest divisor of `v` that exists in `nums`. So for each `v`, iterate over all values in the set and check if they divide `v`, taking the minimum.

## Complexity

- **Time:** O(n * sqrt(max_val)) — for each element, find minimum divisor in set
- **Space:** O(n) — for the set of values
