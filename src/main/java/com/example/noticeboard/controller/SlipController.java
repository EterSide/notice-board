package com.example.noticeboard.controller;

import com.example.noticeboard.dto.request.SlipSendRequest;
import com.example.noticeboard.dto.response.SlipResponse;
import com.example.noticeboard.dto.response.SlipSendReponse;
import com.example.noticeboard.service.SlipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SlipController {

    private final SlipService service;
    private final SlipService slipService;

    public SlipController(SlipService service, SlipService slipService) {
        this.service = service;
        this.slipService = slipService;
    }

    @PostMapping("slips")
    public SlipSendReponse sendSlip(@RequestBody SlipSendRequest request) {
        return slipService.sendSlip(request);
    }

    @GetMapping("slips/received")
    public List<SlipResponse> getRcvSlips(@RequestParam Long userId) {
        return slipService.getRcvSlips(userId);
    }
}
