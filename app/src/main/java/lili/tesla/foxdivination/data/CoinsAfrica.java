package lili.tesla.foxdivination.data;

import java.util.Random;

import lili.tesla.foxdivination.presentation.util.Utils;

/**
 * Created by Лилия on 03.12.2017.
 */

public class CoinsAfrica {

    private static final Random random = new Random();

    private CoinAfrica[] coins;
    private int countOrel;
    private int countReshka;

    public CoinsAfrica() {

        coins = new CoinAfrica[4];
        countOrel = 0;
        countReshka = 0;

        for (int i = 0; i < 4; i ++) {
            int randomNum = random.nextInt(2);
            coins[i] = new CoinAfrica(randomNum);
            if (randomNum == 0) {
                countReshka++;
            } else {
                countOrel++;
            }
        }
    }

    public CoinAfrica[] getCoins() {
        return coins;
    }

    public void setCoins(CoinAfrica[] coins) {
        this.coins = coins;
    }

    public int getCountOrel() {
        return countOrel;
    }

    public void setCountOrel(int countOrel) {
        this.countOrel = countOrel;
    }

    public int getCountReshka() {
        return countReshka;
    }

    public void setCountReshka(int countReshka) {
        this.countReshka = countReshka;
    }

}
