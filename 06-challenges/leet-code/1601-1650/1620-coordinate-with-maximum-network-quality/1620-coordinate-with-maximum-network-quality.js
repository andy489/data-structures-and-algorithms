// https://leetcode.com/problems/coordinate-with-maximum-network-quality/

var bestCoordinate = function(towers, radius) {
    let maxQuality = 0;
    let best = [0, 0];
    for (let x = 0; x <= 50; x++) {
        for (let y = 0; y <= 50; y++) {
            let quality = 0;
            for (const [tx, ty, q] of towers) {
                const d = Math.sqrt((x - tx) ** 2 + (y - ty) ** 2);
                if (d <= radius) {
                    quality += Math.floor(q / (1 + d));
                }
            }
            if (quality > maxQuality) {
                maxQuality = quality;
                best = [x, y];
            }
        }
    }
    return best;
};
