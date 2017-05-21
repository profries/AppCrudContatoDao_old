package com.example.iossenac.appcrudcontatodao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iossenac.appcrudcontatodao.R;
import com.example.iossenac.appcrudcontatodao.dao.ContatoDao;
import com.example.iossenac.appcrudcontatodao.dao.bd.ContatoDaoBd;
import com.example.iossenac.appcrudcontatodao.model.Contato;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

    }

    public void cadastrar(View v){
        EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
        EditText editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        Contato contato = new Contato(editTextNome.getText().toString(),
                editTextTelefone.getText().toString());
        ContatoDao dao = new ContatoDaoBd(this);
        dao.inserir(contato);
        Toast.makeText(this,"Cadastro realizada com sucesso!",Toast.LENGTH_SHORT)
                .show();
        finish();

    }

    public void cancelar(View view){
        finish();
    }
}