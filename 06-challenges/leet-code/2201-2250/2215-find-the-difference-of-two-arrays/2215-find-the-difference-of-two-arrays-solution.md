# 2215. Find the Difference of Two Arrays — Solution

**Approach:** Hash Sets

Convert both arrays to `HashSet`s, then find elements in each set not present in the other.

**Time Complexity:** O(n + m) — where n and m are the lengths of nums1 and nums2.

**Space Complexity:** O(n + m) — for the two sets.
