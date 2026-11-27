# 2102. Sequentially Ordinal Rank Tracker

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/sequentially-ordinal-rank-tracker/

---

## Problem Statement

A scenic location is represented by its name and attractiveness score, where `name` is a unique string among all locations and `score` is an integer. Locations can be ranked from the best to the worst. The higher the score, the better the location. If the scores of two locations are equal, then the location with the lexicographically smaller name is better.

You are building a system that tracks the ranking of locations with the system initially starting with no locations. It supports:

- Adding scenic locations, one at a time.
- Querying the **i**th best location of all locations already added, where `i` is the number of times the system has been queried (including the current query).

Note that the test data are generated so that at any time, the number of queries does not exceed the number of locations added to the system.

Implement the `SORTracker` class:

- `SORTracker()` Initializes the tracker system.
- `void add(string name, int score)` Adds a scenic location with `name` and `score` to the system.
- `string get()` Queries and returns the **i**th best location, where `i` is the number of times this method has been invoked (including this invocation).

---

## Examples

**Example 1:**
```
Input:
["SORTracker","add","add","get","add","get","add","get","add","get","add","get","get"]
[[],["bradford",2],["branford",3],[],["alps",2],[],["orland",2],[],["orlando",3],[],["alpine",2],[],[]]

Output: [null,null,null,"branford",null,"alps",null,"bradford",null,"bradford",null,"bradford","orland"]

Explanation:
SORTracker tracker = new SORTracker();
tracker.add("bradford", 2);
tracker.add("branford", 3);
tracker.get(); // returns "branford" (1st best)
tracker.add("alps", 2);
tracker.get(); // returns "alps" (2nd best)
tracker.add("orland", 2);
tracker.get(); // returns "bradford" (3rd best)
tracker.add("orlando", 3);
tracker.get(); // returns "bradford" (4th best)
tracker.add("alpine", 2);
tracker.get(); // returns "bradford" (5th best)
tracker.get(); // returns "orland" (6th best)
```

---

## Constraints

- The interleaved sequence of `add` and `get` operations contains at most `4 * 10^4` operations total.
- `0 <= score <= 10^6`
- `name` consists of lowercase English letters.
- At any time, the number of `get` calls does not exceed the number of `add` calls.
