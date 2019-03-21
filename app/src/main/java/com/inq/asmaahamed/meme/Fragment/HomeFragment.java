package com.inq.eslamwael74.meme.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.inq.eslamwael74.meme.Activity.MainActivity;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Eslam Wael on 1/30/2018.
 */

public class HomeFragment extends Fragment {

    private static final String ARG_Ex = "AdDetailsFragment";
    private String example;
    ToolbarListener toolbarListener;
    MainActivity.OnBackPressedListener onBackPressedListener;

    @OnClick(R.id.used_cars)
    void usedCarClick() {
        openFragment(UsedCarFragment.newInstance(""), R.id.home_frame);
    }

    @OnClick(R.id.acc_card)
    void AccessoriesClick() {
        openFragment(AccessoriesFragment.newInstance(""), R.id.home_frame);
    }

    @OnClick(R.id.spare_parts)
    void sparePartsClick() {
        openFragment(SpearePartsFragment.newInstance(""), R.id.home_frame);
    }

    public static HomeFragment newInstance(String example) {
        HomeFragment firstFragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        toolbarListener = (ToolbarListener) getActivity();
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.setOnBackPressedListener(() -> {
            toolbarListener.setTextListener("الصفحه الرئيسيه");
            toolbarListener.setSearchImageVisibility(true);
            return true;
        });


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
        getActivity().getSupportFragmentManager().popBackStack();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Toast.makeText(getActivity(), "thanks", Toast.LENGTH_SHORT).show();
    }


}
