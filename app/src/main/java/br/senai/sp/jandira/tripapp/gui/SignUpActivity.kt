package br.senai.sp.jandira.tripapp.gui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
                SignUpScreen()
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignUpScreen() {



//Colum principal
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
//INICIO da forma roxa
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TopShape()
        }//Fim da forma roxa


//INICIO do Sign up
        //Header
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.sign_up),
                fontSize = 32.sp,
                fontWeight = FontWeight(800),
                lineHeight = 90.sp,
                color = Color(207, 6, 240)

            )
            Text(
                text = stringResource(id = R.string.create),
                fontSize = 15.sp,
                fontWeight = FontWeight(400),
                lineHeight = 90.sp,
                color = Color(160, 156, 156)

            )

            Spacer(modifier = Modifier.height(32.dp))

            Box(
                modifier = Modifier.size(100.dp),
//DUAS maneiras de fazer esse Icon ir para o BottomEnd
//                contentAlignment = Alignment.BottomEnd
            ) {
                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .offset(x = 0.dp, y = 0.dp),
                    shape = CircleShape,
                    backgroundColor = Color(
                        232,
                        232,
                        232,
                        1
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user_photo),
                        contentDescription = null,
                        contentScale = ContentScale.Crop

                    )
                }



                Image(
                    modifier = Modifier
                        .align(alignment = Alignment.BottomEnd)
                        .background(Color.Gray)
                        .height(20.dp),
                    painter = painterResource(id = R.drawable.add_a_photo_24),
                    contentDescription = null
                )
            }

        }//FIM do Sign up


//INICIO dos Text Fields
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            //TextField username
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
            }


            Column(
                modifier = Modifier
//                    .height(height = 300.dp)
                    .verticalScroll(rememberScrollState()
                        )
            ) {
                // -------------------
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = {
                        Text(text = stringResource(id = R.string.username))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.person_24),
                            contentDescription = stringResource(id = R.string.username),
                            tint = Color(207, 1, 240)

                        )
                    }
                )
            }//TextField EMAIL

            Spacer(
                modifier = Modifier.height(16.dp)
            )

//TextField PHONE
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
                        Text(text = stringResource(id = R.string.phone))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.smartphone_24),
                            contentDescription = stringResource(id = R.string.phone),
                            tint = Color(207, 1, 240)

                        )
                    }
                )
            }//TextField PHONE

            Spacer(
                modifier = Modifier.height(16.dp)
            )

//TextField EMAIL
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
                            tint = Color(207, 1, 240)

                        )
                    }
                )
            }//TextField EMAIL

            Spacer(
                modifier = Modifier.height(16.dp)
            )

//TextField PASSWORD
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
                            tint = Color(207, 1, 240)

                        )
                    }
                )
            }//TextField PASSWORD
//FIM dos Text Fields


            Spacer(
                modifier = Modifier.height(15.dp)
            )

//INICIO do over 18
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = false,
                    onCheckedChange = {})
                Text(text = stringResource(id = R.string.over_18))
            }//FIM do over 18

            Spacer(modifier = Modifier.height(18.dp))

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color(207, 6, 240)),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
                    .height(48.dp)

            ) {
                Text(
                    text = stringResource(id = R.string.create_account),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White

                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = stringResource(id = R.string.already_have))

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = stringResource(id = R.string.sign_in),
                    color = Color(207, 6, 240),
                    fontWeight = FontWeight.Bold
                )
            }

        }//FIM dos Text Fields
//-----------

    }





//INICIO da Row de Don't have an account


        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            BottomShape()
        }//Final da Row de Don't have an account


    }

