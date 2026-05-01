import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {

    int numgames = 58;
    int teasAmount = 10;
    
    Season season = new Season(numgames);
    
    // PARAM: set the filename to choose what data set gets analyzed
    File myObj = new File("all22.txt");
    try {
        Scanner myReader = new Scanner(myObj);
        int counter = 0;

        // throw out the first line
        String data = myReader.nextLine();
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
            season.addGame(data, counter++);
            //System.out.print("added game \n");
        }
        myReader.close();

        season.updateCashes(teasAmount);
        System.out.print(season.cashRate());
        return;
        
    }  catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    
    
}
} 

