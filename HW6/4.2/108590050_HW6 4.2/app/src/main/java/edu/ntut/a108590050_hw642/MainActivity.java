package edu.ntut.a108590050_hw642;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkBox1;
    private CheckBox chkBox2;
    private CheckBox chkBox3;
    private CheckBox chkBox4;
    private CheckBox chkBox5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkBox1 = (CheckBox) findViewById(R.id.checkBox_1);
        chkBox2 = (CheckBox) findViewById(R.id.checkBox_2);
        chkBox3 = (CheckBox) findViewById(R.id.checkBox_3);
        chkBox4 = (CheckBox) findViewById(R.id.checkBox_4);
        chkBox5 = (CheckBox) findViewById(R.id.checkBox_5);

        if (savedInstanceState != null) {
            chkBox1.setChecked(savedInstanceState.getBoolean("chkBox1"));
            chkBox2.setChecked(savedInstanceState.getBoolean("chkBox2"));
            chkBox3.setChecked(savedInstanceState.getBoolean("chkBox3"));
            chkBox4.setChecked(savedInstanceState.getBoolean("chkBox4"));
            chkBox5.setChecked(savedInstanceState.getBoolean("chkBox5"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("chkBox1", chkBox1.isChecked());
        outState.putBoolean("chkBox2", chkBox2.isChecked());
        outState.putBoolean("chkBox3", chkBox3.isChecked());
        outState.putBoolean("chkBox4", chkBox4.isChecked());
        outState.putBoolean("chkBox5", chkBox5.isChecked());
    }

    public void onSubmit(View btn) {
        String msg = "Toppings: ";
        if (chkBox1.isChecked())
            msg += chkBox1.getText().toString() + " ";
        if (chkBox2.isChecked())
            msg += chkBox2.getText().toString() + " ";
        if (chkBox3.isChecked())
            msg += chkBox3.getText().toString() + " ";
        if (chkBox4.isChecked())
            msg += chkBox4.getText().toString() + " ";
        if (chkBox5.isChecked())
            msg += chkBox5.getText().toString() + " ";

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }



}