
// Class for storing the information of one player
public class Player
{
    public String name;
    public String surname;
    public String teamName;
    public String nation;
    public int goals;
    public void printFullInfo()
    {
        System.out.println("Full Name: " + name + " " + surname + "\nTeam Name: " + teamName + "\nNation: " + nation + "\nGoals: " + goals);
    }
    public void stringToProperties(String playerTag)
    {
        String[] playerArr = playerTag.trim().split(" ");
        this.name = playerArr[0];
        this.surname = playerArr[1];
        this.teamName = playerArr[2];
        this.nation = playerArr[3];
        this.goals = Integer.parseInt(playerArr[4]);
    }
}