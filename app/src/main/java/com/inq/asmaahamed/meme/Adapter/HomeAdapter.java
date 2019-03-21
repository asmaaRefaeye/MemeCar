package com.inq.eslamwael74.meme.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inq.eslamwael74.meme.Model.CardDescription;
import com.inq.eslamwael74.meme.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


import java.util.List;

/**
 * Created by Omar on 1/26/2018.
 */


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context context;
    List<CardDescription> cardDescriptions;
    FragmentActivity fragmentActivity;

    public HomeAdapter(Context context, List<CardDescription> cardDescriptions, FragmentActivity fragmentActivity) {
        this.context = context;
        this.cardDescriptions = cardDescriptions;
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_fragment, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CardDescription description = cardDescriptions.get(position);


        Picasso.with(context)
                .load(description.getImage())
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



        holder.tvName.setText(description.getName());


    }

    @Override
    public int getItemCount() {
        return cardDescriptions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImage;
        private TextView tvName;


        public ViewHolder(View itemView) {
            super(itemView);
//           mImage = itemView.findViewById(R.id.grditem_img);
//            tvName = itemView.findViewById(R.id.griditem_txt);

        }
    }

}
