class ParkingSystem
{
    public int[] cars = new int[3];
    public ParkingSystem(int big, int medium, int small)
    {
        cars[0] = big;
        cars[1] = medium;
        cars[2] = small;
    }
    
    public boolean addCar(int carType)
    {
        if(carType == 1 && cars[0] > 0)
        {
            cars[0]--;
            return true;
        }
        if(carType == 2 && cars[1] > 0)
        {
            cars[1]--;
            return true;
        }
        if(carType == 3 && cars[2] > 0)
        {
            cars[2]--;
            return true;
        }

        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */