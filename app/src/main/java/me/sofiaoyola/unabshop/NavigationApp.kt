package me.sofiaoyola.unabshop

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable

fun NavigationApp(){

    val myNavController = rememberNavController()
    val myStartDestination: String = "login"

    NavHost(
        navController = myNavController,
        startDestination = myStartDestination
    ){
        composable("login"){
            LoginScreen(onClickRegister = {
                myNavController.navigate("register")
            }, onSuccessfulLogin = {
                myNavController.navigate("home"){
                    popUpTo("login"){inclusive = true} //Para que me limpie el Login
                }
            })
        }

        composable("register"){
            RegisterScreen(onClickBack = {
                myNavController.popBackStack()
            })
        }

        composable("home"){
            HomeScreen()
        }
    }
}