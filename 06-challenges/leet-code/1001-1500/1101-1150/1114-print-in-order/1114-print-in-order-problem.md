# 1114. Print in Order

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/print-in-order/

---

## Problem Statement

Suppose we have a class:
```
public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
```
The same instance of `Foo` will be passed to three different threads. Thread A will call `first()`, Thread B will call `second()`, and thread C will call `third()`. Design a mechanism and modify the program to ensure that `second()` is executed after `first()`, and `third()` is executed after `second()`.

---

## Constraints

- Concurrency problem; see problem page for full details.
