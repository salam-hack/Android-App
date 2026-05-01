package com.salamhack.presentation.shared.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.presentation.shared.designSystem.theme.Theme

enum class PriorityLevel(val title: String, val color: Color) {
    LOW("منخفضة", Color(0xFF10B981)),
    MEDIUM("متوسطة", Color(0xFFF59E0B)),
    HIGH("عالية", Color(0xFFE63946)),
}

@Composable
fun PrioritySelector(
    modifier: Modifier = Modifier,
    title: String = "مستوى الأولوية",
    selectedPriority: PriorityLevel?,
    onPrioritySelected: (PriorityLevel) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            color = Color(0xFF314158),
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(end = 4.dp),
            style = androidx.compose.ui.text.TextStyle(textDirection = TextDirection.Rtl)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {

            val priorities = PriorityLevel.values().toList()

            priorities.forEach { priority ->
                PriorityCard(
                    modifier = Modifier.weight(1f),
                    priority = priority,
                    isSelected = priority == selectedPriority,
                    onClick = { onPrioritySelected(priority) }
                )
            }
        }
    }
}

@Composable
fun PriorityCard(
    priority: PriorityLevel,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val unselectedBgColor = Color(0xFFF8FAFC)
    val unselectedBorderColor = Color(0xFFE2E8F0)
    val unselectedTextColor = Color(0xFF475569)

    val selectedBgColor = priority.color.copy(alpha = 0.1f)
    val selectedBorderColor = priority.color
    val selectedTextColor = priority.color

    val backgroundColor = if (isSelected) selectedBgColor else unselectedBgColor
    val borderColor = if (isSelected) selectedBorderColor else unselectedBorderColor
    val textColor = if (isSelected) selectedTextColor else unselectedTextColor

    Box(
        modifier = modifier
            .height(74.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .border(
                border = BorderStroke(if (isSelected) 1.5.dp else 1.dp, borderColor),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(priority.color)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = priority.title,
                style = Theme.textStyle.title.sub.copy(
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = textColor

                ),
            )
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    name = "Priority Selector Component"
)
@Composable
fun PrioritySelectorPreview() {
    Surface(
        modifier = Modifier.padding(16.dp),
        color = Color.White
    ) {
        PrioritySelector(
            selectedPriority = PriorityLevel.HIGH,
            onPrioritySelected = {}
        )
    }
}