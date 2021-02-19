package com.example.adddelupd;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.text.Editable;
import android.text.TextWatcher;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView1;
    private EditText inputText1,inputText2;
    private Button btnAdd, btnEdit;

    ArrayList<String> foods = new ArrayList<String>();
    ArrayAdapter myAdapter1;

    Integer indexVal;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = (ListView) findViewById(R.id.listView1);
        btnAdd = (Button) findViewById(R.id.button);
        btnAdd = (Button) findViewById(R.id.button2);
        inputText1 = (EditText) findViewById(R.id.editText);
        inputText1.addTextChangedListener(inputTextWatcher);

        //setup listview
        myAdapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, foods);
        listView1.setAdapter(myAdapter1);
        foods.add("Tomato");

        //add items
        btnAdd = (Button) findViewById(R.id.button);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringVal = inputText1.getText().toString();
                if (!stringVal.isEmpty()) {
                    foods.add(stringVal);
                    myAdapter1.notifyDataSetChanged();
                    inputText1.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT); //doesn't work yet
                }
            }
        });

        //select item
        listView1 = (ListView) findViewById(R.id.listView1);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + " has been selected.";
                indexVal = i;
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });

        //edit
        btnEdit = (Button) findViewById(R.id.button2);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringVal = inputText1.getText().toString();
                foods.set(indexVal, stringVal);
                myAdapter1.notifyDataSetChanged();
            }
        });

        //delete
        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item = adapterView.getItemAtPosition(i).toString() + " has been deleted.";
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();

                foods.remove(i);
                myAdapter1.notifyDataSetChanged();
                return true;
            }
        });
    }

        private final TextWatcher inputTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String foodName = inputText1.getText().toString().trim();
                btnAdd.setEnabled(!foodName.isEmpty());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        };
    }