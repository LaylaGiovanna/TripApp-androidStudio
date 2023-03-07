package br.senai.sp.jandira.tripapp

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.tripapp.ui.theme.TripAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripAppTheme {
                TripApp()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun TripApp() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
        }

        //HEADER
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .height(48.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Card(modifier = Modifier
                    .width(126.dp)
                    .height(42.dp),

                    shape = RoundedCornerShape(
                        bottomStart = 24.dp
                    ),
                    backgroundColor = Color(
                        red = 207, green = 6, blue = 240
                    )
                ) {

                }
            }
        }
        //Column 1 ready


        //LOGIN
        Column() {

        }

        //TEXT FIELDS
        Column() {

        }

        //FOOTER
        Column() {

        }


    } //final do surface
} //final da fun