package lovstad.dk.picturestack;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Intro_akt extends AppCompatActivity implements View.OnClickListener {
    public static ImageView testbillede;
    public static TextView testtext;
    public static ArrayList<String> billeder;
    public int billedcount = 0;
    public Bitmap placeholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        testbillede = (ImageView) findViewById(R.id.testbillede);
        testtext = (TextView) findViewById(R.id.testtext);

        if (placeholder == null) {
            placeholder = BitmapFactory.decodeFile("loadingplaceholder.png");

        }
        testbillede.setImageBitmap(placeholder);


        Log.d("AsyncTask", "Asynctask starter om lidt...");
        testtext.setText("Loader...");
        new Downloader().execute();
        testbillede.setOnClickListener(this);



    }
    protected static void setData(ArrayList<String> data) {
        billeder = data;
        testtext.setText("Billeder:");

    }

    @Override
    public void onClick(View v) {
        testbillede.setImageBitmap(Base64crypter.decode(billeder.get(billedcount)));
        placeholder = Base64crypter.decode(billeder.get(billedcount));
        billedcount++;
        if (billedcount == billeder.size()) {
            billedcount = 0;
        }

    }
}
