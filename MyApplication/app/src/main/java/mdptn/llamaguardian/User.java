package mdptn.llamaguardian;

/**
 * Created by Megan on 5/12/2017.
 */

public class User {

    //setter and getter constructors for User table

    private String name;
    private int money;


    public void setName(String name){
        this.name = name;
    }

    public void setMoney(int money){
        this.money = money;
    }

    public String getName(String name){
        return name;
    }

    public int getMoney(int money){
        return money;
    }

}
