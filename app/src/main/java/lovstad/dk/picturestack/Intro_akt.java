package lovstad.dk.picturestack;

import android.graphics.Bitmap;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Intro_akt extends AppCompatActivity {
    public ImageView testbillede;
    public TextView testtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        testbillede = (ImageView) findViewById(R.id.testbillede);
        testtext = (TextView) findViewById(R.id.testtext);
        Log.d("AsyncTask", "Asynctask starter om lidt...");
        testtext.setText("Etellerandet");
        AsyncTask asyncTask = new AsyncTask() {
            String ting;
            @Override
            protected Object doInBackground(Object[] params) {

                try {
                    Log.d("AsyncTask", "Asynctask er startet.");
                    URL url = new URL("http://rasmuslovstad.dk/");
                    BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
                    ting = br.readLine();
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return ting;
            }


            @Override
            protected void onPostExecute(Object resultat) {
                Log.d("AsyncTask", "OnPostExecute er startet. Resultatet er "+resultat);
                testtext.setText(resultat.toString());
            }

        };
        asyncTask.execute();
        protected String hentData() {
        return null;
    }
    }
}
