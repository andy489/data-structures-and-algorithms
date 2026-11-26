// https://leetcode.com/problems/minimum-area-rectangle/

var minAreaRect = function(points) {
    const pts = new Set(points.map(([x,y]) => `${x},${y}`));
    let minArea = Infinity;
    for (let i = 0; i < points.length; i++) {
        for (let j = i + 1; j < points.length; j++) {
            const [x1,y1] = points[i], [x2,y2] = points[j];
            if (x1 !== x2 && y1 !== y2) {
                if (pts.has(`${x1},${y2}`) && pts.has(`${x2},${y1}`)) {
                    minArea = Math.min(minArea, Math.abs(x2-x1) * Math.abs(y2-y1));
                }
            }
        }
    }
    return minArea === Infinity ? 0 : minArea;
};
