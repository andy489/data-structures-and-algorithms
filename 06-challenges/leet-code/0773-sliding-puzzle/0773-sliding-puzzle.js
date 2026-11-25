// https://leetcode.com/problems/sliding-puzzle/

var slidingPuzzle = function(board) {
    const neighbors = [[1,3],[0,2,4],[1,5],[0,4],[1,3,5],[2,4]];
    const start = board.flat().join('');
    const target = '123450';
    if (start === target) return 0;
    const queue = [[start, 0]];
    const visited = new Set([start]);
    while (queue.length) {
        const [curr, steps] = queue.shift();
        const zero = curr.indexOf('0');
        for (const nxt of neighbors[zero]) {
            const arr = curr.split('');
            [arr[zero], arr[nxt]] = [arr[nxt], arr[zero]];
            const newState = arr.join('');
            if (newState === target) return steps + 1;
            if (!visited.has(newState)) {
                visited.add(newState);
                queue.push([newState, steps + 1]);
            }
        }
    }
    return -1;
};
