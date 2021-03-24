package com.android.DROID_MJ.tictactoe;

package com.android.panthom.DROID_MJ.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Vibrator;
import android.os.VibrationEffect;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.graphics.Typeface;
 
public class a extends Activity implements View.OnClickListener {
    private Button[][] a = new Button[3][3];
    private TextView b;
    private TextView c;
    private String d;
    private int e;
    private Button f;
    private boolean g = true;
    private int h;
    private int i;
    private int j;
    private MediaPlayer create;
    private MediaPlayer create2;
    private boolean r;
Typeface e1;
private AlertDialog.Builder b13;
TextView win;

 
    protected void onCreate(Bundle a) {
        super.onCreate(a);
        setContentView(R.layout.a);
        a3();
        this.b = findViewById(R.id.text_view_p1);
        this.c = findViewById(R.id.text_view_p2);
        this.win = findViewById(R.id.win);
View overlay = findViewById(R.id.mylayout); overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN);
     /*   this.e1 = Typeface.createFromAsset(getAssets(), "fonts/a.ttf");
this.b.setTypeface(this.e1);
this.c.setTypeface(this.e1);
this.f.setTypeface(this.e1);
this.win.setTypeface(this.e1);*/
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.d = "button_" + i + j;
                this.e = getResources().getIdentifier(this.d, "id", getPackageName());
                this.a[i][j] = findViewById(this.e);
                this.a[i][j].setOnClickListener(this);
            }
        }
        this.f = findViewById(R.id.button_reset);
        this.f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                g();
  a2();
a3();
            }
        });
    }

    public void onClick(View a) {
        if (!((Button) a).getText().toString().equals("")) {
            return;
        }
        if (this.g) {
            ((Button) a).setText("X");
        a1();
        this.f.setVisibility(View.VISIBLE);

        } else {
            ((Button) a).setText("O");
        a1();
        this.f.setVisibility(View.VISIBLE);

        }
        this.h++;
        if (a()) {
            if (this.g) {
                th();
            } else {
                th1();
            }
        } else if (this.h == 9) {
            th2();
        } else {
            this.g = !this.g;
        }
    }
 
    private boolean a() {
        String[][] field = new String[3][3];
win.setText("");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = this.a[i][j].getText().toString();
            }
        }
 
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }
 
        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }
 
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }
 
        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")) {
            return true;
        }
 
        return false;
    }
 
    private void e() {
        this.b.setText("Player 1: " + this.i);
        this.c.setText("Player 2: " + this.j);
    }
 
    private void f() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.a[i][j].setText("");
            }
        }
        this.h = 0;
        this.g = true;
        
    }
 private void th() {
i++;
win.setText("Player 1 WIN");
e();
a2();
f();
}
private void th1() {
j++;
win.setText("Player 2 WIN");
e();
a2();
f();
}
private void th2() {
win.setText("DRAW");
a2();
f();

}
    private void g() {
        this.i = 0;
        this.j = 0;
        e();
f();

this.f.setVisibility(View.GONE);
    }
 
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
 
        outState.putInt("this.h", this.h);
        outState.putInt("this.i", this.i);
        outState.putInt("this.j", this.j);
        outState.putBoolean("this.g", this.g);
    }
 
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
 
        this.h = savedInstanceState.getInt("this.h");
        this.i = savedInstanceState.getInt("this.i");
        this.j = savedInstanceState.getInt("this.j");
        this.g = savedInstanceState.getBoolean("this.g");
    }

private void a1(){
                create = MediaPlayer.create(this, R.raw.a);
                create.setOnCompletionListener(new OnCompletionListener() {
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                    }
                });
                create.start();
}

private void a2() {
Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
// Vibrate for 500 milliseconds
if (VERSION.SDK_INT >= 27) {
    v.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
} else { 
    //deprecated in API 26  
    v.vibrate(50);
}
}
private void a3() {
                create2 = MediaPlayer.create(this, R.raw.c);
                create2.setOnCompletionListener(new OnCompletionListener() {
                    public void onCompletion(MediaPlayer mediaPlayer) {
mediaPlayer.setLooping(true); 
                        mediaPlayer.release();
                    }
                });
                create2.start();
}

    public void onStop() {
create2.pause();
        super.onStop();
    }
   protected void onResume() {
create2.start();
View overlay = findViewById(R.id.mylayout); overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN);
super.onResume();
 }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                  c5();
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }

    public void c5() {
        this.b13 =  new AlertDialog.Builder(this);
        this.b13.setCancelable(true); 
        this.b13.setMessage("Do you want to exit?"); 
        this.b13.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface a, int b) { 
                System.exit(0);
            } 
   	     });
        this.b13.setNegativeButton("No", new DialogInterface.OnClickListener() { 
            public void onClick(DialogInterface a, int b) { 
                a.dismiss(); 
  	        } 
  	    }); 
       this.b13.create().show();
    } 
}