# 895. Maximum Frequency Stack — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-frequency-stack/

---

## Solution: Frequency + Group Stacks — O(1) push/pop, O(n) space

**Idea:** Maintain frequency map (val→freq) and group stacks (freq→[vals]). maxFreq tracks current max frequency. Push increments freq and appends to that freq's stack. Pop removes from maxFreq's stack and decrements.

**Algorithm:**
1. push(val): freq[val]++. maxFreq = max(maxFreq, freq[val]). group[freq[val]].append(val).
2. pop(): val = group[maxFreq].pop(). freq[val]--. If group[maxFreq] empty: maxFreq--. Return val.

**Complexity:**

| | |
|---|---|
| Time | O(1) per push/pop |
| Space | O(n) |
