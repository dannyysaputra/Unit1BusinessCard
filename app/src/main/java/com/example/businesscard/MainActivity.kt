package com.example.businesscard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF3eea34)
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    CardName(
        name = stringResource(R.string.name),
        role = stringResource(R.string.roles),
        imagePainter = painterResource(R.drawable.android_logo)
    )
    SocialMediaSection(
        number = stringResource(R.string.number),
        instagram = stringResource(R.string.instagram),
        email = stringResource(R.string.email)
    )
}

@Composable
private fun CardName(
    name: String,
    role: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier.padding(start = 100.dp, end = 100.dp)
        )
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = role,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
private fun SocialMediaSection(
    number: String,
    instagram: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            Icon(Icons.Rounded.Call, contentDescription = null)
            Text(
                text = number,
                modifier = Modifier.padding(start = 12.dp)
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            Icon(Icons.Rounded.Share, contentDescription = null)
            Text(
                text = instagram,
                modifier = Modifier.padding(start = 18.dp)
            )
        }
        Row(
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            Icon(Icons.Rounded.Email, contentDescription = null)
            Text(
                text = email,
                modifier = Modifier.padding(start = 18.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x443eea34)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}