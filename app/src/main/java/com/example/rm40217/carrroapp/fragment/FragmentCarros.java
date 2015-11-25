package com.example.rm40217.carrroapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rm40217.carrroapp.R;
import com.example.rm40217.carrroapp.adapter.CarroAdapter;
import com.example.rm40217.carrroapp.model.Carro;
import com.example.rm40217.carrroapp.service.CarroService;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCarros extends Fragment {

    private List<Carro> carros;
    private RecyclerView rvCarros;
    private LinearLayoutManager layoutManager;

    public FragmentCarros() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carros, container, false);
        rvCarros = (RecyclerView) view.findViewById(R.id.rvCarros);
        layoutManager = new LinearLayoutManager(getContext());
        rvCarros.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        taskCarros();
    }

    private void taskCarros() {
        CarroService carroService = new CarroService(getContext());
        carros = carroService.getCarros(carroService.loadJSONFromRaw(R.raw.carros_classicos));

        rvCarros.setAdapter(new CarroAdapter(getContext(), carros));
    }
}
