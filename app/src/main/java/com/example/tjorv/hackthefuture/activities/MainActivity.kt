package com.example.tjorv.hackthefuture.activities

import android.app.Dialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.provider.AuthCallback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.example.tjorv.hackthefuture.R
import com.example.tjorv.hackthefuture.fragments.MainFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        login()
        super.onCreate(savedInstanceState)
    }

    private fun login() {
        WebAuthProvider.init(Auth0(this))
            .withScheme("demo")
            .withAudience(String.format("https://%s/userinfo", getString(R.string.com_auth0_domain)))
            .start(this, object:AuthCallback {
                override fun onSuccess(credentials: Credentials) {
                    val sharedPref = getSharedPreferences("HTF", Context.MODE_PRIVATE) ?: return
                    with (sharedPref.edit()) {
                        putString("APIKey", credentials.accessToken)
                        apply()
                    }
                    val fragmentTransaction = supportFragmentManager.beginTransaction()
                    fragmentTransaction.add(R.id.fragment_holder, MainFragment())
                    fragmentTransaction.commit()
                }

                override fun onFailure(dialog: Dialog) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onFailure(exception: AuthenticationException?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
    }
}




