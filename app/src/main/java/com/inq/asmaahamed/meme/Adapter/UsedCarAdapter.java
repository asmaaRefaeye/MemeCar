package com.inq.eslamwael74.meme.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inq.eslamwael74.meme.Fragment.AdDetailsFragment;
import com.inq.eslamwael74.meme.Model.Car;
import com.inq.eslamwael74.meme.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Eslam Wael on 2/2/2018.
 */

public class UsedCarAdapter extends RecyclerView.Adapter<UsedCarAdapter.MyViewHolder> {

    FragmentActivity fragmentActivity;
    ArrayList<Car> cars;

    public UsedCarAdapter(FragmentActivity fragmentActivity, ArrayList<Car> cars) {
        this.fragmentActivity = fragmentActivity;
        this.cars = cars;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(fragmentActivity).
                inflate(R.layout.car_item, parent, false));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(fragmentActivity)
                .load(cars.get(position).getImages().get(position))
                .fit().centerCrop()
                .error(R.drawable.car_placeholder)
                .into(holder.mImage, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                    }
                });
        holder.tvRef.setText(cars.get(position).getStatus());
        holder.tvSize.setText(cars.get(position).getStatus());
        holder.tvColor.setText(cars.get(position).getStatus());

        holder.card.setOnClickListener(v -> {
            openFragment(
                    AdDetailsFragment.newInstance(cars.get(position)), R.id.used_car_frame);
        });
    }

    void openFragment(Fragment fragment, int id) {
        Fragment Fragment = fragment;
        FragmentTransaction fragmentTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(
                        R.anim.enter_from_left,
                        R.anim.exit_from_left,
                        R.anim.enter_from_right,
                        R.anim.exit_from_right);
        fragmentTransaction.replace(id, Fragment);
//        getSupportFragmentManager().popBackStack();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    public int getItemCount() {
        return cars.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card)
        CardView card;

        @BindView(R.id.image)
        ImageView mImage;

        @BindView(R.id.tv_res)
        TextView tvRef;

        @BindView(R.id.tv_size)
        TextView tvSize;

        @BindView(R.id.tv_color)
        TextView tvColor;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
