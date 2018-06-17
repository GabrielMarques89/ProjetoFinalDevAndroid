package geen.gabrielmarques.projetofinaldevandroid.ActivityHelper;

import android.app.Activity;

import java.lang.ref.WeakReference;

public class ActivityHelper {
    public static WeakReference<Activity> mActivityRef;

    public static void updateActivity(Activity activity) {
        mActivityRef = new WeakReference<Activity>(activity);
    }
}