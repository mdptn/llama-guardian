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
    private static final String TABLE_LLAMA = "llama";
    private static final String TABLE_LIVESTOCK = "livestock";
    private static final String TABLE_PREDATOR = "predator";
    private static final String TABLE_OWNED_LLAMA = "owned_llama";
    private static final String TABLE_OWNED_LIVESTOCK = "owned_livestock";

    // Llama table fields
    private static final String LLAMA_SPECIES = "species";
    private static final String LLAMA_TYPE = "type";
    private static final String LLAMA_SKILL = "skill";
    private static final String LLAMA_PRICE = "price";

    // Livestock table fields
    private static final String LIVE_SPECIES = "species";
    private static final String LIVE_PRICE = "price";

    // Predator table fields
    private static final String PRED_SPECIES = "species";
    private static final String PRED_SCARE = "scare_reward";
    private static final String PRED_DEFEAT = "defeat_reward";

    // Owned Llama fields
    private static final String OLLAMA_ID = "id";
    private static final String OLLAMA_NAME = "name";
    private static final String OLLAMA_SPECIES = "species";
    private static final String OLLAMA_TYPE = "type";
    private static final String OLLAMA_SKILL = "skill";
    private static final String OLLAMA_PRICE = "price";

    // Owned Livestock table fields
    private static final String OLIVE_ID = "id";
    private static final String OLIVE_SPECIES = "species";



    // create Llama table
    private static final String CREATE_TABLE_LLAMA = "CREATE TABLE " + TABLE_LLAMA +
            "(" +
            LLAMA_SPECIES + " TEXT," +
            LLAMA_TYPE + " TEXT," +
            LLAMA_SKILL + " TEXT," +
            LLAMA_PRICE + " INT," +
            ")";

    // create Livestock table
    private static final String CREATE_TABLE_LIVESTOCK = "CREATE TABLE " + TABLE_LIVESTOCK +
            "(" +
            LIVE_SPECIES + " TEXT," +
            LIVE_PRICE + " INT," +
            ")";

    // create Predator table
    private static final String CREATE_TABLE_PREDATOR = "CREATE TABLE " + TABLE_PREDATOR +
            "(" +
            PRED_SPECIES + " TEXT," +
            PRED_SCARE + " INT," +
            PRED_DEFEAT + " INT," +
            ")";

    // create Owned Llama table
    private static final String CREATE_TABLE_OWNED_LLAMA = "CREATE TABLE " + TABLE_OWNED_LLAMA +
            "(" +
            OLLAMA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            OLLAMA_NAME + " TEXT," +
            OLLAMA_SPECIES + " TEXT," +
            OLLAMA_TYPE + " TEXT," +
            OLLAMA_SKILL + " TEXT," +
            OLLAMA_PRICE + " INT," +
            ")";

    // create Owned Livestock table
    private static final String CREATE_TABLE_OWNED_LIVESTOCK = "CREATE TABLE " + TABLE_OWNED_LIVESTOCK +
            "(" +
            OLIVE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            OLIVE_SPECIES + " TEXT," +
            ")";



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_LLAMA);
        db.execSQL(CREATE_TABLE_LIVESTOCK);
        db.execSQL(CREATE_TABLE_PREDATOR);
        db.execSQL(CREATE_TABLE_OWNED_LLAMA);
        db.execSQL(CREATE_TABLE_OWNED_LIVESTOCK);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_LLAMA);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIVESTOCK);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PREDATOR);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_OWNED_LLAMA);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_OWNED_LIVESTOCK);
            onCreate(db);
        }
    }

}
