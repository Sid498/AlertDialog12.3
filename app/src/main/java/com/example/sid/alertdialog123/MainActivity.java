package com.example.sid.alertdialog123;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCustom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCustom = (Button) findViewById(R.id.btnCustomDialog);
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //this for custom dialog
                final Dialog dialog = new Dialog(MainActivity.this);
                //setting this field to false because if user click outside it should not allow to close the dialog
                dialog.setCanceledOnTouchOutside(false);
                dialog.setContentView(R.layout.dialog);
                dialog.show();

                //setting buttons for closing app or canceling the dialog
                Button btnYes = (Button) dialog.findViewById(R.id.btnYes);
                Button btnNo = (Button) dialog.findViewById(R.id.btnNo);

                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //closing the app
                        finish();
                    }
                });

                btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //dismissing the app
                        dialog.dismiss();
                    }
                });
            }
        });

        final Button btnShow = (Button) findViewById(R.id.btnAlert);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                    builder = new AlertDialog.Builder(MainActivity.this,android.R.style.Theme_Material_Dialog_Alert);
                }
                else {
                    builder = new AlertDialog.Builder(getApplicationContext());
                }
                builder.setTitle("Confirm Delete..").setMessage("Are you sure you want to delete this?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setIcon(R.drawable.alert).show();
            }
        });
    }
}
