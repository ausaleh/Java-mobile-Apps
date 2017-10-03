package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity = 0;


    /**
     * This method is called when the plusbutton is clicked.
     */
   public void increment (View view)
   {
       if (quantity ==100 )
       {
           Toast.makeText(this,"you cat buy morethan 100",Toast.LENGTH_SHORT).show();
           return;
       }
       quantity = quantity + 1;
       displayquantity(quantity);
   }
    public void decrement(View view) {
            if (quantity == 0 )
            {
                Toast.makeText(this,"you cat buy less than 1",Toast.LENGTH_SHORT).show();
                return;
            }
        quantity = quantity - 1;

        displayquantity(quantity);
        ;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText name_field = (EditText) findViewById(R.id.name);
        String name = name_field.getText().toString();
        CheckBox whippedcreambox = (CheckBox) findViewById(R.id.wc);
        CheckBox chocho = (CheckBox) findViewById(R.id.cho);
        boolean haswhippedcream = whippedcreambox.isChecked();


        boolean haschoco = chocho.isChecked();
        int price = calculatePrice(haschoco,haswhippedcream);
        String priceMessage = CreateOrderSummary(price,haswhippedcream,haschoco,name);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this

        intent.putExtra(Intent.EXTRA_SUBJECT, "order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);

        }

      /*  CreateOrderSummary(10);*/

    }
    /** calc methods*/
    private int calculatePrice(boolean addwhippedcream,boolean addchocho)
    {
        int baseprice = 5;

        if (addwhippedcream)
        {
            baseprice = baseprice + 1;
        }

        if (addchocho)
        {
            baseprice = baseprice +2;
        }
        return quantity * baseprice;

    }
    /** order summary*/
    public String CreateOrderSummary(int price, boolean addwhippedcream,boolean addchocho, String name)
    {
        String priceMessage= "name : " + name;
        priceMessage += "\nadd whipped cream "+ addwhippedcream;
        priceMessage +="\nadd chcho cram" + addchocho;
        priceMessage = priceMessage + "\n quantity " + quantity;

        priceMessage = priceMessage + " \n total: $" + price;
        priceMessage = priceMessage + "\n" +getString(R.string.thank_you);

        return priceMessage;


    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayquantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */

    /**
     * This method displays the given text on the screen.
     */

}