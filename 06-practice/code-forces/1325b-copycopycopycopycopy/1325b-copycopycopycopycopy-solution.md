# 1325B. CopyCopyCopyCopyCopy — Solution

---

## Key Insight

The LIS of the array concatenated *n* times equals the **number of distinct values** in the original array.

**Why:**
- Since we have *n* copies, each distinct value appears at least *n* times in the concatenation.
- We can pick one occurrence of each distinct value from successive copies in increasing value order — this forms a valid increasing subsequence.
- We cannot do better than the number of distinct values: any strictly increasing subsequence can use each value at most once.

---

## Algorithm

1. Read the array.
2. Count distinct elements (e.g., insert into a set or sort + unique).
3. Output the count.

**Example:** `[3, 1, 4, 1, 5, 9]` has distinct values `{1, 3, 4, 5, 9}` — size 5. ✓

---

## Complexity

| | |
|---|---|
| Time | O(n log n) — inserting into a set, or sorting |
| Space | O(n) — set storage |
