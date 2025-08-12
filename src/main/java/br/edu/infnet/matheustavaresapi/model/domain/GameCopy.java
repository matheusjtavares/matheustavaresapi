package br.edu.infnet.matheustavaresapi.model.domain;

import java.math.BigDecimal;
import java.util.Date;

public class GameCopy {
    public GameTitle title;
    public Platform platform;
    public Date ownedSince;
    public Person onwnerPerson;
    public Boolean availableForRental;
    public BigDecimal rentalDailyFee;
}
