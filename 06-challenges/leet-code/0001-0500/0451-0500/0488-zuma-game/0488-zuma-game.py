# https://leetcode.com/problems/zuma-game/

class Solution:
    def findMinStep(self, board: str, hand: str) -> int:
        from collections import Counter

        def collapse(s: str) -> str:
            changed = True
            while changed:
                changed = False
                i = 0
                while i < len(s):
                    j = i
                    while j < len(s) and s[j] == s[i]:
                        j += 1
                    if j - i >= 3:
                        s = s[:i] + s[j:]
                        changed = True
                        break
                    i = j
            return s

        def dfs(board: str, hand_count: list) -> int:
            board = collapse(board)
            if not board:
                return 0
            result = float('inf')
            i = 0
            while i < len(board):
                j = i
                while j < len(board) and board[j] == board[i]:
                    j += 1
                need = 3 - (j - i)
                color = ord(board[i]) - ord('A')
                if hand_count[color] >= need:
                    hand_count[color] -= need
                    sub = dfs(board[:i] + board[j:], hand_count)
                    if sub != float('inf'):
                        result = min(result, sub + need)
                    hand_count[color] += need
                i = j
            return result

        hand_count = [0] * 26
        for c in hand:
            hand_count[ord(c) - ord('A')] += 1

        result = dfs(board, hand_count)
        return -1 if result == float('inf') else result
