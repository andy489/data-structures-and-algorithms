# 220. Contains Duplicate III — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/contains-duplicate-iii/

---

## Solution: Bucket Sort — O(n) time, O(min(n, indexDiff)) space

**Idea:** Partition the value space into buckets of size `valueDiff + 1`. Two numbers in the same bucket always satisfy `|a - b| <= valueDiff`. Numbers in adjacent buckets may also satisfy this, so check those too. Maintain a sliding window of `indexDiff` active buckets.

**Algorithm:**
1. For each `nums[i]`, compute its bucket id: `getBucket(v) = v < 0 ? (v + 1) / size - 1 : v / size` where `size = valueDiff + 1`.
2. If `buckets` already has this bucket, return `true`.
3. Check adjacent buckets `id-1` and `id+1`; if the existing value is within `valueDiff`, return `true`.
4. Put `(id, nums[i])` in `buckets`.
5. If `i >= indexDiff`, remove the bucket for `nums[i - indexDiff]`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — amortized constant per element |
| Space | O(min(n, indexDiff)) — sliding bucket map |
