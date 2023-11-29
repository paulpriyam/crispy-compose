package com.example.compose.day8

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.day4.PortfolioListView
import com.example.compose.day567.model.PortfolioData
import com.example.compose.ui.theme.ComposeTheme

class MovieActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    ComposeTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()

        }
    }
}

@Preview
@Composable
fun MainContent() {
    Scaffold(modifier = Modifier,
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.8f),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Movie Screen",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(color = Color.White, fontSize = 20.sp)
                )
            }
        }) {  paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            PortfolioListView(
                listOf<PortfolioData>(
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
                    PortfolioData(
                        project = "iOS Project",
                        description = "Sample iOS Project"
                    ),
                    PortfolioData(
                        project = "iOS Project",
                        description = "Sample iOS Project"
                    ),
                    PortfolioData(
                        project = "iOS Project",
                        description = "Sample iOS Project"
                    ),
                )
            ){item->
                Log.d("TAG", "MainContent: itemCLicked $item")
            }
        }
    }
}