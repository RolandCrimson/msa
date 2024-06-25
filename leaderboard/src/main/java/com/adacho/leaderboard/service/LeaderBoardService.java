package com.adacho.leaderboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adacho.leaderboard.domain.LeaderBoardRow;
import com.adacho.leaderboard.repository.ScoreCardRepository;

@Service
public class LeaderBoardService {
	private final ScoreCardRepository scoreCardRepository;

	LeaderBoardService(ScoreCardRepository scoreCardRepository) {
		this.scoreCardRepository = scoreCardRepository;
	}

	public List<LeaderBoardRow> getCurrentLeaderBoard() {
		return scoreCardRepository.findFirst10();
	}
}
