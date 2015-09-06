package com.cop.cals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class mydialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog);
        Intent intent =getIntent();
        if (intent!=null)
        {
            intent.getStringExtra("");
        }
    }
public void close(View v)
{
    finish();
}

}
