# 3475. DNA Pattern Recognition

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/dna-pattern-recognition/

---

## Problem Statement

Table: `Samples`

```
+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| sample_id      | int     |
| dna_sequence   | varchar |
| species        | varchar |
+----------------+---------+
sample_id is the unique key for this table.
Each row contains a DNA sequence represented as a string of characters (A, T, G, C) and the species it was collected from.
```

Biologists are studying basic patterns in DNA sequences. Write a solution to identify `sample_id` with the following patterns:

- Sequences that **start** with **ATG** (a common **start codon**)
- Sequences that **end** with either **TAA**, **TAG**, or **TGA** (**stop codons**)
- Sequences containing the motif **ATAT** (a simple repeated pattern)
- Sequences that have **at least** `3` **consecutive** **G** (like **GGG** or **GGGG**)

Return the result table ordered by `sample_id` in **ascending** order.

---

## Examples

**Example:**
```
Input:
+-----------+------------------+-----------+
| sample_id | dna_sequence     | species   |
+-----------+------------------+-----------+
| 1         | ATGCTAGCTAGCTAA  | Human     |
| 2         | GGGTCAATCATC     | Human     |
| 3         | ATATATCGTAGCTA   | Human     |
| 4         | ATGGGGTCATCATAA  | Mouse     |
| 5         | TCAGTCAGTCAG     | Mouse     |
| 6         | ATATCGCGCTAG     | Zebrafish |
| 7         | CGTATGCGTCGTA    | Zebrafish |
+-----------+------------------+-----------+

Output:
+-----------+------------------+-------------+-------------+------------+------------+------------+
| sample_id | dna_sequence     | species     | has_start   | has_stop   | has_atat   | has_ggg    |
+-----------+------------------+-------------+-------------+------------+------------+------------+
| 1         | ATGCTAGCTAGCTAA  | Human       | 1           | 1          | 0          | 0          |
| 2         | GGGTCAATCATC     | Human       | 0           | 0          | 0          | 1          |
| 3         | ATATATCGTAGCTA   | Human       | 0           | 0          | 1          | 0          |
| 4         | ATGGGGTCATCATAA  | Mouse       | 1           | 1          | 0          | 1          |
| 5         | TCAGTCAGTCAG     | Mouse       | 0           | 0          | 0          | 0          |
| 6         | ATATCGCGCTAG     | Zebrafish   | 0           | 1          | 1          | 0          |
| 7         | CGTATGCGTCGTA    | Zebrafish   | 0           | 0          | 0          | 0          |
+-----------+------------------+-------------+-------------+------------+------------+------------+
```

---

## Constraints

- The table may contain multiple rows.
- DNA sequences consist of characters A, T, G, C.
