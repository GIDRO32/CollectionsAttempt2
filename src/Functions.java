import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Functions
{
    public static void sortPlayers(ArrayList<Player> players)
    {
        boolean isSorted = false;
        int outIterations = 0;

        while (!isSorted)
        {
            isSorted = true;

            for (int j = 0; j < players.size() - outIterations - 1; j++)
            {
                if (players.get(j).goals > players.get(j + 1).goals)
                {
                    isSorted = false;
                    // Swap the elements
                    Player temp = players.get(j);
                    players.set(j, players.get(j + 1));
                    players.set(j + 1, temp);
                }

            }
            outIterations++;
        }
    }
    public static void findPlayerName(String searchKey, ArrayList<Player> players)
    {
        for (int i = 0; i < players.size(); i++)
        {
            if (players.get(i).name.toLowerCase().contains(searchKey.toLowerCase()))
            {
                System.out.println("Player " + (i + 1) +":");
                players.get(i).printFullInfo();
            }
        }
    }
    public static ArrayList<Player> readFile() throws FileNotFoundException {
        FileInputStream myFile = new FileInputStream("myCollection.txt");
        Scanner myFileReader = new Scanner(myFile);
        ArrayList<String> reader = new ArrayList<String>();
        int line_count = 0;
        while (myFileReader.hasNextLine())
        {
            String current_line = myFileReader.nextLine();
            reader.add(current_line);;
        }
        for(int i = 0; i < reader.size()/4; i++)
        {
            for(int j = i; j < i+4; j++)
            {
                reader.get(j + 1).trim();
            }
        }
        myFileReader.close();
        return new ArrayList<Player>();
    }
    public static void saveToFile(ArrayList<Player> players) throws FileNotFoundException {
        FileOutputStream myFileW = new FileOutputStream("myCollection.txt");
        PrintWriter myFileWriter = new PrintWriter(myFileW);
        for(int i = 0; i < players.size(); i++)
        {
            myFileWriter.println("Player " + (i + 1) + ":");
            myFileWriter.println("Full name: " + players.get(i).name + " " + players.get(i).surname);
            myFileWriter.println("Team Name: " + players.get(i).teamName);
            myFileWriter.println("Goals: " + players.get(i).goals);
        }
        myFileWriter.close();
    }
}
