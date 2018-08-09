package com.culqi.service;

import com.culqi.client.RestClient;
import com.culqi.model.Token;
import com.culqi.model.Card;
import com.culqi.util.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CulqiServiceImpl implements CulqiService {
    private static final Logger logger = LogManager.getLogger(CulqiServiceImpl.class);
    private RestTemplate restTemplate=new RestTemplate();
    @Override
    public Token generateToken(Card card) {
        if ( card.getPan()== null) return null;
        logger.info("Connection to URL :"+RestClient.getServerURL());
        logger.info("bin parameter:"+card.getBin());
        String result = restTemplate.getForObject(RestClient.getServerURL() + card.getBin(), String.class);
        logger.info(result);
        JSONObject objetoBinList = new JSONObject(result);
        logger.info("objetoBinList:" + objetoBinList);
        String scheme = objetoBinList.getString("scheme");
        logger.info("scheme : " + scheme);
        String dateTimeNow=Utility.getDateTimeNow();
        Token token = new Token(card);
        logger.info("token:"+token.getToken());
        token.setBrand(scheme);
        token.setCreation_dt(dateTimeNow);
        return token;
    }



}
