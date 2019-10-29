package com.br.calendario_academico;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.br.calendario_academico.ui.main.SectionsPagerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String URLJSON = "https://cedav.com.br/wp-content/themes/cedav/js/jacad_api_calendario.json";
    ArrayList<DadosModel> dadosModelEvento = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        //DadosModel dados = new DadosModel(1,"Teste de descrição", "24/10/2019", "31/10/2019", "red", true);

        new JsonTask().execute(URLJSON);
    }

    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected String doInBackground(String... params) {

            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();

                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);
                }
                return buffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //Log.i("Log: ", " " + result);
            try{
                JSONArray listajson = new JSONArray(result);
                for (int i = 0; i < listajson.length(); i++){
                    JSONObject event = listajson.getJSONObject(i);
                    Log.i("Log: ", ""+event.getInt("idLegenda"));
                    Log.i("Log: ", ""+event.getString("descricao"));
                    Log.i("Log: ", ""+event.getString("dataInicio"));
                    Log.i("Log: ", ""+event.getString("dataFim"));
                    Log.i("Log: ", ""+event.getString("cor"));
                    Log.i("Log: ", ""+event.getInt("feriado"));
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
    }

}