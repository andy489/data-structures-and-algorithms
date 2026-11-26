# 1115. Print FooBar Alternately

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/print-foobar-alternately/

---

## Problem Statement

Suppose you are given the following code:
```
class FooBar {
  public void foo() { for (int i = 0; i < n; i++) { print("foo"); } }
  public void bar() { for (int i = 0; i < n; i++) { print("bar"); } }
}
```
The same instance of `FooBar` will be passed to two different threads: thread A will call `foo()`, while thread B will call `bar()`. Modify the given program to output `"foobar"` `n` times.

---

## Constraints

- Concurrency problem; see problem page for full details.
