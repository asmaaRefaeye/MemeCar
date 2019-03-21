package com.inq.eslamwael74.meme.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inq.eslamwael74.meme.Model.Accessory;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by eslamwael74 on 1/30/2018.
 */

public class AccessoriesAdDetailsFragment extends Fragment {

    private static final String ARG_Ex = "AdDetailsFragment";
    private String example;
    ToolbarListener toolbarListener;
    Accessory accessory;

    @BindView(R.id.image)
    ImageView mImage;

    @BindView(R.id.name)
    TextView tvName;

    @BindView(R.id.details)
    TextView tvDetails;

    @BindView(R.id.price)
    TextView tvPrice;




    public static AccessoriesAdDetailsFragment newInstance(Accessory accessory) {
        AccessoriesAdDetailsFragment firstFragment = new AccessoriesAdDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_Ex, accessory);
        firstFragment.setArguments(args);
        return firstFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accessory = getArguments().getParcelable(ARG_Ex);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.accessories_details_fragment,container,false);
        ButterKnife.bind(this,view);
        toolbarListener = (ToolbarListener) getActivity();
        toolbarListener.setTextListener("تفاصيل الأعلان");

        init();

        return view;
    }


    void init(){
        Picasso.with(getActivity())
                .load(accessory.getImage())
                .fit().centerCrop()
                .error(R.drawable.car_placeholder)
                .into(mImage, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                    }
                });

        tvName.setText(accessory.getName());
        tvDetails.setText(accessory.getDescription());
        tvPrice.setText(accessory.getPrice());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        toolbarListener.setTextListener("كماليات");
        toolbarListener.setSearchImageVisibility(true);
    }
}
