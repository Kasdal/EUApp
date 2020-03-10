import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * <h1>EU App.!</h1>
 * Application to organize and sort multiple EU countries/parties
 * @author Milan PLes
 * @version 3.9
 * @since 13/03/2020
 */
public class EUDriver {

    private Scanner input = new Scanner(System.in);
    private ArrayList<Country> euCountries;

    private PartyList partyList;

    public EUDriver() {
        euCountries = new ArrayList<Country>();
        partyList = new PartyList();
        runMenu();
    }


    public static void main(String[] args) {
        new EUDriver();
    }

    /**
     * @return Scanner input aquired from the user.
     */
    private int mainMenu() {

        System.out.println("EU Menu");
        System.out.println("---------");
        System.out.println("  1) Add a country to EU");
        System.out.println("  2) Remove a country from EU");
        System.out.println("  3) Update an EU country's information");
        System.out.println("  4) List all the EU Countries");
        System.out.println("---------");
        System.out.println("Country Menu");
        System.out.println("  5) Add an MEP");
        System.out.println("  6) Remove an MEP");
        System.out.println("  7) Update the information on an MEP");
        System.out.println("  8) List all MEP's in this country");
        System.out.println("  --------------------");
        System.out.println("Party Menu");
        System.out.println("  9)  Add an New Party");
        System.out.println("  10) Remove a Party");
        System.out.println("  11) Update the Party Information");
        System.out.println("  12) List all parties");
        System.out.println("  --------------------");
        System.out.println("Report Menu");
        System.out.println("  13)  Print all the parties in the EU");
        System.out.println("  14)  Calculate and print the party with the most local Representatives");
        System.out.println("  15)  List all parties of a given Genre");
        System.out.println("  16)  List all MEP's of a given Party");
        System.out.println("  17)  Add an New Party");
        System.out.println("  --------------------");
        System.out.println("  18)  Save  to euApp.xml");
        System.out.println("  19)  load from euApp.xml");
        System.out.println("  0) Exit");
        return ScannerInput.readNextInt("==>>");

    }

