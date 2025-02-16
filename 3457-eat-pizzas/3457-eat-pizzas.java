class Solution 
{
    public long maxWeight(int[] arr) 
    {
        Arrays.sort(arr);
        flipArray(arr);
        return computeMaxGain(arr, (arr.length / 4 + 1) / 2);
    }

    private long computeMaxGain(int[] slices, int oddMeals) 
    {
        long totalGain = 0;
        int indexA = 0;
        
        while (indexA < oddMeals) 
        {
            totalGain += slices[indexA++];
        }
        
        int evenMeals = slices.length / 4 - oddMeals, indexB = 0;

        while (indexB < evenMeals) 
        {
            totalGain += slices[oddMeals + 2 * indexB++ + 1];
        }
        
        return totalGain;
    }

    private void flipArray(int[] arr) 
    {
        int leftIdx = 0;
        int rightIdx = arr.length - 1;

        while (leftIdx < rightIdx) 
        {
            int tempVal = arr[leftIdx];
            arr[leftIdx] = arr[rightIdx];
            arr[rightIdx] = tempVal;
        
            leftIdx++;
            rightIdx--;
        }
    }
}
