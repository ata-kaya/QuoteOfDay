package com.atakaya.quoteofday.presentation.ui.screens.common.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.atakaya.quoteofday.presentation.ui.models.QuoteModel

fun interface QuoteCardButtonClickListener {
    fun onClick(buttonType: ButtonType)
}

enum class ButtonType {
    Favorite, Share
}

@Composable
fun QuoteCard(
    modifier: Modifier,
    quote: QuoteModel,
    quoteCardButtonClickListener: QuoteCardButtonClickListener,
) {
    Box(
        modifier = modifier
            .background(Color.Unspecified)
            .fillMaxWidth()
            .padding(vertical = 40.dp)
            .graphicsLayer(rotationZ = -3f)
            .padding(32.dp)
            .border(
                width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = Color(0xFFD3D3D3), shape = RoundedCornerShape(
                    10.dp
                )
            )
    ) {
        Box(
            modifier = Modifier
                .graphicsLayer(rotationZ = 3f)
                .fillMaxSize()
                .border(
                    width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp)
                )
                .background(
                    color = Color(0xFFD3D3D3), shape = RoundedCornerShape(10.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer(rotationZ = 0f)
                    .padding(30.dp)
                    .background(Color.Unspecified)
            ) {
                Column {
                    Text(
                        text = "“",
                        fontSize = 60.sp,
                        modifier = Modifier
                            .background(Color.Unspecified)
                            .height(40.dp)
                    )

                    Text(
                        style = TextStyle(
                            fontStyle = FontStyle.Italic
                        ),
                        text = quote.quote ?: "",
                        fontSize = 20.sp,
                        maxLines = 5,
                        textAlign = TextAlign.Start,

                        modifier = Modifier

                    )
                    Text(
                        text = "”",
                        fontSize = 60.sp,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Unspecified)
                            .height(30.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Unspecified)
                        .padding(bottom = 16.dp)
                        .align(Alignment.BottomEnd),
                ) {
                    ShareButton(modifier = Modifier.background(Color.Unspecified)) {
                        Log.d("atakaya", "share clicked")
                        quoteCardButtonClickListener.onClick(ButtonType.Share)
                    }
                    FavButton(
                        isFavorite = quote.isFavorite,
                        modifier = Modifier.background(Color.Unspecified),
                    ) {
                        Log.d("atakaya", "fav clicked ${quote.isFavorite}")
                        quoteCardButtonClickListener.onClick(ButtonType.Favorite)
                    }

                    Text(
                        style = TextStyle(
                            fontWeight = FontWeight.W600
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp)
                            .background(Color.Unspecified),
                        text = quote.author ?: "",
                        textAlign = TextAlign.End
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun QuoteCardPreview() {
    QuoteCard(
        modifier = Modifier, quote = QuoteModel(
            quote = "omid zmani", author = "atakaya"
        )
    ) {

    }
}
