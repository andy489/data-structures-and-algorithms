// https://leetcode.com/problems/dice-roll-simulation/

var dieSimulator = function(n, rollMax) {
    const MOD=1e9+7, dp=Array.from({length:n+1},()=>Array.from({length:6},()=>new Array(16).fill(0)));
    for(let j=0;j<6;j++) dp[1][j][1]=1;
    for(let i=2;i<=n;i++) for(let j=0;j<6;j++){
        let tot=0;
        for(let pj=0;pj<6;pj++) if(pj!==j) for(let pk=1;pk<=rollMax[pj];pk++) tot=(tot+dp[i-1][pj][pk])%MOD;
        dp[i][j][1]=tot;
        for(let k=2;k<=rollMax[j];k++) dp[i][j][k]=dp[i-1][j][k-1];
    }
    let res=0;
    for(let j=0;j<6;j++) for(let k=1;k<=rollMax[j];k++) res=(res+dp[n][j][k])%MOD;
    return res;
};
