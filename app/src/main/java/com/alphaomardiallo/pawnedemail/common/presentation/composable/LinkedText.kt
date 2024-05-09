package com.alphaomardiallo.pawnedemail.common.presentation.composable

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun LinkedText(
    link: String,
    context: Context,
) {
    Text(
        text = link,
        textDecoration = TextDecoration.Underline,
        color = Color.Blue,
        modifier = Modifier.clickable {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://$link")
            )
            context.startActivity(intent)
        }
    )
}