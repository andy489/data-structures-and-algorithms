# 1813. Sentence Similarity III — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sentence-similarity-iii/

---

## Solution: Two Pointers on Word Arrays — O(n) time, O(n) space

**Idea:** Split both sentences into word arrays. Use two pointers — one scanning from the front and one from the back — to find the matching prefix and suffix. The sentences are similar if there is a gap in one of the arrays that can be filled (i.e., one array is exhausted by the two pointers).

**Algorithm:**
1. Split `sentence1` into `w1` and `sentence2` into `w2`.
2. Advance pointer `i` from the left while `w1[i] == w2[i]`.
3. Retreat pointers `j1` and `j2` from the right while the words match.
4. Return `true` if `i > j1` (all of `w1` is accounted for) or `i > j2` (all of `w2` is accounted for).

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass over word arrays |
| Space | O(n) — word arrays |
