package geen.gabrielmarques.projetofinaldevandroid;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

public class TelaVencer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_vencer);
        Objects.requireNonNull(getSupportActionBar()).hide();

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.vitoria);
        mp.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 1500);
    }
}