package mdptn.llamaguardian;

/**
 * Created by Megan on 5/12/2017.
 */

public class Owned {

    //setter and getter constructors for Owned table

    private int id;
    private String name;
    private String species;
    private String type;
    private String skill;
    private int hp;


    public void setID(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
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

    public int getID(int id){
        return id;
    }
    
    public String getName(String name){
        return name;
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

}
