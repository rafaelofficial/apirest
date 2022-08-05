package com.rafael.apirest.dto;

import java.io.Serializable;

import com.rafael.apirest.model.LogCar;

public class LogCarDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String dataHora;
	private String carId;

	public LogCarDTO() {
	}
	
	public LogCarDTO(LogCar obj) {
		id = obj.getId();
		dataHora = obj.getDataHora();
		carId = obj.getCarId();
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
	public String toString() {
		return id + ", " + dataHora + ", " + carId;
	}
}
