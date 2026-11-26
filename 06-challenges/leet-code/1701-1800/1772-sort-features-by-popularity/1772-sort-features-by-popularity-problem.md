# 1772. Sort Features by Popularity

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sort-features-by-popularity/

---

## Problem Statement

You are given a string array `features` where `features[i]` is a single word that represents the name of a feature of the latest product you are working on. You have made a survey where users have reported which features they would like to see in the product. The survey results are given as a string array `responses`, where each `responses[i]` is a string containing **space-separated** words.

The **popularity** of a feature is the number of `responses[i]` that contain the feature. You want to sort the features in non-increasing order by their popularities. If two features have the same popularity, order them by their original index in ascending order.

Return *the features in sorted order*.

---

## Examples

**Example 1:**
```
Input: features = ["cooler","lock","touch"], responses = ["i like cooler cooler","lock touch cool","locker like touch"]
Output: ["touch","cooler","lock"]
Explanation: appearances("cooler") = 1, appearances("lock") = 1, appearances("touch") = 2. Since "touch" has the most appearances, it is first in the output. The features "cooler" and "lock" both have 1 appearance, so "cooler" comes first since "cooler" < "lock" alphabetically... no wait — "cooler" comes first because it has index 0 in features, and "lock" has index 1.
```

**Example 2:**
```
Input: features = ["a","aa","b","c"], responses = ["a","a aa","a a a a a","b a"]
Output: ["a","aa","b","c"]
```

---

## Constraints

- `1 <= features.length <= 10^4`
- `1 <= features[i].length <= 10`
- `features` contains no duplicates.
- `1 <= responses.length <= 10^2`
- `1 <= responses[i].length <= 10^3`
- `responses[i]` consists of lowercase English letters and spaces.
- Each word in `responses[i]` has length in range `[1, 10]`.
- Each `responses[i]` has no leading or trailing spaces.
- All words in `responses[i]` are separated by a single space.
