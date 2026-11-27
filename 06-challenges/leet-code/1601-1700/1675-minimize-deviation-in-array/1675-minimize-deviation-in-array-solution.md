# 1675. Minimize Deviation in Array — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimize-deviation-in-array/

---

## Solution: Max Heap with Normalization — O(n log n * log(max)) time, O(n) space

**Idea:** First normalize all numbers to their maximum possible value (multiply all odds by 2). Now we can only divide even numbers. Use a max-heap: repeatedly reduce the maximum (divide by 2 if even) and track `min` throughout to minimize `max - min`.

**Algorithm:**
1. For each `num`, if odd multiply by 2. Add to max-heap and track `min`.
2. While the heap's maximum is even: pop it, update deviation = `max - min`, divide by 2, push back, update `min`.
3. Stop when max is odd (can't reduce further).
4. Return minimum deviation seen.

**Complexity:**

| | |
|---|---|
| Time | O(n log n * log(max)) — each element divided at most log(max) times |
| Space | O(n) |
