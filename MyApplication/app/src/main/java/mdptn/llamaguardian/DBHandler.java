package mdptn.llamaguardian;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.DatabaseUtils;

import mdptn.llamaguardian.DBclasses.User;
import mdptn.llamaguardian.DBclasses.Shop;
import mdptn.llamaguardian.DBclasses.Predator;
import mdptn.llamaguardian.DBclasses.Owned;

import java.util.ArrayList;
import java.util.List;

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
    private static final String SHOP_ID = "id";
    private static final String SHOP_SPECIES = "species";   //llama, goat, sheep, etc.
    private static final String SHOP_TYPE = "type";         //llama, livestock, item
    private static final String SHOP_SKILL = "skill";       //for llamas & items only
    private static final String SHOP_HP = "hp";             //for llamas & items
    private static final String SHOP_PRICE = "price";

    // Predator table fields
    private static final String PRED_ID = "id";
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
            SHOP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            SHOP_SPECIES + " TEXT," +
            SHOP_TYPE + " TEXT," +
            SHOP_SKILL + " TEXT," +
            SHOP_HP + " INT," +
            SHOP_PRICE + " INT," +
            ")";

    // create Predator table
    private static final String CREATE_TABLE_PREDATOR = "CREATE TABLE " + TABLE_PREDATOR +
            "(" +
            PRED_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
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


    //constructor
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


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



    // CRUD methods - create, retrieve(get), update, delete

    // User table =================================================================================
    // CREATE method
    public void createUser(User usr) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_NAME, usr.getName());
        values.put(USER_MONEY, usr.getMoney());

        long User_return = db.insert(TABLE_USER, null, values); //row id returned //-1 if error
    }

    // RETRIEVE method
    public User getUser(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_USER + " WHERE " + USER_NAME + " = " + name;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            c.moveToFirst();
        }

        User usr = new User();
        usr.setName(c.getString(c.getColumnIndex(USER_NAME)));
        usr.setMoney(c.getInt(c.getColumnIndex(USER_MONEY)));

        return usr;
    }

    // UPDATE method
    public void updateUser(User usr, String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_NAME, usr.getName());
        values.put(USER_MONEY, usr.getMoney());

        long User_returns = db.update(TABLE_USER, values, "name = " + name, null);
    }

    // DELETE method
    public void deleteUser(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_USER, USER_NAME + " = ?", new String[]{String.valueOf(name)});
    }

    // Shop table =================================================================================
    // CREATE method
    public void createShop(Shop sh) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SHOP_ID, sh.getID());
        values.put(SHOP_SPECIES, sh.getSpecies());
        values.put(SHOP_TYPE, sh.getType());
        values.put(SHOP_SKILL, sh.getSkill());
        values.put(SHOP_HP, sh.getHP());
        values.put(SHOP_PRICE, sh.getPrice());

        long Shop_return = db.insert(TABLE_SHOP, null, values); //row id returned //-1 if error
    }

    // RETRIEVE method
    public Shop getShop(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_USER + " WHERE " + SHOP_ID + " = " + id;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            c.moveToFirst();
        }

        Shop sh = new Shop();
        sh.setID(c.getInt(c.getColumnIndex(SHOP_ID)));
        sh.setSpecies(c.getString(c.getColumnIndex(SHOP_SPECIES)));
        sh.setType(c.getString(c.getColumnIndex(SHOP_TYPE)));
        sh.setSkill(c.getString(c.getColumnIndex(SHOP_SKILL)));
        sh.setHP(c.getInt(c.getColumnIndex(SHOP_HP)));
        sh.setPrice(c.getInt(c.getColumnIndex(SHOP_PRICE)));

        return sh;
    }

    // UPDATE method
    public void updateShop(Shop sh, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SHOP_ID, sh.getID());
        values.put(SHOP_SPECIES, sh.getSpecies());
        values.put(SHOP_TYPE, sh.getType());
        values.put(SHOP_SKILL, sh.getSkill());
        values.put(SHOP_HP, sh.getHP());
        values.put(SHOP_PRICE, sh.getPrice());

        long Shop_returns = db.update(TABLE_SHOP, values, "id = " + id, null);
    }

    // DELETE method
    public void deleteShop(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_SHOP, SHOP_ID + " = ?", new String[]{String.valueOf(id)});
    }

    // get all rows in Shop table
    public List<Shop> getAllShop() {
        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_SHOP;
        Cursor c = db.rawQuery(selectQuery, null);

        List<Shop> shl = new ArrayList<Shop>();
        if (c.moveToFirst()) {
            do {
                Shop sh = new Shop();
                sh.setID(c.getInt(c.getColumnIndex(SHOP_ID)));
                sh.setSpecies(c.getString(c.getColumnIndex(SHOP_SPECIES)));
                sh.setType(c.getString(c.getColumnIndex(SHOP_TYPE)));
                sh.setSkill(c.getString(c.getColumnIndex(SHOP_SKILL)));
                sh.setHP(c.getInt(c.getColumnIndex(SHOP_HP)));
                sh.setPrice(c.getInt(c.getColumnIndex(SHOP_PRICE)));
                shl.add(sh);
            } while (c.moveToNext());
        }

        return shl;
    }

    // Predator table =============================================================================
    // CREATE method
    public void createPredator(Predator pr) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PRED_ID, pr.getID());
        values.put(PRED_SPECIES, pr.getSpecies());
        values.put(PRED_SCARE, pr.getScare());
        values.put(PRED_DEFEAT, pr.getDefeat());

        long Predator_return = db.insert(TABLE_PREDATOR, null, values); //row id returned //-1 if error
    }

    // RETRIEVE method
    public Predator getPredator(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_PREDATOR + " WHERE " + PRED_ID + " = " + id;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            c.moveToFirst();
        }

        Predator pr = new Predator();
        pr.setID(c.getInt(c.getColumnIndex(PRED_ID)));
        pr.setSpecies(c.getString(c.getColumnIndex(PRED_SPECIES)));
        pr.setScare(c.getInt(c.getColumnIndex(PRED_SCARE)));
        pr.setDefeat(c.getInt(c.getColumnIndex(PRED_DEFEAT)));

        return pr;
    }

    // UPDATE method
    public void updatePredator(Predator pr, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PRED_ID, pr.getID());
        values.put(PRED_SPECIES, pr.getSpecies());
        values.put(PRED_SCARE, pr.getScare());
        values.put(PRED_DEFEAT, pr.getDefeat());

        long Predator_returns = db.update(TABLE_PREDATOR, values, "id = " + id, null);
    }

    // DELETE method
    public void deletePredator(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_PREDATOR, PRED_ID + " = ?", new String[]{String.valueOf(id)});
    }

    // Owned table ================================================================================
    // CREATE method
    public void createOwned(Owned ow) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(OWNED_ID, ow.getID());
        values.put(OWNED_NAME, ow.getName());
        values.put(OWNED_SPECIES, ow.getSpecies());
        values.put(OWNED_TYPE, ow.getType());
        values.put(OWNED_SKILL, ow.getSkill());
        values.put(OWNED_HP, ow.getHP());

        long Owned_return = db.insert(TABLE_OWNED, null, values); //row id returned //-1 if error
    }

    // RETRIEVE method
    public Owned getOwned(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_OWNED + " WHERE " + OWNED_ID + " = " + id;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            c.moveToFirst();
        }

        Owned ow = new Owned();
        ow.setID(c.getInt(c.getColumnIndex(OWNED_ID)));
        ow.setName(c.getString(c.getColumnIndex(OWNED_NAME)));
        ow.setSpecies(c.getString(c.getColumnIndex(OWNED_SPECIES)));
        ow.setType(c.getString(c.getColumnIndex(OWNED_TYPE)));
        ow.setSkill(c.getString(c.getColumnIndex(OWNED_SKILL)));
        ow.setHP(c.getInt(c.getColumnIndex(OWNED_HP)));

        return ow;
    }

    // UPDATE method
    public void updateOwned(Owned ow, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(OWNED_ID, ow.getID());
        values.put(OWNED_NAME, ow.getName());
        values.put(OWNED_SPECIES, ow.getSpecies());
        values.put(OWNED_TYPE, ow.getType());
        values.put(OWNED_SKILL, ow.getSkill());
        values.put(OWNED_HP, ow.getHP());

        long Owned_returns = db.update(TABLE_OWNED, values, "id = " + id, null);
    }

    // DELETE method
    public void deleteOwned(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_OWNED, OWNED_ID + " = ?", new String[]{String.valueOf(id)});
    }

    // get all rows in Owned table
    public List<Owned> getAllOwned() {
        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_OWNED;
        Cursor c = db.rawQuery(selectQuery, null);

        List<Owned> owl = new ArrayList<Owned>();
        if (c.moveToFirst()) {
            do {
                Owned ow = new Owned();
                ow.setID(c.getInt(c.getColumnIndex(OWNED_ID)));
                ow.setName(c.getString(c.getColumnIndex(OWNED_NAME)));
                ow.setSpecies(c.getString(c.getColumnIndex(OWNED_SPECIES)));
                ow.setType(c.getString(c.getColumnIndex(OWNED_TYPE)));
                ow.setSkill(c.getString(c.getColumnIndex(OWNED_SKILL)));
                ow.setHP(c.getInt(c.getColumnIndex(OWNED_HP)));
                owl.add(ow);
            } while (c.moveToNext());
        }

        return owl;
    }












}
