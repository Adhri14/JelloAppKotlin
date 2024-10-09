package com.daemon.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daemon.auth.ui.signin.SignInScreen
import com.daemon.auth.ui.signup.SignUpScreen
import com.daemon.ui.theme.MyJelloTheme

class MainActivity : ComponentActivity() {

    sealed class Screen(val route: String) {
        object AuthSignIn : Screen("auth/signin")
        object AuthSignUp : Screen("auth/signup")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyJelloTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AuthSignIn.route
                    ) {
                        composable(route = Screen.AuthSignIn.route) {
                            SignInScreen(
                                navController = navController
                            )
                        }
                        composable(route = Screen.AuthSignUp.route) {
                            SignUpScreen(
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}