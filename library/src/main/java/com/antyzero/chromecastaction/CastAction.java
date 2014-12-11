package com.antyzero.chromecastaction;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.MediaRouteActionProvider;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastMediaControlIntent;

/**
 *
 */
public class CastAction {

    // TODO include in configuration
    private static final String APP_ID = "B9EE3CE8";

    private final MediaRouter.Callback mediaRouterCallback = new MediaRouter.Callback() {
        @Override
        public void onRouteSelected( MediaRouter router, MediaRouter.RouteInfo route ) {
            CastDevice device = CastDevice.getFromBundle( route.getExtras() );
            //setSelectedDevice(device);
        }

        @Override
        public void onRouteUnselected( MediaRouter router, MediaRouter.RouteInfo route ) {
            //setSelectedDevice(null);
        }
    };

    private MediaRouter mediaRouter;
    private MediaRouteSelector mediaRouteSelector;

    private final MenuItem menuItem;
    private final MediaRouteActionProvider mediaRouteActionProvider;

    /**
     * @param context
     * @param menu
     */
    public CastAction( @NonNull Context context, @NonNull Menu menu ) {

        // Prepare components

        mediaRouteActionProvider = new MediaRouteActionProvider( context );
        mediaRouter = MediaRouter.getInstance(context.getApplicationContext());
        mediaRouteSelector = new MediaRouteSelector.Builder().addControlCategory( CastMediaControlIntent.categoryForCast( APP_ID )).build();

        mediaRouteActionProvider.setRouteSelector(mediaRouteSelector);

        // Build MenuItem

        menuItem = menu.add( "Cast" );

        // Configure looks
        menuItem.setShowAsAction( MenuItem.SHOW_AS_ACTION_ALWAYS );

        MenuItemCompat.setActionProvider( menuItem, mediaRouteActionProvider );
    }

    public void start(){
        mediaRouter.addCallback( mediaRouteSelector, mediaRouterCallback );
    }

    public void stop(){
        mediaRouter.removeCallback( mediaRouterCallback );
    }
}
