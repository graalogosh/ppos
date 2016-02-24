package tk.graalogosh.ppos.utils;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import tk.graalogosh.ppos.models.DadataPassport;

/**
 * Created by GraaLoGosh (graalogosh@gmail.com)) on 21.02.2016.
 */

public class DadataClient {
    private final String passportURL="https://dadata.ru/api/v2/clean/passport";
    private static final Gson gson = new Gson();

    public DadataPassport getDadataPassport(final String number){
        final String correctedNumber = number.replaceAll("\\s", "");

        OkHttpClient client = new OkHttpClient();

        Request request= new Request.Builder()
                .url(passportURL)
                .addHeader("Content-Type","application/json")
                .addHeader("Authorization", "Token")
    }
}
