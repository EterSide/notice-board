package com.example.noticeboard.service;

import com.example.noticeboard.domain.Slip;
import com.example.noticeboard.domain.User;
import com.example.noticeboard.dto.request.SlipSendRequest;
import com.example.noticeboard.dto.response.SlipReponse;
import com.example.noticeboard.repository.SlipRepository;
import com.example.noticeboard.repository.UserRepository;
import org.springframework.stereotype.Service;

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

    public SlipReponse sendSlip(SlipSendRequest request) {

        User sndUser = userRepository.findById(request.getSndId()).orElseThrow(IllegalArgumentException::new);
        User rcvUser = userRepository.findById(request.getRcvId()).orElseThrow(IllegalArgumentException::new);

        Slip slip = slipRepository.save(new Slip(sndUser, rcvUser, request.getContent()));

        return new SlipReponse(
                slip.getId(),
                sndUser.getId(),
                rcvUser.getId(),
                slip.getContent(),
                slip.getTime()
        );
    }

}
