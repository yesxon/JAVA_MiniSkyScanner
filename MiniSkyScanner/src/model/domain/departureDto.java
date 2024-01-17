package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class departureDto {
	int index;
	String destination;
	String dep_time;
	int left_seat;
	int price;
	String departure;
}
