package com.mariofeles.appmaterialdesign.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.mariofeles.appmaterialdesign.model.Friend;
import java.sql.SQLException;

/**
 * Created by Mario Feles dos Santos Junior on 14/09/15.
 * DatabaseHelper class controler base
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper{
    private static final String databaseName = "appteste.db";
    private static final int databaseVersion = 1;

    public DatabaseHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sd,ConnectionSource cs) {
        try {
            TableUtils.createTable(cs, Friend.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sd, ConnectionSource cs, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(cs,Friend.class,true);
            onCreate(sd,cs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close() {
        super.close();
    }
}
