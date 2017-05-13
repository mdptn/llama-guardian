package mdptn.llamaguardian;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Megan on 5/11/2017.
 */
public class DBHandler extends SQLiteOpenHelper{


    private static final String DATABASE_NAME = "LGdatabase";
    private static final int DATABASE_VERSION = 1;


    // Game Tables

    private static final String TABLE_USER = "user";
    private static final String TABLE_SHOP = "shop";
    private static final String TABLE_PREDATOR = "predator";
    private static final String TABLE_OWNED = "owned";


    // User table fields
    private static final String USER_NAME = "name";
    private static final String USER_MONEY = "money";

    // Shop table fields
    private static final String SHOP_SPECIES = "species";   //llama, goat, sheep, etc.
    private static final String SHOP_TYPE = "type";         //llama, livestock, item
    private static final String SHOP_SKILL = "skill";       //for llamas & items only
    private static final String SHOP_HP = "hp";             //for llamas & items
    private static final String SHOP_PRICE = "price";

    // Predator table fields
    private static final String PRED_SPECIES = "species";
    private static final String PRED_SCARE = "scare_reward";
    private static final String PRED_DEFEAT = "defeat_reward";

    // Owned table fields
    private static final String OWNED_ID = "id";            //unique id
    private static final String OWNED_NAME = "name";        //for only llama/alpaca
    private static final String OWNED_SPECIES = "species";  //llama,sheep,etc
    private static final String OWNED_TYPE = "type";        //llama, livestock, item
    private static final String OWNED_SKILL = "skill";      //for llamas & items
    private static final String OWNED_HP = "hp";             //for llamas & items



    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_SHOP +
            "(" +
            USER_NAME + " TEXT," +
            USER_MONEY + " INT," +
            ")";

    private static final String CREATE_TABLE_SHOP = "CREATE TABLE " + TABLE_SHOP +
            "(" +
            SHOP_SPECIES + " TEXT," +
            SHOP_TYPE + " TEXT," +
            SHOP_SKILL + " TEXT," +
            SHOP_HP + " INT," +
            SHOP_PRICE + " INT," +
            ")";

    // create Predator table
    private static final String CREATE_TABLE_PREDATOR = "CREATE TABLE " + TABLE_PREDATOR +
            "(" +
            PRED_SPECIES + " TEXT," +
            PRED_SCARE + " INT," +
            PRED_DEFEAT + " INT," +
            ")";

    // create Owned  table
    private static final String CREATE_TABLE_OWNED = "CREATE TABLE " + TABLE_OWNED +
            "(" +
            OWNED_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            OWNED_NAME + " TEXT," +
            OWNED_SPECIES + " TEXT," +
            OWNED_TYPE + " TEXT," +
            OWNED_SKILL + " TEXT," +
            OWNED_HP + " INT," +
            ")";




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        db.execSQL(CREATE_TABLE_SHOP);
        db.execSQL(CREATE_TABLE_PREDATOR);
        db.execSQL(CREATE_TABLE_OWNED);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOP);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PREDATOR);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_OWNED);
            onCreate(db);
        }
    }

}
