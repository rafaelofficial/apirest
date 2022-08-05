package com.rafael.apirest.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "logs")
public class CarLogging implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("_id")
	@Id
	private String id;

	@JsonProperty("data_hora")
	private String dataHora;

	@JsonProperty("car_id")
	private String carId;

	public CarLogging() {
	}

	public CarLogging(String id, String dataHora, String carId) {
		this.id = id;
		this.dataHora = dataHora;
		this.carId = carId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarLogging other = (CarLogging) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return id + ", " + dataHora + ", " + carId;
	}
}
