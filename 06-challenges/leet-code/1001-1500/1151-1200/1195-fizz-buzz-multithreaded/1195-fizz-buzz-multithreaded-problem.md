# 1195. Fizz Buzz Multithreaded

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/fizz-buzz-multithreaded/

---

## Problem Statement

You have the four functions: `fizz()`, `buzz()`, `fizzbuzz()`, and `number()`, each to be run in a separate thread. Use four threads and implement:
- Thread A calls `fizz()` to check for divisibility by 3 and 5.
- Thread B calls `buzz()` to check divisibility by 5.
- Thread C calls `fizzbuzz()` for divisibility by 3 and 5.
- Thread D calls `number()` for numbers not divisible by 3 or 5.

---

## Constraints

- Concurrency problem; see problem page for full details.
