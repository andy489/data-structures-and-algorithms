// https://leetcode.com/problems/maximum-number-of-darts-inside-of-a-circular-dartboard/

var numPoints = function(darts, r) {
    const n = darts.length;
    let ans = 1;
    function centers(a, b) {
        const mx=(a[0]+b[0])/2, my=(a[1]+b[1])/2;
        const dx=b[0]-a[0], dy=b[1]-a[1], d=Math.sqrt(dx*dx+dy*dy);
        if (d > 2*r) return [];
        const h = Math.sqrt(Math.max(0, r*r-d*d/4));
        return [[mx+h*(-dy/d), my+h*(dx/d)],[mx-h*(-dy/d), my-h*(dx/d)]];
    }
    function count(cx, cy) {
        return darts.filter(p => (p[0]-cx)**2+(p[1]-cy)**2 <= r*r+1e-6).length;
    }
    for (let i = 0; i < n; i++)
        for (let j = i+1; j < n; j++)
            for (const [cx,cy] of centers(darts[i],darts[j]))
                ans = Math.max(ans, count(cx,cy));
    return ans;
};
