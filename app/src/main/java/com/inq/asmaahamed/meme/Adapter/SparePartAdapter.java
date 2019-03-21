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

import com.inq.eslamwael74.meme.Fragment.AccessoriesAdDetailsFragment;
import com.inq.eslamwael74.meme.Fragment.SpearPartDetailsFragment;
import com.inq.eslamwael74.meme.Model.Accessory;
import com.inq.eslamwael74.meme.Model.SpearPart;
import com.inq.eslamwael74.meme.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Eslam Wael on 2/2/2018.
 */

public class SparePartAdapter extends RecyclerView.Adapter<SparePartAdapter.MyViewHolder> {

    FragmentActivity fragmentActivity;
    ArrayList<SpearPart> spearParts;

    public SparePartAdapter(FragmentActivity fragmentActivity, ArrayList<SpearPart> spearParts) {
        this.fragmentActivity = fragmentActivity;
        this.spearParts = spearParts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(fragmentActivity).
                inflate(R.layout.accessroies_item, parent, false));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(fragmentActivity)
                .load(spearParts.get(position).getImage())
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
        holder.tvName.setText(spearParts.get(position).getName());
        holder.tvPrice.setText(spearParts.get(position).getPrice());

        holder.card.setOnClickListener(v -> {
            openFragment(SpearPartDetailsFragment.newInstance(spearParts.get(position)),R.id.spare_part_frame);
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
        return spearParts.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card)
        CardView card;

        @BindView(R.id.image)
        ImageView mImage;

        @BindView(R.id.acc_desc)
        TextView tvName;

        @BindView(R.id.price)
        TextView tvPrice;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
