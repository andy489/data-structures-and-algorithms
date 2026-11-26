# 1467. Probability Of A Two Boxes Having The Same Number Of Distinct Balls — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/probability-of-a-two-boxes-having-the-same-number-of-distinct-balls/

---

## Solution: Combinatorics + DFS — O(2^(sum)*k) time, O(k) space

**Idea:** Enumerate all ways to split each color's balls. For each valid split (equal total balls in each box), check if distinct colors are equal.

**Algorithm:**
1. Use DFS over colors. For each color, try putting 0..balls[i] in box1.
2. Track: b1 count, b2 count, d1 (distinct in box1), d2 (distinct in box2), combinations.
3. When all colors assigned and b1==b2==n: add multinomial coeff to total; if d1==d2 add to favorable.
4. Return favorable/total.

**Complexity:**

| | |
|---|---|
| Time | O(2^(sum)*k) |
| Space | O(k) |
