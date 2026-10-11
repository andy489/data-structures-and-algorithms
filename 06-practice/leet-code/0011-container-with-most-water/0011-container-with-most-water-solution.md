# 11. Container With Most Water — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/container-with-most-water/

---

## Solution

### Two Pointers — O(n) time, O(1) space

**Idea:** Place one pointer at the left end and one at the right end. The water held by any pair `(i, j)` is:

```
area = (j - i) * min(height[i], height[j])
```

To maximize this, we want both wide containers AND tall walls. Starting maximally wide, we shrink the width by moving the pointer pointing to the **shorter** wall inward.

**Why move the shorter side?** Moving the taller side can only decrease or maintain the min-height (bottlenecked by the shorter side anyway) while also decreasing the width — strictly bad. Moving the shorter side gives a chance to find a taller wall that increases the min-height enough to compensate for the smaller width.

**Algorithm:**
1. `left = 0`, `right = n - 1`, `maxArea = 0`.
2. While `left < right`:
   - `maxArea = max(maxArea, (right - left) * min(height[left], height[right]))`
   - If `height[left] < height[right]`: `left++`
   - Else: `right--`
3. Return `maxArea`.

**Correctness proof sketch:** By induction — when we discard the shorter pointer's position, any container using that position with any inner partner is already narrower and no taller (bottlenecked by the short wall), so the current area is their upper bound. We never miss a better solution.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass, each pointer moves at most n times |
| Space | O(1) |
