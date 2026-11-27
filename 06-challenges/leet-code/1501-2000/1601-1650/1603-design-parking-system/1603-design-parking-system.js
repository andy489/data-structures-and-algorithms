// https://leetcode.com/problems/design-parking-system/

var ParkingSystem = function(big, medium, small) {
    this.slots = [0, big, medium, small];
};

ParkingSystem.prototype.addCar = function(carType) {
    return this.slots[carType]-- > 0;
};
