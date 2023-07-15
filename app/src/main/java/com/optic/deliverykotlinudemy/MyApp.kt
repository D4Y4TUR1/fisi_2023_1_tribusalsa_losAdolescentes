package com.optic.deliverykotlinudemy

import android.app.Application
import com.optic.deliverykotlinudemy.config.Config
import com.paypal.checkout.PayPalCheckout
import com.paypal.checkout.config.CheckoutConfig
import com.paypal.checkout.config.Environment
import com.paypal.checkout.config.SettingsConfig
import com.paypal.checkout.createorder.CurrencyCode
import com.paypal.checkout.createorder.UserAction

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        val config = CheckoutConfig(
            application = this,
            clientId = Config.PAYPAL_CLIENT_ID,
            environment = Environment.SANDBOX,
            returnUrl = "${BuildConfig.APPLICATION_ID}://paypalpay",
            currencyCode = CurrencyCode.USD,
            userAction = UserAction.PAY_NOW,
            settingsConfig = SettingsConfig(
                loggingEnabled = true
            )
        )
        PayPalCheckout.setConfig(config)
    }
}


