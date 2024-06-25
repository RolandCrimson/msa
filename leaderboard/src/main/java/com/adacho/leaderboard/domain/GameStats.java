package com.adacho.leaderboard.domain;

import java.util.Collections;
import java.util.List;

import com.adacho.leaderboard.enums.Badge;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class GameStats {
	private final Long userId;
	private final int score;
	private final List<Badge> badges;

	// JSON/JPA 를 위한 빈 생성자
//	public GameStats() {
//		this.userId = 0L;
//		this.score = 0;
//		this.badges = Collections.emptyList();
//	}

	/**
	 * 빈 인스턴스(0점과 배지 없는 상태)를 만들기 위한 팩토리 메소드
	 *
	 * @param userId 사용자 ID
	 * @return {@link GameStats} 객체(0점과 배지 없는 상태)
	 */
	public static GameStats emptyStats(final Long userId) {
		return new GameStats(userId, 0, Collections.emptyList());
	}

	/**
	 * @return 수정불가능한 배지 카드 리스트의 뷰
	 */
	public List<Badge> getBadges() {
		return Collections.unmodifiableList(badges);
	}
}
