# https://leetcode.com/problems/brace-expansion-ii/

class Solution:
    def braceExpansionII(self, expression: str) -> list[str]:
        def parse(i):
            # returns (set_of_strings, next_index)
            result = {''}
            while i < len(expression) and expression[i] not in ('}', ','):
                if expression[i] == '{':
                    i += 1
                    nxt, i = parse(i)
                    while expression[i] == ',':
                        i += 1
                        more, i = parse(i)
                        nxt |= more
                    i += 1  # skip '}'
                else:
                    nxt = {expression[i]}
                    i += 1
                result = {a + b for a in result for b in nxt}
            return result, i
        result, _ = parse(0)
        return sorted(result)
