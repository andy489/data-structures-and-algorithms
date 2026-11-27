// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

var findTheCity = function(n, edges, distanceThreshold) {
    const dist = Array.from({length:n},()=>new Array(n).fill(Infinity));
    for (let i=0;i<n;i++) dist[i][i]=0;
    for (const [u,v,w] of edges) { dist[u][v]=w; dist[v][u]=w; }
    for (let k=0;k<n;k++) for (let i=0;i<n;i++) for (let j=0;j<n;j++) {
        if (dist[i][k]+dist[k][j]<dist[i][j]) dist[i][j]=dist[i][k]+dist[k][j];
    }
    let ans=-1, minCnt=n+1;
    for (let i=0;i<n;i++) {
        const cnt=dist[i].filter((d,j)=>i!==j&&d<=distanceThreshold).length;
        if (cnt<=minCnt) { minCnt=cnt; ans=i; }
    }
    return ans;
};
