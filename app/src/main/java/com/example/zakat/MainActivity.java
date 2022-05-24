package com.example.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonBegin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBegin = (Button) findViewById(R.id.buttonBegin);
        buttonBegin.setOnClickListener(this);

    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu); // resource.directory.xml, variable param

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){

            case R.id.developer1:

                Toast.makeText(this,"Student's Information",Toast.LENGTH_LONG).show();
                //connect and display activitytab :
                Intent intentDev = new Intent(this, AboutUsZakat.class);
                startActivity(intentDev);
                break;

            case R.id.aboutus1:

                Toast.makeText(this,"Zakat App Information",Toast.LENGTH_LONG).show();
                Intent intentAbt = new Intent(this, AppInfo.class);
                startActivity(intentAbt);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.buttonBegin:

                Intent intentZakat = new Intent(this, ZakatProcess.class);
                startActivity(intentZakat);
                break;

        }
    }
}