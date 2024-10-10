package com.daemon.auth.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.daemon.ui.components.ButtonPrimary
import com.daemon.ui.components.JelloEditText
import com.daemon.ui.components.JelloImageViewClick
import com.daemon.ui.components.JelloTextHeader
import com.daemon.ui.components.JelloTextRegular
import com.daemon.ui.components.JelloTextRegularWithClick

@Composable
fun SignUpScreen(
    navController: NavController = rememberNavController()
) {
    Column (
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White)
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
            text = "Create your account",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        JelloTextRegularWithClick(
            text = "Do you already have account ? ",
            textClick = "Sign In",
            onClick = {
                navController.popBackStack()
            }
        )

        Spacer(modifier = Modifier.height(25.dp))

        JelloTextRegular(
            text = "Username",
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        JelloEditText(
            value = "adhri.test",
        )

        Spacer(modifier = Modifier.height(20.dp))

        JelloTextRegular(
            text = "E-mail",
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        JelloEditText(
            value = "testing.email@gmail.com",
        )

        Spacer(modifier = Modifier.height(20.dp))

        JelloTextRegular(
            text = "Password",
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        JelloEditText(
            value = "password",
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(30.dp))
        ButtonPrimary(
            text = "Create account"
        )
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}