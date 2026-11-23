# https://leetcode.com/problems/remove-invalid-parentheses/

class Solution:
    def removeInvalidParentheses(self, s: str) -> list[str]:
        result = []
        visited = {s}
        queue = [s]
        found = False
        while queue and not found:
            next_level = []
            for cur in queue:
                if self._is_valid(cur):
                    result.append(cur)
                    found = True
                if not found:
                    for i in range(len(cur)):
                        if cur[i] not in '()':
                            continue
                        nxt = cur[:i] + cur[i+1:]
                        if nxt not in visited:
                            visited.add(nxt)
                            next_level.append(nxt)
            queue = next_level
        return result

    def _is_valid(self, s: str) -> bool:
        count = 0
        for c in s:
            if c == '(':
                count += 1
            elif c == ')':
                count -= 1
                if count < 0:
                    return False
        return count == 0
