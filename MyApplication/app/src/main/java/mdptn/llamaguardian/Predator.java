package mdptn.llamaguardian;

/**
 * Created by Megan on 5/12/2017.
 */

public class Predator {

    //setter and getter constructors for Predator table

    private String species;
    private int scare_reward;
    private int defeat_reward;


    public void setSpecies(String species){
        this.species = species;
    }

    public void setScare(int scare_reward){
        this.scare_reward = scare_reward;
    }

    public void setDefeat(int defeat_reward){
        this.defeat_reward = defeat_reward;
    }

    public String getSpecies(String species){
        return species;
    }

    public int getScare(int scare_reward){
        return scare_reward;
    }

    public int getDefeat(int defeat_reward){
        return defeat_reward;
    }

}
