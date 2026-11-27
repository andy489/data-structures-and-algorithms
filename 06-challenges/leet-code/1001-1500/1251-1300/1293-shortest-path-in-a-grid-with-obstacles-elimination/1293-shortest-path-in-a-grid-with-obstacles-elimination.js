// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

var shortestPath = function(grid, k) {
    const m=grid.length,n=grid[0].length;
    if(k>=m+n-2)return m+n-2;
    const vis=Array.from({length:m},()=>Array.from({length:n},()=>new Array(k+1).fill(false)));
    let q=[[0,0,k,0]]; vis[0][0][k]=true;
    const dirs=[[-1,0],[1,0],[0,-1],[0,1]];
    while(q.length){
        const nq=[];
        for(const[r,c,rem,steps] of q){
            for(const[dr,dc] of dirs){
                const nr=r+dr,nc=c+dc;
                if(nr<0||nr>=m||nc<0||nc>=n)continue;
                const nrem=rem-grid[nr][nc];
                if(nrem<0||vis[nr][nc][nrem])continue;
                if(nr===m-1&&nc===n-1)return steps+1;
                vis[nr][nc][nrem]=true;nq.push([nr,nc,nrem,steps+1]);
            }
        }
        q=nq;
    }
    return -1;
};
