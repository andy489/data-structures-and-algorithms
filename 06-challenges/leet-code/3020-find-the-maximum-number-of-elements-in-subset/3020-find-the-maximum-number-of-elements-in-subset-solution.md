# 3020. Find the Maximum Number of Elements in Subset — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/

---

## Solution: HashMap + Squaring Chain — O(n log(max)) time, O(n) space

**Idea:** For each starting value x (where x is not a perfect square of another element in the set), follow the chain x → x² → x⁴ → ... counting pairs. The sequence has a palindrome structure, so the total length = 2*pairs + (1 if the last squared value exists an odd number of times).

**Algorithm:**
1. Count frequencies in a map.
2. For x=1: answer = min(freq[1], largest even ≤ freq[1] if freq[1] is odd add 1 else freq[1]).
3. For each x > 1 with freq[x] >= 2 and x is not x²-reachable from a smaller element:
   - Follow chain: len=0, cur=x; while freq[cur] >= 2: len+=2, cur=cur*cur.
   - If freq[cur] >= 1: len+=1 (middle element).
   - ans = max(ans, len).
4. Return ans (minimum 1).

**Complexity:**

| | |
|---|---|
| Time | O(n log(max)) — chain length is O(log log max) |
| Space | O(n) — frequency map |
