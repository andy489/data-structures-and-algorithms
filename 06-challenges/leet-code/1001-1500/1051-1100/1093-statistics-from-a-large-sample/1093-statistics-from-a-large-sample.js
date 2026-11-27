// https://leetcode.com/problems/statistics-from-a-large-sample/

var sampleStats = function(count) {
    let mn = -1, mx = -1, mode = 0, total = 0, sum = 0;
    for (let i = 0; i < 256; i++) {
        if (count[i] > 0) {
            if (mn === -1) mn = i;
            mx = i;
            if (count[i] > count[mode]) mode = i;
            total += count[i];
            sum += i * count[i];
        }
    }
    const mean = sum / total;
    const mid1 = Math.floor((total + 1) / 2), mid2 = Math.floor((total + 2) / 2);
    let m1 = -1, m2 = -1, cum = 0;
    for (let i = 0; i < 256; i++) {
        cum += count[i];
        if (m1 === -1 && cum >= mid1) m1 = i;
        if (m2 === -1 && cum >= mid2) m2 = i;
    }
    return [mn, mx, mean, (m1+m2)/2, mode];
};
