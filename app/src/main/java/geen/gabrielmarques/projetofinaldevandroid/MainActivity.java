package geen.gabrielmarques.projetofinaldevandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import geen.gabrielmarques.projetofinaldevandroid.ActivityHelper.ActivityHelper;
import geen.gabrielmarques.projetofinaldevandroid.ApiHelpers.ApiBuilder;
import geen.gabrielmarques.projetofinaldevandroid.ApiHelpers.ApiPerguntas;
import geen.gabrielmarques.projetofinaldevandroid.Models.RoundDto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public ArrayList<RoundDto> rounds;
    public int fase=0;
    public int numeroPergunta=15;
    public float pontuacao=0;
    public Boolean jogoIniciado = false;
    public Button BtnContinuar;
    public Button BtnIniciar;

    //TODO: Salvar nas preferencias de usuário.
    public float ultimaPontuacao=0;

    public void FinishGame(){
        fase = 0;
        pontuacao=0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHelper.updateActivity(this);
        requestApiForNewRound(numeroPergunta);
        setContentView(R.layout.activity_main);
        BtnContinuar = findViewById(R.id.btnContinuar);
        BtnIniciar = findViewById(R.id.btnJogar);
        BtnContinuar.setEnabled(jogoIniciado);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }

    public void btnContinuarOnClick(View v) throws IOException {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    public void btnJogarOnClick(View v) {
        if(jogoIniciado == false){
            jogoIniciado = true;
            BtnContinuar.setEnabled(jogoIniciado);
            BtnIniciar.setEnabled(!jogoIniciado);
            requestApiForNewRound(numeroPergunta);
            while (rounds == null){

            }
            btnJogarOnClick(v);
        }
        else{
            if(rounds != null){
                Intent intent = new Intent(this, QuizActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this,"Aguarde, estamos carregando novas perguntas.",Toast.LENGTH_LONG).show();
            }
        }

    }

    public void requestApiForNewRound(int quantasPerguntas){
        ApiPerguntas api = ApiBuilder.Build(ApiBuilder.defaultBaseUrl);
        Call<ArrayList<RoundDto>> call = api.GameGetQuestions(quantasPerguntas);
        call.enqueue(new Callback<ArrayList<RoundDto>>() {

            @Override
            public void onResponse(Call<ArrayList<RoundDto>> call, Response<ArrayList<RoundDto>> response) {
                rounds = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<RoundDto>> call, Throwable t) {
                Log.e("exception no onFailure",t.getMessage());
                //something bad happened
            }
        });
    }

    public void btnMelhoresPontuacoesOnClick(View v) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    public void btnConfiguracoesOnClick(View v) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    public void btnSairOnClick(View v) {
        finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}