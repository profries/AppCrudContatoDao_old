package com.example.iossenac.appcrudcontatodao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.iossenac.appcrudcontatodao.dao.ContatoDao;
import com.example.iossenac.appcrudcontatodao.dao.bd.ContatoDaoBd;
import com.example.iossenac.appcrudcontatodao.model.Contato;

public class DetalheActivity extends AppCompatActivity {
    EditText editTextNome, editTextTelefone;
    Contato contatoEditar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        Intent it = getIntent();
        this.contatoEditar = (Contato) it.getSerializableExtra("contato");

        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);
        editTextNome.setText(contatoEditar.getNome());
        editTextTelefone.setText(contatoEditar.getTelefone());
    }


    public void editar(View v){
        contatoEditar.setNome(editTextNome.getText().toString());
        contatoEditar.setTelefone(editTextTelefone.getText().toString());

        ContatoDao dao = new ContatoDaoBd(this);
        dao.atualizar(contatoEditar);
        Toast.makeText(this,"Edicao realizada com sucesso!", Toast.LENGTH_SHORT)
                .show();
        finish();
    }

    public void excluir(View v){
        ContatoDao dao = new ContatoDaoBd(this);
        dao.excluir(contatoEditar);
        Toast.makeText(this,"Exclusao realizada com sucesso!",Toast.LENGTH_SHORT)
                .show();
        finish();
    }

    public void voltar(View v){
        finish();
    }
}
