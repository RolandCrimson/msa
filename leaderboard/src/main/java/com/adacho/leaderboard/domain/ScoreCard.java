package com.adacho.leaderboard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class ScoreCard {
	// 명시되지 않은 경우 이 카드에 할당되는 기본 점수
	public static final int DEFAULT_SCORE = 10;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "card_id")
	private final Long cardId;

	@Column(name = "user_id")
	private final Long userId;
	
	@Column(name = "user_alias")
	private final String alias;

	@Column(name = "challenge_id")
	private final Long challengeId;

	@Column(name = "score_ts")
	private final long scoreTimestamp;

	@Column(name = "score")
	private final int score;

	public ScoreCard() {
		this(null, null, null, null, 0, 0);
	}

	public ScoreCard(final Long userId, final String alias, final Long challengeId) {
		this(null, userId, alias, challengeId, System.currentTimeMillis(), DEFAULT_SCORE);
	}
}
