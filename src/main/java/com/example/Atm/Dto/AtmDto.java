package com.example.Atm.Dto;

import lombok.Data;

@Data
public class AtmDto {
    private String amount;
    private int[][] bill;
    private int[][] coin;
    private int[][][] moneyResult;


}
