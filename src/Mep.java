public class Mep
{
    // Instances //

    private String MEPName;
    private String MEPEmail;
    private String MEPPhone;
    private Party MEPParty;

    // Constructors //

    public Mep (String MEPName, String MEPEmail, String MEPPhone, Party MEPParty,PartyList Plist)
    {
        this.MEPName = Utilities.max30Chars(MEPName);
        if(Utilities.validEmail(MEPEmail))
            this.MEPEmail = MEPEmail;
        else this.MEPEmail ="invalid format email. Needs to contain . and @";
        if (Utilities.onlyContainsNumbers(MEPPhone))
            this.MEPPhone = MEPPhone;
        else this.MEPPhone = "unknown";
        this.MEPParty = Utilities.validParty(MEPParty.getPartyName(),Plist);
    }

    // Methods //

    public String toString() {
        return "Mep{" +
                "MEPName='" + MEPName + '\'' +
                ", MEPEmail='" + MEPEmail + '\'' +
                ", MEPPhone='" + MEPPhone + '\'' +
                ", MEPParty=" + MEPParty +
                '}';
    }

    // Getters //

    public String getMEPName()
    {
        return MEPName;
    }

    public String getMEPEmail()
    {
        return MEPEmail;
    }

    public String getMEPPhone()
    {
        return MEPPhone;
    }

    public Party getMEPParty()
    {
        return MEPParty;
    }


    // Setters //

    public void setMEPName(String MEPName)
    {
        this.MEPName = MEPName;
    }

    public void setMEPEmail(String MEPEmail)
    {
        this.MEPEmail = MEPEmail;
    }

    public void setMEPPhone(String MEPPhone)
    {
        this.MEPPhone = MEPPhone;
    }

    public void setMEPParty(Party MEPParty)
    {
        this.MEPParty = MEPParty;
    }
}
