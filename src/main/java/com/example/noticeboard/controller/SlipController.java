package com.example.noticeboard.controller;

import com.example.noticeboard.dto.request.SlipSendRequest;
import com.example.noticeboard.dto.response.SlipReponse;
import com.example.noticeboard.service.SlipService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlipController {

    private final SlipService service;
    private final SlipService slipService;

    public SlipController(SlipService service, SlipService slipService) {
        this.service = service;
        this.slipService = slipService;
    }

    @PostMapping("slips")
    public SlipReponse sendSlip(@RequestBody SlipSendRequest request) {
        return slipService.sendSlip(request);
    }
}
