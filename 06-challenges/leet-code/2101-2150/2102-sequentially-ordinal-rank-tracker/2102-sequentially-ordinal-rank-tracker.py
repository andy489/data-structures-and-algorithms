# https://leetcode.com/problems/sequentially-ordinal-rank-tracker/

import heapq

# Solution: Two Heaps — O(log n) per operation
# Invariant: after q calls to get(), `left` holds the top-q best locations,
# with the q-th best (worst of the top q) at left[0].
# `right` holds the remaining locations with the best at right[0].
class SORTracker:
    def __init__(self):
        # right: max-heap of unselected locations — best at top
        # Store as (-score, name) for Python's min-heap
        self.right = []
        # left: min-heap of selected top-q locations — worst of top-q at top
        # Store as (score, reversed_name) so min-heap gives worst-of-best at top:
        # worst = lowest score, then lex-largest name
        # Use (score, inverted_name) where inverted_name flips lex order
        self.left = []

    def add(self, name: str, score: int) -> None:
        heapq.heappush(self.right, (-score, name))
        if self.left:
            # left top (worst of top-q): (score, inv_name)
            l_score, l_inv = self.left[0]
            l_name = ''.join(chr(ord('z') + ord('a') - ord(c)) for c in l_inv)
            r_neg, r_name = self.right[0]
            r_score = -r_neg
            # right's best is better than left's worst?
            if r_score > l_score or (r_score == l_score and r_name < l_name):
                heapq.heappop(self.right)
                heapq.heappop(self.left)
                # move right's best to left
                inv_r = ''.join(chr(ord('z') + ord('a') - ord(c)) for c in r_name)
                heapq.heappush(self.left, (r_score, inv_r))
                # move left's worst back to right
                heapq.heappush(self.right, (-l_score, l_name))

    def get(self) -> str:
        neg_score, name = heapq.heappop(self.right)
        score = -neg_score
        inv_name = ''.join(chr(ord('z') + ord('a') - ord(c)) for c in name)
        heapq.heappush(self.left, (score, inv_name))
        # left[0] is the q-th best (worst of the top-q)
        l_score, l_inv = self.left[0]
        return ''.join(chr(ord('z') + ord('a') - ord(c)) for c in l_inv)
