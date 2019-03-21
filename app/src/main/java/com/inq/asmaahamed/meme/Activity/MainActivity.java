package com.inq.eslamwael74.meme.Activity;

import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.inq.eslamwael74.meme.ApiModel.City;
import com.inq.eslamwael74.meme.Fragment.HomeFragment;
import com.inq.eslamwael74.meme.Fragment.MainSearch_cardetailFragment;
import com.inq.eslamwael74.meme.Fragment.MessageFragment;
import com.inq.eslamwael74.meme.Fragment.MyAdsFragment;
import com.inq.eslamwael74.meme.Fragment.ProfileFragment;
import com.inq.eslamwael74.meme.Fragment.SearchResultFragment;
import com.inq.eslamwael74.meme.Model.Car;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.Rest.ApiInterface;
import com.inq.eslamwael74.meme.Rest.CitesResponse;
import com.inq.eslamwael74.meme.Rest.RestClient;
import com.inq.eslamwael74.meme.ToolbarListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements ToolbarListener {


    public interface OnBackPressedListener {
        boolean onBackClick();
    }

    private OnBackPressedListener onBackPressedListener;

    public void setOnBackPressedListener(OnBackPressedListener onBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener;
    }

    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.toolbar3)
    Toolbar mToolBar;

    @BindView(R.id.nav_view)
    NavigationView mNavView;

    ImageButton searchBtn;

   /* @BindView(R.id.search_btn)
    ImageButton searchBtn;
    @OnClick(R.id.search_btn)
    void mSearchImage(){
        //here open ur search fragment //right ?s
        openFragment(SearchResultFragment.newInstance("semsem"), R.id.main_container);
    }*/

    @OnClick(R.id.menu_btn)
    void menuBtnClick() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }



    void init() {


        //lets testy here
        ApiInterface apiService =
                RestClient.getClient().create(ApiInterface.class);

        Call<CitesResponse> call = apiService.getAllCities("5643f3996af23d5a1d1552e8f14f3ada1d157c0d");

        call.enqueue(new Callback<CitesResponse>() {
            @Override
            public void onResponse(Call<CitesResponse> call, Response<CitesResponse> response) {

                int statusCode = response.code();
                Log.e("succes",String.valueOf(statusCode));
                //List<City> mlist=response.body().data;  //wait
                Log.e("size",response.body().message);
                //showtxt.setText(response.message());
            }

            @Override
            public void onFailure(Call<CitesResponse> call, Throwable t) {
                Log.e("error", t.toString());
            }

        });
        //run//
        View headerLayout =
                mNavView.inflateHeaderView(R.layout.nav_header_main);
        LinearLayout linProfile = headerLayout.findViewById(R.id.lin_profile);
        LinearLayout linMyAds = headerLayout.findViewById(R.id.lin_my_ads);
        LinearLayout linMessages = headerLayout.findViewById(R.id.lin_messages);
        LinearLayout wqwq = headerLayout.findViewById(R.id.lin_my_adsass);
        LinearLayout linSettings = headerLayout.findViewById(R.id.lin_settings);
        LinearLayout linCall = headerLayout.findViewById(R.id.lin_call);
        LinearLayout linFaq = headerLayout.findViewById(R.id.lin_faq);
        LinearLayout linhome = headerLayout.findViewById(R.id.lin_home);
        searchBtn=findViewById(R.id.search_btn);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //ya mama
                //hena will only open the esrach fragment sa7 ? yaaaaa so u will not pass any data uu  will okjust open the fragment
                //right ? or what yaaaaa
                openFragment(MainSearch_cardetailFragment.newInstance(), R.id.main_container);
            }
        });

        linProfile.setOnClickListener(v -> {
            openFragment(ProfileFragment.newInstance(""), R.id.home_frame);
        });
        linMyAds.setOnClickListener(v -> {
            openFragment(MyAdsFragment.newInstance(0), R.id.main_container);
        });
        linMessages.setOnClickListener(v -> {
            openFragment(MessageFragment.newInstance(0), R.id.main_container);
        });

        linhome.setOnClickListener(v -> {
            openFragment(HomeFragment.newInstance(""), R.id.home_frame);
        });

        wqwq.setOnClickListener(v -> {
        });
        linSettings.setOnClickListener(v -> {


        });
        linCall.setOnClickListener(v -> {


        });
        linFaq.setOnClickListener(v -> {


        });


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);

    }

    void openFragment(Fragment fragment, int id) {
        mDrawerLayout.closeDrawer(GravityCompat.START, true);
        Fragment Fragment = fragment;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.enter_from_left,
                        R.anim.exit_from_left,
                        R.anim.enter_from_right,
                        R.anim.exit_from_right);
        fragmentTransaction.replace(id, Fragment);
        getSupportFragmentManager().popBackStack();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        openHomeFragment();

        init();

    }

    void openHomeFragment() {
        HomeFragment homeFragment = HomeFragment.newInstance("as");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container, homeFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void setTextListener(String text) {
        tvToolbar.setText(text);
    }

   @Override //wait
    public void setSearchImageVisibility(boolean visibility) {
        new Handler().postDelayed(() -> {
            if (visibility) {
                searchBtn.setVisibility(View.VISIBLE); //ha ? noooooooooo cant use bindview  and onclick in same time
            } else {
                searchBtn.setVisibility(View.INVISIBLE);
            }

        }, 401);

    }

}
