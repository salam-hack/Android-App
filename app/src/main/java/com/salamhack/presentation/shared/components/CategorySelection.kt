package com.salamhack.presentation.shared.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.salamhack.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.text.style.TextDirection
import com.salamhack.domain.entity.Category
import com.salamhack.presentation.shared.designSystem.theme.Theme
import com.salamhack.presentation.uiModel.toUi

@Composable
fun CategorySelection(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    selectedCategory: Category?,
    onCategorySelected: (Category) -> Unit,
    isError: Boolean = false,
) {
    var expanded by remember { mutableStateOf(false) }

    val selectedUi = selectedCategory?.toUi()

    val backgroundColor =
        if (selectedCategory == null) Theme.colors.white else Color(0xFFF8FAFC)

    Column(modifier = modifier.fillMaxWidth()) {

        Text(
            text = "فئة المعاملة",
            modifier = Modifier.fillMaxWidth(),
            style = Theme.textStyle.title.sub.copy(
                color = Color(0xFF314158)
            ),
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(backgroundColor)
                .border(
                    1.dp,
                    if (isError) Color(0xFFFFA2A2) else Color(0xFFF1F5F9),
                    RoundedCornerShape(12.dp)
                )
                .clickable { expanded = true }
                .padding(horizontal = 12.dp, vertical = 10.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.Gray
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = selectedCategory?.name ?: "اختر التصنيف...",
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    style = Theme.textStyle.title.sub.copy(
                        color = if (selectedCategory == null)
                            Color(0xFF90A1B9)
                        else
                            Color(0xFF1D293D),
                        textDirection = TextDirection.Rtl
                    )
                )

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            color = selectedUi?.iconBackgroundColor ?: Color(0xFFF4F6F9),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    if (selectedUi != null) {
                        Icon(
                            painter = painterResource(selectedUi.icon),
                            contentDescription = null,
                            tint = selectedUi.iconColor
                        )
                    } else {
                        Icon(
                            painter = painterResource(R.drawable.ic_category),
                            contentDescription = null,
                            tint = Color(0xFF90A1B9)
                        )
                    }
                }
            }

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth(0.9f)
            ) {

                categories.forEach { category ->

                    val ui = category.toUi()

                    DropdownMenuItem(
                        text = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Text(
                                    text = category.name,
                                    style = Theme.textStyle.title.sub.copy(
                                        color = Color(0xFF0F3A70),
                                    ),
                                )

                                Spacer(modifier = Modifier.width(16.dp))

                                Box(
                                    modifier = Modifier
                                        .size(40.dp)
                                        .background(
                                            color = ui.iconBackgroundColor,
                                            shape = RoundedCornerShape(12.dp)
                                        ),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        painter = painterResource(ui.icon),
                                        contentDescription = null,
                                        tint = ui.iconColor
                                    )
                                }
                            }
                        },
                        onClick = {
                            onCategorySelected(category)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {

    val categories = listOf(
        Category("EXP_FOOD", "طعام"),
        Category("EXP_TRANSPORT", "نقل"),
        Category("EXP_ENTERTAINMENT", "ترفيه"),
    )

    var selected by remember { mutableStateOf<Category?>(null) }

    CategorySelection(
        categories = categories,
        selectedCategory = selected,
        onCategorySelected = { selected = it }
    )
}