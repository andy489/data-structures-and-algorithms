// https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/

var countOrders = function(n) {
    const MOD=1_000_000_007n;
    let ans=1n;
    for(let k=1;k<=n;k++) ans=ans*BigInt(2*k-1)%MOD*BigInt(k)%MOD;
    return Number(ans);
};
