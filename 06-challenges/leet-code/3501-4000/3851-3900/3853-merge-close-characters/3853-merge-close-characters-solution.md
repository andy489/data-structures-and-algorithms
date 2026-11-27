# 3853. Merge Close Characters — Solution

**Link:** https://leetcode.com/problems/merge-close-characters/

## Approach: Simulation with StringBuilder

Simulate the merge process repeatedly until no merges occur in a pass:

1. Convert the string to a list of characters.
2. In each pass, scan from left to right looking for the leftmost pair of equal characters within distance `k`.
3. When found, remove the right character (merge into left) and restart the scan from the beginning.
4. Continue until no merge happens in a full pass.

Since constraints are small (length ≤ 100), repeated passes are acceptable.

## Complexity

- **Time:** O(n^3) in the worst case — O(n) merges, each requiring O(n) scan, O(n) removal
- **Space:** O(n)
