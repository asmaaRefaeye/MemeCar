package com.inq.eslamwael74.meme.Fragment;


import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.inq.eslamwael74.meme.Adapter.AccessoriesAdapter;
import com.inq.eslamwael74.meme.Adapter.Adphoto_AdvsAdapter;
import com.inq.eslamwael74.meme.Model.Accessory;
import com.inq.eslamwael74.meme.Model.AddPhoto_Adv;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Omar on 2/8/2018.
 */

public class ad_morephotos_advertsfragment  extends Fragment {

// neeeeeeed data yaaaa asmaaaaaa


    AlertDialog dialog ;
    final static int  REQUEST_CAMERA  = 1;
    final static int SELECTED_FILES = 2 ;


    ToolbarListener toolbarListener;

    Context context;

    @BindView(R.id.add_photo_recycler)
    RecyclerView add_photo_RecyclerView;

    ArrayList<AddPhoto_Adv> addPhoto_Adv;

    @BindView(R.id.camera_addphoto_advng)
    ImageView addphoto;

    @OnClick(R.id.btn_addphoto)
    void addphoto (){
        ShowImage(context);

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getActivity();
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ad_morephotos_advertsfragment, container, false);
        toolbarListener = (ToolbarListener) getActivity();
        toolbarListener.setTextListener("إضافة إعلان");
        ButterKnife.bind(this, view);


        return view;
    }


    public void init(){

        addPhoto_Adv = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            addPhoto_Adv.add(new AddPhoto_Adv("https://i.ebayimg.com/00/s/MjM2WDMxNQ==/z/-9kAAOSwTA9X6Y7U/$_57.JPG?set_id=80000000000"));

        }

            Adphoto_AdvsAdapter adphoto_advsAdapter = new Adphoto_AdvsAdapter(getActivity(),addPhoto_Adv,toolbarListener);
    add_photo_RecyclerView.setHasFixedSize(true);
    add_photo_RecyclerView.setLayoutManager(new LinearLayoutManager(context));
    add_photo_RecyclerView.setAdapter(adphoto_advsAdapter);

    }

    public  void ShowImage (Context context){

        final CharSequence[] IconItems = {"camera", "gallary", "remove"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Images");

        builder.setItems(IconItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (IconItems[i].equals("camera")) {
                    Intent cintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cintent, REQUEST_CAMERA);


                } else if (IconItems[i].equals("gallary")) {
                    Intent gintent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    gintent.setType("image/*");
                    startActivityForResult(gintent.createChooser(gintent, "select file"), SELECTED_FILES);


                } else if (IconItems[i].equals("remove")) {
                    dialogInterface.dismiss();

                }

            }
        });
        dialog = builder.create();
        dialog.show();


    }

    @Override
    public void onDetach() {
        super.onDetach();
        toolbarListener.setTextListener(getString(R.string.home_page));
        toolbarListener.setSearchImageVisibility(false);
    }



}
