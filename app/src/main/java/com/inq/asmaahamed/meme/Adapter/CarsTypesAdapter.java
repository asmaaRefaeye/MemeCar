package com.inq.eslamwael74.meme.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inq.eslamwael74.meme.Model.CarsTypes;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Omar on 2/1/2018.
 */

public class CarsTypesAdapter extends RecyclerView.Adapter<CarsTypesAdapter.Carsholder> {

    Context context;
    FragmentActivity fragmentActivity;
    List<CarsTypes> CarsTypes;
    ToolbarListener toolbarListener;

    public CarsTypesAdapter(ToolbarListener toolbarListener) {
        this.toolbarListener = toolbarListener;
    }

    public CarsTypesAdapter(Context context, List<CarsTypes> carsTypes, FragmentActivity fragmentActivity) {
        this.context = context;
        this.CarsTypes = carsTypes;
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public Carsholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messeges_rowitem_fragment, parent, false);
        Carsholder carsviewHolder = new Carsholder(view);

        return carsviewHolder;


    }

    @Override
    public void onBindViewHolder(CarsTypesAdapter.Carsholder holder, int position) {

        CarsTypes carsTypes = CarsTypes.get(position);

        Picasso.with(fragmentActivity)
                .load(carsTypes.getCarImage())
                .fit().centerCrop()
                .error(R.drawable.car_placeholder)
                .into(holder.cartypeImg, new Callback() {
                    @Override
                    public void onSuccess() {
                    }

                    @Override
                    public void onError() {
                    }
                });

        holder.carstypeName.setText(CarsTypes.get(position).getCarname());
        holder.carstypeRef.setText(CarsTypes.get(position).getCarRef());
        holder.carstypeSize.setText(CarsTypes.get(position).getCarsize());
        holder.carstypeColors.setText(CarsTypes.get(position).getCarcolors());
        holder.carstypePrice.setText(CarsTypes.get(position).getCarprice());

    }


    void openFragment(Fragment fragment, int id) {
        toolbarListener.setSearchImageVisibility(false);
        Fragment Fragment = fragment;
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
        return CarsTypes.size();
    }


    public class Carsholder extends RecyclerView.ViewHolder {

        @BindView(R.id.carstypes_Img)
        ImageView cartypeImg;

        @BindView(R.id.carstypes_name)
        TextView carstypeName;

        @BindView(R.id.carstypes_ref)
        TextView carstypeRef;

        @BindView(R.id.carstypes_size)
        TextView carstypeSize;

        @BindView(R.id.carstypes_colors)
        TextView carstypeColors;

        @BindView(R.id.carstypes_price)
        TextView carstypePrice;


        public Carsholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
