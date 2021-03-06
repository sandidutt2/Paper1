package com.example.android.paper;
import com.example.android.paper.EditNote;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
{

    //private static File localPath, backupPath;//?

    // Layout components
    private static ListView listView;
    private ImageButton newNote;

    ArrayList<String> title=new ArrayList<>();
    public static ArrayList<String> notes=new ArrayList<>();
    static ArrayAdapter arrayAdapter;

    private Toolbar toolbar;
    private MenuItem searchMenu;

    //private static JSONArray notes;
    private static NoteAdapter adapter;

    public static ArrayList<Integer> notesForDelete=new ArrayList<>();
    public static boolean deleteNote=false;//True if deleteNote is active,false otherwise.



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newNote=(ImageButton) findViewById(R.id.newNote);

        listView=(ListView) findViewById(R.id.listView);
        newNote=(ImageButton) findViewById(R.id.newNote);


        searchMenu=(MenuItem) findViewById(R.id.action_search);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle("Pages");
        }
        toolbar.setSubtitle("A note taking app");
        toolbar.inflateMenu(R.menu.menu_main);

        notes.add("Example note");
        arrayAdapter=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,notes);
        listView.setAdapter(arrayAdapter);


        newNote.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),EditNote.class);
                startActivity(intent);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent=new Intent(MainActivity.this,EditNote.class);
                intent.putExtra("titleId",i);
                intent.putExtra("noteId",i);
                startActivity(intent);

            }
        });







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }





}



