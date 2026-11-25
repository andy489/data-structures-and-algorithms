# 950. Reveal Cards In Increasing Order

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reveal-cards-in-increasing-order/

---

## Problem Statement

You are given an integer array `deck`. There is a deck of cards where every card has a unique integer. The integer on the `i`th card is `deck[i]`.

You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.

You will do the following repeatedly until all cards are revealed:
1. Take the top card of the deck, reveal it, and take it out of the deck.
2. If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
3. If there are still unrevealed cards, go back to step 1. Otherwise, stop.

Return *an ordering of the deck that would reveal the cards in increasing order*.

---

## Examples

**Example 1:**
```
Input:  deck = [17,13,11,2,3,5,7]
Output: [2,13,3,11,5,17,7]
```

---

## Constraints

- `1 <= deck.length <= 1000`
- `1 <= deck[i] <= 10^6`
- All the values of `deck` are **unique**.
