package layout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ikurek.pwr.R;
import com.jaredrummler.materialspinner.MaterialSpinner;

import static com.ikurek.pwr.StartIntroActivity.selectedDepartment;


public class IntroBeforeWeStart extends Fragment {


    public static IntroBeforeWeStart newInstance() {

        return new IntroBeforeWeStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro_before_we_start, container, false);

        MaterialSpinner spinner = (MaterialSpinner) view.findViewById(R.id.spinnerDepartments);
        spinner.setItems(getResources().getStringArray(R.array.departments_names));
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {

                selectedDepartment = position;

            }
        });


        return view;
    }

}