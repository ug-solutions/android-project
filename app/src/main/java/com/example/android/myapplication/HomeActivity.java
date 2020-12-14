package com.example.android.myapplication;

// import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
// import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    LinearLayout layout_list;
    Button buttonAdd;


    //    List<String> teamList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        layout_list = findViewById(R.id.layout_list);
        buttonAdd = findViewById(R.id.button_add);

        buttonAdd.setOnClickListener((View.OnClickListener) this);

//        teamList.add("Team");
//        teamList.add("India");
//        teamList.add("England");
//        teamList.add("Austrilia");

    }


    public void onClick(View v) {
        addView();
    }

    private void addView() {

        final View listView = getLayoutInflater().inflate(R.layout.row_add_list,null,false);

        EditText editText = (EditText)listView.findViewById(R.id.edit_name);
        EditText editText1 = (EditText) listView.findViewById(R.id.edit_Vccno);  
        EditText editText2 = (EditText)listView.findViewById(R.id.edit_date);
        

//        AppCompatSpinner spinnerTeam = (AppCompatSpinner)listView.findViewById(R.id.spinner_team);
        ImageView imageClose = (ImageView)listView.findViewById(R.id.image_remove);

//        ArrayAdapter arrayAdapter  = new ArrayAdapter(this,android.R.layout.simple_spinner_item,teamList);
//        spinnerTeam.setAdapter(arrayAdapter);

        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeView(listView);
            }
        });

        layout_list.addView(listView);
    }

    private void removeView(View view) {


        layout_list.removeView(view);
    }
}
