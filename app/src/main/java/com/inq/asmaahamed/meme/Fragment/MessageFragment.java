package com.inq.eslamwael74.meme.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inq.eslamwael74.meme.Adapter.AccessoriesAdapter;
import com.inq.eslamwael74.meme.Adapter.MessagesAdapter;
import com.inq.eslamwael74.meme.Model.Message;
import com.inq.eslamwael74.meme.R;
import com.inq.eslamwael74.meme.ToolbarListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Omar on 1/30/2018.
 */

public class MessageFragment extends Fragment {


    private static final String ARG_Ex = "AdDetailsFragment";
    private String example;
    ToolbarListener toolbarListener;

    @BindView(R.id.message_recycler)
    RecyclerView mRecyclerView;

    int type;


    public static MessageFragment newInstance(int type) {
        MessageFragment firstFragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_Ex, type);
        firstFragment.setArguments(args);
        return firstFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getInt(ARG_Ex);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.message_fragment,container,false);
        ButterKnife.bind(this,view);
        toolbarListener = (ToolbarListener) getActivity();
        toolbarListener.setTextListener(getString(R.string.me_messages));

        init();

        return view;
    }

    void init(){

        ArrayList<Message> messages = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            messages.add(new Message("as","NewMessage","12/2"));
        }

        MessagesAdapter messagesAdapter = new MessagesAdapter(getActivity(),messages);
//        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(messagesAdapter);
    }


    public void onDetach() {
        super.onDetach();
        if (type == 0){
            toolbarListener.setTextListener(getString(R.string.home_page));
        }
        else{
            toolbarListener.setTextListener(getString(R.string.profile));
        }
    }

}
