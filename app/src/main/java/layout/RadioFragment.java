package layout;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ikurek.pwr.R;

import java.io.IOException;


public class RadioFragment extends Fragment {

    public MediaPlayer radioPlayer;
    int volumeSetByUser;
    AudioManager audioManager;
    String url = "http://radioluz.pwr.wroc.pl:8000/luzhifi.mp3";
    Snackbar snackbar;
    AudioManager.OnAudioFocusChangeListener afChangeListener;


    public RadioFragment() {
        // Required empty public constructor
    }


    public static RadioFragment newInstance() {
        RadioFragment fragment = new RadioFragment();

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
        View view = inflater.inflate(R.layout.fragment_radio, container, false);

        final ImageButton playPauseRadio = (ImageButton) view.findViewById(R.id.imageButtonPlayRadio) ;




        //Przycisk play
        playPauseRadio.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if (radioPlayer != null && radioPlayer.isPlaying()) {

                    radioPlayer.stop();
                    audioManager.abandonAudioFocus(afChangeListener);
                    playPauseRadio.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                }

                else {

                    playPauseRadio.setImageResource(R.drawable.ic_stop_black_24dp);

                    radioPlayer = new MediaPlayer();
                    snackbar = Snackbar.make(getView(), "Buforowanie treści...", Snackbar.LENGTH_INDEFINITE);

                    try {
                        radioPlayer.setDataSource(url);
                    } catch (IllegalArgumentException e) {
                        Toast.makeText(getContext(), "Błędny adres radia", Toast.LENGTH_LONG).show();
                    } catch (SecurityException e) {
                        Toast.makeText(getContext(), "Problemy z połączeniem", Toast.LENGTH_LONG).show();
                    } catch (IllegalStateException e) {
                        Toast.makeText(getContext(), "Nie udało się otworzyć streamu radia", Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



                    radioPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                        @Override
                        public void onPrepared(MediaPlayer radioPlayer) {

                            audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
                            audioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);


                            radioPlayer.start();
                            snackbar.dismiss();
                        }
                    });


                    snackbar.show();
                    radioPlayer.prepareAsync();


                }
                }
        });


        //Wycisz dźwięk przy telefonach, powiadomieniach itd
        afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            public void onAudioFocusChange(int focusChange) {


                switch (focusChange) {

                    case AudioManager.AUDIOFOCUS_GAIN:

                        Toast.makeText(getContext(), Integer.toString(volumeSetByUser), Toast.LENGTH_SHORT);
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volumeSetByUser, 0);

                        break;

                    case AudioManager.AUDIOFOCUS_LOSS:

                        radioPlayer.stop();
                        radioPlayer.release();
                        playPauseRadio.setImageResource(R.drawable.ic_play_arrow_black_24dp);


                        break;

                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:


                        volumeSetByUser = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);

                        break;

                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:

                        volumeSetByUser = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);

                        break;

                    default:
                        //
                }
            }
        };


        return view;
    }

}
