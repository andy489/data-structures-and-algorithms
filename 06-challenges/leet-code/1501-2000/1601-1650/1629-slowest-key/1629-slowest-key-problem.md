# 1629. Slowest Key

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/slowest-key/

---

## Problem Statement

A newly designed keypad was tested, where a tester pressed a sequence of `n` keys, one at a time.

You are given a string `keysPressed` of length `n`, where `keysPressed[i]` was the `i`th key pressed in the testing sequence, and a sorted list `releaseTimes`, where `releaseTimes[i]` was the time the `i`th key was released. Both arrays are **0-indexed**. The `0`th key was pressed at time `0`, and every subsequent key was pressed **directly after** the previous key was released.

The tester wants to know the key of the keypress that had the **longest duration**. The `i`th keypress had a duration of `releaseTimes[i] - releaseTimes[i - 1]`, and the duration of the `0`th keypress was `releaseTimes[0]`.

Note that the same key could have been pressed multiple times during the test, and these multiple presses of the same key **may not** have the same duration.

Return the key of the keypress that had the **longest duration**. If there are multiple such keypresses, return the lexicographically largest key of the keypresses.

---

## Examples

**Example 1:**
```
Input: releaseTimes = [9,29,49,50], keysPressed = "cbcd"
Output: "c"
Explanation: The keypresses were 'c' for 9 (0 to 9), 'b' for 20 (9 to 29), 'c' for 20 (29 to 49), and 'd' for 1 (49 to 50).
'b' and 'c' both had duration 20, 'c' is returned since it is lexicographically larger.
```

**Example 2:**
```
Input: releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
Output: "a"
```

---

## Constraints
- `releaseTimes.length == n`
- `keysPressed.length == n`
- `2 <= n <= 1000`
- `1 <= releaseTimes[i] <= 10^9`
- `releaseTimes[i] < releaseTimes[i+1]`
- `keysPressed` contains only lowercase English letters.
