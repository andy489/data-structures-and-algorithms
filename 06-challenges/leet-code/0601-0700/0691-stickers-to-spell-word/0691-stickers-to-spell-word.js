// https://leetcode.com/problems/stickers-to-spell-word/

var minStickers = function(stickers, target) {
    const t = target.length;
    const total = 1 << t;
    const dp = new Array(total).fill(Infinity);
    dp[0] = 0;
    for (let mask = 0; mask < total; mask++) {
        if (dp[mask] === Infinity) continue;
        for (const sticker of stickers) {
            const freq = {};
            for (const c of sticker) freq[c] = (freq[c] || 0) + 1;
            let newMask = mask;
            for (let i = 0; i < t; i++) {
                if (!((newMask >> i) & 1)) {
                    const c = target[i];
                    if (freq[c] > 0) {
                        freq[c]--;
                        newMask |= (1 << i);
                    }
                }
            }
            dp[newMask] = Math.min(dp[newMask], dp[mask] + 1);
        }
    }
    return dp[total - 1] === Infinity ? -1 : dp[total - 1];
};
