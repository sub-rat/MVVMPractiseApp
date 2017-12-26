package np.com.percoid.mvvmsampleapp.view.adapter;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by Subrat on 12/26/2017.
 */

public class CustomBindingAdapter {
    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show){
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
