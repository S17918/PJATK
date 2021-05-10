/*
 *
 *  @author Wasilewski Piotr S17918
 *
 */

package zad1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;


public class Service {

    String Country = null;
    Double ex_rate = null;

    public Service(String Country) {
        this.Country = Country;
    }

    public String getWeather(String City){

        String key ="ff0dc0a7e5003c05ee73c5f0db8f95d9";
        String JSON = null;

        OpenWeatherMap weather = new OpenWeatherMap(OpenWeatherMap.Units.METRIC, key); 

        try {
            CurrentWeather pogoda = weather.currentWeatherByCityName(City);
            if(pogoda.hasBaseStation()){
                JSON = pogoda.getRawResponse();
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return JSON;
    }

    public double getRateFor(String Currency_code){
        
        String url = "https://api.exchangeratesapi.io/latest";
        String key = "ff25386cdc086b897f6078b87df4c109";

        HttpGet get = new HttpGet(url + "?acces_key=" + key + "&base=" + Currency.get(Country) + "&symbols=" + Currency_code);
        
        try(CloseableHttpClient httpclient = HttpClients.createDefault(); CloseableHttpResponse response = httpclient.execute(get);) {
            
            HttpEntity entity = response.getEntity();
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));

            if(!exchangeRates.isNull("rates")){
                ex_rate = exchangeRates.getJSONObject("rates").getDouble(Currency_code);
            }else{
                ex_rate = 1.0;
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return ex_rate;

    }

    Double getNBPRate(){
        
        String[] url = {"http://www.nbp.pl/kursy/kursya.html", "http://www.nbp.pl/kursy/kursyb.html"};
        Double ex_rate_nbp = null;

        for(int i = 0; i < 2 && ex_rate_nbp == null; i++){

            HttpGet get = new HttpGet(url[i]);

            try(CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse response = httpClient.execute(get);) {
                
                HttpEntity entity = response.getEntity();
                String exchangeRates = EntityUtils.toString(entity);

                int index = exchangeRates.indexOf(Currency.get(Country));
                
                if(index != -1 && !Country.equals("Poland")){

                    int rate_index = exchangeRates.indexOf(">", index + 10) +1;
                    ex_rate_nbp = Double.valueOf(exchangeRates.substring(rate_index, rate_index + 6).replace(',', '.'));

                }else{
                    ex_rate_nbp = 1.0;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return ex_rate_nbp;
    }

    public String WikiDescription(String City){

        String city_in_polish = Cities_to_polish.get(City);

        if(city_in_polish != null){
            return "https://pl.wikipedia.org/wiki/" + city_in_polish;
        }

        return city_in_polish;

    }

    Map<String, String> Currency = new HashMap<String, String>(){
        {
            put("Poland", "PLN");
            put("USA", "USD");
            put("Germany", "EUR");
            put("England", "GBP");
            put("Italy", "EUR");
            put("Thailand", "THB");
        }
    };

    Map<String, String> Cities_to_polish = new HashMap<String, String>(){
        {
            put("Warsaw", "Warszawa");
            put("Cracow", "Kraków");
            put("Washington", "Waszyngton");
            put("Rome", "Rzym");
            put("Miami", "Miami");
            put("Munich", "Monachium");
            put("Berlin", "Berlin");
            put("London", "Londyn");
            put("York", "York");
            
        }
    };

}  
