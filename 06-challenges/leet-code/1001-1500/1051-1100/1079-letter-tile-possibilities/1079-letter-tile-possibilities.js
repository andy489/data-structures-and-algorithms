// https://leetcode.com/problems/letter-tile-possibilities/

var numTilePossibilities = function(tiles) {
    const freq = new Array(26).fill(0);
    for (const c of tiles) freq[c.charCodeAt(0)-65]++;
    const dfs = () => {
        let count = 0;
        for (let i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                freq[i]--;
                count += 1 + dfs();
                freq[i]++;
            }
        }
        return count;
    };
    return dfs();
};
