package com.example.android.paper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class NewNote extends AppCompatActivity
{
    public EditText title, note;
    private RelativeLayout relativeLayoutEdit;
    private Toolbar toolbar;
    private MenuItem removeEverything;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        title=(EditText) findViewById(R.id.title);
        note=(EditText) findViewById(R.id.note);
        relativeLayoutEdit=(RelativeLayout) findViewById(R.id.relativeLayout);
        toolbar=(Toolbar) findViewById(R.id.toolbarEdit);
        removeEverything=(MenuItem) findViewById(R.id.removeEverything);


        String getTitle=title.getText().toString().trim();
        String getNote=note.getText().toString().trim();

        //ArrayList<getTitle> titleList=new ArrayList<getTitle>();


    }


}