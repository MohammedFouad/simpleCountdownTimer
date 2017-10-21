package com.mohamedfoad.countdowntimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView tvl;
    private Button startbtn, cancelbtn;
    private ToggleButton togbtn;

    private boolean isPaused = false;
    private boolean isCanceled = false;
    private long remainingTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startbtn = (Button)findViewById(R.id.startbtn);
        cancelbtn = (Button)findViewById(R.id.cancelbtn);
        togbtn = (ToggleButton) findViewById(R.id.togbtn);

       cancelbtn.setEnabled(false);
      togbtn.setEnabled(false);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startbtn.setEnabled(false);
                cancelbtn.setEnabled(true);
                togbtn.setEnabled(true);

                isPaused = false;
                isCanceled = false;

                long milliSecondsInFuture = 10000; // 10 sec
                long countdownInterval = 1000;     // 1 sec

                new CountDownTimer(milliSecondsInFuture, countdownInterval) {
                    @Override
                    public void onTick(long milliSecondsUntilFinished) {

                        if (isPaused || isCanceled){
                            cancel();
                        }else {
                            tvl.setText("" + milliSecondsUntilFinished/1000);
                            remainingTime=milliSecondsUntilFinished;
                        }

                    }

                    @Override
                    public void onFinish() {

                        tvl.setText("Time is up");

                    }
                }.start();
            }
        });
    }
}
