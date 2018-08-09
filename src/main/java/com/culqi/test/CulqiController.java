package com.culqi.test;


import com.culqi.service.CulqiService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.culqi.model.Card;
import org.springframework.http.*;
import com.culqi.model.*;


@RestController
public class CulqiController {
	private static final Logger logger = LogManager.getLogger(CulqiController.class);
	@Autowired
	private CulqiService culqiService;
	@RequestMapping(value = "/tokens", method = RequestMethod.POST)
	public ResponseEntity<Token> generateToken(@RequestBody Card card) {
		logger.info("Start  generateToken");
		Token token= culqiService.generateToken(card);
		logger.info("End  generateToken");
		return new ResponseEntity<Token>(token, HttpStatus.OK);
	}



}