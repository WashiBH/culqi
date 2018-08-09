package com.culqi.service;

import com.culqi.model.Token;
import com.culqi.model.Card;

public interface CulqiService {
   Token generateToken(Card card);
}
