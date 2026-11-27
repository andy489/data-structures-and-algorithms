# 165. Compare Version Numbers

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/compare-version-numbers/

---

## Problem Statement

Given two version strings, `version1` and `version2`, compare them. A version string consists of **revisions** separated by dots `'.'`. The **value** of the revision is its **integer value** ignoring leading zeros.

To compare version strings, compare their revision values in **left-to-right order**. If one version string has fewer revisions, treat the missing revision as `0`.

Return:
- `-1` if `version1 < version2`
- `1` if `version1 > version2`
- `0` if equal

---

## Examples

**Example 1:**
```
Input:  version1 = "1.2", version2 = "1.10"
Output: -1
```

**Example 2:**
```
Input:  version1 = "1.01", version2 = "1.001"
Output: 0
```

**Example 3:**
```
Input:  version1 = "1.0", version2 = "1.0.0.0"
Output: 0
```

---

## Constraints

- `1 <= version1.length, version2.length <= 500`
- `version1` and `version2` only contain digits and `'.'`.
- Both are **valid** version strings.
