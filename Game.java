

public class Game {
    public String away;
    public String home;
    public double spread;
    public double overUnder;
    public double awayScore;
    public double homeScore;
    public boolean cashedUnder;
    public boolean cashedOver; 
    public boolean cashedMiddleTwelve;
    // public boolean divisional;
    // public boolean primetime;

    public Game(String a, String h, String s, String ou, String as, String hs) {
        away = a;
        home = h;
        spread = Double.parseDouble(s);
        overUnder = Double.parseDouble(ou);
        awayScore = Double.parseDouble(as);
        homeScore = Double.parseDouble(hs);
        cashedUnder = false;
        cashedOver = false;
        cashedMiddleTwelve = false;
    }

    // under
    public void didItCashUnder(double teasAmount) {
        // away
        if (awayScore - spread + teasAmount > homeScore) {
            if (homeScore + spread + teasAmount > awayScore) {
                if (overUnder + teasAmount > awayScore + homeScore) {
                    this.cashedUnder = true;
                }
            }
        }
    }

    // over
    public void didItCashOver(double teasAmount) {
        if ((awayScore - spread) + teasAmount > homeScore) {
            if (homeScore + spread + teasAmount > awayScore) {
                if (overUnder - teasAmount < awayScore + homeScore) {
                    this.cashedOver = true;
                }
            }
        }
    }

    public void didItCashMiddle() {
        if ((awayScore - spread) + 12 > homeScore) {
            if (homeScore + spread + 12 > awayScore) {
                this.cashedMiddleTwelve = true;
            }
        }
    }

}