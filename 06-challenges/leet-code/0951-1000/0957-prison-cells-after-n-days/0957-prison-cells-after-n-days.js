// https://leetcode.com/problems/prison-cells-after-n-days/

var prisonAfterNDays = function(cells, n) {
    const nextDay = (c) => {
        const next = new Array(8).fill(0);
        for (let i = 1; i < 7; i++) next[i] = c[i-1] === c[i+1] ? 1 : 0;
        return next;
    };
    const seen = new Map();
    cells = [...cells];
    for (let day = 0; day < n; day++) {
        const key = cells.join(',');
        if (seen.has(key)) {
            const cycle = day - seen.get(key);
            const remaining = (n - day) % cycle;
            for (let i = 0; i < remaining; i++) cells = nextDay(cells);
            return cells;
        }
        seen.set(key, day);
        cells = nextDay(cells);
    }
    return cells;
};
