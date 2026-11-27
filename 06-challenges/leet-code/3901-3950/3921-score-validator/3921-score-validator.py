# https://leetcode.com/problems/score-validator/

class Solution:
    def scoreValidator(self, events: list[str]) -> list[int]:
        score = 0
        counter = 0
        for e in events:
            if e == "W":
                counter += 1
                if counter == 10:
                    break
            elif e in ("WD", "NB"):
                score += 1
            else:
                score += int(e)
        return [score, counter]
