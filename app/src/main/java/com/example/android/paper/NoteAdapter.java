package com.example.android.paper;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

class NoteAdapter extends BaseAdapter implements ListAdapter
{
    private Context context;
    private JSONArray arrayOfNotes;
    private LayoutInflater inflater;


    public NoteAdapter(Context context, JSONArray arrayOfNotes, LayoutInflater inflater)
    {
        this.context = context;
        this.arrayOfNotes = arrayOfNotes;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //This constructor is only for removing the error in adapter=new NoteAdapter(getApplicationContext(),notes) in MainActivity.
    public NoteAdapter(Context applicationContext, JSONArray notes)
    {

    }


    // Return number of notes
    @Override
    public int getCount()
    {
        if (this.arrayOfNotes != null)
            return this.arrayOfNotes.length();

        else
            return 0;
    }

    // Return note at position
    @Override
    public JSONObject getItem(int position)
    {
        if (this.arrayOfNotes != null)
            return this.arrayOfNotes.optJSONObject(position);

        else
            return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        return convertView;
    }




}