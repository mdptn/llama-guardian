package mdptn.llamaguardian.DBclasses;

/**
 * Created by Megan on 5/12/2017.
 */

public class Predator {

    //setter and getter constructors for Predator table

    private int id;
    private String species;
    private int scare_reward;
    private int defeat_reward;


    public void setID(int id){
        this.id = id;
    }

    public void setSpecies(String species){
        this.species = species;
    }

    public void setScare(int scare_reward){
        this.scare_reward = scare_reward;
    }

    public void setDefeat(int defeat_reward){
        this.defeat_reward = defeat_reward;
    }

    public int getID(){
        return id;
    }

    public String getSpecies(){
        return species;
    }

    public int getScare(){
        return scare_reward;
    }

    public int getDefeat(){
        return defeat_reward;
    }

}
