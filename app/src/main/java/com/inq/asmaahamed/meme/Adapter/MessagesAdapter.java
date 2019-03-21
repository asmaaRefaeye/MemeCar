package com.inq.eslamwael74.meme.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inq.eslamwael74.meme.Model.Message;
import com.inq.eslamwael74.meme.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Omar on 2/1/2018.
 */

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.messageholder> {

    ArrayList<Message> Message;
    FragmentActivity fragmentActivity;

    public MessagesAdapter(FragmentActivity fragmentActivity, ArrayList<Message> messages) {
        this.Message = messages;
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public messageholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(fragmentActivity).
                inflate(R.layout.messeges_rowitem_fragment, parent, false);

        return new messageholder(view);


    }

    @Override
    public void onBindViewHolder(MessagesAdapter.messageholder holder, int position) {

        Message message = Message.get(position);
        holder.mesgName.setText(message.getMessageUserName());
        holder.mesgproduct.setText(message.getMessageProduct());
        holder.mesgdate.setText(message.getMessageDate());

    }

    @Override
    public int getItemCount() {
        return Message.size();
    }

    public class messageholder extends RecyclerView.ViewHolder {

        @BindView(R.id.mesg_personname)
        TextView mesgName;

        @BindView(R.id.messg_buymessage)
        TextView mesgproduct;

        @BindView(R.id.mesg_datemessage)
        TextView mesgdate;


        public messageholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
