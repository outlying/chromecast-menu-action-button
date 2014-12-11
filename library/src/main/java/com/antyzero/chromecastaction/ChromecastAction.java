package com.antyzero.chromecastaction;

import android.view.Menu;
import android.view.MenuItem;

/**
 *
 */
public class ChromecastAction {

    private final MenuItem menuItem;

    public ChromecastAction( Menu menu ) {

        menuItem = menu.add( "Chromecast" );

        // Quickly disable item
        /*menuItem.setVisible( false );
        menuItem.setEnabled( false );*/

        // Configure looks
        menuItem.setShowAsAction( MenuItem.SHOW_AS_ACTION_ALWAYS );
        menuItem.setIcon( R.drawable.common_signin_btn_icon_pressed_light );
    }
}
