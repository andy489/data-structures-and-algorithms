// https://leetcode.com/problems/image-smoother/

var imageSmoother = function(img) {
    const m = img.length, n = img[0].length;
    const res = Array.from({length: m}, () => new Array(n).fill(0));
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            let sum = 0, cnt = 0;
            for (let di = -1; di <= 1; di++) {
                for (let dj = -1; dj <= 1; dj++) {
                    const ni = i + di, nj = j + dj;
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                        sum += img[ni][nj];
                        cnt++;
                    }
                }
            }
            res[i][j] = Math.floor(sum / cnt);
        }
    }
    return res;
};
