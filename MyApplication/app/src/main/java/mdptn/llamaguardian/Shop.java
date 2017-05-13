package mdptn.llamaguardian;

/**
 * Created by Megan on 5/12/2017.
 */

public class Shop {

    //setter and getter constructors for Shop table

    private String species;
    private String type;
    private String skill;
    private int hp;
    private int price;


    public void setSpecies(String species){
        this.species = species;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setSkill(String skill){
        this.skill = skill;
    }

    public void setHP(int hp){
        this.hp = hp;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public String getSpecies(String species){
        return species;
    }

    public String getType(String type){
        return type;
    }

    public String getSkill(String skill){
        return skill;
    }

    public int getHP(int hp){
        return hp;
    }

    public int getPrice(int price){
        return price;
    }

}
