package com.inq.eslamwael74.meme.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Omar on 2/8/2018.
 */

public class Add_kamaliyat_advertsFragment extends Fragment {
    private static final String ARG_Ex = "Add_new_kamayiat";
    private String example;

   int type;

    @BindView(R.id.add_kmaladverts_img)
    ImageView Kamayatimg;

    @BindView(R.id.kamlyiat_details)
    TextView kamalyatDetailtxt;

    @BindView(R.id.kamlyiat_moredetails)
    TextView kamalyatmoreDetailtxt;

    @OnClick(R.id.btn_khaamalyiat_sendmsg)
    void kamalyatsendbtn (){

    }



    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getInt(ARG_Ex);
    }



    public static Add_kamaliyat_advertsFragment newInstance(int type) {
        Add_kamaliyat_advertsFragment firstFragment = new Add_kamaliyat_advertsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_Ex, type);
        firstFragment.setArguments(args);
        return firstFragment;
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_kamaliyat_adverts, container, false);
        ButterKnife.bind(this, view);

        return view;
    }


}
