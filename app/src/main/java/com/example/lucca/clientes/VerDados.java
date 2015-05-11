package com.example.lucca.clientes;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class VerDados extends ActionBarActivity {

    private TextView saidaNome;
    private TextView saidaCpf;
    private TextView saidaRg;
    private TextView saidaEnd;
    private TextView saidaBairro;
    private TextView saidaCidade;
    private TextView saidaUf;
    private TextView saidaNomePai;
    private TextView saidaNomeMae;
    private TextView saidaLocalNascimento;
    private TextView saidaDataNascimento;

    private DataBase helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_dados);

        saidaNome = (TextView) findViewById(R.id.saidaNome);
        saidaCpf = (TextView) findViewById(R.id.saidaCpf);
        saidaRg = (TextView) findViewById(R.id.saidaRg);
        saidaEnd = (TextView) findViewById(R.id.saidaEnd);
        saidaBairro = (TextView) findViewById(R.id.saidaBairro);
        saidaCidade = (TextView) findViewById(R.id.saidaCidade);
        saidaUf = (TextView) findViewById(R.id.saidaUf);
        saidaNomePai = (TextView) findViewById(R.id.saidaNomePai);
        saidaNomeMae = (TextView) findViewById(R.id.saidaNomeMae);
        saidaLocalNascimento = (TextView) findViewById(R.id.saidaLocalNascimento);
        saidaDataNascimento = (TextView) findViewById(R.id.saidaDataNascimento);

        helper = new DataBase(this);
        db = helper.getWritableDatabase();


        Intent i = getIntent();

        Pessoa pessoa = (Pessoa) i.getSerializableExtra(Cadastro.PESSOA);

        String nome = pessoa.getNome();
        String cpf = pessoa.getCpf();
        int rg = pessoa.getRg();
        String end = pessoa.getEnd();
        String bairro = pessoa.getBairro();
        String cidade = pessoa.getCidade();
        String uf = pessoa.getUf();
        String nomePai = pessoa.getNomePai();
        String nomeMae = pessoa.getNomeMae();
        String localNascimento = pessoa.getLocalNascimento();
        String dataNascimento = pessoa.getDataNascimento();

        saidaNome.setText(nome);
        saidaCpf.setText(cpf);
        saidaRg.setText(rg);
        saidaEnd.setText(end);
        saidaBairro.setText(bairro);
        saidaCidade.setText(cidade);
        saidaUf.setText(uf);
        saidaNomeMae.setText(nomeMae);
        saidaNomePai.setText(nomePai);
        saidaLocalNascimento.setText(localNascimento);
        saidaDataNascimento.setText(dataNascimento);

        ContentValues values = new ContentValues();
        values.put(DataBase.CLIENTE.NOME, nome);
        values.put(DataBase.CLIENTE.CPF, cpf);
        values.put(DataBase.CLIENTE.RG, rg);
        values.put(DataBase.CLIENTE.END, end);
        values.put(DataBase.CLIENTE.BAIRRO, bairro);
        values.put(DataBase.CLIENTE.CIDADE, cidade);
        values.put(DataBase.CLIENTE.UF, uf);
        values.put(DataBase.CLIENTE.NOMEMAE, nomeMae);
        values.put(DataBase.CLIENTE.NOMEPAI, nomePai);
        values.put(DataBase.CLIENTE.DATADENASCIMENTO, dataNascimento);
        values.put(DataBase.CLIENTE.LOCALDENASCIMENTO, localNascimento);

        long id = db.insert("cliente", null, values);


        if (id != -1) {
            Toast.makeText(this, "cliente1 salvo com sucesso", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Erro na gravação de dados", Toast.LENGTH_LONG).show();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ver_dados, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
