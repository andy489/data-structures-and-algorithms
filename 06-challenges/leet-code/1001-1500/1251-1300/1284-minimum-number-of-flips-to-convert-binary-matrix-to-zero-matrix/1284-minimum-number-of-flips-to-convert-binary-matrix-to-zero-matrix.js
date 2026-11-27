// https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/

var minFlips = function(mat) {
    const m=mat.length,n=mat[0].length;
    let start=0;for(let i=0;i<m;i++)for(let j=0;j<n;j++)start|=mat[i][j]<<(i*n+j);
    if(!start)return 0;
    const dirs=[[0,0],[-1,0],[1,0],[0,-1],[0,1]];
    const fm=[];
    for(let i=0;i<m;i++)for(let j=0;j<n;j++){
        let mask=0;for(const[di,dj]of dirs){const ni=i+di,nj=j+dj;if(ni>=0&&ni<m&&nj>=0&&nj<n)mask|=1<<(ni*n+nj);}
        fm.push(mask);
    }
    const vis=new Set([start]);let q=[start],steps=0;
    while(q.length){
        steps++;const nq=[];
        for(const cur of q)for(const f of fm){const nx=cur^f;if(!nx)return steps;if(!vis.has(nx)){vis.add(nx);nq.push(nx);}}
        q=nq;
    }
    return -1;
};
