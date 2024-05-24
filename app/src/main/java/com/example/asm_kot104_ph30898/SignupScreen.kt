package com.example.asm_kot104_ph30898

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.asm_kot104_ph30898.repository.AccountRepository
import com.example.asm_kot104_ph30898.viewmodel.LoginViewModel

class SignupScreen: ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            SignupScreen(loginViewModel)
        }
    }
    @SuppressLint("NotConstructor")
    @Composable
    fun SignupScreen(loginViewModel: LoginViewModel){
        var name by remember { mutableStateOf("")}
        var email by remember { mutableStateOf("")}
        var password by remember { mutableStateOf("")}
        var confirmPassword by remember { mutableStateOf("")}

        val context = remember { application}
        fun isValidEmail(email: String): Boolean {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isValidPassword(password: String): Boolean {
            return password.length >= 6
        }

        fun isUniqueEmail(email: String): Boolean {
            return loginViewModel.getAccountByEmail(email) == null
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome",color = Color.Black, fontSize = 30.sp)
            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),value = name, onValueChange = {name = it}, label = {
                Text(text = "Name")
            })
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),value = email, onValueChange = {email = it}, label = {
                Text(text = "Email")
            })
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),value = password, onValueChange = {password = it},visualTransformation = PasswordVisualTransformation(), label = {
                Text(text = "PassWord")
            })
            OutlinedTextField(modifier = Modifier.fillMaxWidth(),value = confirmPassword, onValueChange = {confirmPassword = it},visualTransformation = PasswordVisualTransformation(),                    label = {
                Text(text = "Confirm PassWord")
            })
            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = {
                when {
                    !isValidEmail(email) -> {
                        Toast.makeText(context, "Invalid email format", Toast.LENGTH_SHORT).show()
                    }

                    !isValidPassword(password) -> {
                        Toast.makeText(
                            context,
                            "Password must be at least 6 characters",Toast.LENGTH_SHORT).show()
                    }

                    password != confirmPassword -> {
                        Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                    }

                    !isUniqueEmail(email) -> {
                        Toast.makeText(context, "Email is already registered", Toast.LENGTH_SHORT).show()
                    }

                    else -> {
                        loginViewModel.addAccount(Account(email, password))
                        Toast.makeText(context, "Account created successfully", Toast.LENGTH_SHORT).show()
                        val intent = Intent(context, LoginScreen::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        context.startActivity(intent)
                    }
                }
            },
                modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black)
            ){
                Text(text = "Sign Up")
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Do you already have an account?")
                TextButton(onClick = {
                    val intent = Intent(context,LoginScreen::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    context.startActivity(intent)
                }) {
                    Text(text = "Log In")
                }
            }
        }
    }
}
