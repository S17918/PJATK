package pjatk.prm.s17918.managerfinansowykotlin.databases

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import androidx.annotation.RequiresApi
import pjatk.prm.s17918.managerfinansowykotlin.model.Event

@RequiresApi(Build.VERSION_CODES.P)
class DatabaseHelper(
    context: Context?,
    name: String?,
    version: Int,
    openParams: SQLiteDatabase.OpenParams
) : SQLiteOpenHelper(context, name, version, openParams) {

    private val EVENTS_TABLE = "EVENTS_TABLE"
    private val COLUMN_EVENT_PRICE = "EVENT_PRICE"
    private val COLUMN_EVENT_NAME = "EVENT_NAME"
    private val COLUMN_EVENT_DATE = "EVENT_DATE"
    private val COLUMN_EVENT_CATEGORY = "EVENT_CATEGORY"
    private val COLUMN_ID = "ID"



    override fun onCreate(database: SQLiteDatabase?) {
        val createTableStatement = "CREATE TABLE $EVENTS_TABLE ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_EVENT_PRICE TEXT, $COLUMN_EVENT_NAME TEXT, $COLUMN_EVENT_DATE TEXT, $COLUMN_EVENT_CATEGORY TEXT)"
        database?.execSQL(createTableStatement)
    }

    override fun onUpgrade(database: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun addOneEvent(event: Event): Boolean {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_EVENT_NAME, event.name)
        contentValues.put(COLUMN_EVENT_PRICE, event.price)
        contentValues.put(COLUMN_EVENT_DATE, event.date)
        contentValues.put(COLUMN_EVENT_CATEGORY, event.category)
        val insert = database.insert(EVENTS_TABLE, null, contentValues)
        return !insert.equals(-1)
    }

}