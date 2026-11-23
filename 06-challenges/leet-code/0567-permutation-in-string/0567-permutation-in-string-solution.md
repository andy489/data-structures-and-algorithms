# Solution: Permutation in String

## Approach
Sliding window of size `s1.length` over `s2`. Maintain a frequency array of size 26. When the window matches s1's frequency array, return true.

**Time:** O(|s1| + |s2|) | **Space:** O(1)
