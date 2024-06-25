package com.adacho.leaderboard.event;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.adacho.leaderboard.service.GameService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EventHandler {
	private GameService gameService;
	EventHandler(final GameService gameService) {
		this.gameService = gameService;
	}

	@RabbitListener(queues = "${rps.queue}")
	void handleMultiplicationSolved(final RpsSolvedEvent event) {
		log.info("Rps Solved Event 수신: {}", event.getRpsChallengeId());
		try {
			gameService.newChallengeForUser(event.getUserId(), event.getAlias(), event.getRpsChallengeId(), event.getOutcome());
		} catch (final Exception e) {
			log.error("RpsSolvedEvent 처리 시 에러", e);
			// 해당 이벤트가 다시 큐로 들어가거나 두 번 처리되지 않도록 예외 발생
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}
}
