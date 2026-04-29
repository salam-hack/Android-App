package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salamhack.presentation.shared.designSystem.theme.Theme
import com.salamhack.R

@Composable
fun ErrorBanner(
    modifier: Modifier = Modifier,
    message: String = "خطأ: يرجى تحديد فئة المعاملة قبل الحفظ"
) {
    // Define the colors based on the image
    val darkRed = Color(0xFFC10007) // For text and icon
    val lightRedBackground = Color(0xFFFEF2F2) // For the fill
    val lightRedBorder = Color(0xFFFFC9C9) // For the stroke/border

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = lightRedBackground,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = lightRedBorder,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {

        Text(
            text = message,
            style = Theme.textStyle.title.sub.copy(
                color = darkRed
            ),
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_error),
            contentDescription = "Error Info",
            tint = darkRed,
            modifier = Modifier
                .padding(start = 12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorBannerPreview() {
    ErrorBanner(
        modifier = Modifier.padding(16.dp)
    )
}