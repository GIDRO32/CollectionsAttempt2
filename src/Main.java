import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Player> playersTag = new ArrayList<Player>();
        Scanner key = new Scanner(System.in);
        boolean isTyping = true;
        String symbol = null;
        String option = null;
        int find = 1;
        System.out.println("Welcome to the Football Players collection app.");
        while (isTyping) {
            System.out.println("\nType a word to choose an option.");
            System.out.println("\nexit - exit program\nadd player - add player to the collection\nremove player - remove player from the collection\nprint - print all players\nsort - sort players by goals\nfind team- find players by team name\nfind nation - find players by nation\nfind name - find players by their names\nread - read collection elements from the file\nsave - save collection to file.");
            option = key.nextLine();

            if (option.toLowerCase().equals("exit")) {
                break;
            } else if (option.toLowerCase().equals("add player")) {
                System.out.println("Type a player data(name, surname, team-name, Player's nation, number of goals.)\nNote: if Team name or country has more than one word, divide them with a hyphen.\nFor example: Let-the-bodies-hit-the-floor");
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
                symbol = key.nextLine();
                Functions.findPlayerName(symbol, playersTag);
            }
            else if (option.toLowerCase().equals("find team"))
            {
                symbol = key.nextLine();
                Functions.findPlayerTeam(symbol, playersTag);
            }
            else if (option.toLowerCase().equals("find nation"))
            {
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
//            else if (option.toLowerCase().equals("find name"))
//            {
//                symbol = key.nextLine();
//                System.out.println(symbol);
//                players.findPlayerName(symbol);
//            }
        }
    }

}