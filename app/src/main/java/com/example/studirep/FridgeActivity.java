package com.example.studirep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FridgeActivity extends AppCompatActivity {
    ListView listView1;
    EditText inputtext1;
    Button btnAdd, btnEdit;

    ArrayList<String> foods = new ArrayList<String>();
    ArrayAdapter myAdapter1;

    Integer indexVal;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge);

        listView1 = (ListView) findViewById(R.id.listView1);
        btnAdd = (Button) findViewById(R.id.button);
        btnAdd = (Button) findViewById(R.id.button2);
        inputtext1 = (EditText) findViewById(R.id.editText);

        //setup listview
        myAdapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, foods);
        listView1.setAdapter(myAdapter1);

        //add items
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringVal = inputtext1.getText().toString();
                foods.add(stringVal);
                myAdapter1.notifyDataSetChanged();

                inputtext1.setText("");
            }
        });

        //select item
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + "has been selected.";
                indexVal = i;
                Toast.makeText(FridgeActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });

        //edit
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringVal = inputtext1.getText().toString();
                foods.set(indexVal, stringVal);
                myAdapter1.notifyDataSetChanged();
            }
        });

        //delete
        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + "has been deleted.";
                Toast.makeText(FridgeActivity.this, item, Toast.LENGTH_SHORT).show();

                foods.remove(i);
                myAdapter1.notifyDataSetChanged();
                return true;
            }
        });
    }
}
