// https://leetcode.com/problems/design-parking-system/

// Solution: Counter Array — O(1) time, O(1) space
class ParkingSystem {
    private int[] slots;

    public ParkingSystem(int big, int medium, int small) {
        slots = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType) {
        return slots[carType]-- > 0;
    }
}
