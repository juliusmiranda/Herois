package co.br.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class HeroiRepository {
    SQLiteDatabase db;
    public HeroiRepository(Context context){
        Conexao cn = new Conexao(context);
        db = cn.getWritableDatabase();
    }
    public void salvar(Heroi heroi){
        ContentValues valores = new ContentValues();
        valores.put("nome", heroi.getNome());
        valores.put("poder", heroi.getPoder());
        db.insert("herois", null, valores);
    }
    public ArrayList<Heroi> listarTodos(){
        ArrayList<Heroi> herois = new ArrayList<Heroi>();
        Cursor cur = db.rawQuery("SELECT * FROM herois", null);
        if(cur.moveToFirst()){
            do{
                Heroi h = new Heroi();
                h.setNome(cur.getString(0));
                h.setPoder(cur.getString(1));
                herois.add(h);
            }while (cur.moveToNext());
        }
        return herois;
    }
}
