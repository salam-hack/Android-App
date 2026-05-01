package com.salamhack.presentation.shared.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.text.style.TextDirection
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme


@Composable
fun GoalIconSelector(
    title: String,
    icons: List<GoalIcon>,
    selectedIconId: String?,
    onIconSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = title,
            style = Theme.textStyle.title.sub.copy(
                color = Color(0xFF314158),
                textDirection = TextDirection.Rtl,
            ),
            modifier = Modifier.padding(end = 16.dp)
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            reverseLayout = true
        ) {
            items(icons) { icon ->
                SelectableIconItem(
                    icon = icon,
                    isSelected = icon.id == selectedIconId,
                    onClick = { onIconSelected(icon.id) }
                )
            }
        }
    }
}

@Composable
fun SelectableIconItem(
    icon: GoalIcon,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val unselectedBgColor = Color(0xFFF8FAFC)
    val unselectedBorderColor = Color(0xFFE2E8F0)
    val unselectedIconColor = Color(0xFF94A3B8)

    val selectedBgColor = icon.color.copy(alpha = 0.1f)
    val selectedBorderColor = icon.color
    val selectedIconColor = icon.color

    val backgroundColor = if (isSelected) selectedBgColor else unselectedBgColor
    val borderColor = if (isSelected) selectedBorderColor else unselectedBorderColor
    val iconColor = if (isSelected) selectedIconColor else unselectedIconColor

    Box(
        modifier = modifier
            .size(56.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .border(
                border = BorderStroke(if (isSelected) 2.dp else 1.dp, borderColor),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon.iconRes),
            contentDescription = icon.contentDescription,
            tint = iconColor,
            modifier = Modifier.size(24.dp)
        )
    }
}

data class GoalIcon(
    val id: String,
    @DrawableRes val iconRes: Int,
    val color: Color,
    val contentDescription: String? = null
)

data class GoalSelectionUiState(
    val availableIcons: List<GoalIcon> = emptyList(),
    val selectedIconId: String? = null
)

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    name = "Goal Icon Selector (Arabic RTL)",
)
@Composable
fun GoalIconSelectorPreview() {
    val mockIcons = listOf(
        GoalIcon("car", R.drawable.ic_car, Color(0xFFB89020)),
        GoalIcon("home", R.drawable.ic_home, Color(0xFF45556C)),
        GoalIcon("laptop", R.drawable.ic_laptop, Theme.colors.bluePrimary),
        GoalIcon("plane", R.drawable.ic_travel, Color(0xFF2B7FFF)),
        GoalIcon("diamond", R.drawable.ic_diamond, Theme.colors.lightGreen),
        GoalIcon("education", R.drawable.ic_edu, Color(0xFF9810FA))
    )

    var selectedId by remember { mutableStateOf("car") }

    Surface(
        modifier = Modifier.padding(16.dp),
        color = Color.White
    ) {
        GoalIconSelector(
            title = "اختر أيقونة للهدف",
            icons = mockIcons,
            selectedIconId = selectedId,
            onIconSelected = { selectedId = it }
        )
    }
}