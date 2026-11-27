# https://leetcode.com/problems/number-of-valid-move-combinations-on-chessboard/

class Solution:
    def countCombinations(self, pieces: list[str], positions: list[list[int]]) -> int:
        DIRS = {
            'rook': [(0,1),(0,-1),(1,0),(-1,0)],
            'bishop': [(1,1),(1,-1),(-1,1),(-1,-1)],
            'queen': [(0,1),(0,-1),(1,0),(-1,0),(1,1),(1,-1),(-1,1),(-1,-1)]
        }
        n = len(pieces)
        all_moves = []
        for i, (p, pos) in enumerate(zip(pieces, positions)):
            moves = [tuple(pos)]
            for dr, dc in DIRS[p]:
                r, c = pos[0] + dr, pos[1] + dc
                while 1 <= r <= 8 and 1 <= c <= 8:
                    moves.append((r, c))
                    r += dr; c += dc
            all_moves.append(moves)
        def valid(targets):
            r = [positions[i][0] for i in range(n)]
            c = [positions[i][1] for i in range(n)]
            tr = [targets[i][0] for i in range(n)]
            tc = [targets[i][1] for i in range(n)]
            dr = [int(tr[i]>r[i]) - int(tr[i]<r[i]) for i in range(n)]
            dc = [int(tc[i]>c[i]) - int(tc[i]<c[i]) for i in range(n)]
            done = [False] * n
            for _ in range(8):
                for i in range(n):
                    if not done[i]:
                        r[i] += dr[i]; c[i] += dc[i]
                        if r[i] == tr[i] and c[i] == tc[i]:
                            done[i] = True
                coords = [(r[i], c[i]) for i in range(n)]
                if len(set(coords)) < n:
                    return False
            return True
        from itertools import product
        return sum(1 for combo in product(*all_moves) if valid(combo))
