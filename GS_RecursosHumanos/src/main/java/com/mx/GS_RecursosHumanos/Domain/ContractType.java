package com.mx.GS_RecursosHumanos.Domain;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ContractType")
public class ContractType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short contractTypeId;

	@Column(length = 80, nullable = false)
	private String name;

	@Column(length = 255, nullable = true)
	private String description;

	@Column(nullable = false)
	private boolean isActive;

	@Column(nullable = false)
	private LocalDateTime dateCreated;

}
