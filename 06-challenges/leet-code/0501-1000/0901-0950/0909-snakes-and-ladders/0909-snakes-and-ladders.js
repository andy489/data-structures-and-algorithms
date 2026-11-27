// https://leetcode.com/problems/snakes-and-ladders/

var snakesAndLadders = function(board) {
    const n = board.length, target = n * n;
    const toRC = label => {
        const idx = label - 1;
        const row = Math.floor(idx / n), colInRow = idx % n;
        const r = n - 1 - row;
        const c = row % 2 === 0 ? colInRow : n - 1 - colInRow;
        return [r, c];
    };
    const visited = new Set([1]);
    const queue = [[1, 0]];
    for (let i = 0; i < queue.length; i++) {
        const [curr, steps] = queue[i];
        for (let dice = 1; dice <= 6; dice++) {
            let nxt = curr + dice;
            if (nxt > target) break;
            const [r, c] = toRC(nxt);
            if (board[r][c] !== -1) nxt = board[r][c];
            if (nxt === target) return steps + 1;
            if (!visited.has(nxt)) {
                visited.add(nxt);
                queue.push([nxt, steps + 1]);
            }
        }
    }
    return -1;
};
