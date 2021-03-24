package com.android.panthom.DROID_MJ.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import java.util.Timer;
import android.view.View;
import java.util.TimerTask;
import android.widget.Toast;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class b extends Activity {
    private Timer a;
    private ProgressBar b;
    private int c = 0;
    private ImageView d;
    private Intent e;
    private MediaPlayer f;

    protected void onCreate(Bundle a) {

        super.onCreate(a);
        setContentView(R.layout.b);
        b1();
        this.b = (ProgressBar)findViewById(R.id.c);
        this.d = (ImageView) findViewById(R.id.a);
        this.d.setImageResource(R.drawable.a);
View overlay = findViewById(R.id.mylayout); overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN);
 
        this.b.setProgress(0);

        this.a = new Timer();
        this.a.schedule(new TimerTask() {
            public void run() {
                if (b.this.c < 100) {
                    b.this.runOnUiThread(new Runnable() {
                        public void run() {
                        }
                    });
                    b.this.b.setProgress(b.this.c);
                    b bVar = b.this;
                    bVar.c = bVar.c + 1;
                    return;
                }
                b.this.a.cancel();
                b.this.e = new Intent(b.this, a.class);
                b.this.startActivity(b.this.e);
                b.this.f.stop();
                b.this.finish();
            }
        }, 0, 100);
    }

    public void b1() {
        this.f = MediaPlayer.create(this, R.raw.b);
        this.f.setOnCompletionListener(new OnCompletionListener() {
            public void onCompletion(MediaPlayer a) {
                 a.release();
            }
        });
        this.f.start();
    }
}
