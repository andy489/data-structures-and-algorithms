# 3475. DNA Pattern Recognition — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/dna-pattern-recognition/

---

## Solution: SQL Pattern Matching with REGEXP/LIKE — O(n) time, O(n) space

**Idea:** Use SQL string functions to check each DNA pattern condition independently for every row. Flag each condition as a boolean (1/0) and return all rows with their flags.

**Algorithm:**
1. Select all rows from `Samples`.
2. For `has_start`: check if `dna_sequence` starts with `ATG` using `LIKE 'ATG%'`.
3. For `has_stop`: check if ends with `TAA`, `TAG`, or `TGA`.
4. For `has_atat`: check if contains `ATAT`.
5. For `has_ggg`: check if contains `GGG`.
6. Order by `sample_id` ascending.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
