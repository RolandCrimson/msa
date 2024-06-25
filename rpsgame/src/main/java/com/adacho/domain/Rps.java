package com.adacho.domain;

import com.adacho.enums.RockPaperScissors;

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
public class Rps {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rpsplay_id")
	private Long id;

	private final RockPaperScissors challenge;

	Rps() {
		this(null);
	}
}
