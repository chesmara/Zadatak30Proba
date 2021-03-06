package com.example.androiddevelopment.zadatak30proba.activity;

import android.app.Dialog;


import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import android.widget.Toast;

import com.example.androiddevelopment.zadatak30proba.R;
import com.example.androiddevelopment.zadatak30proba.db1.model.DatabaseHelper;
import com.example.androiddevelopment.zadatak30proba.db1.model.Glumac;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refresh();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create:
                addItem();
                Toast.makeText(this, "Unos novog glumca!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_update:
               refresh ();
                Toast.makeText(this, "Osvezavanje liste glumaca!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                Toast.makeText(this, "Opcija brisanja glumca!!", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    public void addItem( )  {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_layout);

        final EditText glumacName = (EditText) dialog.findViewById(R.id.glumac_name);
        final EditText glumacDescr = (EditText) dialog.findViewById(R.id.glumac_description);
        final EditText glumacRating = (EditText) dialog.findViewById(R.id.glumac_rating);
        final EditText glumacBirthDay = (EditText) dialog.findViewById(R.id.glumac_birth);


        Button ok = (Button) dialog.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= glumacName.getText().toString();
                String desct= glumacDescr.getText().toString();
                String rating=glumacRating.getText().toString();
                String birthday=glumacBirthDay.getText().toString();

                Toast.makeText(MainActivity.this,"pre ok", Toast.LENGTH_SHORT).show();

                Glumac glumac = new Glumac();
                glumac.setName(name);
                glumac.setDescribe(desct);
                glumac.setRating(rating);
                glumac.setBirthday(birthday);





                Toast.makeText(MainActivity.this,"posle", Toast.LENGTH_SHORT).show();

                try {
                    Toast.makeText(MainActivity.this,"Glumac pre inserted!", Toast.LENGTH_SHORT).show();

                    getDatabaseHelper().getGlumacDao().create(glumac);
                    refresh();
                    Toast.makeText(MainActivity.this,"Glumac inserted!", Toast.LENGTH_SHORT).show();

                    List<Glumac> list = getDatabaseHelper().getGlumacDao().queryForAll();
                    Toast.makeText(MainActivity.this, String.valueOf(list.size()) ,Toast.LENGTH_SHORT).show();

                } catch (SQLException e) {
                    e.printStackTrace();
                }









            }
        });



        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }


    public DatabaseHelper getDatabaseHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }


    private void refreshSimo() {
        ListView listview = (ListView) findViewById(R.id.listaGlumaca);

        if (listview != null){
            ArrayAdapter<Glumac> adapter = (ArrayAdapter<Glumac>) listview.getAdapter();

            if(adapter!= null)
            {
                try {
                    adapter.clear();
                    List<Glumac> list = getDatabaseHelper().getGlumacDao().queryForAll();
                    Toast.makeText(MainActivity.this, String.valueOf(list.size()) ,Toast.LENGTH_SHORT).show();
                    adapter.addAll(list);

                    adapter.notifyDataSetChanged();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    private void refresh(){

        ListView listview = (ListView) findViewById(R.id.listaGlumaca);

        ArrayAdapter<Glumac> glumacArrayAdapter = new ArrayAdapter<Glumac> (this, R.layout.list_item);

        listview.setAdapter(glumacArrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);


            }

        });
    }









    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
