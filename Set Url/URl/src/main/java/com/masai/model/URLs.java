package com.masai.model;


import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class URLs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String actualUrl;
	private String shortUrl;
	private LocalDate expiry;
	private LocalDate urlgenerateddate;

}
