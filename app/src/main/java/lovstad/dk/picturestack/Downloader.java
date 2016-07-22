package lovstad.dk.picturestack;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by bruger on 04-07-2016.
 */
public class Downloader extends AsyncTask <Void, Void, ArrayList<String>>{

    @Override
    protected ArrayList<String> doInBackground(Void... params) {
        ArrayList<String> læsteting = new ArrayList<>();
        try {

            Log.d("AsyncTask", "Asynctask er startet.");
            URL url = new URL("http://rasmuslovstad.dk/");

            String line = null;
            int i = 0;
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = br.readLine()) != null) {
                Log.d("AsyncTask", "Linje "+i+" = "+line);
                læsteting.add(line);
                i++;
            }

        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e3) {
            e3.printStackTrace();
        }
        Log.d("AsyncTask", "Størrelsen på listen er "+læsteting.size()+" elementer");
        return læsteting;

    }


    @Override
    protected void onPostExecute(ArrayList<String> o) {
        Log.d("AsyncTask", "OnPostExecute er startet. Resultatet er "+o);

        Intro_akt.setData(o);
    }
}
