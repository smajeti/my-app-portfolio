package com.nanodegree.android.myappportfolio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.Dictionary;
import java.util.Hashtable;


public class MainActivity extends ActionBarActivity {

    private int[] buttonIds = {R.id.spotifyBtnId,
            R.id.scoresAppBtnId,
            R.id.libraryAppBtnId,
            R.id.biggerAppBtnId,
            R.id.baconReaderAppBtnId,
            R.id.capstoneAppBtnId};

    private Dictionary<Integer, String> appMsgStrDict = new Hashtable<Integer, String>(6);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtonClickEvents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initButtonClickEvents() {
        appMsgStrDict.put(R.id.spotifyBtnId, "Spotify Streamer");
        appMsgStrDict.put(R.id.scoresAppBtnId, "Scores");
        appMsgStrDict.put(R.id.libraryAppBtnId, "Library");
        appMsgStrDict.put(R.id.biggerAppBtnId, "Build It Bigger");
        appMsgStrDict.put(R.id.baconReaderAppBtnId, "Bacon Reader");
        appMsgStrDict.put(R.id.capstoneAppBtnId, "My Capstone");

        for (int btnId : buttonIds) {
            Button btn = (Button) findViewById(btnId);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button clickedBtn = (Button) view;
                    MainActivity.this.raiseToast(clickedBtn.getId());
                }
            });
        }
    }

    private void raiseToast(int btnId) {
        String toastTxt = MessageFormat.format("This button launches {0} app!", appMsgStrDict.get(btnId));
        Toast toast = Toast.makeText(this, toastTxt, Toast.LENGTH_SHORT);
        toast.show();
    }
}
