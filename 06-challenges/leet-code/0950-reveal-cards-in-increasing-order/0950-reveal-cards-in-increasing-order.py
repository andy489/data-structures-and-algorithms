# https://leetcode.com/problems/reveal-cards-in-increasing-order/

from collections import deque

class Solution:
    def deckRevealedIncreasing(self, deck: list) -> list:
        deck.sort()
        n = len(deck)
        q = deque(range(n))
        result = [0] * n
        for card in deck:
            result[q.popleft()] = card
            if q:
                q.append(q.popleft())
        return result
