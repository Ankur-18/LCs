class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int match =0;

        for(int i = 0,j =0 ; i<players.length && j<trainers.length ;j++ )
        {
            if(players[i] <= trainers[j])
            {
                match++;
                i++;
            }
        }

        return match;

    }
}