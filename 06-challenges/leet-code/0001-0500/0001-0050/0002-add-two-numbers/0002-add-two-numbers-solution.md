# 2. Add Two Numbers — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/add-two-numbers/

---

## Solution

### Elementary Addition with Carry — O(max(m,n)) time, O(max(m,n)) space

**Key insight:** Because digits are already stored in reverse order, the head of each list is the least significant digit. We simulate the grade-school column-by-column addition from least to most significant digit, exactly as we would do by hand.

**Algorithm:**
1. Initialize a dummy head node and a `carry = 0`.
2. Traverse both lists simultaneously. At each step:
   - Sum the current digits from `l1` and `l2` (treat a missing node as 0) plus `carry`.
   - `carry = sum / 10`, new digit = `sum % 10`.
   - Append a new node with the new digit to the result list.
3. After both lists are exhausted, if `carry > 0` append one final node with value `carry`.

**Why a dummy head?** It avoids special-casing the first node — every new node is simply appended after `dummy`.

**Tricky case:** `l1 = [9,9,9,9,9,9,9]`, `l2 = [9,9,9,9]` — after both lists end there is still `carry = 1`, which becomes the 8th node `[1]`.

**Complexity:**

| | |
|---|---|
| Time | O(max(m, n)) — we visit each node at most once |
| Space | O(max(m, n)) — the result list has at most max(m,n)+1 nodes |
