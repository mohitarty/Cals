package com.cop.cals;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String[] prgmNameList = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public static int[] prgmImages = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o,
            R.drawable.p,
            R.drawable.q,
            R.drawable.r,
            R.drawable.s,
            R.drawable.t,
            R.drawable.u,
            R.drawable.v,
            R.drawable.w,
            R.drawable.x,
            R.drawable.y,
            R.drawable.z,


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new CustomAdapter(this, prgmNameList, prgmImages));
        gv.setOnItemClickListener(this);
    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Intent intent= new Intent(this,mydialog.class);
        Intent intent = null;
        if (position == 0) {
            intent = new Intent(view.getContext(), apple.class);
        }
        if (position == 1) {
            intent = new Intent(view.getContext(), boy.class);
        }
        if (position == 2) {
            intent = new Intent(view.getContext(), car.class);
        }
        if (position == 3) {
            intent = new Intent(view.getContext(), donkey.class);
        }
        if (position == 4) {
            intent = new Intent(view.getContext(), ear.class);
        }
        if (position == 5) {
            intent = new Intent(view.getContext(), fly.class);
        }
        if (position == 6) {
            intent = new Intent(view.getContext(), goat.class);
        }
        if (position == 7) {
            intent = new Intent(view.getContext(), horse.class);
        }
        if (position == 8) {
            intent = new Intent(view.getContext(), iron.class);
        }
        if (position == 9) {
            intent = new Intent(view.getContext(), joker.class);
        }
        if (position == 10) {
            intent = new Intent(view.getContext(), kite.class);
        }
        if (position == 11) {
            intent = new Intent(view.getContext(), lion.class);
        }
        if (position == 12) {
            intent = new Intent(view.getContext(), monkey.class);
        }
        if (position == 13) {
            intent = new Intent(view.getContext(), nurse.class);
        }
        if (position == 14) {
            intent = new Intent(view.getContext(), owl.class);
        }
        if (position == 15) {
            intent = new Intent(view.getContext(), parrot.class);
        }
        if (position == 16) {
            intent = new Intent(view.getContext(), queen.class);
        }
        if (position == 17) {
            intent = new Intent(view.getContext(), rat.class);
        }
        if (position == 18) {
            intent = new Intent(view.getContext(), ship.class);
        }
        if (position == 19) {
            intent = new Intent(view.getContext(), tiger.class);
        }
        if (position == 20) {
            intent = new Intent(view.getContext(), umbrella.class);
        }
        if (position == 21) {
            intent = new Intent(view.getContext(), viagra.class);
        }
        if (position == 22) {
            intent = new Intent(view.getContext(), worm.class);
        }
        if (position == 23) {
            intent = new Intent(view.getContext(), xray.class);
        }
        if (position == 24) {
            intent = new Intent(view.getContext(), yolk.class);
        }
        if (position == 25) {
            intent = new Intent(view.getContext(), zebra.class);
        }


        startActivity(intent);

    }



    private static final int TIME_INTERVAL = 2000; // # milliseconds, desired time passed between two back presses.
    private long mBackPressed;

    @Override
    public void onBackPressed() {
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed(); // not calling the default onBackPressed
            //android.os.Process.killProcess(android.os.Process.myPid());
            //System.exit(1);
            return;
        } else {
            Toast.makeText(getBaseContext(), "Press back again to leave", Toast.LENGTH_SHORT).show();
        }

        mBackPressed = System.currentTimeMillis();
    }
@Override
  public boolean onCreateOptionsMenu(Menu menu){
    getMenuInflater().inflate(R.menu.menu_main, menu);


      return true;
  }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(MainActivity.this,credits.class);
                startActivity(intent);
                return true;
            case R.id.action_auto:
                Intent inte = new Intent(MainActivity.this,apple.class);
                startActivity(inte);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


