package cn.istary.acmcoder.util;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;


/**
 * @author Sinry
 * @version 2019/5/24 16:43
 * @describe $desc$
 */

public class StyleUtil {

    public static void setFont(Context context, TextView textView){
        Typeface fontType = Typeface.createFromAsset(context.getAssets(), "fonts/FONT.TTF");
        textView.setTypeface(fontType);
    }
}
