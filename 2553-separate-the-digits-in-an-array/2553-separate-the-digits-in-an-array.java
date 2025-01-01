class Solution
{
    public void separation(int num, ArrayList<Integer> list)
    {
        String numStr = String.valueOf(num);
        for(int i = 0; i < numStr.length(); i++)
        {
            list.add(numStr.charAt(i) - '0');
        }
    }

    public int[] separateDigits(int[] nums)
    {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            separation(nums[i], list);
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++)
        {
            result[i] = list.get(i);
        }

        return result;
    }
}