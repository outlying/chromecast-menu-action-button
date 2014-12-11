package com.antyzero.chromecastaction.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

import com.antyzero.chromecastaction.CastAction;

public class MainActivity extends ActionBarActivity {

    private CastAction castAction;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {

        castAction = new CastAction(this, menu);
        castAction.start();

        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onStop() {

        castAction.stop();

        super.onStop();
    }
}
