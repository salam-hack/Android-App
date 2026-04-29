package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun SearchTextField(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String = "ابحث في المحادثات السابقة..."
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.CenterEnd
        ) {
            if (query.isEmpty()) {
                Text(
                    text = hint,
                    style = Theme.textStyle.title.sub.copy(
                        color = Color(0xFF90A1B9),
                        textDirection = TextDirection.Rtl
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }

            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = Modifier.fillMaxWidth(),
                textStyle = Theme.textStyle.title.sub.copy(
                    color = Theme.colors.dark,
                    textDirection = TextDirection.Rtl
                ),
                singleLine = true
            )
        }

        Icon(
            painter = painterResource(R.drawable.ic_search),
            contentDescription = "بحث",
            tint = Color(0xFF90A1B9),
            modifier = Modifier
                .size(26.dp)
        )
    }
}

@Preview
@Composable
private fun Preview(){
    var query by remember { mutableStateOf("") }
    SearchTextField(
        query = query,
        onQueryChange = { query = it }
    )
}