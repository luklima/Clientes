package com.example.lucca.clientes;

/**
 * Created by LuccaGonçalo on 30/04/2015.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBase extends SQLiteOpenHelper {
    private static final String BANCO_DADOS = "BancoLucca";
    private static final int VERSAO = 1;

    public static final class CLIENTE {
        public static final String TABELA = "cliente";
        public static final String _ID = "_id";
        public static final String NOME = "nome";
        public static final String CPF = "cpf";
        public static final String RG = "rg";
        public static final String END = "end";
        public static final String BAIRRO = "bairro";
        public static final String CIDADE = "cidade";
        public static final String UF = "uf";
        public static final String NOMEPAI = "nomePai";
        public static final String NOMEMAE = "nomeMae";
        public static final String DATADENASCIMENTO = "dataDeNascimento";
        public static final String LOCALDENASCIMENTO = "localDeNascimento";


    }

    public DataBase(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE cliente(" +
                 "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                CLIENTE.NOME              +  " TEXT NOT NULL,"  +
                CLIENTE.CPF               +  " TEXT NOT NULL, "  +
                CLIENTE.RG                +  " INTEGER NOT NULL,"+
                CLIENTE.END               +  " TEXT NOT NULL,"   +
                CLIENTE.BAIRRO            +  " TEXT NOT NULL,"   +
                CLIENTE.CIDADE            +  " TEXT NOT NULL,"   +
                CLIENTE.UF               +  " TEXT NOT NULL, "  +
                CLIENTE.NOMEPAI           +  " TEXT NOT NULL,"   +
                CLIENTE.NOMEMAE           +  " TEXT NOT NULL,"   +
                CLIENTE.DATADENASCIMENTO  +  " TEXT NOT NULL,"   +
                CLIENTE.LOCALDENASCIMENTO +  " TEXT NOT NULL"   +
                ")";
        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}