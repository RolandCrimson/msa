package com.adacho.service;

import org.springframework.stereotype.Service;

import com.adacho.enums.RockPaperScissors;

@Service
public class RandomGeneratorService {
	public RockPaperScissors getRockPaperScissors() {
		return RockPaperScissors.randomRps();
	}
}
