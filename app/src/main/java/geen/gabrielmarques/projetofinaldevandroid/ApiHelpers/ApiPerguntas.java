package geen.gabrielmarques.projetofinaldevandroid.ApiHelpers;

import java.util.ArrayList;
import java.util.List;

import geen.gabrielmarques.projetofinaldevandroid.Models.PerguntaDto;
import geen.gabrielmarques.projetofinaldevandroid.Models.RoundDto;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

public interface ApiPerguntas {
    @Headers({
            "accept: application/json",
            "accept-language: en-US,en;q=0.8",
            "content-type: application/json",
            "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.79 Safari/537.36"
    })
    @POST("pergunta/get")
    Call<PerguntaDto> FindPergunta(@Query("id") long id);

    @Headers({
            "accept: application/json",
            "accept-language: en-US,en;q=0.8",
            "content-type: application/json",
            "user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.79 Safari/537.36"
    })
    @POST("round/get")
    Call<ArrayList<RoundDto>> GameGetQuestions(@Query("numeroPerguntas") long numeroPerguntas);
}
