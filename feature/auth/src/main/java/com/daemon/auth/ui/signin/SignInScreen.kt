package com.daemon.auth.ui.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.daemon.auth.MainActivity
import com.daemon.ui.components.ButtonPrimary
import com.daemon.ui.components.ButtonSosmed
import com.daemon.ui.components.JelloEditText
import com.daemon.ui.components.JelloEditTextPreview
import com.daemon.ui.components.JelloImageViewClick
import com.daemon.ui.components.JelloTextHeader
import com.daemon.ui.components.JelloTextRegular
import com.daemon.ui.components.JelloTextRegularWithClick
import com.daemon.ui.components.JelloTextViewRow

@Composable
fun SignInScreen(
    navController: NavController = rememberNavController()
) {
    var emailValue by remember { mutableStateOf("testing") }
    var passwordValue by remember { mutableStateOf("") }

    val scrollViewState = rememberScrollState()

    Column (
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(scrollViewState)
    ) {
        JelloImageViewClick(
            onClick = {
                navController.popBackStack()
            },
            imageVector = Icons.Sharp.ArrowBack,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(30.dp))

        JelloTextHeader(
            text = "Welcome to Login",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        JelloTextRegularWithClick(
            text = "Please fill E-mail & password to login your app account. ",
            textClick = "Sign Up",
            onClick = {
                navController.navigate(route = MainActivity.Screen.AuthSignUp.route)
            }
        )

        Spacer(modifier = Modifier.height(25.dp))

        JelloTextRegular(
            text = "E-mail",
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        JelloEditText(
            value = emailValue,
            onTyping = {
                emailValue = it
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        JelloTextRegular(
            text = "Password",
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        JelloEditText(
            value = passwordValue,
            onTyping = {
                passwordValue = it
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(30.dp))
        JelloTextViewRow()

        Spacer(modifier = Modifier.height(30.dp))
        ButtonPrimary()

        Spacer(modifier = Modifier.height(10.dp))
        ButtonSosmed()
    }
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}