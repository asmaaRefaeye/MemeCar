package com.inq.eslamwael74.meme.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inq.eslamwael74.meme.R;

import butterknife.ButterKnife;

/**
 * Created by eslamwael74 on 1/30/2018.
 */

public class FragmentExample extends Fragment {


    private static final String ARG_Ex = "AdDetailsFragment";
    private String example;




    public static ShowAdFragment newInstance(String example) {
        ShowAdFragment firstFragment = new ShowAdFragment();
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
        View view= inflater.inflate(R.layout.show_add_fragment,container,false);
        ButterKnife.bind(this,view);


        return view;
    }




}
