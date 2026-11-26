// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/

var minCost = function(grid) {
    const m=grid.length, n=grid[0].length;
    const dirs=[[0,1],[0,-1],[1,0],[-1,0]];
    const dist=Array.from({length:m},()=>new Array(n).fill(Infinity));
    dist[0][0]=0;
    const dq=[[0,0]]; // simple deque as array
    let head=0;
    // Use proper deque logic
    const front=[], back=[];
    front.push([0,0]);
    const poll=()=>front.length?front.pop():back.shift();
    const pushFront=(v)=>front.push(v);
    const pushBack=(v)=>back.push(v);
    while(front.length||back.length){
        const [r,c]=poll();
        for(let d=0;d<4;d++){
            const [nr,nc]=[r+dirs[d][0],c+dirs[d][1]];
            if(nr>=0&&nr<m&&nc>=0&&nc<n){
                const cost=grid[r][c]-1===d?0:1;
                if(dist[r][c]+cost<dist[nr][nc]){
                    dist[nr][nc]=dist[r][c]+cost;
                    if(cost===0) pushFront([nr,nc]);
                    else pushBack([nr,nc]);
                }
            }
        }
    }
    return dist[m-1][n-1];
};
