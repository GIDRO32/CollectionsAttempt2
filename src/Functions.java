import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//Class for repeating "Player" class
public class Functions
{
    public static void sortPlayers(ArrayList<Player> players)// <-- Sorting players by number of goals(from smallest to highest)
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
    public static void findPlayerName(String searchKey, ArrayList<Player> players)//Search players by their own names
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
    public static void findPlayerTeam(String searchKey, ArrayList<Player> players)//Search players by teams they are playing in
    {
        for (int i = 0; i < players.size(); i++)
        {
            if (players.get(i).teamName.toLowerCase().contains(searchKey.toLowerCase()))
            {
                System.out.println("Player " + (i + 1) +":");
                players.get(i).printFullInfo();
            }
        }
    }
    public static void findPlayerNation(String searchKey, ArrayList<Player> players)//Search players by countries, where they are from
    {
        for (int i = 0; i < players.size(); i++)
        {
            if (players.get(i).teamName.toLowerCase().contains(searchKey.toLowerCase()))
            {
                System.out.println("Player " + (i + 1) +":");
                players.get(i).printFullInfo();
            }
        }
    }
    public static ArrayList<Player> readFile() throws FileNotFoundException {//To read collection items from the file and then print
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<String> reader = new ArrayList<String>();

        FileInputStream myFile = new FileInputStream("myCollection.txt");
        Scanner myFileReader = new Scanner(myFile);

        while (myFileReader.hasNextLine())
        {
            String current_line = myFileReader.nextLine();
            reader.add(current_line);;
        }

        for(int i = 0; i < reader.size(); i += 5)
        {

            Player p = new Player();

            String[] args = reader.get(i + 1).split(" ");
            p.name = args[2];
            p.surname = args[3];

            args = reader.get(i + 2).split(" ");
            p.teamName = args[2];

            args = reader.get(i + 3).split(" ");
            p.nation = args[2];

            args = reader.get(i + 4).split(" ");
            p.goals = Integer.parseInt(args[1]);

            players.add(p);
        }
        myFileReader.close();
        return players;
    }
    public static void saveToFile(ArrayList<Player> players) throws FileNotFoundException //To save items to the collection
    {
        FileOutputStream myFileW = new FileOutputStream("myCollection.txt");
        PrintWriter myFileWriter = new PrintWriter(myFileW);
        for (int i = 0; i < players.size(); i++) {
            myFileWriter.println("Player " + (i + 1) + ":");
            myFileWriter.println("Full name: " + players.get(i).name + " " + players.get(i).surname);
            myFileWriter.println("Team Name: " + players.get(i).teamName);
            myFileWriter.println("Player nation: " + players.get(i).nation);
            myFileWriter.println("Goals: " + players.get(i).goals);
        }
        myFileWriter.close();
    }
    }
