package rusi.myfootballstats;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rusi on 02/11/2016.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private String CreateTablePlayer = "CREATE TABLE jugador (_id INT PRIMARY KEY AUTOINCREMENT, nombre TEXT, apodo TEXT, edad INT, peso REAL, altura REAL);";
    private String CreateTableUser = "CREATE TABLE user (_id INT PRIMARY KEY AUTOINCREMENT, FOREIGN KEY(id_jugador) REFERENCES jugador(_id));";
    private String CreateTableTeam = "CREATE TABLE equipo (_id INT PRIMARY KEY AUTOINCREMENT, nombre_equipo TEXT);";
    private String CreateTableMatch = "CREATE TABLE partido (_id INT PRIMARY KEY AUTOINCREMENT, FOREIGN KEY(equipo_propio) REFERENCES equipo(_id), " +
            "FOREIGN KEY(equipo_rival) REFERENCES equipo(_id), fecha TEXT, ubicacion TEXT, resultado TEXT, goles_propios INT, asistencias_propias INT, " +
            "tarj_amarillas_propias INT, tarj_rojas_propias INT, posicion_propia TEXT, peso_propio REAL, minutos_jugados INT);";
    private String CreateTableMatchTeam = "CREATE TABLE equipo_partido (_id INT PRIMARY KEY AUTOINCREMENT, FOREIGN KEY(id_partido) REFERENCES partido(_id), " +
            "FOREIGN KEY(id_equipo) REFERENCES equipo(_id), FOREIGN KEY(id_jugador) REFERENCES jugador(_id));";

    public DataBaseHelper(Context context) {
        super(context, "DataBase.db", null, 1);
    }

    public void insertarJugador(String nombre, String apodo, int edad, double peso, double altura){

    }

    public void insertarUser(String nombre, String apodo, int edad, double peso, double altura){

    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateTablePlayer);
        db.execSQL(CreateTableUser);
        db.execSQL(CreateTableTeam);
        db.execSQL(CreateTableMatch);
        db.execSQL(CreateTableMatchTeam);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
