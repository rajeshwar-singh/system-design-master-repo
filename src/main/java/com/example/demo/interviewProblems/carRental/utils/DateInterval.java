package com.example.demo.interviewProblems.carRental.utils;

import java.time.LocalDate;

public class DateInterval {

    private final LocalDate from;
    private final LocalDate to;

    public DateInterval(LocalDate from, LocalDate to)
    {
        if(to.isBefore(from))
        {
            throw new IllegalStateException("End date cannot be before start date");
        }
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom()
    {
        return from;
    }
    public LocalDate getTo()
    {
        return to;
    }

    public boolean overlap(DateInterval otherDate)
    {
        return !(this.to.isBefore(otherDate.from) || this.from.isBefore(otherDate.to));
    }
}
