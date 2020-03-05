package com.example.piyushstark.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2,ed3;
Button bt1,bt2,bt3;
    TextView tvshow;
    DatabaseHelper databaseHelper;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.ed1);
        ed2=(EditText)findViewById(R.id.ed2);
        ed3=(EditText)findViewById(R.id.ed3);
        bt1=(Button)findViewById(R.id.bt1);
        tvshow=(TextView)findViewById(R.id.tvshow);

        databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();



        bt1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        databaseHelper.saveData(ed1.getText().toString(),ed2.getText().toString(),Integer.parseInt(ed3.getText().toString()));
        StringBuffer stringBuffer=databaseHelper.getData();
        tvshow.setText(stringBuffer.toString());

    }
});



    }
}
