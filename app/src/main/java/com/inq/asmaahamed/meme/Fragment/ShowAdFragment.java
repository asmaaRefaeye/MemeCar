package com.inq.eslamwael74.meme.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class ShowAdFragment extends Fragment {

    private static final String ARG_Ex = "AdDetailsFragment";
    private Car car;
    ToolbarListener toolbarListener;


    @BindView(R.id.car_name)
    EditText tvCarName;

    @BindView(R.id.car_type)
    EditText tvCarType;

    @BindView(R.id.car_status)
    EditText tvCarStatus;

    @BindView(R.id.car_lime)
    EditText tvCarLime;

    @BindView(R.id.car_model)
    EditText tvCarModel;

    @BindView(R.id.check_status)
    EditText tvCarCheckStatus;

    @BindView(R.id.payment_method)
    EditText tvPaymentMethod;

    @BindView(R.id.date_of_examination)
    EditText tvDateOfExamination;

    @OnClick(R.id.image_btn)
    void imageClick() {

        Toast.makeText(getActivity(), "عرض الصور", Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.btn_send_message)
    void sendMessageClick() {
        Toast.makeText(getActivity(), "ارسال رساله", Toast.LENGTH_SHORT).show();
    }


    public ShowAdFragment() {

    }

    public static ShowAdFragment newInstance(Car car) {
        ShowAdFragment firstFragment = new ShowAdFragment();
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
        View view = inflater.inflate(R.layout.show_add_fragment, container, false);
        ButterKnife.bind(this, view);
        toolbarListener = (ToolbarListener) getActivity();
        toolbarListener.setTextListener("تفاصيل الأعلان");

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        toolbarListener.setTextListener("تفاصيل الأعلان");
    }

    /*  public void Actionlanguage (){
        Login = (Button) findViewById(R.id.bu_baselog);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(BasicLogActivity.this, Login);
                popupMenu.getMenuInflater().inflate(R.menu.main_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();
                        switch (id) {
                            case R.id.menu_ar:
                                Intent menuIntent = new Intent(getApplicationContext(), LoginAr_Activity.class);
                                startActivity(menuIntent);
                                break;
                            case R.id.menu_en:
                                Intent menIntent = new Intent(getApplicationContext(), LoginEn_Activity.class);
                                startActivity(menIntent);
                                break;
                        }

                        return true;
                    }
                });
                popupMenu.show();

            }
        });


    }*/


}
