package com.cm.misc.javeriana.game.app.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Class that defines UI-related utilities
 */
public class UIUtils {
    /**
     * Shows a toast message
     *
     * @param context  the {@link android.view.View}'s context
     * @param message  the message to show
     * @param duration the duration of the message on the screen. Use {@link Toast}
     *                 <code>LENGTH_LONG</code> or <code>LENGTH_SHORT</code>
     */
    public static void showToast(Context context, String message, int duration) {
        Toast.makeText(context, message, duration).show();
    }
}
