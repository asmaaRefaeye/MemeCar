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
import com.inq.eslamwael74.meme.Model.Accessory;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Eslam Wael on 2/2/2018.
 */

public class AccessoriesAdapter extends RecyclerView.Adapter<AccessoriesAdapter.MyViewHolder> {

    FragmentActivity fragmentActivity;
    ArrayList<Accessory> accessories;
    ToolbarListener toolbarListener;

    public AccessoriesAdapter(FragmentActivity fragmentActivity, ArrayList<Accessory> accessories, ToolbarListener toolbarListener) {
        this.fragmentActivity = fragmentActivity;
        this.accessories = accessories;
        this.toolbarListener = toolbarListener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(fragmentActivity).
                inflate(R.layout.accessroies_item, parent, false));

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(fragmentActivity)
                .load(accessories.get(position).getImage())
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
        holder.tvName.setText(accessories.get(position).getName());
        holder.tvPrice.setText(accessories.get(position).getPrice());

        holder.card.setOnClickListener(v -> {
            openFragment(AccessoriesAdDetailsFragment.newInstance(accessories.get(position)),R.id.accessories_frame);
    });
    }

    void openFragment(Fragment fragment, int id) {  //u have defined the method 2 times ?
        // how ?
        toolbarListener.setSearchImageVisibility(false); // this is work .... ahat is problem in other fragment
        Fragment Fragment = fragment; //where is this
        FragmentTransaction fragmentTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction().
                setCustomAnimations(
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
        return accessories.size();
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
