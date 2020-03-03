package com.example.jjalv.mp3_2;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.io.IOException;


public class MainActivity extends Activity implements Button.OnClickListener {

    Button bt1, bt2, bt3, bt4;
    Spinner sp;
    String[] temas = {"Mecano - aire", "Melendi - mis porros", "Acdc - shoot to thrill"};
    private MediaPlayer mediaPlayer;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1 = (Button) findViewById(R.id.button);
        bt2 = (Button) findViewById(R.id.button2);
        bt3 = (Button) findViewById(R.id.button3);
        bt4 = (Button) findViewById(R.id.button4);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, temas);

        sp = (Spinner) findViewById(R.id.spinner);

        sp.setAdapter(arrayAdapter);
    }


    @Override
    public void onClick(View v) {
        String selec = sp.getSelectedItem().toString();


        switch (v.getId()) {

            case R.id.button:
                //Detenemos la música si se está reproduciendo:
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {

                    mediaPlayer.stop();
                    mediaPlayer.release();
                }

                if (selec.equals("Mecano - aire")) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.mecano);
                    mediaPlayer.start();

                } else if (selec.equals("Melendi - mis porros")) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.melendi);
                    mediaPlayer.start();

                } else if (selec.equals("Acdc - shoot to thrill")) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.acdc);
                    mediaPlayer.start();
                }

                break;
            case R.id.button2:
                if (mediaPlayer.isPlaying()) {

                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }


                break;
            case R.id.button3:
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {

                    mediaPlayer.stop();

                    try {
                        mediaPlayer.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                }
                break;
            case R.id.button4:
                System.exit(0);
        }

    }
}
