package com.example.compose.day567.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val ButtonSizeModifier = Modifier.size(40.dp)

@Composable
fun RoundedIconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    tint: Color = Color.Black.copy(alpha = 0.8f),
    backgroundColor: Color = MaterialTheme.colors.background,
    onClickListener: () -> Unit,
    elevation: Dp = 4.dp
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .clickable { onClickListener.invoke() }
            .then(
                ButtonSizeModifier
            ),
        elevation = elevation,
        backgroundColor = backgroundColor,
        shape = CircleShape
    ) {
        Icon(imageVector = icon, contentDescription = "icon button", tint = tint)
    }
}