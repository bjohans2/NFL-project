
public class Season {
    /**
     * read in a file of all of the games, make an array of length n where n = games in file.
     * create a new game for each line and add the game to the array. 
     */

    private Game[] games;
    private int numGames;
    Season(int n) {
        games = new Game[n];
        numGames = n;
    }

    public void addGame(String line, int count) {
        // get a line of text, create game, add game at count
        String arr[] = line.split("\\s+", 6);
        //System.out.print(line);
        //System.out.print(arr[0] + arr[1] + arr[2] + arr[3] + arr[4] + arr[5] + "\n");
        this.games[count] = new Game(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
    }

    public Game[] getGames() {
        return this.games;
    }

    public String cashRate() {
        double underCount = 0.0;
        double overCount = 0.0;
        double middleTwelveCount = 0.0;
        double fourWayCount = 0.0;
        for (int i = 0; i < numGames; i++) {
            if (this.games[i].cashedUnder) {
                //System.out.println("UNDER CASH:" + this.games[i].away + " " + this.games[i].home);
                underCount++;
            } 
            if (this.games[i].cashedOver) {
                //System.out.println("OVER CASH:" + this.games[i].away + " " + this.games[i].home);
                overCount++;
            }
            if (this.games[i].cashedMiddleTwelve) {
                middleTwelveCount++;
            } if (this.games[i].cashedUnder && this.games[i].cashedOver) {
                fourWayCount++;
            }
        }

        double upercent = (underCount / (double)numGames) * 100.0;
        double opercent = (overCount / (double)numGames) * 100.0;
        double mpercent = (middleTwelveCount / (double)numGames) * 100.0;
        double fpercent = (fourWayCount / (double)numGames) * 100.0;
        return "Middle + alt under: Cash rate is " + underCount + " out of " + numGames + ": " + upercent + "%" + "\n" + 
               "Middle + alt over: Cash rate is " + overCount + " out of " + numGames + ": " + opercent + "%" + "\n" + 
               "Middle +12: Cash rate is " + middleTwelveCount + " out of " + numGames + ": " + mpercent + "%" + "\n" +
               "Four way +12: Cash rate is " + fourWayCount + " out of " + numGames + ": " + fpercent + "%" + "\n";
    }

    public void updateCashes(double teasAmount) {
        for (int i = 0; i < numGames; i++) {
            this.games[i].didItCashOver(teasAmount);
            this.games[i].didItCashUnder(teasAmount);
            this.games[i].didItCashMiddle(); // hard set to 12

        }
    }

}
