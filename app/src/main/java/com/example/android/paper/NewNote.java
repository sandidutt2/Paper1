package com.example.android.paper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class NewNote extends AppCompatActivity
{
    public EditText titleEdit, noteEdit;
    private RelativeLayout relativeLayoutEdit;
    private Toolbar toolbar;
    private MenuItem removeEverything;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        titleEdit=(EditText) findViewById(R.id.titleEdit);
        noteEdit=(EditText) findViewById(R.id.noteEdit);
        relativeLayoutEdit=(RelativeLayout) findViewById(R.id.relativeLayout);
        toolbar=(Toolbar) findViewById(R.id.toolbarEdit);
        removeEverything=(MenuItem) findViewById(R.id.removeEverything);
    }

    public EditText getTitleEdit() {
        return titleEdit;
    }
}