package com.inq.eslamwael74.meme.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inq.eslamwael74.meme.Adapter.UsedCarAdapter;
import com.inq.eslamwael74.meme.Model.Car;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Omar on 1/30/2018.
 */

public class UsedCarFragment extends Fragment {


    private static final String ARG_Ex = "AdDetailsFragment";
    private String example;
    ToolbarListener toolbarListener;


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    public static UsedCarFragment newInstance(String example) {
        UsedCarFragment firstFragment = new UsedCarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_Ex, example);
        firstFragment.setArguments(args);
        return firstFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        example = getArguments().getString(ARG_Ex);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.used_car_fragment,container,false);
        ButterKnife.bind(this,view);
        toolbarListener = (ToolbarListener) getActivity();
        toolbarListener.setTextListener("سيارات مستعمله");
//        MainActivity mainActivity = (MainActivity) getActivity();
//        mainActivity.setOnBackPressedListener(() -> {
//            toolbarListener.setTextListener("الصفحه الرئيسيه");
//            return true;
//        });
        init();

        return view;
    }

    void init(){
        Car car;
        ArrayList<String> imgList = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();

        imgList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNGN2gNNT--pXzVT7VQRqVk_dmh2Aj3lMKgE4xZ8t1ljikwDz4");
        imgList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNGN2gNNT--pXzVT7VQRqVk_dmh2Aj3lMKgE4xZ8t1ljikwDz4");
        imgList.add("https://i.ebayimg.com/00/s/MjM2WDMxNQ==/z/-9kAAOSwTA9X6Y7U/$_57.JPG?set_id=80000000000");
        imgList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNGN2gNNT--pXzVT7VQRqVk_dmh2Aj3lMKgE4xZ8t1ljikwDz4");
        imgList.add("http://automotivecdn.com/toyota/2018/Yaris/2018-toyota-yaris-grn-btn1.jpg");
        imgList.add("https://i.ebayimg.com/00/s/MjM2WDMxNQ==/z/-9kAAOSwTA9X6Y7U/$_57.JPG?set_id=80000000000");
        imgList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNGN2gNNT--pXzVT7VQRqVk_dmh2Aj3lMKgE4xZ8t1ljikwDz4");
        imgList.add("http://automotivecdn.com/toyota/2018/Yaris/2018-toyota-yaris-grn-btn1.jpg");
        imgList.add("https://i.ebayimg.com/00/s/MjM2WDMxNQ==/z/-9kAAOSwTA9X6Y7U/$_57.JPG?set_id=80000000000");
        imgList.add("http://automotivecdn.com/toyota/2018/Yaris/2018-toyota-yaris-grn-btn1.jpg");


        car = new Car("BMW","ayHaga","saas","sasa","saxcxxc","asasa",imgList,"EG",
                "PAYED","200.00","500","20-11-1996");
        for (int i = 0; i <5 ; i++) {
            cars.add(car);
        }

        UsedCarAdapter usedCarAdapter = new UsedCarAdapter(getActivity(),cars);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(usedCarAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        toolbarListener.setTextListener("الصفخه الرئيسيه");

    }
}
