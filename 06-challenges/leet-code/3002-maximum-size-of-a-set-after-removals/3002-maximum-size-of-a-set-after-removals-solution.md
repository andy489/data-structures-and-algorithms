# 3002. Maximum Size of a Set After Removals — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-size-of-a-set-after-removals/

---

## Solution: Greedy Set Intersection — O(n) time, O(n) space

**Idea:** Let u1 = unique elements in nums1, u2 = unique elements in nums2, common = elements in both. We can keep at most n/2 unique from each. The answer is min(u1, n/2) + min(u2, n/2) - overlap where overlap is the shared elements we're forced to duplicate.

More precisely: unique1 only in nums1, unique2 only in nums2, shared in both. We can contribute min(|unique1|+|shared|, n/2) from side1 and min(|unique2|+|shared|, n/2) from side2 but shared elements count once.

Greedy: answer = min(u1, n/2) + min(u2, n/2) where we subtract the forced overlaps.

Simpler formula: let `only1` = exclusive to nums1, `only2` = exclusive to nums2, `both` = in common. Answer = min(|only1| + |both|, n/2) + min(|only2| + |both|, n/2) - |both| ... this needs careful counting. 

The clean solution: total distinct we can achieve = min(distinct1, n/2) + min(distinct2, n/2) - max(0, shared - (distinct1 - n/2) - (distinct2 - n/2)) but clipped. The answer = min(n, min(d1,n/2) + min(d2,n/2)) where the overlap is handled by the constraint.

Actually: answer = min(n, min(d1, n/2) + min(d2, n/2)) where d1=|set(nums1)|, d2=|set(nums2)|, but we must subtract elements that must appear in both. The correct formula: keep = min(d1, n/2) + min(d2, n/2) - |intersection forced| where forced overlap = max(0, |both| - (d1-n/2+max(0,d1-n/2)) ...).

Correct greedy: answer = min(n, only1_kept + only2_kept + shared_kept) where only1_kept = min(only1, n/2), only2_kept = min(only2, n/2), shared can fill remaining slots.

**Algorithm:**
1. Compute set1 = set(nums1), set2 = set(nums2).
2. only1 = |set1 - set2|, only2 = |set2 - set1|, shared = |set1 & set2|.
3. take1 = min(only1, n/2), take2 = min(only2, n/2).
4. Remaining slots: rem = n - take1 - take2 = fill from shared (but each shared element used once).
5. Answer = take1 + take2 + min(shared, rem).

**Complexity:**

| | |
|---|---|
| Time | O(n) — hash set operations |
| Space | O(n) — sets |
