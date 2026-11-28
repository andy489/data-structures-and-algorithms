# 3456. Find Special Substring of Length K — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-special-substring-of-length-k/

---

## Solution: Run-Length Encoding — O(n) time, O(1) space

**Idea:** Scan through s tracking runs of equal characters. For each run of length exactly k, verify the character before the run (if any) and the character after the run (if any) are different from the run character.

**Algorithm:**
1. Iterate through s, identifying contiguous runs of the same character.
2. For each run of length exactly k, check that the boundary characters differ.
3. Return true if any such run is found, false otherwise.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
