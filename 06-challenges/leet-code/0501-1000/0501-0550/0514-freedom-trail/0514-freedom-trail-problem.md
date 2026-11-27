# 514. Freedom Trail

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/freedom-trail/

---

## Problem Statement

In the video game Fallout 4, the quest **"Road to Freedom"** requires players to reach a metal dial called the **"Freedom Trail Ring"** and use the dial to spell a specific keyword to open the door.

Given a string `ring` that represents the code engraved on the outer ring and another string `key` that represents the keyword needs to be spelled, return the **minimum number** of steps to spell all the characters in the keyword.

Initially, the first character of the ring is aligned at the `"12:00"` direction. You need to spell all the characters in `key` one by one by rotating the ring **clockwise** or **counterclockwise** to make each character of `key` aligned at `"12:00"` direction and then by pressing the center button.

At the stage of rotating the ring to spell the key character `key[i]`:
1. You can rotate the ring clockwise or counterclockwise by one place, which counts as **1 step**. The final purpose of the rotation is to align one of the ring's characters at the `"12:00"` direction, where this character must equal to the character `key[i]`.
2. If the character `key[i]` has been aligned at the `"12:00"` direction, press the center button to spell, which also counts as **1 step**. After the pressing, you could begin to spell the next character in the key (next stage).

---

## Examples

**Example 1:**
```
Input:  ring = "godding", key = "gd"
Output: 4
Explanation: rotate to 'g' (0 steps, already there), press (1 step), rotate to 'd' (2 steps), press (1 step) = 4
```

**Example 2:**
```
Input:  ring = "godding", key = "godding"
Output: 13
```

---

## Constraints

- `1 <= ring.length, key.length <= 100`
- `ring` and `key` consist of only lowercase English letters.
- It is guaranteed that `key` could always be spelled by rotating `ring`.
