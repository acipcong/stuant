package management.stuant.com.stuant.common;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by USER on 11/25/2018.
 */

public class Utils {

    public static float convertDIPToPixels(Context context, float dip){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, displayMetrics);
    }
}
