public class Party
{
    // Instances //

    private String partyName;
    private String partyLeader;
    private String partyGenre;
    private int numLocalReps;

    // Constructors //

    public Party (String partyName, String partyLeader, String partyGenre, int numLocalReps)
    {
        this.partyName = Utilities.max30Chars(partyName);
        this.partyLeader = partyLeader;
        this.partyGenre = Utilities.validGenre(partyGenre);
        if(Utilities.validIntNonNegative(numLocalReps))
            this.numLocalReps = numLocalReps;
        else
            this.numLocalReps = 0;
    }

    // Methods //

    public String toString()
    {
        return "Party{" +
                "partyName='" + partyName + '\'' +
                ", partyLeader='" + partyLeader + '\'' +
                ", partyGenre='" + partyGenre + '\'' +
                ", numLocalReps=" + numLocalReps +
                '}';
    }

    // Getters //

    public String getPartyName()
    {
        return partyName;
    }

    public String getPartyLeader()
    {
        return partyLeader;
    }

    public String getPartyGenre()
    {
        return partyGenre;
    }

    public int getNumLocalReps()
    {
        return numLocalReps;
    }

    // Setters //

    public void setPartyName(String partyName)
    {
        this.partyName = partyName;
    }

    public void setPartyLeader(String partyLeader)
    {
        this.partyLeader = partyLeader;
    }

    public void setPartyGenre(String partyGenre)
    {
        this.partyGenre = partyGenre;
    }

    public void setNumLocalReps(int numLocalReps)
    {
        this.numLocalReps = numLocalReps;
    }
}
