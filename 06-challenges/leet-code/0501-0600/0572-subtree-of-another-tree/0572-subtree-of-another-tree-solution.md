# Solution: Subtree of Another Tree

## Approach
For each node in `root`, check if the subtree rooted there is identical to `subRoot` using a helper `isSameTree`. Early-exit when a match is found.

**Time:** O(m * n) where m = |root|, n = |subRoot| | **Space:** O(h_root)
