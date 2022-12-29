import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Player> playersTag = new ArrayList<Player>();//Stores Players
        Scanner key = new Scanner(System.in);//Variable to type
        boolean isTyping = true;
        String symbol = null;// <-- For searching
        String option = null;// <-- For choosing the function
        System.out.println("Welcome to the Football Players collection app.");
        while (isTyping) {
            System.out.println("\nType a word to choose an option.");
            System.out.println("\nexit - exit program\nadd player - add player to the collection\nremove player - remove player from the collection\nprint - print all players\nsort - sort players by goals\nfind team- find players by team name\nfind nation - find players by nation\nfind name - find players by their names\nread - read collection elements from the file\nsave - save collection to file.");
            option = key.nextLine();

            if (option.toLowerCase().equals("exit")) {
                break;
            } else if (option.toLowerCase().equals("add player")) {//Note: Everytime you press space you get to type next property
                System.out.println("Type a player data(name, surname, team-name, Player's nation, number of goals.)\nNote: type (;) to move to next property");
                String playerIn = key.nextLine();
                Player pl = new Player();
                pl.stringToProperties(playerIn);
                playersTag.add(pl);

            }
            if (option.toLowerCase().equals("print"))
            {
                for (int i = 0; i < playersTag.size(); i++)
                {
                    System.out.println("\nPlayer " + (i + 1) + ":");
                    playersTag.get(i).printFullInfo();
                }
            }
            else if (option.toLowerCase().equals("sort"))
            {
                Functions.sortPlayers(playersTag);
                for (int i = 0; i < playersTag.size(); i++) {
                    System.out.println("\nPlayer " + (i + 1) + ":");
                    playersTag.get(i).printFullInfo();
                }
            }
            else if (option.toLowerCase().equals("find name"))
            {
                System.out.println("Type a player's name(without surname):");
                symbol = key.nextLine();
                Functions.findPlayerName(symbol, playersTag);
            }
            else if (option.toLowerCase().equals("find team"))
            {
                System.out.println("Type the name of the team:");
                symbol = key.nextLine();
                Functions.findPlayerTeam(symbol, playersTag);
            }
            else if (option.toLowerCase().equals("find nation"))
            {
                System.out.println("Type the name of the country:");
                symbol = key.nextLine();
                Functions.findPlayerNation(symbol, playersTag);
            }
            else if(option.toLowerCase().equals("remove player"))
            {
                System.out.println("Enter the index of the player you want to remove.\nCurrent array size: " + playersTag.size());
                symbol = key.nextLine();
                playersTag.remove(Integer.parseInt(symbol) - 1);
            }
            else if(option.toLowerCase().equals("read"))
            {
                playersTag = Functions.readFile();
            }
            else if(option.toLowerCase().equals("save"))
            {
                Functions.saveToFile(playersTag);
            }
        }
    }

}