package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ikurek.pwr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class IntroHello extends Fragment {


    public IntroHello() {
        // Required empty public constructor
    }

    public static IntroHello newInstance() {

        return new IntroHello();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro_hello, container, false);
    }

}
