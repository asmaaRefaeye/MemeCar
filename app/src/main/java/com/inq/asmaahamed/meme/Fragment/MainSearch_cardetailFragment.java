package com.inq.eslamwael74.meme.Fragment;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.inq.eslamwael74.meme.Model.Car;
import com.inq.eslamwael74.meme.Model.CarsDetails;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by EslamWael74 on 1/24/2018.
 */

public class MainSearch_cardetailFragment extends Fragment {

    private static final String ARG_Ex = "AdDetailsFragment";
    private CarsDetails car;
    ToolbarListener toolbarListener;


    @BindView(R.id.car_name)
    TextView tvCarName;

    @BindView(R.id.car_type)
    TextView tvCarType;

    @BindView(R.id.car_status)
    TextView tvCarStatus;

    @BindView(R.id.car_lime)
    TextView tvCarLime;

    @BindView(R.id.car_model)
    TextView tvCarModel;

    @BindView(R.id.check_status)
    TextView tvCarCheckStatus;

    @BindView(R.id.payment_method)
    TextView tvPaymentMethod;

    @BindView(R.id.date_of_examination)
    TextView tvDateOfExamination;

    @OnClick(R.id.image_btn)
    void imageClick() {

        Toast.makeText(getActivity(), "عرض الصور", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_send_message)
    void sendMessageClick() { // sed data to web // bossy
        //u here make new car object using the data in search fields
        //and send it to the search fragment
        //get data from edit texts
        openFragment(SearchResultFragment.newInstance(car), R.id.search_fragment);
    }

    private void openFragment(SearchResultFragment searchResultFragment, int search_fragment) {


    }


    public MainSearch_cardetailFragment() {

    }

    public static MainSearch_cardetailFragment newInstance() {
        MainSearch_cardetailFragment firstFragment = new MainSearch_cardetailFragment();
      //  Bundle args = new Bundle();
      //  args.putParcelable(ARG_Ex, (Parcelable) car);
       // firstFragment.setArguments(args);
        return firstFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   car = getArguments().getParcelable(ARG_Ex);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.car_details_fragment, container, false);
        ButterKnife.bind(this, view);
        toolbarListener = (ToolbarListener) getActivity();
        toolbarListener.setTextListener("تفاصيل الأعلان");

       // setCarData();

        return view;
    }

    void setCarData() {
        tvCarName.setText(car.getName());
        tvCarType.setText(car.getType());
        tvCarStatus.setText(car.getState());
        tvCarLime.setText(car.getLime());
        tvCarModel.setText(car.getModel());
        tvCarCheckStatus.setText(car.getCheck_state());
        tvPaymentMethod.setText(car.getPayment_method());
        tvDateOfExamination.setText(car.getDateofExamination());

    }

    @Override
    public void onDetach() {
        super.onDetach();
        toolbarListener.setTextListener("تفاصيل الأعلان");
    }
}
