class Solution 
{
    public boolean isIncreasing(int[] arr, int si, int ei)
    {
        for(int i = si; i < ei; i++)
        {
            if(arr[i] >= arr[i + 1])
            {
                return false;
            }
        }

        return true;
    }

    public boolean isDecreasing(int[] arr, int si, int ei)
    {
        for(int i = si; i < ei; i++)
        {
            if(arr[i] <= arr[i + 1])
            {
                return false;
            }
        }

        return true;
    }

    public boolean validMountainArray(int[] arr) 
    {
        int n = arr.length;
        if(n < 3)
        {
            return false;
        }

        int breakPoint = -1;
        for(int i = 1; i < n - 1; i++)
        {
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1])
            {
                breakPoint = i;
                break;
            }
        }

        if(breakPoint == -1 || breakPoint == 0 || breakPoint == n - 1)
        {
            return false;
        }

        boolean increasing = isIncreasing(arr, 0, breakPoint);
        boolean decreasing = isDecreasing(arr, breakPoint, n - 1);
    
        return increasing && decreasing;
    }
}