package com.inq.eslamwael74.meme.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inq.eslamwael74.meme.Model.Accessory;
import com.inq.eslamwael74.meme.Model.SearchCar;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Omar on 2/4/2018.
 */

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.SerchCarsholder> {



    Context context;
    ArrayList<com.inq.eslamwael74.meme.Model.SearchCar> fragmentActivity;
    List<SearchCar> SearchCar;
    ToolbarListener toolbarListener;

    public SearchResultAdapter(FragmentActivity activity, ArrayList<Accessory> searchCars, ToolbarListener toolbarListener) {
        this.toolbarListener = toolbarListener;
    }

    public SearchResultAdapter(Context context, ArrayList<com.inq.eslamwael74.meme.Model.SearchCar> fragmentActivity, ToolbarListener searchCar) {
        this.context = context;
        this.fragmentActivity = fragmentActivity;
        this.SearchCar = (List<com.inq.eslamwael74.meme.Model.SearchCar>) searchCar;
    }

    @Override
    public SerchCarsholder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.searchcars_item_row_fragment, parent, false);
        SerchCarsholder SearchcarsviewHolder = new SerchCarsholder(view);

        return SearchcarsviewHolder;


    }

    @Override
    public void onBindViewHolder(SerchCarsholder holder, int position) {




        holder.CarDescription.setText(SearchCar.get(position).getCarDescription_txt());
        holder.TextCarSpeed.setText(SearchCar.get(position).getCarSpeed_txt());
        holder.TextCarSpeed_Km.setText(SearchCar.get(position).getCarspeed_Km_txt());
        holder.TextCarSpeed_hr.setText(SearchCar.get(position).getCarSpeed_hr_txt());
        holder.TextSearchDate.setText(SearchCar.get(position).getSearchDate_txt());

    }

  /*void openFragment(Fragment fragment, int id) { //from where u call this method ?
        toolbarListener.setSearchImageVisibility(false); //ok wait
        Fragment Fragment = fragment;   //I GUESS GETSUPPORTFRAGMENTMANAGER is a method of context or activity  .... i delrt it .. iam stubit
        FragmentTransaction fragmentTransaction =fragmentActivity
                //fragmentActivity.getSupportFragmentManager().beginTransaction().
                setCustomAnimations(
                        R.anim.enter_from_left,
                        R.anim.exit_from_left,
                        R.anim.enter_from_right,
                        R.anim.exit_from_right);
        fragmentTransaction.replace(id, Fragment);
//        getSupportFragmentManager().popBackStack();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }*/


    @Override
    public int getItemCount() {
        return SearchCar.size();
    }

    public class SerchCarsholder extends RecyclerView.ViewHolder{

        @BindView(R.id.frSearchcar_img)
        ImageView fristSearchCar;

        @BindView(R.id.scSerchcar_img)
        ImageView secondSearchCar;

        @BindView(R.id.cars_desciption_txt)
        TextView CarDescription;

        @BindView(R.id.carspeed_txt)
        TextView TextCarSpeed;

        @BindView(R.id.carspeedkm_txt)
        TextView TextCarSpeed_Km;

        @BindView(R.id.searchdate_txt)
        TextView TextSearchDate;

        @BindView(R.id.car_speed_hr_txt)
        TextView TextCarSpeed_hr;



        public SerchCarsholder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
