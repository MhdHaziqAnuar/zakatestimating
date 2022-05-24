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

public class ZakatProcess extends AppCompatActivity implements View.OnClickListener {

    TextView output1;
    TextView output2;
    TextView output3;

    EditText weight;
    EditText value;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_process);

        //process1
        weight = (EditText) findViewById(R.id.editweightgold);
        if(weight.getText().toString().equals("")){
            weight.setError("Please fill the weight (g).");
        }
        value = (EditText) findViewById(R.id.editvaluegold);
        if(value.getText().toString().equals("")){
            value.setError("Please fill the value per (g).");
        }
        output1 = (TextView) findViewById(R.id.totalvaluegold);
        button1 = (Button) findViewById(R.id.buttonTotal1);
        button1.setOnClickListener(this);

        //process2
        output2 = (TextView) findViewById(R.id.totalvaluepayable);
        output3 = (TextView) findViewById(R.id.totalvaluezakat);
        button2 = (Button) findViewById(R.id.buttontotal2);
        button2.setOnClickListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu); // resource.directory.xml, variable param

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){

            case R.id.developer1:

                Toast.makeText(this,"Student's Information",Toast.LENGTH_SHORT).show();
                //connect and display activitytab :
                Intent intentDev = new Intent(this, AboutUsZakat.class);
                startActivity(intentDev);
                break;

            case R.id.aboutus1:

                Toast.makeText(this,"Zakat App Information",Toast.LENGTH_SHORT).show();
                Intent intentAbt = new Intent(this, AppInfo.class);
                startActivity(intentAbt);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        double weightgram;
        double valuegram;
        double totalvaluegold;
        int keep = 85;
        int wear = 200;
        double zakatpayable;
        double totalzakat;

        switch (view.getId()){

            case R.id.buttonTotal1:

                //process1
                weightgram = Double.parseDouble(weight.getText().toString());
                valuegram = Double.parseDouble(value.getText().toString());
                totalvaluegold = weightgram * valuegram;

                //process2
                zakatpayable = (weightgram - keep) * valuegram;
                if(zakatpayable < 0.0)
                {
                    totalzakat = 0 * 0.025;
                    output1.setText("Total Value Gold: RM"+totalvaluegold);
                    output2.setText("Total Zakat Payable: RM"+zakatpayable+" or RM0.00 because Zakat Payable is less than 0.");
                    output3.setText("Total Zakat : RM "+totalzakat);
                }

                else
                {
                    totalzakat = zakatpayable * 0.025;
                    output1.setText("Total Value Gold: RM"+totalvaluegold);
                    output2.setText("Total Zakat Payable: RM"+zakatpayable);
                    output3.setText("Total Zakat : RM "+totalzakat);
                }
                Toast.makeText(this,"Successfully calculated for Keep.",Toast.LENGTH_LONG).show();

                break;

            case R.id.buttontotal2:

                //process1
                weightgram = Double.parseDouble(weight.getText().toString());
                valuegram = Double.parseDouble(value.getText().toString());
                totalvaluegold = weightgram * valuegram;

                //process2
                zakatpayable = (weightgram - wear) * valuegram;
                if(zakatpayable < 0.0)
                {
                    totalzakat = 0 * 0.025;
                    output1.setText("Total Value Gold: RM"+totalvaluegold);
                    output2.setText("Total Zakat Payable: RM"+zakatpayable+" or RM0.00 because Zakat Payable is less than 0.");
                    output3.setText("Total Zakat : RM "+totalzakat);
                }

                else
                {
                    totalzakat = zakatpayable * 0.025;
                    output1.setText("Total Value Gold: RM"+totalvaluegold);
                    output2.setText("Total Zakat Payable: RM"+zakatpayable);
                    output3.setText("Total Zakat : RM "+totalzakat);
                }
                Toast.makeText(this,"Successfully calculated for Wear.",Toast.LENGTH_LONG).show();


            break;
        }

    }
}
