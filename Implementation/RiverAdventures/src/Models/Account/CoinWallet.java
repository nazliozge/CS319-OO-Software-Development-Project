package Models.Account;

/**
 * Created by Nazli on 24/04/16.
 */
public class CoinWallet {

    //attributes
    private int coinAmount;

    //constructor
    public CoinWallet()
    {
        coinAmount=0;
    }

    //methods
    public int getCoinAmount()
    {
        return coinAmount;
    }

    public void addCoin(int amount)
    {
        coinAmount +=amount;
    }

    public void spendCoin(int amount)
    {
        coinAmount -=amount;
    }
}
