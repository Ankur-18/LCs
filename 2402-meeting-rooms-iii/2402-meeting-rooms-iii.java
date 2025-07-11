class Solution {
    public int mostBooked(int n, int[][] meetings) {

        //sort given event array based on starting time 
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        long[] lastAvlblAt = new long[n];
        int[] roomCount = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;
            long earlyEndRoomTime = Long.MAX_VALUE;
            int earlyEndRoom = 0;
            boolean found = false;

            //Finding first avlbl room for currrent meeting
            for (int room = 0; room < n; room++) {

                if (lastAvlblAt[room] <= start) { // if Room milgya
                    lastAvlblAt[room] = end;
                    roomCount[room]++;
                    found = true;
                    break; //room mil gya to, then no need to check further
                }

                //if room nahi mila then prepare... we need to store next avbl room ,
                // jo sbse phle end hone vala hai jo ki aage not found vaale case me use hoga..

                if (lastAvlblAt[room] < earlyEndRoomTime) {
                    earlyEndRoomTime = lastAvlblAt[room]; //minimu Time;
                    earlyEndRoom = room; //index of that room with minmal Time

                }

            }

            //If room nahi mila 
            if (!found) {
                lastAvlblAt[earlyEndRoom] += duration; //nahi mila to slect that room ka index which ha minimal time, 
                                                       // which we have already found above ( earlyEndRoomTime[minmalTime]  && earlyEndRoom[index] )

                roomCount[earlyEndRoom]++; // use room ka no of time of usage bi update krna hoga;
            }

        }

        //Now ,hmko use room ka index returna krna hai ( count nahi return krna hai ) jo room room ka count sabe jada hai ..

        int resultRoom = -1;
        int maxUse = 0;

        for (int room = 0; room < n; room++) {
            if (roomCount[room] > maxUse) {
                maxUse = roomCount[room];
                resultRoom = room;
            }
        }

        return resultRoom;
    }
}