package com.inq.eslamwael74.meme.Adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.inq.eslamwael74.meme.Fragment.MainSearch_cardetailFragment;
import com.inq.eslamwael74.meme.Model.Car;
import com.inq.eslamwael74.meme.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 * Created by EslamWael74 on 1/25/2018.
 */

public class MainSearchcardetailAdapter extends PagerAdapter {

    private LayoutInflater layoutInflater;
    private FragmentActivity context;
    Car car;

    public MainSearchcardetailAdapter(Car car, FragmentActivity context) {
        this.car = car;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return car.getImages().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    void getCarDetailsFragment(Car car, int position) {

        if (position == 0) {
            MainSearch_cardetailFragment carDetailsFragment = MainSearch_cardetailFragment.newInstance();
            FragmentTransaction transaction = context.getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(
                            R.anim.enter_from_left,
                            R.anim.exit_from_left,
                            R.anim.enter_from_right,
                            R.anim.exit_from_right);
            transaction.replace(R.id.ad_details_frame, carDetailsFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    @Override
    public Object instantiateItem(ViewGroup viewGroup, final int position) {
        View view = layoutInflater.inflate(R.layout.slide_imageview_layout, viewGroup, false);


        final ImageView myImage = view.findViewById(R.id.image_details);
        final ProgressBar progressBar = view.findViewById(R.id.progressBar);

        myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCarDetailsFragment(car,position);

            }
        });

        Picasso.with(context)
                .load(car.getImages().get(position))
                .fit().centerCrop()
                .error(R.drawable.car_placeholder)
                .into(myImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        progressBar.setVisibility(View.GONE);
                    }
                });


        viewGroup.addView(view, 0);
        return view;
    }
}
