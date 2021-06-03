package com.example.android.droidcafeinput;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);

        RadioButton rb1 = findViewById(R.id.sameday);
        RadioButton rb2 = findViewById(R.id.nextday);
        RadioButton rb3 = findViewById(R.id.pickup);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String deliveryMethod = sharedPref.getString("delivery_list", "Same day messenger service");
        switch (deliveryMethod) {
            case "Same day messenger service":  rb1.setChecked(true);   break;
            case "Next day ground delivery":    rb2.setChecked(true);   break;
            case "Pick up":                     rb3.setChecked(true);   break;
        }
    }

    public void onRadioButtonClicked(@NonNull View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    displayToast(getString(R.string.same_day_messenger_service));
                break;

            case R.id.nextday:
                if (checked)
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;

            case R.id.pickup:
                if (checked)
                    displayToast(getString(R.string.pick_up));
                break;

            default: break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
