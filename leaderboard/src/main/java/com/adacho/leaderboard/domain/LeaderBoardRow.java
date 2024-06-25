package com.adacho.leaderboard.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class LeaderBoardRow {
	private final Long userId;
	private final String alias;
	private final Long totalScore;

	// JSON/JPA 를 위한 빈 생성자
//	public LeaderBoardRow() {
//		this(0L, 0L);
//	}
}
