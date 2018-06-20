package geen.gabrielmarques.projetofinaldevandroid.ApiHelpers;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBuilder {
    public static String defaultBaseUrl = "http://192.168.1.87/EnadeProject.Web/";

    public static ApiPerguntas Build(String url){

        Gson GsonConfig = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .setLenient()
                .serializeNulls()
                .setDateFormat(DateFormat.LONG)
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .setVersion(1.0)
                .create();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        OkHttpClient client =httpClient.addInterceptor(logging).build();

        return new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonConfig))
                .build()
                .create(ApiPerguntas.class);
    }
}
