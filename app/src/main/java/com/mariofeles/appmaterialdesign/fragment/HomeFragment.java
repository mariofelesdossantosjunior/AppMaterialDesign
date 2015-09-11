package com.mariofeles.appmaterialdesign.fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mariofeles.appmaterialdesign.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Mario Feles Dos Santos junior on 10/09/15.
 */
public class HomeFragment extends Fragment {

    @Bind(R.id.spNumeros)
    Spinner spNumeros;
    @Bind(R.id.btLigar)
    Button btLigar;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        // Inflate the layout for this fragment
        ButterKnife.bind(this, rootView);
        montaSpinner();
        return rootView;
    }

    @OnClick(R.id.btLigar)
    public void clickLigar() {
        Intent irParaDiscagem = new Intent(Intent.ACTION_CALL);
        Uri discarPara = Uri.parse("tel:" + spNumeros.getSelectedItem());
        Toast.makeText(getActivity(), "Ligando Para : " + spNumeros.getSelectedItem(), Toast.LENGTH_LONG).show();
        irParaDiscagem.setData(discarPara);
        startActivity(irParaDiscagem);
    }

    private void montaSpinner() {
        List<String> ls = new ArrayList<String>();
        ls.add("(044)88426754");
        ls.add("(044)88107801");
        ls.add("(044)88260086");
        ls.add("(044)88426754");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, ls);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spNumeros.setAdapter(dataAdapter);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
