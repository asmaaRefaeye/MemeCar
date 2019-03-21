package com.inq.eslamwael74.meme.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.inq.eslamwael74.meme.Model.AddPhoto_Adv;
import com.inq.eslamwael74.meme.Model.CarsTypes;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Omar on 2/8/2018.
 */

public class Adphoto_AdvsAdapter extends RecyclerView.Adapter<Adphoto_AdvsAdapter.photoholder> {

    Context context;
    FragmentActivity fragmentActivity;
    List<AddPhoto_Adv> AddPhoto_Adv;
    ToolbarListener toolbarListener;

    public Adphoto_AdvsAdapter(Context context, FragmentActivity fragmentActivity,
                               List<AddPhoto_Adv> addPhoto_Adv, ToolbarListener toolbarListener) {
        this.context = context;
        this.fragmentActivity = fragmentActivity;
        this.AddPhoto_Adv = addPhoto_Adv;
        this.toolbarListener = toolbarListener;
    }

    public Adphoto_AdvsAdapter(Activity activity, ArrayList<AddPhoto_Adv> addPhoto_adv, ToolbarListener toolbarListener) {
    }

    @Override
    public Adphoto_AdvsAdapter.photoholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ad_morephotos_itemrow_advertsfragment, parent, false);
        photoholder addPhoto_advholder = new photoholder(view);

        return addPhoto_advholder;

    }

    @Override
    public void onBindViewHolder(Adphoto_AdvsAdapter.photoholder holder, int position) {
        Picasso.with(fragmentActivity)
                .load(AddPhoto_Adv.get(position).getNewphoto())
                .fit().centerCrop()
                .error(R.drawable.car_placeholder)
                .into(holder.addnewphoto, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                    }
                });

    }

    @Override
    public int getItemCount() {
        return AddPhoto_Adv.size();
    }

    public class photoholder extends RecyclerView.ViewHolder {


        @BindView(R.id.ad_photo_item)
        ImageView addnewphoto;

        public photoholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}





