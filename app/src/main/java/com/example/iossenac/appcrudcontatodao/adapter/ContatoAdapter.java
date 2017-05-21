package com.example.iossenac.appcrudcontatodao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.iossenac.appcrudcontatodao.R;
import com.example.iossenac.appcrudcontatodao.model.Contato;

import java.util.List;

/**
 * Created by lhries on 21/05/17.
 */

public class ContatoAdapter extends BaseAdapter {
    private List<Contato> listaContatos;
    private Context contexto;

    public ContatoAdapter(List<Contato> listaContatos, Context contexto) {
        this.listaContatos = listaContatos;
        this.contexto = contexto;
    }

    public void setListaContatos(List<Contato> listaContatos) {
        this.listaContatos = listaContatos;
    }

    @Override
    public int getCount() {
        return listaContatos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaContatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contato contato = listaContatos.get(position);

        LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item,null);

        TextView textoNome = (TextView) view.findViewById(R.id.textoNome);
        textoNome.setText(contato.getNome());

        TextView textoTelefone = (TextView) view.findViewById(R.id.textoTelefone);
        textoTelefone.setText(contato.getTelefone());

        return view;
    }
}
