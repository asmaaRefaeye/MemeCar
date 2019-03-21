package com.inq.eslamwael74.meme.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inq.eslamwael74.meme.Adapter.CarsTypesAdapter;
import com.inq.eslamwael74.meme.Model.CarsTypes;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Omar on 2/1/2018.
 */

public class CarsTypesFragment extends Fragment {


    @BindView(R.id.frSearchcar_img)
    ImageView imgviewFristCar;

    @BindView(R.id.cars_desciption_txt)
    TextView txtviewcardetails;

    @BindView(R.id.scSerchcar_img)
    ImageView imgviewSecCar;

    @BindView(R.id.car_speed_Img)
    ImageView imgviewCarSpeed;

    @BindView(R.id.carspeed_txt)
    TextView txtviewCarSpeed;

    @BindView(R.id.car_speedkm_Img)
    ImageView FrimgviewCarSpeedKm;


    @BindView(R.id.carspeedkm_txt)
    TextView txtviewCarSpeedKm;

    @BindView(R.id.recyclecarsType)
    RecyclerView carRecyclerView;

    ArrayList<CarsTypes> cars;
    ToolbarListener toolbarListener;

    Context context;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getActivity();

    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cars_types_fragment, container, false);

        toolbarListener = (ToolbarListener) getActivity();
        toolbarListener.setTextListener("سيارات مستعملة");
        ButterKnife.bind(this, view);

        init();
        return view;
    }


    void init(){

        cars = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            cars.add(new CarsTypes ("https://i.ebayimg.com/00/s/MjM2WDMxNQ==/z/-9kAAOSwTA9X6Y7U/$_57.JPG?set_id=80000000000",
                    "BMW","god","midum","blue","500054$"));
        }

        CarsTypesAdapter carsTypesAdapter = new CarsTypesAdapter(getActivity(), cars, (FragmentActivity) toolbarListener);
        carRecyclerView.setHasFixedSize(true);
        carRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        carRecyclerView.setAdapter(carsTypesAdapter);

    }


    @Override
    public void onDetach() {
        super.onDetach();
        toolbarListener.setTextListener(getString(R.string.home_page));
        toolbarListener.setSearchImageVisibility(false);
    }





}
