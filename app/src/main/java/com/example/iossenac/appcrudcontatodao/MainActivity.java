package com.example.iossenac.appcrudcontatodao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.iossenac.appcrudcontatodao.adapter.ContatoAdapter;
import com.example.iossenac.appcrudcontatodao.dao.ContatoDao;
import com.example.iossenac.appcrudcontatodao.dao.bd.ContatoDaoBd;
import com.example.iossenac.appcrudcontatodao.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Contato> listaContatos = new ArrayList<>();
    ContatoAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adaptador = new ContatoAdapter(listaContatos,
                this);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adaptador);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Contato contato = listaContatos.get(position);

                        Intent it = new Intent(MainActivity.this, DetalheActivity.class);
                        it.putExtra("contato",contato);
                        startActivity(it);
                    }
                }
        );

    }

    @Override
    public void onResume() {
        super.onResume();
        ContatoDao dao = new ContatoDaoBd(this);
        listaContatos = dao.listar();
        adaptador.setListaContatos(listaContatos);
        adaptador.notifyDataSetChanged();
    }

    public void abrirFormulario(View v){
        Intent it = new Intent(this, CadastroActivity.class);
        startActivity(it);

    }

    public void finalizar(View view){
        finish();
    }
}
