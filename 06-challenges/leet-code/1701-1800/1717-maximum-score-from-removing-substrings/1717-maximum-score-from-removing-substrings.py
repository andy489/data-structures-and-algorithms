# https://leetcode.com/problems/maximum-score-from-removing-substrings/

class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        def remove_pair(chars: list, first: str, second: str, points: int) -> tuple[list, int]:
            stack = []
            score = 0
            for c in chars:
                if stack and stack[-1] == first and c == second:
                    stack.pop()
                    score += points
                else:
                    stack.append(c)
            return stack, score

        chars = list(s)
        if x >= y:
            remaining, score1 = remove_pair(chars, 'a', 'b', x)
            _, score2 = remove_pair(remaining, 'b', 'a', y)
        else:
            remaining, score1 = remove_pair(chars, 'b', 'a', y)
            _, score2 = remove_pair(remaining, 'a', 'b', x)
        return score1 + score2
