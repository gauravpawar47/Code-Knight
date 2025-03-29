class Solution 
{
    public int minimumRefill(int[] plants, int capacityA, int capacityB) 
    {
        int alice = 0;
        int bob = plants.length - 1;
        int refill = 0;
        int[] capacity = {capacityA, capacityB};
        int max = Math.max(capacityA, capacityB);
        
        while(alice <= bob)
        {   
            if(alice == bob)
            {
                int maxCapacity = Math.max(capacityA, capacityB);
                if(maxCapacity > plants[alice])
                {
                    maxCapacity -= plants[alice];
                }
                else
                {
                    maxCapacity = max;
                    maxCapacity -= plants[alice];
                    refill++;
                }
                
                break;
            }

            if(capacityA >= plants[alice])
            {
                capacityA -= plants[alice];
                alice++;
            }
            else
            {
                capacityA = capacity[0];
                refill++;

                capacityA -= plants[alice];
                alice++;
            }

            if(capacityB > plants[bob])
            {
                capacityB -= plants[bob];
                bob--;
            }
            else
            {
                capacityB = capacity[1];
                refill++;

                capacityB -= plants[bob];
                bob--;   
            }
        }

        return refill;  
    }
}