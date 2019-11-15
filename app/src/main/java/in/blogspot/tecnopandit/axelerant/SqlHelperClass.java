package in.blogspot.tecnopandit.axelerant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SqlHelperClass extends SQLiteOpenHelper {
    public static final String dbname="poll.db";
    public static final String tablename="pollresult";
    public static final String option1="option1";
    public static final String option2="option2";
    public static final String option3="option3";
    public static final String option4="option4";
    public SqlHelperClass(@Nullable Context context) {
        super(context, dbname, null, 1);
        SQLiteDatabase dbase=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table pollresult (id integer primary key autoincrement , option1 integer ,option2 integer, option3 integer, option4 integer)");
        ContentValues cv=new ContentValues();
        cv.put("option1",0);
        cv.put("option2",0);
        cv.put("option3",0);
        cv.put("option4",0);
        Long res=db.insert(tablename,null,cv);
        Log.i("If inserted:::::::::",res.toString());
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists pollresult");
    }
    public long insert(String cname)
    {
        int value=0;
        SQLiteDatabase dbase=this.getWritableDatabase();
        String qry="Select * from pollresult where id=1";
        Cursor cursor=dbase.rawQuery(qry,null);
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            value=cursor.getInt(cursor.getColumnIndex(cname));
        }
        ContentValues cv=new ContentValues();
        cv.put(cname,value+1);
        //long res=dbase.insert(tablename,null,cv);
        long res =dbase.update(tablename,cv,"",null);
        return res;
    }
    public String getval()
    {
        int a=0,b=0,c=0,d=0;
        SQLiteDatabase db=this.getWritableDatabase();
        String qry="Select * from pollresult where id=1";
        Cursor cursor=db.rawQuery(qry,null);
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            a=cursor.getInt(1);
            b=cursor.getInt(2);
            c=cursor.getInt(3);
            d=cursor.getInt(4);
        }
        String result="Android: "+a+"\nPHP: "+b+"\nServlet: "+c+"\nXcode: "+d;
        return result;
    }
}
