# Solution: Count Special Quadruplets

## Approach: HashMap for Two-Sum Variant

Fix indices `c` and `d` from right. For each pair `(c, d)`, we need `nums[a] + nums[b] == nums[d] - nums[c]`. Use a frequency map of `nums[a] + nums[b]` for all `a < b < c`.

Alternatively, with constraints `n <= 50`, an O(n^3) approach with a map suffices: iterate `c` from right to left, maintain a count map of `nums[d] - nums[c]` for all `d > c`, then for each pair `(a, b)` with `b < c`, look up `nums[a] + nums[b]` in the map.

**Simpler O(n^3):** fix `a`, `b`, `c`; check if `nums[a]+nums[b]+nums[c]` exists at some `d > c`.

**Time:** O(n^3)  
**Space:** O(n)
