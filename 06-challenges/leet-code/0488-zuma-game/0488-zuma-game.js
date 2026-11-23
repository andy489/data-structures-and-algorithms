// https://leetcode.com/problems/zuma-game/

var findMinStep = function(board, hand) {
    const handCount = new Array(26).fill(0);
    for (const c of hand) handCount[c.charCodeAt(0) - 65]++;

    const collapse = (s) => {
        let changed = true;
        while (changed) {
            changed = false;
            let i = 0;
            while (i < s.length) {
                let j = i;
                while (j < s.length && s[j] === s[i]) j++;
                if (j - i >= 3) { s = s.slice(0, i) + s.slice(j); changed = true; break; }
                i = j;
            }
        }
        return s;
    };

    const dfs = (board, handCount) => {
        board = collapse(board);
        if (board === '') return 0;
        let result = Infinity;
        let i = 0;
        while (i < board.length) {
            let j = i;
            while (j < board.length && board[j] === board[i]) j++;
            const need = 3 - (j - i);
            const colorIdx = board.charCodeAt(i) - 65;
            if (handCount[colorIdx] >= need) {
                handCount[colorIdx] -= need;
                const sub = dfs(board.slice(0, i) + board.slice(j), handCount);
                if (sub !== Infinity) result = Math.min(result, sub + need);
                handCount[colorIdx] += need;
            }
            i = j;
        }
        return result;
    };

    const result = dfs(board, handCount);
    return result === Infinity ? -1 : result;
};
