package layout;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.ikurek.pwr.R;
import com.squareup.picasso.Picasso;


//Fragment zawiera koty
//Dużo kotów
//Guzik do wyświetlania kotów też
public class CatFragment extends Fragment {
    ImageView cats;
    Picasso picasso;
    Button moarcats;
    TextView loading;


    public CatFragment() {
        // Required empty public constructor
    }


    public static CatFragment newInstance(Context context) {
        CatFragment fragment = new CatFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cat, container, false);

        cats = (ImageView) view.findViewById(R.id.imageViewCats);
        moarcats = (Button) view.findViewById(R.id.buttonMoreCats);
        loading = (TextView) view.findViewById(R.id.textViewLoadingCats);
        picasso = Picasso.with(getContext());

        //Przy stworzeniu widoku zabiera jednego losowego kota
        //Dzięki theCatAPI

        //Wyświetlanie kota na starcie
        loading.setText(R.string.Loading);
        picasso.load("http://thecatapi.com/api/images/get?format=src&type=jpg").into(cats);
        loading.setText("");

        moarcats.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                //Wyświetlanie kolejnych kotów
                picasso.invalidate("http://thecatapi.com/api/images/get?format=src&type=jpg");
                loading.setText(R.string.Loading);
                picasso.load("http://thecatapi.com/api/images/get?format=src&type=jpg").into(cats);
                loading.setText("");
            }
        });


        return view;
    }


}
