package com.cop.cals;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;

import static android.support.v4.app.ActivityCompat.startActivity;

public class boy extends AppCompatActivity {
    MediaPlayer mp;
    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boy);
        mp = MediaPlayer.create(boy.this, R.raw.bb);

        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        Intent i = getIntent();
        boolean ap = i.getBooleanExtra("autoplay", false);

        if(ap)
            mp.start();

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Intent intent = new Intent(boy.this, car.class);
                intent.putExtra("autoplay", true);
                startActivity(intent);
                finish();
            }
        });

        Button bt=(Button)findViewById(R.id.button2);
        Button bt2 =(Button)findViewById(R.id.button3);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(boy.this, MainActivity.class);
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
        /*mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                Intent stopplay= new Intent(boy.this,car.class);
                stopplay.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(stopplay);


                finish();
                overridePendingTransition(R.anim.left_in,R.anim.left_out);






            }

        });*/


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
                Intent intent = new Intent(boy.this, car.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("autoplay", true);
                boy.this.mp.stop();
                startActivity(intent);

                finish();
                overridePendingTransition(R.anim.left_in,R.anim.left_out);
            }else if (event2.getX() > event1.getX()){

                Intent intent = new Intent(boy.this, apple.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("autoplay", true);
                boy.this.mp.stop();
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.right_out,R.anim.right_in);
            }

            return true;
        }
    }
}
