# https://leetcode.com/problems/count-the-repetitions/

class Solution:
    def getMaxRepetitions(self, s1: str, n1: int, s2: str, n2: int) -> int:
        len1, len2 = len(s1), len(s2)
        s2_index = s2_count = 0
        state_to_round: dict = {}
        s2_count_at_round = [0] * (n1 + 1)

        for round_ in range(n1):
            for ch in s1:
                if ch == s2[s2_index]:
                    s2_index += 1
                    if s2_index == len2:
                        s2_index = 0
                        s2_count += 1
            s2_count_at_round[round_ + 1] = s2_count
            if s2_index in state_to_round:
                prev_round, prev_count = state_to_round[s2_index]
                cycle_len = round_ + 1 - prev_round
                cycle_count = s2_count - prev_count
                total_in_cycles = ((n1 - prev_round) // cycle_len) * cycle_count
                remainder = (n1 - prev_round) % cycle_len
                total_s2 = prev_count + total_in_cycles + (s2_count_at_round[prev_round + remainder] - prev_count)
                return total_s2 // n2
            state_to_round[s2_index] = (round_ + 1, s2_count)

        return s2_count // n2
