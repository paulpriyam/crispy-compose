package com.example.compose.day4

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.compose.R
import com.example.compose.day567.model.MovieData
import com.example.compose.day567.model.getMovieList
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
    val data = getMovieList()
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


@Composable
fun PortfolioInfo(
    data: List<MovieData> = getMovieList()
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
fun PortfolioListView(data: List<MovieData>, onItemClicked: (MovieData) -> Unit = {}) {
    LazyColumn() {
        items(data) { item ->
            MovieCard(item) {
                onItemClicked.invoke(it)
            }
        }
    }
}


@Composable
private fun MovieCard(
    item: MovieData= getMovieList().first(),
    onItemClicked: (MovieData) -> Unit = {},
) {
    val expanded = remember {
        mutableStateOf<Boolean>(false)
    }

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
                .padding(vertical = 4.dp, horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(data = item.image) {
                    crossfade(true)
                    transformations(CircleCropTransformation())
                },
                contentDescription = "portfolio image",
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.DarkGray,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append(item.name)
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.LightGray,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        )
                    ) {
                        append("(" + item.year + ")")
                    }
                })
                Text(buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Yellow,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    ) {
                        append("IMDb Rating  ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.LightGray,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        )
                    ) {
                        append(item.imdb + "/10")
                    }
                })
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Spacer(modifier = Modifier.height(8.dp))
                Text(buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.DarkGray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    ) {
                        append("Director: ")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color.DarkGray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        )
                    ) {
                        append(item.director)
                    }
                })
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Actors",
                        style = TextStyle(
                            color = Color.DarkGray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    )
                    LazyRow(modifier = Modifier.padding(horizontal = 8.dp)) {
                        items(item.actors) {
                            Card(
                                shape = RoundedCornerShape(corner = CornerSize(size = 4.dp)),
                                border = BorderStroke(width = 1.dp, color = Color.DarkGray),
                                elevation = 4.dp,
                                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                            ) {
                                Text(text = it, modifier = Modifier.padding(4.dp))
                            }
                        }
                    }
                }
                if (expanded.value) {
                    Text(text = item.summary, style = MaterialTheme.typography.body2)
                }
                Icon(
                    imageVector = if (expanded.value) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "arrow down",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            expanded.value = !expanded.value
                        }
                )
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

@Composable
fun DefaultPreview() {
    ComposeTheme {
        CustomCard()
    }
}