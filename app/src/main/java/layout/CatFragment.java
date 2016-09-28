package layout;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ikurek.pwr.R;
import com.squareup.picasso.Picasso;


//Fragment zawiera koty
//Dużo kotów
//Guzik do wyświetlania kotów też
public class CatFragment extends Fragment {
    ImageView cats;
    Picasso picasso;
    Button moarcats;
    ProgressBar catDownloadProgress;


    public CatFragment() {
        // Required empty public constructor
    }


    public static CatFragment newInstance(Context context) {
        CatFragment fragment = new CatFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        getActivity().setTitle(getString(R.string.cats));
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cat, container, false);

        cats = (ImageView) view.findViewById(R.id.imageViewCats);
        moarcats = (Button) view.findViewById(R.id.buttonMoreCats);
        catDownloadProgress = (ProgressBar) view.findViewById(R.id.progressBarCatDownload);
        picasso = Picasso.with(this.getContext());

        catDownloadProgress.setVisibility(View.VISIBLE);

        //Przy stworzeniu widoku zabiera jednego losowego kota
        //Dzięki theCatAPI
        picasso.load("http://thecatapi.com/api/images/get?format=src&type=jpg").into(cats, new com.squareup.picasso.Callback() {
            @Override
            public void onSuccess() {
                catDownloadProgress.setVisibility(View.GONE);
            }

            @Override
            public void onError() {
                catDownloadProgress.setVisibility(View.GONE);
                Log.e("Picasso", "Error with picasso image loading");
            }
        });


        moarcats.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                catDownloadProgress.setVisibility(View.VISIBLE);

                //Wyświetlanie kolejnych kotów
                picasso.invalidate("http://thecatapi.com/api/images/get?format=src&type=jpg");

                picasso.load("http://thecatapi.com/api/images/get?format=src&type=jpg").into(cats, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        catDownloadProgress.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {
                        catDownloadProgress.setVisibility(View.GONE);
                        Log.e("Picasso", "Error with picasso image loading");
                    }
                });

            }
        });


        return view;
    }


}
