package com.adacho.leaderboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adacho.leaderboard.domain.GameStats;
import com.adacho.leaderboard.service.GameService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserStatsController {
	private final GameService gameService;

	public UserStatsController(final GameService gameService) {
		this.gameService = gameService;
	}

	@GetMapping("/stats")
	public GameStats getStatsForUser(@RequestParam("userId") final Long userId) {
		log.info("userId in getStatsForUser: " + userId);
		return gameService.retrieveStatsForUser(userId);
	}
}
