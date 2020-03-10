import java.util.ArrayList;

public class Country
{
    // Instances //

    private String name;
    private ArrayList<Mep> meps;
    private int noMEPs;

    // Constructors //

    public Country (String name, int noMEPs)
    {
        this.name = Utilities.max30Chars(name);
        this.noMEPs = noMEPs;
    }

    // Methods //

    public String toString()
    {
        return "Country{" +
                "name='" + name + '\'' +
                ", meps=" + meps +
                ", noMEPs=" + noMEPs +
                '}';
    }
    public void addMEP(Mep mepObject){
        meps.add(mepObject);
    }
    public boolean removeMep(int delMep){
        if (Utilities.validIndex(delMep, meps)){
            meps.remove(delMep);
            return true;
        }
        else return false;
    }

    public String listOfMEPs(){
        String mepList = "";
        for (int i = 0; i < meps.size(); i++) {
            mepList = mepList + i + ": " + meps.get(i).toString() + "\n";
        }
        return mepList;
    }

    int numberOfMEPs(){
        return meps.size();
    }

    // Getters //

    public String getName()
    {
        return name;
    }

    public ArrayList<Mep> getMeps()
    {
        return meps;
    }

    public int getNoMEPs()
    {
        return noMEPs;
    }

    // Setters //

    public void setName(String name)
    {
        this.name = name;
    }

    public void setMeps(ArrayList<Mep> meps)
    {
        this.meps = meps;
    }

    public void setNoMEPs(int noMEPs)
    {
        this.noMEPs = noMEPs;
    }
}
