package com.example.lucca.clientes;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Cadastro extends ActionBarActivity {

    public static final String PESSOA = "pessoa";
    private EditText edNome;
    private EditText edCpf;
    private EditText edRg;
    private EditText edEnd;
    private EditText edBairro;
    private EditText edCidade;
    private EditText edUf;
    private EditText edNomePai;
    private EditText edNomeMae;
    private EditText edLocalNascimento;
    private EditText edDataNascimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edNome = (EditText) findViewById(R.id.edNome);
        edCpf = (EditText) findViewById(R.id.edCpf);
        edRg = (EditText) findViewById(R.id.edRg);
        edEnd = (EditText) findViewById(R.id.edEnd);
        edBairro = (EditText) findViewById(R.id.edBairro);
        edCidade = (EditText) findViewById(R.id.edCidade);
        edUf = (EditText) findViewById(R.id.edUf);
        edNomePai = (EditText) findViewById(R.id.edNomePai);
        edNomeMae = (EditText) findViewById(R.id.edNomeMae);
        edDataNascimento = (EditText) findViewById(R.id.edNascimento);
        edLocalNascimento = (EditText) findViewById(R.id.edLocalNascimento);

    }

    public void enviar(View v) {

        String nome = edNome.getText().toString();
        String cpf = edCpf.getText().toString();
        int rg = Integer.parseInt(edRg.getText().toString());
        String end = edEnd.getText().toString();
        String bairro = edBairro.getText().toString();
        String cidade = edCidade.getText().toString();
        String uf = edUf.getText().toString();
        String nomePai = edNomePai.getText().toString();
        String nomeMae = edNomeMae.getText().toString();
        String dataNascimento = edDataNascimento.getText().toString();
        String localNascimento = edLocalNascimento.getText().toString();




        Pessoa pessoa = new Pessoa();

        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setRg(rg);
        pessoa.setEnd(end);
        pessoa.setBairro(bairro);
        pessoa.setCidade(cidade);
        pessoa.setUf(uf);
        pessoa.setNomePai(nomePai);
        pessoa.setNomeMae(nomeMae);
        pessoa.setDataNascimento(dataNascimento);
        pessoa.setLocalNascimento(localNascimento);


        Intent i = new Intent(this, VerDados.class);
        i.putExtra(PESSOA, pessoa);

        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cadastro, menu);
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