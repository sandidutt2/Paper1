package com.example.android.paper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class EditNote extends AppCompatActivity
{
    public EditText titleEdit, noteEdit;
    private RelativeLayout relativeLayoutEdit;
    private Toolbar toolbar;
    private MenuItem removeEverything;
    int titleId,noteId;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        titleEdit=(EditText) findViewById(R.id.titleEdit);
        noteEdit=(EditText) findViewById(R.id.noteEdit);
        relativeLayoutEdit=(RelativeLayout) findViewById(R.id.relativeLayout);


        removeEverything=(MenuItem) findViewById(R.id.removeEverything);

        toolbar=(Toolbar) findViewById(R.id.toolbarEdit);
        getSupportActionBar(toolbar);

        toolbar.setTitle("Paper");
        toolbar.setSubtitle("A note taking app");
        toolbar.inflateMenu(R.menu.menu_edit);

        Menu menu=toolbar.getMenu();

        Intent intent=getIntent();
         titleId=intent.getIntExtra("titleId",-1);
         noteId=intent.getIntExtra("noteId",-1);

        if(titleId!=-1 && noteId!=-1)
        {
            titleEdit.setText(MainActivity.notes.get(titleId));
            noteEdit.setText(MainActivity.notes.get(noteId));
        }
        else
        {
            MainActivity.notes.add("");
            titleId=MainActivity.notes.size()-1;
            noteId=MainActivity.notes.size()-1;
        }



        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener()
        {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem)
            {
                int id=menuItem.getItemId();
                if(id==R.id.removeEverything)
                {
                    noteEdit.setText("");

                }

                return false;
            }
        });

        titleEdit.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                MainActivity.notes.set(titleId,String.valueOf(charSequence));
                MainActivity.arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable editable)
            {

            }
        });
        /*

        noteEdit.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                //MainActivity.notes.set(noteId,String.valueOf(charSequence));
                //MainActivity.arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable editable)
            {

            }
        });
        */

    }
    //This method is used only to remove the error for the function getSupportActionBar in onCreate method.

    private MenuItem getSupportActionBar(Toolbar toolbar)
    {
        return removeEverything;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_edit, menu);

        // return true so that the menu pop up is opened
        return true;
    }






}
