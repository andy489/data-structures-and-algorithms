# Solution: 3425. Longest Special Path

**Link:** https://leetcode.com/problems/longest-special-path/

## Approach

DFS on the rooted tree with a sliding window to maintain unique values on the current root-to-node path.

- Maintain a prefix sum array of edge lengths from root to current node.
- Maintain a map from value -> last depth where this value was seen on the current path.
- For each node, the valid start of the path is `max(0, lastSeen[nums[node]] + 1)` to ensure uniqueness.
- Use a two-pointer / depth tracking to find the earliest start depth.
- Track the longest path length and minimum node count.

Since values can repeat on the path, we need to slide the "start" pointer past the last occurrence of the current node's value.

## Complexity

- Time: O(n)
- Space: O(n)
