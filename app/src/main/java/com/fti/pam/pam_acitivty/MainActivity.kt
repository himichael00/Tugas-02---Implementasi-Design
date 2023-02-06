package com.fti.pam.pam_acitivty

import android.content.Intent
import android.icu.text.AlphabeticIndex.Bucket.LabelType
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fti.pam.pam_acitivty.ui.theme.PAM_AcitivtyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAM_AcitivtyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginForm()
                }
            }
        }
    }
}

internal fun doAuth(
    userName: String,
    password: String,
): Boolean {
    return (userName.equals("admin") && password.equals("admin"))
}

@Composable
fun LoginForm() {
    val lContext = LocalContext.current

    var usernameInput by remember {
        mutableStateOf(value = "")
    }
    var paswwordInput by remember {
        mutableStateOf(value = "")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(value = usernameInput.toString(), onValueChange = {usernameInput = it}, label = { Text(text = "Username")}, modifier = Modifier.fillMaxWidth(),
        )
        TextField(value = paswwordInput.toString(), onValueChange = {paswwordInput = it}, label = { Text(text = "Password")},
        visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth(),
        )
        Button(onClick = { val isAuthenticated = doAuth(usernameInput, paswwordInput)
        if (isAuthenticated) {
            lContext.startActivity(Intent(lContext, HomeActivity::class.java)
                .apply { putExtra("username", usernameInput)
                }
            )
        }
        })
        {
            Text(text = "Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormPreview() {
    PAM_AcitivtyTheme {
        LoginForm()
    }
}