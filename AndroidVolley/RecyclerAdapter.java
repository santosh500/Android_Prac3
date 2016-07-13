package com.example.santo_000.volleydemo2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by santo_000 on 7/12/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>
{

    ArrayList<Contact> arrayList = new ArrayList<>();

    public RecyclerAdapter(ArrayList<Contact> arrayList)
    {
        this.arrayList = arrayList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.text_id.setText(arrayList.get(position).getID());
        holder.text_uid.setText(arrayList.get(position).getUID());
        holder.text_type.setText(arrayList.get(position).getType());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView text_id,text_uid,text_type;

        public MyViewHolder(View itemView) {
            super(itemView);

            text_id = (TextView)itemView.findViewById(R.id.ID);
            text_uid = (TextView)itemView.findViewById(R.id.userID);
            text_type = (TextView)itemView.findViewById(R.id.type);

        }
    }
}
