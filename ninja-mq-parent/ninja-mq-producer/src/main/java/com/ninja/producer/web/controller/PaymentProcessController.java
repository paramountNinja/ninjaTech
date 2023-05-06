package com.ninja.producer.web.controller;

import com.ninja.producer.service.SendOrderService;
import com.ninja.producer.web.request.PayProcessRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by ninja on 2019/12/7
 */
@Controller
public class PaymentProcessController {
    @Autowired
    private SendOrderService sendOrderService;

    @PostMapping("/payment/process")
    public ResponseEntity<String> paymentProcess(@RequestBody PayProcessRequest request) {
        sendOrderService.handle(request.getOrderNo());
        return ResponseEntity.ok("success");
    }
}
