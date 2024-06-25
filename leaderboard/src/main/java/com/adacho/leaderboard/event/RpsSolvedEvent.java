package com.adacho.leaderboard.event;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class RpsSolvedEvent  implements Serializable{

	private static final long serialVersionUID = -5402625124693991791L;
	private final Long rpsChallengeId;
	private final Long userId;
	private final String alias;
	private final String outcome;
	
	// JSON 역직렬화에 필요(추가)
	RpsSolvedEvent() {
		this.rpsChallengeId = 0L;
		this.userId = 0L;
		this.alias = null;
		this.outcome = null;
	}
}
