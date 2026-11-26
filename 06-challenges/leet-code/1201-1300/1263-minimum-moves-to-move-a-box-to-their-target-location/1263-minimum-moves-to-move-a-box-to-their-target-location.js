// https://leetcode.com/problems/minimum-moves-to-move-a-box-to-their-target-location/

var minPushBox = function(grid) {
    const m=grid.length,n=grid[0].length;
    let box,player;
    for(let i=0;i<m;i++) for(let j=0;j<n;j++){
        if(grid[i][j]==='B')box=[i,j];if(grid[i][j]==='S')player=[i,j];
    }
    const dirs=[[-1,0],[1,0],[0,-1],[0,1]];
    function canReach(sr,sc,tr,tc,br,bc){
        if(sr===tr&&sc===tc)return true;
        const vis=new Set([sr*n+sc]),q=[[sr,sc]];
        while(q.length){
            const[r,c]=q.shift();
            for(const[dr,dc] of dirs){
                const nr=r+dr,nc=c+dc;
                if(nr<0||nr>=m||nc<0||nc>=n||grid[nr][nc]==='#'||(nr===br&&nc===bc)||vis.has(nr*n+nc))continue;
                if(nr===tr&&nc===tc)return true;
                vis.add(nr*n+nc);q.push([nr,nc]);
            }
        }
        return false;
    }
    const dist=new Map(),pq=[[0,...box,...player]];
    const key=(br,bc,pr,pc)=>`${br},${bc},${pr},${pc}`;
    dist.set(key(...box,...player),0);
    pq.sort((a,b)=>a[0]-b[0]);
    while(pq.length){
        pq.sort((a,b)=>a[0]-b[0]);
        const[cost,br,bc,pr,pc]=pq.shift();
        if(grid[br][bc]==='T')return cost;
        const k=key(br,bc,pr,pc);
        if(cost>(dist.get(k)??Infinity))continue;
        for(const[dr,dc] of dirs){
            const nbr=br+dr,nbc=bc+dc;
            if(nbr<0||nbr>=m||nbc<0||nbc>=n||grid[nbr][nbc]==='#')continue;
            const pushR=br-dr,pushC=bc-dc;
            if(pushR<0||pushR>=m||pushC<0||pushC>=n||grid[pushR][pushC]==='#')continue;
            if(canReach(pr,pc,pushR,pushC,br,bc)){
                const nd=cost+1,nk=key(nbr,nbc,br,bc);
                if(nd<(dist.get(nk)??Infinity)){dist.set(nk,nd);pq.push([nd,nbr,nbc,br,bc]);}
            }
        }
    }
    return -1;
};
