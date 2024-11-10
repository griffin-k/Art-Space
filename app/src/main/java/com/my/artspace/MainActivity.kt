package com.my.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ImageGallery()
            }
        }
    }
}

@Composable
fun ImageGallery() {
    val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5
    )

    val titles = listOf(
        "Earth - The Blue Planet",
        "Earth - Home to Diverse Life",
        "Earth - Stunning Oceans",
        "Earth - Majestic Mountains",
        "Earth - Vibrant Cities at Night"
    )

    val descriptions = listOf(
        "Earth, known as the 'Blue Planet', seen from space with its rich oceans and continents.",
        "A diverse planet, Earth supports a variety of life from forests to oceans.",
        "The vast oceans of Earth, covering over 70% of the planet's surface.",
        "The towering mountains of Earth, home to some of the highest peaks in the world.",
        "A beautiful view of Earth’s cities glowing under the night sky."
    )


    var currentIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp, bottom = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = images[currentIndex]),
                    contentDescription = "Displayed Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(16.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color(0xFFADD8E6), shape = RoundedCornerShape(8.dp)) // Light Blue Background
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = titles[currentIndex],
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xFF333333)
                        ),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Text(
                        text = descriptions[currentIndex],
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            color = Color(0xFF555555)
                        )
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .padding(horizontal = 32.dp)
            ) {
                EnhancedButton("Previous") {
                    if (currentIndex > 0) {
                        currentIndex--
                    }
                }

                EnhancedButton("Next") {
                    if (currentIndex < images.size - 1) {
                        currentIndex++
                    }
                }
            }
        }
    }
}

@Composable
fun EnhancedButton(label: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .widthIn(max = 250.dp)
            .height(48.dp)
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(horizontal = 24.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF0000FF)) // Blue Button Color
    ) {
        Text(
            text = label,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewImageGallery() {
    MaterialTheme {
        ImageGallery()
    }
}
