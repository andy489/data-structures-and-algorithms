# https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/

from math import gcd
from functools import reduce
from collections import Counter

class Solution:
    def hasGroupsSizeX(self, deck: list) -> bool:
        counts = Counter(deck).values()
        return reduce(gcd, counts) >= 2
