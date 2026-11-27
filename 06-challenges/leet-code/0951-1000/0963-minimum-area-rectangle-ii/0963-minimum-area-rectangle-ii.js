// https://leetcode.com/problems/minimum-area-rectangle-ii/

var minAreaFreeRect = function(points) {
    const set = new Set(points.map(p => p[0]+','+p[1]));
    const dist = (a, b) => Math.sqrt((a[0]-b[0])**2 + (a[1]-b[1])**2);
    const dot = (v, u, w) => (u[0]-v[0])*(w[0]-v[0]) + (u[1]-v[1])*(w[1]-v[1]);
    let ans = Infinity;
    const n = points.length;
    for (let i = 0; i < n; i++) for (let j = i+1; j < n; j++) for (let k = j+1; k < n; k++) {
        const [A,B,C] = [points[i],points[j],points[k]];
        for (const [vtx,p1,p2] of [[A,B,C],[B,A,C],[C,A,B]]) {
            if (dot(vtx,p1,p2) === 0) {
                const d4 = `${p1[0]+p2[0]-vtx[0]},${p1[1]+p2[1]-vtx[1]}`;
                if (set.has(d4)) ans = Math.min(ans, dist(vtx,p1)*dist(vtx,p2));
            }
        }
    }
    return ans === Infinity ? 0 : ans;
};
