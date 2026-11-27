# 2202. Maximize the Topmost Element After K Moves

## Approach

Key observations:
- If k == 0: return nums[0] (no moves, top is as is).
- If k == 1 and nums.length == 1: we must remove the only element, return -1.
- If k == 1: return nums[1] (pop the top once).
- After k moves, we can "browse" the first min(k, n) elements. The best topmost element from the first k-1 elements (index 0..k-2) can be placed back; also nums[k] (index k) is accessible if k < n (we just pop k times to reach it).
- Special case: if nums.length == 1, we can only pop. If k is odd we end empty (-1), if k is even we can put it back (return nums[0]).

**Algorithm:**
1. Find max of nums[0..min(k-1, n)-1] — these elements can be popped and the best one put back.
2. Also check nums[k] if k < n (accessible by popping exactly k times).
3. Handle edge cases: n == 1 → return nums[0] if k is even else -1.

**Time Complexity:** O(min(k, n))  
**Space Complexity:** O(1)
