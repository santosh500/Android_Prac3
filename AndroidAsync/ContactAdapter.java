package com.example.santo_000.jsonparsingdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by santo_000 on 6/26/2016.
 */
public class ContactAdapter extends ArrayAdapter
{

    List list = new ArrayList();
    public ContactAdapter(Context context, int resource, List list) {
        super(context, resource);
        this.list = list;
    }


    public ContactAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Contacts object)
    {
        super.add(object);
        list.add(object);
    }

    public int getCount()
    {
        return list.size();

    }

    public Object getItem(int position)
    {
        return list.get(position);

    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row;
        row = convertView;
        ContactHolder contactHolder;
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            contactHolder = new ContactHolder();
            contactHolder.tx_name = (TextView)row.findViewById(R.id.tx_name);
            contactHolder.tx_lname = (TextView)row.findViewById(R.id.tx_lname);
            contactHolder.tx_email = (TextView)row.findViewById(R.id.tx_email);
            row.setTag(contactHolder);

        }
        else
        {
            contactHolder = (ContactHolder) row.getTag();
        }
        Contacts contacts = (Contacts) this.getItem(position);
        contactHolder.tx_name.setText(contacts.getFirst_name());
        contactHolder.tx_lname.setText(contacts.getLast_name());
        contactHolder.tx_email.setText(contacts.getEmail());
        return row;
    }

    static class ContactHolder
    {
        TextView tx_name,tx_lname, tx_email;

    }


}
