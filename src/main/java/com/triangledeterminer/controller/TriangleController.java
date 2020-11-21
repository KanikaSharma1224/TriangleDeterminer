package com.triangledeterminer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.triangledeterminer.error.ErrorHandler;
import com.triangledeterminer.error.TriangleDeterminerException;
import com.triangledeterminer.model.APIError;
import com.triangledeterminer.model.ShapeDeterminer;
import com.triangledeterminer.model.TraingleType;
import com.triangledeterminer.model.Triangle;
import com.triangledeterminer.validation.Validator;

@RestController
public class TriangleController {

	private static final Logger logger = LogManager.getLogger(TriangleController.class);
	@Autowired
	private ShapeDeterminer triangleDeterminer;
	@Autowired
	private Validator validator;

	@PostMapping(value = "/triangle/type")
	@ResponseBody
	ResponseEntity<Object> determineTriangleType(@RequestBody Triangle triangle) throws TriangleDeterminerException {
		logger.info("Input Triangle Side1 : {}, Side2 : {}, Side3 : {} ", triangle.getSide1(), triangle.getSide2(),
				triangle.getSide3());

		validator.validateTriangle(triangle);
		return ResponseEntity.ok(new TraingleType(triangleDeterminer.qualify(triangle)));

	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<APIError> handler(Exception ex, WebRequest request) {
		logger.error("Exception in controller : {} ", ex);
		APIError ae = ErrorHandler.generateErrorModel(ex);
		return ResponseEntity.status(ae.getStatus()).body(ae);
	}

}
