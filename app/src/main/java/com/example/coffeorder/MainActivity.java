package com.example.coffeorder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView qText = (TextView) findViewById(
                R.id.quantityCoffee);

        final TextView pText = (TextView) findViewById(
                R.id.priceCoffee);

        Button decreasebutton = (Button) findViewById(R.id.button);
        decreasebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (quantity >= 0) {
                    quantity--;
                } else
                    quantity = 0;
                qText.setText("" + quantity);
            }
        });

        Button increasebutton = (Button) findViewById(R.id.button2);
        increasebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                quantity++;
                qText.setText("" + quantity);
            }
        });

        Button calculate = (Button) findViewById(R.id.button3);
        calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int price = quantity * 17;
                pText.setText("" + price);
            }
        });

        Button resetbutton = (Button) findViewById(R.id.resetAll);
        resetbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                quantity = 0;
                pText.setText("" + quantity);
                qText.setText("" + quantity);
            }
        });

        Button orderbutton = (Button) findViewById(R.id.order);
        orderbutton.setOnClickListener(new View.OnClickListener(){
            public  void  onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Receipt")
                        .setMessage("Coffee  :  " + quantity + "\n" + "Price     :  " + quantity * 17 + " $"
                        + "\n" + "\n" + "\n" + "               Thank you for your oder")
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });
    }
}