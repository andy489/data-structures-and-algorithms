# 809. Expressive Words — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/expressive-words/

---

## Solution: Run-Length Encoding — O(|s| + sum|words|) time, O(|s|) space

**Idea:** Encode both s and each word as (char, count) runs. A word is stretchy if for each run: same char, and either counts match, or s has count >= 3 and s_count >= w_count.

**Algorithm:**
1. Encode s into runs.
2. For each word, encode into runs and compare run-by-run.
3. A run matches if chars equal and (counts equal OR s_count >= 3 AND s_count >= w_count).

**Complexity:**

| | |
|---|---|
| Time | O(|s| + Σ|w|) — encoding and comparison |
| Space | O(|s|) — storing s's runs |
