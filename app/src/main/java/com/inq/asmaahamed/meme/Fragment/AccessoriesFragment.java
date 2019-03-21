package com.inq.eslamwael74.meme.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inq.eslamwael74.meme.Adapter.AccessoriesAdapter;
import com.inq.eslamwael74.meme.Adapter.UsedCarAdapter;
import com.inq.eslamwael74.meme.Model.Accessory;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eslamwael74 on 1/30/2018.
 */

public class AccessoriesFragment extends Fragment {

    private static final String ARG_Ex = "AdDetailsFragment";
    private String example;
    ToolbarListener toolbarListener;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    ArrayList<Accessory> accessories;


    public static AccessoriesFragment newInstance(String example) {
        AccessoriesFragment firstFragment = new AccessoriesFragment();
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
        View view= inflater.inflate(R.layout.accessories_fragment,container,false);
        ButterKnife.bind(this,view);
        toolbarListener = (ToolbarListener) getActivity();
        toolbarListener.setTextListener("كماليات");
        toolbarListener.setSearchImageVisibility(true);
        init();

        return view;
    }

    void init(){

        accessories = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

        accessories.add(new Accessory("acce","500",
                "sasasasasa",
                "https://i.ebayimg.com/00/s/MjM2WDMxNQ==/z/-9kAAOSwTA9X6Y7U/$_57.JPG?set_id=80000000000"));

        }

        AccessoriesAdapter accessoriesAdapter = new AccessoriesAdapter(getActivity(),accessories,toolbarListener);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(accessoriesAdapter);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        toolbarListener.setTextListener(getString(R.string.home_page));
        toolbarListener.setSearchImageVisibility(false);
    }
}
