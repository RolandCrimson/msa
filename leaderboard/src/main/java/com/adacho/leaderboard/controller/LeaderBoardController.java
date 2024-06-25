package com.adacho.leaderboard.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adacho.leaderboard.domain.LeaderBoardRow;
import com.adacho.leaderboard.service.LeaderBoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/leaders")
public class LeaderBoardController {
	private final LeaderBoardService leaderBoardService;

	public LeaderBoardController(final LeaderBoardService leaderBoardService) {
		this.leaderBoardService = leaderBoardService;
	}

	@GetMapping
	public List<LeaderBoardRow> getLeaderBoard() {
		log.info("Retrieving leaderboard");
		List<LeaderBoardRow> list = leaderBoardService.getCurrentLeaderBoard();
		log.info("alias in LeaderBoardRow[0]: " + list.get(0).getAlias());
		return list;
	}
}
