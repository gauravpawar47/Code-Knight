class Solution 
{
    public int maxContainers(int n, int w, int maxWeight) 
    {
        int container = 0;
        for(int i = 0 ; i < n * n; i++)
        {
            if(w <= maxWeight)
            {
                maxWeight -= w;
                container++;
            }
        }     

        return container;
    }
}