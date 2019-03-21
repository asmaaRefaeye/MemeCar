package com.inq.eslamwael74.meme.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inq.eslamwael74.meme.Model.Car;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by EslamWael74 on 1/24/2018.
 */

public class AddNewAdFragment extends Fragment {
    ToolbarListener toolbarListener;
    private static final String ARG_Ex = "AdDetailsFragment";
    private Car car;

    @BindView(R.id.car_name)
    EditText mEditTextCarName;

    @BindView(R.id.car_type)
    EditText mEditTextCarType;

    @BindView(R.id.car_status)
    EditText mEditTextCarStatus;

    @BindView(R.id.car_lime)
    EditText mEditTextCarLime;

    @BindView(R.id.car_model)
    EditText mEditTextCarModel;

    @BindView(R.id.city)
    EditText mEditTextCarCity;

    @BindView(R.id.payment_method)
    EditText mEditTextPaymentMethod;

    @BindView(R.id.date_of_examination)
    EditText mEditTextDateOfExamination;

    @OnClick(R.id.image_btn)
    void imageClick() {

        Toast.makeText(getActivity(), "عرض الصور", Toast.LENGTH_SHORT).show();
    }

    @BindView(R.id.btn_add)
    Button mBtnAddOrUpdate;
    @OnClick(R.id.btn_add)
    void sendMessageClick() {
        Toast.makeText(getActivity(), "اضافه", Toast.LENGTH_SHORT).show();
    }


    public AddNewAdFragment() {

    }

    int type;

    public static AddNewAdFragment newInstance(int type) {
        AddNewAdFragment firstFragment = new AddNewAdFragment();
        Bundle args = new Bundle();
        args.putInt("type", type);
        firstFragment.setArguments(args);
        return firstFragment;
    }

    public static AddNewAdFragment newInstance(Car car,int type) {
        AddNewAdFragment firstFragment = new AddNewAdFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_Ex, car);
        args.putInt("type", type);
        firstFragment.setArguments(args);
        return firstFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getInt("type");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_new_ad_fragment, container, false);
        ButterKnife.bind(this, view);
        toolbarListener = (ToolbarListener) getActivity();
        if (type == 1){
            car = getArguments().getParcelable(ARG_Ex);
            toolbarListener.setTextListener("تعديل الأعلان");
            mBtnAddOrUpdate.setText("تعديل");
            init();
        }
        else{
            toolbarListener.setTextListener("اضافه اعلان");
        }

        return view;
    }


    void init(){
        //here you should set all texts
    }

    @Override
    public void onDetach() {
        super.onDetach();
            toolbarListener.setTextListener("أعلاناتي");

    }

}
