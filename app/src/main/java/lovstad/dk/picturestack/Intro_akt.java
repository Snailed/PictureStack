package lovstad.dk.picturestack;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Intro_akt extends AppCompatActivity implements View.OnClickListener {
    public static ImageView testbillede;
    public static TextView testtext;
    public static ArrayList<String> billeder;
    public int billedcount = 1;
    public Bitmap placeholder = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        testbillede = (ImageView) findViewById(R.id.testbillede);
        testtext = (TextView) findViewById(R.id.testtext);

        if (placeholder == null) {

            testbillede.setImageResource(R.drawable.loadingplaceholder);


        } else {
            testbillede.setImageBitmap(placeholder);
        }
        //testbillede.setImageBitmap(placeholder);


        Log.d("AsyncTask", "Asynctask starter om lidt...");
        testtext.setText("Loader...");
        new Downloader().execute();
        testbillede.setOnClickListener(this);



    }
    protected static void setData(ArrayList<String> data) {
        billeder = data;
        testtext.setText("Billeder:");
        testbillede.setImageBitmap(Base64crypter.decode(billeder.get(0)));

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