    /**
     * Runs menu commands.
     * Calls save/load method for party list.
     */
    private void runMenu() {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    addCountry();
                    break;
                case 2:
                    deleteCountry();
                    break;
                case 3:
                    updateCountry();
                    break;
                case 4:
                    System.out.println(listCountries());
                    break;
                case 5:
                    addMEP();
                    break;

                case 6:
                    deleteMEP();
                    break;
                case 7:
                    updateMEP();
                    break;

                case 8:
                    listMEPSOfCountry();
                    break;

                case 9:
                    addParty();
                    break;

                case 10:
                    deleteParty();
                    break;

                case 11:
                    updateParty();
                    break;

                case 12:
                    System.out.print(partyList.listOfParties());
                    break;
                case 18:
                    try {
                        save();
                        partyList.save();
                    } catch (Exception e) {
                        System.err.println("Error writing to file: " + e);
                    }
                    break;
                case 19:
                    try {
                        load();
                        partyList.load();
                    } catch (Exception e) {
                        System.err.println("Error reading from file: " + e);
                    }
                    break;
            }
            option = mainMenu();
        }
    }

    /**
     *Asks the user to enter details
     * Creates the country object
     * Adds the object to an array
     */
    public void addCountry() {
        System.out.print("Enter the Country Name: ");
        String countryName = input.nextLine();

        int numberOfSeats = ScannerInput.readNextInt("Enter the number of seats: ");
        euCountries.add(new Country(countryName, numberOfSeats));
        //ask the user to enter the country details
        //create a country object
        //add that object to the euCountries array list
    }

    /**
     * Prints the list of elements in a array.
     * Preforms validity on indexes.
     * Removes an object from an array
     */
    public void deleteCountry() {
        System.out.println(listCountries());

        if (euCountries.size() > 0) {
            int index = ScannerInput.readNextInt("Enter the index of the Country to delete ==> ");
            if ((index >= 0) && (index < euCountries.size())) {

                euCountries.remove(index);
                System.out.println("Country deleted.");
            } else {
                System.out.println("There is no Country for this index number");
            }
        }
    }
    /**
     * Prints the list of elements in a array.
     * Preforms validity on indexes.
     * Calls a setter to preform an update.
     */
    public void updateCountry() {

        System.out.println(listCountries());

        if (euCountries.size() > 0) {
            int index = ScannerInput.readNextInt("Enter the index of the Country to update ==> ");
            if ((index >= 0) && (index < euCountries.size())) {

                int numMep = ScannerInput.readNextInt("Enter new number of MEPs.");
                euCountries.get(index).setNoMEPs(numMep);
            } else {
                System.out.println("This country is not recognised");
            }
        }
    }

    /**
     * Parses through an array, adds elements to a String list
     * @return String of Country list
     */
    public String listCountries() {
        String countryList = "";
        for (int i = 0; i < euCountries.size(); i++) {
            countryList = countryList + i + ": " + euCountries.get(i).toString() + "\n";
        }
        return countryList;
    }

    /**
     *  Prints the list of elements in a array.
     *  Preforms validity on indexes.
     *  Calls a setter to preform update on MEP's
     */
    public void addMEP() {
        System.out.println(listCountries());
        if (euCountries.size() > 0) {
            int index = ScannerInput.readNextInt("Enter the index of the Country to add MEP ==> ");
            if ((index >= 0) && (index < euCountries.size())) ;
            {
                System.out.print("Enter the MEP Name: ");
                String MEPName = input.nextLine();
                System.out.print("Enter a valid email :");
                String MEPEmail = input.nextLine();
                System.out.print("Enter the Phone Number :");
                String MEPPhone = input.nextLine();
                System.out.print("Enter MEP Party index");
                System.out.print(partyList.listOfParties());
                int partyIndex = ScannerInput.readNextInt("==> ");
                Party mepParty = partyList.getParty(partyIndex);
                Mep newMep = new Mep(MEPName,MEPEmail,MEPPhone, mepParty, partyList);
                euCountries.get(index).addMEP(newMep);

            }


        }
    }

    /**
     *  Prints the list of elements in a array.
     *  Preforms validity on indexes.
     *  Creates new country object and calls the getter of an index
     *  Validates the index and removes it from the list if valid.
     */
    public void  deleteMEP(){
        System.out.println(listCountries());if (euCountries.size() > 0) {
            int index = ScannerInput.readNextInt("Enter the index of the Country to list MEPs ==> ");
            if ((index >= 0) && (index < euCountries.size())) {
                Country newCountry = euCountries.get(index);
                System.out.println(newCountry.listOfMEPs());
                if (newCountry.numberOfMEPs() > 0) {
                    index = ScannerInput.readNextInt("Enter the index of the MEPs to delete ==> ");
                    if ((index >= 0) && (index < newCountry.numberOfMEPs())){

                        newCountry.removeMep(index);
                        System.out.println("Mep removed.");
                    } else {
                        System.out.println("There is no Mep for this index number");
                    }
                }

            }
        }

    }
    /**
     *  Prints the list of elements in a array.
     *  Preforms validity on indexes.
     *  Creates new country object and calls the getter of an index
     *  Validates the index.
     *  Calls the setter to update the Mep's
     */
    public void updateMEP(){
        System.out.println(listCountries());if (euCountries.size() > 0) {
            int index = ScannerInput.readNextInt("Enter the index of the Country to list MEPs ==> ");
            if ((index >= 0) && (index < euCountries.size())) {
                Country newCountry = euCountries.get(index);
                System.out.println(newCountry.listOfMEPs());
                if (newCountry.numberOfMEPs() > 0) {
                    index = ScannerInput.readNextInt("Enter the index of the MEPs to update ==> ");
                    if ((index >= 0) && (index < newCountry.numberOfMEPs())){
                    Mep mepUp = newCountry.getMeps().get(index);
                    if(mepUp != null){
                        System.out.println("new name");
                        String newName = input.nextLine();
                        mepUp.setMEPName(newName);
                        System.out.println("new email");
                        String newEmail = input.nextLine();
                        mepUp.setMEPEmail(newEmail);
                        System.out.println("new phone");
                        String newPhone = input.nextLine();
                        mepUp.setMEPPhone(newPhone);
                    }

                 }

                }
            }
        }
    }

    /**
     * Preforms validity on indexes.
     * Prints the list of elements in a array.
     * @return object with the list of MEP's
     */
    public String listMEPSOfCountry(){
       System.out.println(listCountries());
       if (euCountries.size() > 0) {
           int index = ScannerInput.readNextInt("Enter the index of the Country to list MEPs ==> ");
           if ((index >= 0) && (index < euCountries.size())) {
               Country newCountry = euCountries.get(index);
               return newCountry.listOfMEPs();
           } else return "No country at this index";
       }
        else return "No countries";
}


    public void addParty(){
        System.out.print("Enter the party name: ");
        String partyName = input.nextLine();
        System.out.print("Enter the name of the party leader: ");
        String partyLeader = input.nextLine();
        System.out.print("Define party genre: ");
        String partyGenre = input.nextLine();
        int numOfLocal =  ScannerInput.readNextInt("Number of local representatives: ");
        Party newParty = new Party(partyName, partyLeader, partyGenre, numOfLocal);
        partyList.addParty(newParty);


    }

    public void deleteParty(){
        System.out.println(partyList.listOfParties());

        if (partyList.numberOfParties() > 0) {
            int index = ScannerInput.readNextInt("Enter the index of the Party to delete ==> ");
               if(partyList.removeParty(index))
                     System.out.println("Party deleted.");
                else {
                    System.out.println("There is no Party for this index number");
                }
        }
    }

    public void updateParty(){
        System.out.println(partyList.listOfParties());
        if (partyList.numberOfParties() > 0) {
            int index = ScannerInput.readNextInt("Enter the index of the Party to update ==> ");
            Party partyToBeUpdated = partyList.getParty(index);
            if(partyToBeUpdated != null){

                //ask the user
            }
            else
                System.out.print("unknown");
        }
    }

    /**
     * @param
     */
    public void listOfParties(){
        System.out.print(partyList.listOfParties());

    }

//public String listPartyByGenre(){
//
//
//}




    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("euApp.xml"));
        euCountries = (ArrayList<Country>) is.readObject();
        is.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("euApp.xml"));
        out.writeObject(euCountries);
        out.close();
    }
}
