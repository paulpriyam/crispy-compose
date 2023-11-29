package com.example.compose.day4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.day567.model.PortfolioData
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CustomCard()
                }
            }
        }
    }
}

@Composable
fun CustomCard() {
    val data = listOf(
        PortfolioData(
            project = "Android Project",
            description = "Sample Android Project"
        ),
        PortfolioData(
            project = "Android Project 2",
            description = "Sample Android Project"
        ),
        PortfolioData(
            project = "Flutter Project",
            description = "Sample Flutter Project"
        ),
        PortfolioData(
            project = "React Project",
            description = "Sample React Project"
        ),
        PortfolioData(
            project = "iOS Project",
            description = "Sample iOS Project"
        ),
    )
    val buttonClickState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(corner = CornerSize(8.dp)),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .height(300.dp)
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileImage()
                Spacer(modifier = Modifier.height(16.dp))
                Divider()
                InfoSection()
                Button(onClick = {
                    buttonClickState.value = !buttonClickState.value
                }) {
                    Text("Portfolio", style = MaterialTheme.typography.button)
                }
                if (buttonClickState.value) {
                    PortfolioInfo(data)
                } else {
                    Box() {

                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun PortfolioInfo(
    data: List<PortfolioData> = listOf<PortfolioData>(
        PortfolioData(
            project = "Android Project",
            description = "Sample Android Project"
        ),
        PortfolioData(
            project = "Android Project 2",
            description = "Sample Android Project"
        ),
        PortfolioData(
            project = "Flutter Project",
            description = "Sample Flutter Project"
        ),
        PortfolioData(
            project = "React Project",
            description = "Sample React Project"
        ),
        PortfolioData(
            project = "iOS Project",
            description = "Sample iOS Project"
        ),
    )
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            shape = RoundedCornerShape(corner = CornerSize(4.dp)),
            border = BorderStroke(width = 1.dp, color = Color.Black)
        ) {
            PortfolioListView(data = data)
        }
    }
}

@Composable
fun PortfolioListView(data: List<PortfolioData>, onItemClicked: (PortfolioData) -> Unit = {}) {
    LazyColumn() {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable {
                        onItemClicked.invoke(item)
                    },
                elevation = 4.dp,
                shape = RoundedCornerShape(corner = CornerSize(size = 4.dp))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = item.image),
                        contentDescription = "project image",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.fillMaxSize()) {
                        Text(text = item.project, style = MaterialTheme.typography.body1)
                        Text(text = item.description, style = MaterialTheme.typography.body2)
                    }
                }
            }
        }
    }
}

@Composable
private fun InfoSection() {
    Column(modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(
            text = "Priyam.P",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primary
        )
        Text(text = "Android Developer", modifier = Modifier.padding(4.dp))
        Text(
            modifier = Modifier.padding(4.dp),
            text = "paul.demon2204@gmail.com",
            style = MaterialTheme.typography.subtitle1
        )

    }
}

@Composable
private fun ProfileImage() {
    Surface(
        modifier = Modifier
            .height(100.dp)
            .width(100.dp),
        shape = CircleShape,
        border = BorderStroke(width = 1.dp, color = Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "profile image",
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        CustomCard()
    }
}