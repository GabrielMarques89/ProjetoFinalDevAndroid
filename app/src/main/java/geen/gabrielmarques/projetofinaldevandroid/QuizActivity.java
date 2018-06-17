package geen.gabrielmarques.projetofinaldevandroid;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import geen.gabrielmarques.projetofinaldevandroid.ActivityHelper.ActivityHelper;
import geen.gabrielmarques.projetofinaldevandroid.Models.*;

public class QuizActivity extends AppCompatActivity {
    Map<Button, Boolean> map = new HashMap<Button, Boolean>();
    ArrayList<Button> buttons = new ArrayList<Button>();
    public MainActivity parent;
    public double Pontuacao=0;
    public int timer=15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        parent = ((MainActivity) ActivityHelper.mActivityRef.get());
        Objects.requireNonNull(getSupportActionBar()).hide();
        FillButtonList();
        runTimer();

        RoundDto question = parent.rounds.get(parent.fase);
        for (int j = 0; j <= question.getResposta().size() - 1; j++) {
            map.put(buttons.get(j), question.getResposta().get(j).getCorreta());
            buttons.get(j).setText(question.getResposta().get(j).getConteudo());
        }

        TextView textoPergunta = findViewById(R.id.textoPergunta);
        textoPergunta.setText(question.getPergunta().getConteudo());
        this.Pontuacao = question.getPergunta().getDificuldade();
    }

    private void runTimer(){
        final Button button = findViewById(R.id.timer);
        button.setVisibility(View.INVISIBLE);

        /*final Handler handler = new Handler();
        final Button button = findViewById(R.id.timer);
        handler.postDelayed(new Runnable() {
            public void run() {
                timer = timer - 1;
                button.setText(timer);
                if(timer <= 0){
                    ActionPerder();
                }
            }
        }, 1000);*/


    }

    private void BlinkBackground(View v, int color) {
        final AnimationDrawable drawable = new AnimationDrawable();
        drawable.addFrame(new ColorDrawable(color), 400);
        drawable.addFrame(new ColorDrawable(Color.WHITE), 400);

        drawable.setOneShot(false);
        v.setBackground(drawable);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                drawable.start();
            }
        }, 100);
    }

    public void DisableAllButtons() {
        for (Button but : buttons) {
            but.setOnClickListener(null);
        }
    }

    public void onRespond(View v) {
        Button button = (Button) v;
        Boolean respostaCorreta = map.get(button);
        if (respostaCorreta) {
            PassarDeFase(button);
        } else {
            ActionPerder();
            for (Button but : buttons) {
                if (button.getId() == but.getId()) {
                    BlinkBackground(but, Color.RED);
                } else {
                    if (map.get(but)) {
                        BlinkBackground(but, Color.GREEN);
                    }
                }
            }
        }
        DisableAllButtons();
    }

    private void ActionPerder(){
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.errado);
        mp.start();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                parent.FinishGame();
                finish();
            }
        }, 3300);
    }

    private void PassarDeFase(Button button){
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.certo);
        mp.start();
        parent.pontuacao = parent.pontuacao+1;
        parent.fase++;
        BlinkBackground(button, Color.GREEN);
        final Intent nextFase = new Intent(this, QuizActivity.class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
                startActivity(nextFase);
            }
        }, 3300);
    }

    public void FillButtonList() {
        Button button = findViewById(R.id.btnResposta);
        buttons.add(button);
        Button button2 = findViewById(R.id.btnResposta2);
        buttons.add(button2);
        Button button3 = findViewById(R.id.btnResposta3);
        buttons.add(button3);
        Button button4 = findViewById(R.id.btnResposta4);
        buttons.add(button4);
    }
}
