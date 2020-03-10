import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PartyList {
    // Instances //

    private ArrayList<Party> parties = new ArrayList<>();

    // Constructors //

    // Methods //

    public String toString() {
        return "PartyList{" +
                "parties=" + parties +
                '}';
    }


    // Getters //

    public ArrayList<Party> getPartyList() {
        return parties;
    }

    // Setters //

    public void setParties(ArrayList<Party> parties) {
        this.parties = parties;
    }

    public void addParty(Party party) {
//      This should add the given party to the PartyList.
        parties.add(party);
    }

    public boolean removeParty(int index) {
        if (Utilities.validIndex(index, parties)) {

            parties.remove(index);
            return true;
        } else return false;
    }


    public Party getParty(int index) {
        if (Utilities.validIndex(index, parties)) {

            return parties.get(index);

        } else return null;
    }

    public String listOfParties() {
        String partyListString = "";
        for (int i = 0; i < parties.size(); i++) {
            partyListString = partyListString + i + ": " + parties.get(i).toString() + "\n";
        }
        return partyListString;
    }

    public int numberOfParties() {
        return parties.size();
    }

//    public String listPartiesBySpecificGenre(String genre){
//        String partyGenreString = "";
//        if (int i = 0; i < parties.size(); i++) {
//            partyGenreString = partyGenreString + i + ": " + parties.get(i).getPartyGenre().equalsIgnoreCase(genre) + "\n";
//        }
//        return toString();
//    }





    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("euApp.xml"));
        parties = (ArrayList<Party>) is.readObject();
        is.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("euApp.xml"));
        out.writeObject(parties);
        out.close();
    }
}


