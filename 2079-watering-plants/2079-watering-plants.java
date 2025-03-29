class Solution 
{
    public int wateringPlants(int[] plants, int capacity) 
    {
        int maxCapacity = capacity;
        int steps = 1;

        for(int i = 0; i < plants.length; i++)
        {
            if(plants[i] > capacity)
            {
                steps += (2 * i);
                capacity = maxCapacity;
            }
            
            steps++;
            capacity -= plants[i];    
        }    

        return steps - 1;
    }
}