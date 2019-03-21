package com.inq.eslamwael74.meme.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Eslam Wael on 1/29/2018.
 */

public class ProfileFragment extends Fragment {

    private static final String ARG_Ex = "AdDetailsFragment";
    private String example;
    ToolbarListener toolbarListener;

    @OnClick(R.id.msg_btn)
    void messageClick() {
        openFragment(MessageFragment.newInstance(1), R.id.profile_frame);
    }

    @OnClick(R.id.card_add_new_car_ad)
    void addNewAdCarClick() {
        openFragment(AddNewAdFragment.newInstance(0), R.id.profile_frame);
    }

    @OnClick(R.id.card_add_new_acc_ad)
    void addNewAddAccClick() {
        openFragment(AddNewAdAccFragment.newInstance("sfv"), R.id.profile_frame);
    }

    @OnClick(R.id.card_my_ads)
    void myAdsClick() {
        openFragment(MyAdsFragment.newInstance(1), R.id.profile_frame);
    }



    public static ProfileFragment newInstance(String example) {
        ProfileFragment firstFragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_Ex, example);
        firstFragment.setArguments(args);
        return firstFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        example = getArguments().getString(ARG_Ex);
//        Log.i("Fragement created with ", example);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        toolbarListener = (ToolbarListener) getActivity();
        toolbarListener.setTextListener("الصفحه الشخصيه");
        ButterKnife.bind(this, view);


        return view;
    }


    void openFragment(Fragment fragment, int id) {
        Fragment Fragment = fragment;
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.enter_from_left,
                        R.anim.exit_from_left,
                        R.anim.enter_from_right,
                        R.anim.exit_from_right);
        fragmentTransaction.replace(id, Fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        toolbarListener.setTextListener("الصفحه الرئيسيه");
    }
}
