class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int [] freeArray = new int[n+1];
          freeArray[0] = startTime[0];
          freeArray[n] = eventTime -endTime[n-1];

          for(int i =1 ; i<n;i++)
          {
            freeArray[i] = startTime[i] - endTime[i-1];
            
          }

            int maxSum = 0;
            int currSum = 0;
            int i =0;

            for(int j=0;j<freeArray.length;j++)
            {
                currSum += freeArray[j];

                while(j-i+1>k+1)
                {
                    currSum-= freeArray[i];
                    i++;
                }

                maxSum = Math.max(maxSum,currSum);
            }

            return maxSum;



        // to debug
        //         System.out.println(Arrays.toString(freeArray));
        //   return 0;

    }
}