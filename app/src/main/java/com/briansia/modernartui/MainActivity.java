package com.briansia.modernartui;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import com.briansia.interfaces.FragmentAlertDialog;
import com.briansia.dialogs.MoreInformationDialog;

public class MainActivity extends AppCompatActivity implements FragmentAlertDialog{

    private static final String TAG = MainActivity.class.getName();
    private RelativeLayout palette;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        palette =  findViewById(R.id.palette);
        SeekBar seek =  findViewById(R.id.seekBar);

        seek.setOnSeekBarChangeListener( new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged ( SeekBar seekBar, int progress, boolean fromUser ) {

                int[] redArray = {255, 0, 0};
                int[] blueArray = {0, 0, 255};
                int[] yellowArray = {255, 255, 0};

                redArray[0] = redArray[0] - (255/100)*progress;
                redArray[1] = redArray[1] + (229/100)*progress;
                redArray[2] = redArray[2] + (238/100)*progress;
                blueArray[0] = blueArray[0] + (255/100)*progress;
                blueArray[1] = blueArray[1] + (102/100)*progress;
                blueArray[2] = blueArray[2] - (255/100)*progress;
                yellowArray[0] = yellowArray[0] - (125/100)*progress;
                yellowArray[1] = yellowArray[1] - (255/100)*progress;
                yellowArray[2] = yellowArray[2] + (130/100)*progress;

                for ( int i = 0; i < palette.getChildCount(); i++ ) {
                    View child = palette.getChildAt( i );

                    int originalColor = Color.parseColor( ( String ) child.getTag() );
                    int invertedColor = ( 0x00FFFFFF - ( originalColor | 0xFF000000 ) ) |
                            ( originalColor & 0xFF000000 );

                    if ( getResources().getColor( R.color.white, null) != originalColor &&
                            getResources().getColor( R.color.lightgray , null) != originalColor ) {

                        int origR = ( originalColor >> 16 ) & 0x000000FF;
                        int origG = ( originalColor >> 8 ) & 0x000000FF;
                        int origB = originalColor & 0x000000FF;

                        int invR = ( invertedColor >> 16 ) & 0x000000FF;
                        int invG = ( invertedColor >> 8 ) & 0x000000FF;
                        int invB = invertedColor & 0x000000FF;

                        child.setBackgroundColor( Color.rgb(
                                ( int ) ( origR + ( invR - origR ) * ( progress / 100f ) ),
                                ( int ) ( origG + ( invG - origG ) * ( progress / 100f ) ),
                                ( int ) ( origB + ( invB - origB ) * ( progress / 100f ) ) ) );
                        child.invalidate();
                    }
                }
            }


            @Override
            public void onStartTrackingTouch ( SeekBar seekBar ) {

            }

            @Override
            public void onStopTrackingTouch ( SeekBar seekBar ) {

            }
        } );
    }

    @Override
    public boolean onCreateOptionsMenu ( Menu menu ) {

        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public void showDialog ( MenuItem item ) {
        new MoreInformationDialog().show( getFragmentManager(), TAG );
    }

    @Override
    public void doPositiveClick() {
        /**
         * Sets up an intent to visit the MOMA art website and starts a new activity with it.
         */
        Intent visit = new Intent( Intent.ACTION_VIEW, Uri.parse("http://www.moma.org") );
        Intent chooser = Intent.createChooser( visit, getResources().getString( R.string.open_with ) );
        startActivity(chooser);
    }

    @Override
    public void doNegativeClick() {
        // Do nothing.
    }

}


