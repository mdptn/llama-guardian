package mdptn.llamaguardian.DBclasses;

/**
 * Created by Megan on 5/12/2017.
 */

public class Shop {

    //setter and getter constructors for Shop table

    private int id;
    private String species;
    private String type;
    private String skill;
    private int hp;
    private int price;

    public void setID(int id){
        this.id = id;
    }

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

    public int getID(){
        return id;
    }

    public String getSpecies(){
        return species;
    }

    public String getType(){
        return type;
    }

    public String getSkill(){
        return skill;
    }

    public int getHP(){
        return hp;
    }

    public int getPrice(){
        return price;
    }

}
