package me.sofiaoyola.unabshop

import android.util.Patterns

//Retornar un true si es valido y un false sí no es validp
//También retorne una cadena que me diga qué pasó sí no es valido

//Pair es para que yo pueda retornar dos tipos de datos, en este caso quiero que la función
//retorne String y Boolean

fun validateEmail(email:String): Pair<Boolean, String>{
    return when{
        email.isEmpty() -> Pair(false, "El correo es requerido.")
        !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> Pair(false, "El correo es inválido")
        !email.endsWith("@test.com") -> Pair(false, "El correo no es corporativo")
        else -> Pair(true, "")
    }
}

fun validatePassword(password:String): Pair<Boolean, String>{
    return when{
        password.isEmpty() -> Pair(false, "La contraseña es requerida.")
        password.length <8 -> Pair(false, "La contraseña debe de tener al menos 6 carácteres")
        !password.any{it.isDigit()} -> Pair(false, "La contraseña dene de tener al menos un número")
        else -> Pair(true, "")
    }
}