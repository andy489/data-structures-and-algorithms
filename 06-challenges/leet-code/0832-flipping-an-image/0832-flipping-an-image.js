// https://leetcode.com/problems/flipping-an-image/

var flipAndInvertImage = function(image) {
    for (const row of image) {
        let l = 0, r = row.length - 1;
        while (l <= r) {
            if (row[l] === row[r]) {
                row[l] ^= 1;
                row[r] = row[l];
            }
            l++; r--;
        }
    }
    return image;
};
