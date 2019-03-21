package com.inq.eslamwael74.meme.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inq.eslamwael74.meme.Model.Car;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.Adapter.MainSearchcardetailAdapter;
import com.inq.eslamwael74.meme.ToolbarListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by EslamWael74 on 1/24/2018.
 */

public class AdDetailsFragment extends Fragment {

    private static final String ARG_Ex = "AdDetailsFragment";
    private String example;
    Car car;
    ToolbarListener toolbarListener;

    @OnClick(R.id.send_message)
    void cardClick() {

//        MainSearch_cardetailFragment carDetailsFragment = MainSearch_cardetailFragment.newInstance("ex");
//        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.ad_details_frame, carDetailsFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();

    }

    @BindView(R.id.pager)
    ViewPager mViewPager;

    @BindView(R.id.indicator)
    CircleIndicator mCircle;

    @BindView(R.id.car_name)
    TextView tvCarName;

    @BindView(R.id.car_type)
    TextView tvCarType;

    @BindView(R.id.like)
    ImageView mImageLike;

    @BindView(R.id.share)
    ImageView mImageShare;

    @BindView(R.id.call)
    ImageView mImageCall;

    private ArrayList<String> imgList = new ArrayList<>();


    public AdDetailsFragment() {

    }

    public static AdDetailsFragment newInstance(Car car) {
        AdDetailsFragment firstFragment = new AdDetailsFragment();
       Bundle args = new Bundle();
        args.putParcelable(ARG_Ex, car);
        firstFragment.setArguments(args);
        return firstFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        car = getArguments().getParcelable(ARG_Ex);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ad_details_fragment, container, false);
        ButterKnife.bind(this, view);
        toolbarListener = (ToolbarListener) getActivity();
        toolbarListener.setTextListener("تفاصيل الأعلان");
        initAdapter();


        return view;
    }

    void initAdapter() {

        mViewPager.setAdapter(new MainSearchcardetailAdapter(car, getActivity()));
        mCircle.setViewPager(mViewPager);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        toolbarListener.setTextListener("سيارات مستعمله");

    }
}
