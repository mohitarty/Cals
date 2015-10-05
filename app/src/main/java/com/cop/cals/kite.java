package com.cop.cals;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class kite extends AppCompatActivity {
    private GestureDetectorCompat gestureDetectorCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kite);
        final MediaPlayer mp = MediaPlayer.create(kite.this,R.raw.kk);

        Button bt=(Button)findViewById(R.id.button2);
        Button bt2 =(Button)findViewById(R.id.button3);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(kite.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                mp.stop();
                finish();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mp.isPlaying()) {
                    mp.pause();
                }
                else {
                    mp.start();
                }
            }
        });
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                Intent stopplay= new Intent(kite.this,lion.class);
                stopplay.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(stopplay);
                finish();
                overridePendingTransition(R.anim.left_in, R.anim.left_out);




            }

        });

        gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        //handle 'swipe left' action only

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {

         /*
         Toast.makeText(getBaseContext(),
          event1.toString() + "\n\n" +event2.toString(),
          Toast.LENGTH_SHORT).show();
         */
            if(event2.getX() < event1.getX()){


                //switch another activity
                Intent intent = new Intent(kite.this, lion.class);
                startActivity(intent);finish();
                overridePendingTransition(R.anim.left_in, R.anim.left_out);
            }else if (event2.getX() > event1.getX()){

                Intent intent = new Intent(kite.this,iron.class);
                startActivity(intent);finish();
                overridePendingTransition(R.anim.right_out, R.anim.right_in);
            }

            return true;
        }
    }
}

