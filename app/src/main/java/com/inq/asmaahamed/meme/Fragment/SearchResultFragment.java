package com.inq.eslamwael74.meme.Fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inq.eslamwael74.meme.Adapter.SearchResultAdapter;
import com.inq.eslamwael74.meme.Model.Car;
import com.inq.eslamwael74.meme.Model.CarsDetails;
import com.inq.eslamwael74.meme.Model.SearchCar;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eslamwael74 on 1/30/2018.
 */

public class SearchResultFragment extends Fragment {


    private static final String ARG_Ex = "AdDetailsFragment";
    private CarsDetails car;
    ToolbarListener toolbarListener;
    @BindView(R.id.car_search_recycler)
    RecyclerView SearchRecyclerView;
    ArrayList<SearchCar> searchCars;






    public static SearchResultFragment newInstance(CarsDetails car) {
        SearchResultFragment firstFragment = new SearchResultFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_Ex, (Parcelable) car); //put parcealbel
        firstFragment.setArguments(args);
        return firstFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        car = getArguments().getParcelable(ARG_Ex);
    }


   void init(){

        SearchResultAdapter searchCarAdapter = new SearchResultAdapter(getActivity(), searchCars, toolbarListener);
        SearchRecyclerView.setHasFixedSize(true);
        SearchRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        SearchRecyclerView.setAdapter(searchCarAdapter);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_car, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    public void onDetach() {
        super.onDetach();
        toolbarListener.setTextListener(getString(R.string.search));
        toolbarListener.setSearchImageVisibility(false);
    }

}
