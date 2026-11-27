# 2207. Maximize Number of Subsequences in a String

## Approach

Let p0 = pattern[0] and p1 = pattern[1].

If we add p0 at the beginning: every occurrence of p1 in text contributes one more subsequence (count of p1 in text).
If we add p1 at the end: every occurrence of p0 in text contributes one more subsequence (count of p0 in text).

The answer is: (base count of pattern in text) + max(count of p0, count of p1).

**Algorithm:**
1. Count base subsequences of pattern in text: scan left to right, tracking count of p0 seen; when we see p1, add the count of p0 seen so far.
2. Count occurrences of p0 and p1 in text.
3. Answer = base + max(count_p0, count_p1).

**Time Complexity:** O(n)  
**Space Complexity:** O(1)
