package com.example.Atm.Service;

import com.example.Atm.Dto.AtmDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AtmService {

    public static int[][] bill = {{1000,10}, {500,20}, {100,30}, {50,100}, {20,100}};
    public static int[][] coin = {{10, 50}, {5, 30}, {2,20}, {1,20}};



    public int sumMoney(){
        int total =0;

        for (int i=0; i < bill.length; i++){
            total += bill[i][0] * bill[i][1];
        }

        for (int i=0; i < coin.length; i++){
            total += coin[i][0] * coin[i][1];
        }


        return total;
    }


    public int[][][] withdraw(int amount){
        int[][] billArr = {{1000,0}, {500,0}, {100,0}, {50,0}, {20,0}}; ;
        int[][] coinArr = {{10, 0}, {5, 0}, {2,0}, {1,0}};
        int [][][] errArr = {{{}},{{}}};

        if (amount > sumMoney()) {
            return errArr;
        }

        while (amount > 0) {
            if(Math.floor(amount / 1000) != 0 && bill[0][1] > 0 ) {
                amount -= 1000;
                bill[0][1] -= 1;
                billArr[0][1] += 1;
            }
            else if (Math.floor(amount / 500) != 0 && bill[1][1] > 0 ) {
                amount -= 500;
                bill[1][1] -= 1;
                billArr[1][1] += 1;
            }
            else if (Math.floor(amount / 100) != 0 && bill[2][1] > 0 ) {
                amount -= 100;
                bill[2][1] -= 1;
                billArr[2][1] += 1;
            }
            else if (Math.floor(amount / 50) != 0 && bill[3][1] > 0 ) {
                amount -= 50;
                bill[3][1] -= 1;
                billArr[3][1] += 1;
            }
            else if (Math.floor(amount / 20) != 0 && bill[4][1] > 0 ) {
                amount -= 20;
                bill[4][1] -= 1;
                billArr[4][1] += 1;
            }
            else if (Math.floor(amount / 10) != 0 && coin[0][1] > 0 ) {
                amount -= 10;
                coin[0][1] -= 1;
                coinArr[0][1] += 1;
            }
            else if (Math.floor(amount / 5) != 0 && coin[1][1] > 0 ) {
                amount -= 5;
                coin[1][1] -= 1;
                coinArr[1][1] += 1;
            }
            else if (Math.floor(amount / 2) != 0 && coin[2][1] > 0 ) {
                amount -= 2;
                coin[2][1] -= 1;
                coinArr[2][1] += 1;
            }
            else if (Math.floor(amount / 1) != 0 && coin[3][1] > 0 ) {
                amount -= 1;
                coin[3][1] -= 1;
                coinArr[3][1] += 1;
            }
            else {
                return errArr;
            }
        }



        int[][][] resultArr = {billArr,coinArr};
        return resultArr;
    };




    public AtmDto doWithdraw(String amount) {
        AtmDto result = new AtmDto();
        result.setMoneyResult(withdraw(Integer.parseInt(amount)));

        return result;
    }

    public AtmDto getMoney() {
        AtmDto moneyList = new AtmDto();
        moneyList.setBill(bill);
        moneyList.setCoin(coin);
        return moneyList;
    }


}
