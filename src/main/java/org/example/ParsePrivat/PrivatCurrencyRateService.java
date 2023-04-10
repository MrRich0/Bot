package org.example.ParsePrivat;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.CurrencyRateApiService;
import org.example.ParseNBY.NBYCurrencyResponceDto;
import org.example.RateResponceDto;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class PrivatCurrencyRateService implements CurrencyRateApiService {
    private static final Gson GSON = new Gson();
    private static final String url = "https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";


    @Override
    public List<RateResponceDto> getRates() {
        String text = null;
        try {
            text = Jsoup.connect(url).ignoreContentType(true).get().body().text();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<PrivatCurrencyResponceDto> responceDtos = convertResponce(text);
       return responceDtos.stream()
                .map(item -> {
                    RateResponceDto dto = new RateResponceDto();
                    dto.setCurrencyFrom(item.getCcy());
                    dto.setCurrencyTo(item.getBase_ccy());
                    dto.setRateBuy(item.getBuy());
                    dto.setRateSell(item.getSale());
                    return dto;
                })
                .collect(Collectors.toList());

    }

    private static List<PrivatCurrencyResponceDto> convertResponce(String text) {
        Type type = TypeToken
                .getParameterized(List.class, PrivatCurrencyResponceDto.class)
                .getType();
        List<PrivatCurrencyResponceDto> responceDtos = GSON.fromJson(text, type);
        return responceDtos;
    }
}
