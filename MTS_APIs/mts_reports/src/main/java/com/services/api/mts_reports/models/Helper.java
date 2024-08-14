package com.services.api.mts_reports.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class Helper {
    private String transport;
    private LocalDate date;
}
