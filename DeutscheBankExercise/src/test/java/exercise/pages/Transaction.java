package exercise.pages;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;



public class Transaction {

    private String id;
    private String date;
    private String src_ACC;
    private String dest_ACC;
    private String type;
    private String amount;
    private String currency;

    public Transaction(String id, String date, String src_ACC, String dest_ACC, String type, String amount, String currency){
        this.id = id;
        this.date = date;
        this.src_ACC = src_ACC;
        this.dest_ACC = dest_ACC;
        this.type = type;
        this.amount = amount;
        this.currency = currency;

    }

    public Transaction(String[] rawTransactions) {
        //assume the order is correct
        this.id = rawTransactions[0];
        this.date = rawTransactions[1];
        this.src_ACC = rawTransactions[2];
        this.dest_ACC = rawTransactions[3];
        this.type = rawTransactions[4];
        this.amount = validateAmount(rawTransactions[5]);
        this.currency = rawTransactions[6];
    }


    private String validateAmount(String rawTransaction) {
        Pattern p= Pattern.compile("^\\d+(\\.\\d{2})?$");
        Matcher m= p.matcher(rawTransaction);
        assertThat(String.format("The value of '%s' may have been entered in the incorrect format.", rawTransaction),m.matches());
        return rawTransaction;
    }

    public String toString(){
        return "ID: " +  id + "\n" + "DATE: "  + date + "\n" +"SRC_ACC:"  + src_ACC + "\n" + "DEST_ACC: " + dest_ACC + "\n" + "TYPE: " + type + "\n" + "AMOUNT: " + amount + "\n" + "CCY: " + currency;}

    public String getValue(String header) {
        if (header.contains("id")){
            return this.id;
        } else if (header.contains("date")) {
            return this.date;
        } else if (header.contains("src_acc")) {
            return this.src_ACC;
        } else if (header.contains("dest_acc")) {
            return this.dest_ACC;
        } else if (header.contains("type")) {
            return this.type;
        } else if (header.contains("amount")) {
            return this.amount;
        } else if (header.contains("ccy")) {
            return this.currency;
        } else {
            return "";
        }
    }
}


