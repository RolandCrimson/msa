package com.adacho.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adacho.domain.Rps;
import com.adacho.domain.RpsChallenge;
import com.adacho.domain.User;
import com.adacho.dto.RequestDto;
import com.adacho.dto.ResultDto;
import com.adacho.enums.RockPaperScissors;
import com.adacho.service.RpsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/results")
public class RpsChallengeController {
	private final RpsService rpsService;

	@PostMapping
	Map<String, String> postResult(@RequestBody RequestDto dto) {
		User user = new User(dto.userAlias());
		log.info("userChoice: " + dto.userChoice());
		Rps rps = new Rps(stringToRockPaperScissors(dto.userChoice()));

		RpsChallenge rpsChallenge = new RpsChallenge(user, rps, null, null);
		Map<String, String> map = rpsService.checkChallenge(rpsChallenge);
		log.info("outcome: " + map.get("outcome"));
		log.info("opponent: " + map.get("opponent"));
		return map;
	}

	private RockPaperScissors stringToRockPaperScissors(String code) {
		RockPaperScissors result = null;
		for (RockPaperScissors rps : RockPaperScissors.values()) {
			log.info("RockPaperScissors value: " + rps.getCommentary());
			if (rps.getCommentary().equals(code)) {
				result = rps;
				break;
			}
		}
		return result;
	}

	@GetMapping
	List<ResultDto> getStatistics(@RequestParam("alias") String alias) {
		List<RpsChallenge> challenges = rpsService.getStatsForUser(alias);
		List<ResultDto> results = new ArrayList<ResultDto>();
		log.info("getStatistics results size: " + results.size());
		for (RpsChallenge challenge : challenges) {
			ResultDto result = new ResultDto(challenge.getId(), challenge.getRps().getChallenge().getCommentary(),
					challenge.getOpponent().getCommentary(), challenge.getGameResult().getCommentary(),
					challenge.getUser().getId());
			results.add(result);
		}
		return results;
	}
}
