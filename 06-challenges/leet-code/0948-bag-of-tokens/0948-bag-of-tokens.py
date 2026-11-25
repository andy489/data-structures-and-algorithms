# https://leetcode.com/problems/bag-of-tokens/

class Solution:
    def bagOfTokensScore(self, tokens: list, power: int) -> int:
        tokens.sort()
        lo, hi = 0, len(tokens) - 1
        score = max_score = 0
        while lo <= hi:
            if power >= tokens[lo]:
                power -= tokens[lo]; lo += 1
                score += 1; max_score = max(max_score, score)
            elif score > 0:
                power += tokens[hi]; hi -= 1
                score -= 1
            else:
                break
        return max_score
