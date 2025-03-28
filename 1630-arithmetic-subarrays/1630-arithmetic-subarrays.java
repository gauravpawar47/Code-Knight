class Solution
{
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r)
    {
        ArrayList<Boolean> list = new ArrayList<>();
        for(int i = 0; i < l.length; i++)
        {
            int[] arr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(arr);

            boolean last = true;
            int diff = arr[1] - arr[0];
 
            for(int j = 1; j < arr.length - 1; j++)
            {
                if(arr[j + 1] - arr[j] != diff)
                {
                    last = false;
                    break;
                }
            }

            list.add(last);
        }

        return list;
    }
}