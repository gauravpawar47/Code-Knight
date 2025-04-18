class Solution 
{
    public int countTriples(int n) 
    {
        int ssTriplet = 0;
        for(int i = 1; i <= n - 2; i++)
        {
            for(int j = i + 1; j <= n - 1; j++)
            {
                for(int k = j + 1; k <= n; k++)
                {
                    int I = i * i;
                    int J = j * j;
                    int K = k * k;

                    if((I + J) == K)
                    {
                        ssTriplet += 2;
                    }
                }
            }
        }    

        return ssTriplet;
    }
}