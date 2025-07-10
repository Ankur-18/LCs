class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int result = 0;
        int n = startTime.length;
        int[] freeArray = new int[n + 1];

        freeArray[0] = startTime[0];
        freeArray[n] = eventTime - endTime[n - 1];

        for (int i = 1; i < n; i++) {
            freeArray[i] = startTime[i] - endTime[i - 1];
        }

        int m = freeArray.length;
        int[] maxFreeLeft = new int[m];
        int[] maxFreeRight = new int[m];

        //Precomputing maxFreeLeft

        for (int i = 1; i < m; i++) // tyraverse from start 
        {
            maxFreeLeft[i] = Math.max(maxFreeLeft[i-1], freeArray[i - 1]);
        }

        //Precomputing maxFreeRight

        for (int i = m - 2; i >= 0; i--) // traverse from end 
        {
            maxFreeRight[i] = Math.max(maxFreeRight[i+1], freeArray[i + 1]);
        }

        //calculating each possible movement ( tarvers the freeArray calculated above as based on that array only we can perfom operation on free(gap) parts )

        for (int i = 1; i < m; i++) {
            int d = endTime[i - 1] - startTime[i - 1]; // i -1 because u are traversing based on gap array and event will be one previosu index than current gap 

            //Case1 = complete movement of event 

            if (d <= Math.max(maxFreeLeft[i - 1], maxFreeRight[i])) // if d(event size) is less than maximum possible sapce avlbl on left or right , then we can place(move) event to that free place
            {
                result = Math.max(result, freeArray[i - 1] + d + freeArray[i]); //then total avlb gap would be of size of current event(d) + gap left to moved event(freeArray[i-1]) + gap right to moved event(freeArray[i]), which is basically current index where u are standing
            } // max because we have to return maximum possibkle result             

            //Case2; Shifting of event left or right only 

            result = Math.max(result, freeArray[i - 1] + freeArray[i]); // if shfing only possble thing will be to combine leth of left gap (freeArray[i-1]) and right gap (freeArray[i-1]) 

            // here case2  is not in else condition becase we have to find the value from both the possible cases so as to return the max.
        }

        return result;

    }
}