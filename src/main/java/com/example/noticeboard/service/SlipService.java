package com.example.noticeboard.service;

import com.example.noticeboard.domain.Slip;
import com.example.noticeboard.domain.User;
import com.example.noticeboard.dto.request.SlipSendRequest;
import com.example.noticeboard.dto.response.SlipResponse;
import com.example.noticeboard.dto.response.SlipSendReponse;
import com.example.noticeboard.repository.SlipRepository;
import com.example.noticeboard.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SlipService {

    private final SlipRepository slipRepository;
    private final UserRepository userRepository;

    public SlipService(
            SlipRepository slipRepository,
            UserRepository userRepository
    ) {
        this.slipRepository = slipRepository;
        this.userRepository = userRepository;
    }

    public SlipSendReponse sendSlip(SlipSendRequest request) {

        User sndUser = userRepository.findById(request.getSndId()).orElseThrow(IllegalArgumentException::new);
        User rcvUser = userRepository.findById(request.getRcvId()).orElseThrow(IllegalArgumentException::new);

        Slip slip = slipRepository.save(new Slip(sndUser, rcvUser, request.getContent()));

        return new SlipSendReponse(
                slip.getId(),
                sndUser.getId(),
                rcvUser.getId(),
                slip.getContent(),
                slip.getTime()
        );
    }

    public List<SlipResponse> getRcvSlips(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        List<Slip> slips = slipRepository.findByRcvUser(user);

        List<SlipResponse> slipResponses = new ArrayList<>();

        for (Slip slip : slips) {
            SlipResponse slipResponse = new SlipResponse(
                    slip.getId(),
                    slip.getSndUser().getId(),
                    slip.getContent(),
                    slip.getTime()
            );
            slipResponses.add(slipResponse);
        }

        return slipResponses;
    }

    public List<SlipResponse> getSntSlips(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        List<Slip> slips = slipRepository.findBySndUser(user);

        List<SlipResponse> slipResponses = new ArrayList<>();

        for (Slip slip : slips) {
            SlipResponse slipResponse = new SlipResponse(
                    slip.getId(),
                    slip.getSndUser().getId(),
                    slip.getContent(),
                    slip.getTime()
            );
            slipResponses.add(slipResponse);
        }

        return slipResponses;
    }

}
