# https://leetcode.com/problems/guess-the-word/

import random

class Solution:
    def findSecretWord(self, words: list[str], master) -> None:
        def match(a, b):
            return sum(x == y for x, y in zip(a, b))

        candidates = list(words)
        for _ in range(10):
            if not candidates:
                break
            guess = random.choice(candidates)
            m = master.guess(guess)
            candidates = [w for w in candidates if w != guess and match(guess, w) == m]
