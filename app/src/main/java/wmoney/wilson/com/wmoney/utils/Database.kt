package utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context) : SQLiteOpenHelper(context, "WMoney", null, 1) {

    public val userSQL: String = "create table if not exists user (id integer primary key autoincrement," +
            "name varchar(255) not null," +
            "email varchar(100) not null, " +
            "password varchar(10) not null)"

    public val financesSQL: String = "create table if not exists finances (id integer primary key autoincrement," +
            "year integer not null," +
            "month integer not null," +
            "id_user integer" +
            ")"

    public val expensesSQL: String = "create table if not exists expenses (id integer primary key autoincrement," +
            "value double not null," +
            "id_finances integer," +
            "increment boolean not null," +
            "date date not null)"

    override fun onCreate(db: SQLiteDatabase?) {

        // create database user
        print("QUERY - CREATE TABLE USER")
        db?.execSQL(this.userSQL)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // delete old database
        db?.execSQL("drop table user")

        // create database again
        onCreate(db)
    }
}