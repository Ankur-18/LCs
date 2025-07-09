class Solution {
    int n;
    int[][] t;

    public int maxValue(int[][] events, int k) {

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0])); //sorting based on start time of events
        n = events.length;

        t = new int[n + 1][k + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return solve(events, 0, k);
    }

    public int solve(int[][] events, int i, int k) {
        if (i >= n || k == 0) {
            return 0;
        }

        if(t[i][k]!=-1)
        {
            return t[i][k];
        }

        int start = events[i][0];
        int end = events[i][1];
        int value = events[i][2];

        int skip = solve(events, i + 1, k);

       // int j = i + 1;
        // for (; j < n; j++) {
        //     if (events[j][0] > events[i][1]) {
        //         break;
        //     }
        // }

        int j = findNextEvent(events,end);
        
        int take = value + solve(events, j, k - 1);

        return t[i][k] = Math.max(skip, take);
    }

    public int findNextEvent(int[][]events , int targetEndTime)
    {
        int low = 0;
        int high = n - 1;
        int ans = n; // Default to n if no such event is found (all events end before or at targetEndTime)

        while (low <= high) {
            int mid = low + (high - low) / 2;
          
            if (events[mid][0] > targetEndTime) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}