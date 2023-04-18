package br.senai.sp.jandira.tripapp.gui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripapp.R
import br.senai.sp.jandira.tripapp.components.BottomShape
import br.senai.sp.jandira.tripapp.components.TopShape
import br.senai.sp.jandira.tripapp.model.User
import br.senai.sp.jandira.tripapp.repository.UserRepository
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val user = User(
//            userName = "Maria da Silva",
//            email = "maria@teste123.com",
//            password = "123",
//            phone = "134567",
//            isOver18 = true
//        )
//
//        val userRep = UserRepository(this)
//        var  id = userRep.save(user)
//
//        Toast.makeText(
//            this,
//            "$id",
//            Toast.LENGTH_LONG
//        )


        setContent {
            TripAppTheme {
                // A surface container using the 'background' color from the theme
                SignUpScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreen() {
    var photoUri by remember {
        mutableStateOf<Uri?>(null)
    }

    var launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        photoUri = uri
    }

// o painter vai guardar a imagem, requisitamos a imagem a partir do context atual,
// os dados (data) vai trazer a uri da imagem e o build irá construir de fato
    var painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current)
            .data(photoUri)
            .build()
    )

    var userNameState by remember {
        mutableStateOf("")
    }

    var phoneState by remember {
        mutableStateOf("")
    }

    var emailState by remember {
        mutableStateOf("")
    }

    var passwordState by remember {
        mutableStateOf("")
    }

    var over18State by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp), horizontalArrangement = Arrangement.End
            ) {

                TopShape()
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    color = Color(207, 6, 240),
                    fontSize = 48.sp,
                    fontWeight = FontWeight(800),
                )
                Text(
                    text = stringResource(id = R.string.create_account),
                    color = Color(160, 156, 156)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Box(
//                    contentAlignment = Alignment.BottomEnd
                ) {
                    Card(
                        modifier = Modifier.size(100.dp),
                        shape = CircleShape,
                        backgroundColor = Color(
                            160,
                            156,
                            156,
                            1
                        )
                    ) {
                        Image(
                            painter = if (photoUri == null) painterResource(id = R.drawable.person_24)
                            else painter,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                    Image(
                        painterResource(id = R.drawable.add_a_photo_24),
                        contentDescription = "",
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .clickable {
                                launcher.launch("image/*")
                                var message = "nada"
                                Log.i(
                                    "ds2m",
                                    "${photoUri?.path ?: message}"
                                )
                            }
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                //COMEÇO ////////////////////////////////////////////////////////////////////

                Column() {

                    Column(
                        modifier = Modifier
                            .height(height = 300.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        OutlinedTextField(
                            value = userNameState,
                            shape = RoundedCornerShape(16.dp),
                            onValueChange = { userNameState = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(63.dp),
                            label = { Text(text = stringResource(id = R.string.username)) },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.person_24),
                                    contentDescription = "Username",
                                    modifier = Modifier,
                                    tint = Color(206, 1, 240)
                                )
                            },
                            colors = TextFieldDefaults
                                .outlinedTextFieldColors(
                                    focusedBorderColor = Color(207, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240)
                                    focusedLabelColor = Color(207, 1, 240)
                                )
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        OutlinedTextField(
                            value = phoneState,
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            onValueChange = { phoneState = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(63.dp),
                            label = { Text(text = stringResource(id = R.string.phone)) },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.smartphone_24),
                                    contentDescription = "Phone",
                                    modifier = Modifier,
                                    tint = Color(206, 1, 240)
                                )
                            },
                            colors = TextFieldDefaults
                                .outlinedTextFieldColors(
                                    focusedBorderColor = Color(207, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240)
                                    focusedLabelColor = Color(207, 1, 240)
                                )
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = emailState,
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            onValueChange = { emailState = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(63.dp),
                            label = { Text(text = stringResource(id = R.string.email)) },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.email_24),
                                    contentDescription = "Phone",
                                    modifier = Modifier,
                                    tint = Color(206, 1, 240)
                                )
                            },
                            colors = TextFieldDefaults
                                .outlinedTextFieldColors(
                                    focusedBorderColor = Color(207, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240)
                                    focusedLabelColor = Color(207, 1, 240)
                                )
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = passwordState,
                            shape = RoundedCornerShape(16.dp),
                            visualTransformation = PasswordVisualTransformation(),
                            onValueChange = { passwordState = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(63.dp),
                            label = { Text(text = stringResource(id = R.string.password)) },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.lock_24),
                                    contentDescription = "Phone",
                                    modifier = Modifier,
                                    tint = Color(206, 1, 240)
                                )
                            },
                            colors = TextFieldDefaults
                                .outlinedTextFieldColors(
                                    focusedBorderColor = Color(207, 1, 240),
//                                unfocusedBorderColor = Color(207, 1, 240)
                                    focusedLabelColor = Color(207, 1, 240)
                                )
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Checkbox(checked = over18State, onCheckedChange = { over18State = it })
                            Text(text = stringResource(id = R.string.over_18))
                        }

                        Row(
                            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                        ) {

                            Button(
                                onClick = {
                                    saveUser(
                                        userNameState,
                                        phoneState,
                                        emailState,
                                        passwordState,
                                        over18State,
                                        photoUri?.path ?: "",
                                        context
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(Color(207, 1, 240)),

                                ) {
                                Text(
                                    text = stringResource(
                                        id = R.string.create_account
                                    ).uppercase(),
                                    fontWeight = FontWeight(800),
                                    fontSize = 16.sp,
                                    color = Color.White
                                )
                            }
                        }


                    }

                }
                //TERMINO ///////////////////////////////////////////////////////


            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = stringResource(id = R.string.already_have),
                    color = Color(160, 156, 156)
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    modifier = Modifier.clickable {
                        val intent = Intent(context, MainActivity::class.java)
                        context.startActivity(intent)

                    },
                    text = stringResource(id = R.string.sign_in),
                    color = Color(207, 1, 240),
                    fontWeight = FontWeight(800)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {

                BottomShape()

            }

        }
    }
}

fun saveUser(
    userName: String,
    phone: String,
    email: String,
    password: String,
    isOver18: Boolean,
    profilePhotoUri: String,
    context: Context
) {
    //criando um objeto USER
    val newUser = User(
        id = 0,
        userName = userName,
        phone = phone,
        email = email,
        password = password,
        profilePhoto= profilePhotoUri!!,
        isOver18 = isOver18
    )
    //criando uma instância do repositorio
    val userRepository = UserRepository(context)

    //verificando se o  usuário já existe
    val user = userRepository.findUserByEmail(email)

    Log.i("ds2m", "${user.toString()}")

    //salvando o usuario

    if (user == null) {
        val id = userRepository.save(newUser)
        Toast.makeText(context, "$id", Toast.LENGTH_LONG).show()
    } else {
        Toast.makeText(context, "User alredy exists", Toast.LENGTH_LONG).show()
    }


}




