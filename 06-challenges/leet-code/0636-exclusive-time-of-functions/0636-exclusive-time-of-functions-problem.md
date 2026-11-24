# 636. Exclusive Time of Functions

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/exclusive-time-of-functions/

---

## Problem Statement

On a **single-threaded** CPU, we execute a program containing `n` functions. Each function has a unique ID between `0` and `n-1`.

Function calls are stored in a **call stack**: when a function call starts, its ID is pushed onto the stack, and when a function call ends, its ID is popped off the stack.

The function whose ID is at the top of the stack is **the current function being executed**. Each time a function starts or ends, we write a log with the ID, whether it started or ended, and the timestamp.

You are given a list `logs`, where `logs[i]` represents the `i`th log message formatted as a string `"{function_id}:{start_or_end}:{timestamp}"`. For example, `"0:start:3"` means a call to function `0` **started at the beginning** of time `3`, and `"1:end:2"` means a call to function `1` **ended at the end** of time `2`.

Return the **exclusive time** of each function as an array, where the value at index `i` is the exclusive time for the function with ID `i`.

---

## Examples

**Example 1:**
```
Input:  n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
Output: [3,4]
```

**Example 2:**
```
Input:  n = 1, logs = ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
Output: [8]
```

---

## Constraints

- `1 <= n <= 100`
- `1 <= logs.length <= 500`
- `0 <= function_id < n`
- `0 <= timestamp <= 10^9`
- Timestamps are non-decreasing
- Each function has an empty call stack at the start and end
