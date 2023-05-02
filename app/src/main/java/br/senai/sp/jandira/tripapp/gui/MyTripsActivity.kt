package br.senai.sp.jandira.tripapp.gui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import br.senai.sp.jandira.tripapp.gui.ui.theme.TripAppTheme

class MyTripsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras
        Log.i("ds2m", "id")
        setContent {
            TripAppTheme {
                loggedScreen()
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun loggedScreen(
//    categories: List<Category>,
//    trips: List<Trip>
){
    Surface(modifier = Modifier.fillMaxSize()){
//column principal. que abriga tudo
        Column(modifier = Modifier.fillMaxSize()){

//card  ue tem a foto de paris
            Card(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
                shape = RoundedCornerShape(0.dp)
            ){
                Image(
                    painter =painterResource(id = R.drawable.paris),
                    contentDescription = "lago",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop

                )
            }
            Text(
                text =stringResource(id = R.string.categories),
                color =Color(56,54,54),
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
        }
    }
}