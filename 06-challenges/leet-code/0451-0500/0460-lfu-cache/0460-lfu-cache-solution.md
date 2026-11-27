# 460. LFU Cache — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/lfu-cache/

---

## Solution: HashMap + Doubly Linked List per Frequency — O(1) time, O(capacity) space

**Idea:** Maintain three maps:
- `keyToVal`: key → value
- `keyToFreq`: key → frequency
- `freqToKeys`: frequency → ordered set (LinkedHashSet for LRU ordering within same freq)

Also track `minFreq`. On `get`, increment frequency. On `put`, if full, evict the LRU element in the `minFreq` bucket.

**Algorithm:**
1. `get(key)`: if absent return -1. Else increment key's frequency, update `freqToKeys`, update `minFreq` if needed.
2. `put(key, val)`: if exists, update value and call get logic. If new and full, evict from `freqToKeys[minFreq]`. Insert with freq=1, set `minFreq=1`.

**Complexity:**

| | |
|---|---|
| Time | O(1) average — all operations use HashMap + LinkedHashSet |
| Space | O(capacity) |
