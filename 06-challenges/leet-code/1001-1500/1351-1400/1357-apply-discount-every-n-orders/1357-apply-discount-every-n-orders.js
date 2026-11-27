// https://leetcode.com/problems/apply-discount-every-n-orders/

class Cashier {
    constructor(n, discount, products, prices) {
        this.n=n; this.discount=discount; this.count=0;
        this.prices=new Map(products.map((p,i)=>[p,prices[i]]));
    }
    getBill(product, amount) {
        let total=product.reduce((s,p,i)=>s+this.prices.get(p)*amount[i],0);
        return ++this.count%this.n===0 ? total*(100-this.discount)/100 : total;
    }
}
