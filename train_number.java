package com.rail.injilaislam.railways;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Train_number extends AppCompatActivity {
    EditText t_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_number);
        t_num= (EditText) findViewById(R.id.editText);
        Button check = (Button) findViewById(R.id.button);

        check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String input = t_num.getText().toString();
                Log.e("Train Number ", input);
                Intent intentMain = new Intent(Train_number.this,
                            Route_map.class);
                intentMain.putExtra("Train_Number", input);
                Train_number.this.startActivity(intentMain);
            }
        });
    }

}
