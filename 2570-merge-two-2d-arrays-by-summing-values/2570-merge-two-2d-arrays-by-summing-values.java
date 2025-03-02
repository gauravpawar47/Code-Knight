class Solution 
{
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) 
    {
        ArrayList<int[]> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length)
        {
            int[] temp = new int[2];
            if(nums1[i][0] == nums2[j][0])
            {
                temp[0] = nums1[i][0];
                temp[1] = nums1[i][1] + nums2[j][1]; 
                
                i++;
                j++;
            }
            else if(nums1[i][0] < nums2[j][0])
            {
                temp[0] = nums1[i][0];
                temp[1] = nums1[i][1];

                i++;
            }
            else
            {
                temp[0] = nums2[j][0];
                temp[1] = nums2[j][1];

                j++;
            }

            result.add(temp);
        }

        while(j < nums2.length)
        {
            int[] temp = new int[2];
            temp[0] = nums2[j][0];
            temp[1] = nums2[j][1];

            j++;
            result.add(temp);
        }

        while(i < nums1.length)
        {
            int[] temp = new int[2];
            temp[0] = nums1[i][0];
            temp[1] = nums1[i][1];

            i++;
            result.add(temp);
        }

        int[][] tuples = new int[result.size()][2];
        for(i = 0; i < tuples.length; i++)
        {
            int[] tuple = result.get(i);
            tuples[i][0] = tuple[0];
            tuples[i][1] = tuple[1];
        }
        
        return tuples;
    }
}