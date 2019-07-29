package utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(context: Context) : SQLiteOpenHelper(context, "WMoney", null, 1) {

    public var name_database:String = "WMoney"

    public val userSQL: String = "create table if not exists user (id integer primary key autoincrement," +
            "name varchar(255) not null," +
            "email varchar(100) not null, " +
            "password varchar(10) not null)"

    public val expensesSQL: String = "create table if not exists expenses (id integer primary key autoincrement," +
            "value double not null," +
            "id_user integer references user(id)," +
            "increment boolean not null," +
            "date date not null)"

    override fun onCreate(db: SQLiteDatabase?) {

        // create table user
        print("QUERY - CREATE TABLE USER")
        db?.execSQL(this.userSQL)

        // create table expenses
        print("QUERY - CREATE TABLE Expenses")
        db?.execSQL(this.expensesSQL)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // delete old database
        db?.execSQL("drop table user")

        // create database again
        onCreate(db)
    }
}