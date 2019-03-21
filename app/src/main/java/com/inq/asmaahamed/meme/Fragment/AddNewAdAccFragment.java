package com.inq.eslamwael74.meme.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by eslamwael74 on 1/30/2018.
 */

public class AddNewAdAccFragment extends Fragment {


    private static final String ARG_Ex = "AddNewAdAccFragment";
    private String example;
    ToolbarListener toolbarListener;


    @BindView(R.id.name_ad)
    EditText editTextName;

    @BindView(R.id.edit_details)
    EditText editTextDetails;

    @OnClick(R.id.send_message)
    void sendClick(){
        getActivity().onBackPressed();
    }





    public static AddNewAdAccFragment newInstance(String example) {
        AddNewAdAccFragment firstFragment = new AddNewAdAccFragment();
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
        View view= inflater.inflate(R.layout.add_new_ad_acc_fragment,container,false);
        ButterKnife.bind(this,view);
        toolbarListener = (ToolbarListener) getActivity();
        toolbarListener.setTextListener("اضافه اعلان");

        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        toolbarListener.setTextListener("الصفحه الشخصيه");
    }
}
