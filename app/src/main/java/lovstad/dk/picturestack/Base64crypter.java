package lovstad.dk.picturestack;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

/**
 * Created by bruger on 04-07-2016.
 */
public class Base64crypter {
    public static Bitmap decode(String input) {
        String[] stringarray = input.split(",");
        byte[] inputibytes = Base64.decode(stringarray[1], Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(inputibytes,0,inputibytes.length);

    }
}
