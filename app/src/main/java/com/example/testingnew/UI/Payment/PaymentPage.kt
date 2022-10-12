package com.example.testingnew.UI.Payment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.testingnew.R
import com.example.testingnew.UI.Main.MainActivity
import com.example.testingnew.UI.ThanksPage
import com.payment.paymentsdk.PaymentSdkConfigBuilder
import com.payment.paymentsdk.integrationmodels.*
import com.payment.paymentsdk.PaymentSdkActivity.Companion.startCardPayment
import com.payment.paymentsdk.sharedclasses.interfaces.CallbackPaymentInterface


class PaymentPage : AppCompatActivity(), CallbackPaymentInterface {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_page)

        val bundle = intent.extras
        val price = bundle!!.getDouble("price")

        val profileId = "90173"
        val serverKey = "S2JN2KL9WN-JD9KB96L9H-MZGDN9BHWH"
        val clientKey = "CPKMQV-TNNV6D-PK2PGB-TTG9KK"
        val locale = PaymentSdkLanguageCode.EN //or PaymentSdkLanguageCode.AR
        val screenTitle = "Test SDK"
        val cartId = "123456"
        val cartDesc = "Test"
        val currency = "SAR"
        val amount = price

        val tokeniseType = PaymentSdkTokenise.NONE // tokenise is off
        //or PaymentSdkTokenise.USER_OPTIONAL // tokenise if optional as per user approval
        //or PaymentSdkTokenise.USER_MANDATORY // tokenise is forced as per user approval
        //or PaymentSdkTokenise.MERCHANT_MANDATORY // tokenise is forced without user approval

        val transType = PaymentSdkTransactionType.SALE;
        //or PaymentSdkTransactionType.AUTH


        val tokenFormat = PaymentSdkTokenFormat.Hex32Format()
        //or PaymentSdkTokenFormat.NoneFormat()
        //or PaymentSdkTokenFormat.AlphaNum20Format()
        //or PaymentSdkTokenFormat.Digit22Format()
        //or PaymentSdkTokenFormat.Digit16Format()
        //or PaymentSdkTokenFormat.AlphaNum32Format()
        val billingData = PaymentSdkBillingDetails(
            "City",
            "SA",
            "email1@domain.com",
            "name ",
            "phone", "state",
            "address street", "zip"
        )
        val shippingData = PaymentSdkShippingDetails(
            "City",
            "SA",
            "email1@domain.com",
            "name ",
            "phone", "state",
            "address street", "zip"
        )

        val configData =
            PaymentSdkConfigBuilder(profileId, serverKey, clientKey, amount ?: 0.0, currency)
                .setCartDescription(cartDesc)
                .setLanguageCode(locale)
                .setMerchantIcon(resources.getDrawable(com.payment.paymentsdk.R.drawable.payment_sdk))
                .setBillingData(billingData)
                .setMerchantCountryCode("SA") // ISO alpha 2
                .setShippingData(shippingData)
                .setCartId("123")
                .setTransactionType(transType)
                .showBillingInfo(false)
                .showShippingInfo(true)
                .forceShippingInfo(true)
                .setScreenTitle(screenTitle)
                .build()
        startCardPayment(this, configData, callback = this)
        //or
//        startSamsungPayment(this, configData, "samsungpay token", callback = this)

    }

    override fun onError(error: PaymentSdkError) {
        Log.d("TAG_PAYTABS", "onError: $error")
        Toast.makeText(this, "${error.msg}", Toast.LENGTH_SHORT).show()
    }

    override fun onPaymentFinish(PaymentSdkTransactionDetails: PaymentSdkTransactionDetails) {

        val intent = Intent(this, ThanksPage::class.java)
        startActivities(arrayOf(intent))

        Log.d("TAG_PAYTABS", "onPaymentFinish: $PaymentSdkTransactionDetails")

    }

    override fun onPaymentCancel() {
        //Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show()
        Log.d("TAG_PAYTABS", "onPaymentCancel:")
        val intent = Intent(this, MainActivity::class.java)
        startActivities(arrayOf(intent))
    }
}
