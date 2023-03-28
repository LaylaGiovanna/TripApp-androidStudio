package br.senai.sp.jandira.tripapp.gui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.components.BottomShape
import br.senai.sp.jandira.tripapp.components.TopShape
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TripAppTheme {
                LoginScreen()
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreen(){

    val context = LocalContext.current

    //Colum principal
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TopShape()
        }

        //Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 0.dp)
        ) {
            Text(
                text = stringResource(id = R.string.login),
                fontSize = 64.sp,
                fontWeight = FontWeight(800),
                lineHeight = 90.sp,
                color = Color(207, 6, 240)

            )
            Text(
                text = stringResource(id = R.string.please),
                fontSize = 19.sp,
                fontWeight = FontWeight(400),
                lineHeight = 90.sp,
                color = Color(160, 156, 156)

            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {


            //Main
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = {
                        Text(text = stringResource(id = R.string.email))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.email_24),
                            contentDescription = stringResource(id = R.string.email),
                            tint = Color(207,1,240)

                        )
                    },
                    colors = TextFieldDefaults
                        .outlinedTextFieldColors(
                            focusedBorderColor = Color(207,1,240),
                            unfocusedBorderColor = Color(207,1,240)
                        )
                )
            }
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = {
                        Text(text = stringResource(id = R.string.password))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock_24),
                            contentDescription = stringResource(id = R.string.password),
                            tint = Color(207,1,240)

                        )
                    },
                    colors = TextFieldDefaults
                        .outlinedTextFieldColors(
                            focusedBorderColor = Color(207,1,240),
                            unfocusedBorderColor = Color(207,1,240)
                        )
                )
            }
            Spacer(
                modifier = Modifier.height(30.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                    shape = RoundedCornerShape(16.dp)

                ) {
                    Text(
                        text = stringResource(id = R.string.sign_in),
                        fontSize = 16.sp,
                        fontWeight =  FontWeight.Bold,
                        color = Color.White

                    )
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_forward_24),
                        contentDescription ="",
                        tint = Color.White
                    )
                }
            }



        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = stringResource(id = R.string.dont_have))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = stringResource(id = R.string.sign_up),
                modifier = Modifier.clickable {
//tornar a palavra clicavel
                    val intent = Intent(context, SignUpActivity::class.java)
                    context.startActivity(intent)
                },
                color = Color(207, 6, 240),
                fontWeight = FontWeight.Bold)
        }

        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            BottomShape()
        }
    }
}


