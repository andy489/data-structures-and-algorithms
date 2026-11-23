// https://leetcode.com/problems/implement-rand10-using-rand7/

var rand10 = function() {
    while (true) {
        const row = rand7() - 1;
        const col = rand7() - 1;
        const idx = row * 7 + col;
        if (idx < 40) {
            return idx % 10 + 1;
        }
    }
};
