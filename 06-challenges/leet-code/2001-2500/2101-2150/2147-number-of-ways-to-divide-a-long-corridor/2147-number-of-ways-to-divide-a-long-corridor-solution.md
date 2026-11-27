# 2147. Number of Ways to Divide a Long Corridor — Solution

## Approach: Counting Gaps Between Seat Pairs

**Key insight:** Every valid division must put exactly 2 seats in each section. If total seats are odd or zero, the answer is 0. Otherwise, group seats into pairs. Between the 2nd seat of pair i and the 1st seat of pair i+1, there are some plants. We can place a divider at any position among those plants — that gives `(number of plants between pairs + 1)` choices for each boundary. The answer is the product of all these choices.

**Algorithm:**
1. Collect the indices of all 'S' characters.
2. If `seats.size()` is 0 or odd, return 0.
3. For each boundary between consecutive seat pairs (i.e., between index `2k+1` and `2k+2` for all valid k), count the gap: `seats[2k+2] - seats[2k+1]`.
4. Multiply all gaps together modulo `10^9 + 7`.

## Complexity

| | Time | Space |
|---|---|---|
| Single scan | O(n) | O(n) for seat indices |
| **Total** | **O(n)** | **O(n)** |
