// https://leetcode.com/problems/flood-fill/

var floodFill = function(image, sr, sc, color) {
    const orig = image[sr][sc];
    if (orig === color) return image;
    const dfs = (r, c) => {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if (image[r][c] !== orig) return;
        image[r][c] = color;
        dfs(r + 1, c); dfs(r - 1, c); dfs(r, c + 1); dfs(r, c - 1);
    };
    dfs(sr, sc);
    return image;
};
