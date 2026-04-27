package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.textStyle.ibm
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit = {},
    placeholder: String = "الصق النص أو الرابط هنا...",
    title: String
){
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    var isFocused by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontFamily = ibm,
                fontSize = 14.sp,
                color = Theme.colors.bluePrimary,
                fontWeight = FontWeight.Medium,
                textDirection = TextDirection.Rtl
            ),
            modifier = Modifier
                .align(Alignment.End)
        )

        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 1.dp,
                    shape = RoundedCornerShape(16.dp),
                    clip = false,
                    ambientColor = Color.Black.copy(alpha = 0.05f),
                    spotColor = Color.Black.copy(alpha = 0.05f)
                )
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .border(
                    width = if (isFocused) 1.5.dp else 1.dp,
                    color = if (isFocused) Color(0xFF1976D2) else Color(0xFFE0E0E0),
                    shape = RoundedCornerShape(16.dp)
                )
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
        ) {
            BasicTextField(
                value = textFieldValue,
                onValueChange = { newValue ->
                    textFieldValue = newValue
                    onTextChange(newValue.text)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 14.sp,
                    color = Color(0xFF1A1A1A),
                    lineHeight = 20.sp,
                    fontFamily = FontFamily.Default
                ),
                cursorBrush = SolidColor(Color(0xFF1976D2)),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        if (textFieldValue.text.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = TextStyle(
                                    fontFamily = ibm,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    color = Color(0xFF9E9E9E),
                                    lineHeight = 20.sp,
                                    textDirection = TextDirection.Rtl
                                ),
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                            )
                        }
                        innerTextField()
                    }
                }
            )
        }
    }
}

@Composable
fun AppPhoneTextField(
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit = {},
    placeholder: String = "1069144823",
    title: String
){
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    var isFocused by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontFamily = ibm,
                fontSize = 14.sp,
                color = Theme.colors.bluePrimary,
                fontWeight = FontWeight.Medium,
                textDirection = TextDirection.Rtl
            ),
            modifier = Modifier
                .align(Alignment.End)
        )

        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 1.dp,
                    shape = RoundedCornerShape(16.dp),
                    clip = false,
                    ambientColor = Color.Black.copy(alpha = 0.05f),
                    spotColor = Color.Black.copy(alpha = 0.05f)
                )
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .border(
                    width = if (isFocused) 1.5.dp else 1.dp,
                    color = if (isFocused) Color(0xFF1976D2) else Color(0xFFE0E0E0),
                    shape = RoundedCornerShape(16.dp)
                )
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(11.dp)
            ) {
                Box(
                    modifier = Modifier
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_down_arrow),
                            contentDescription = "كود الدولة مصر",
                            tint = Theme.colors.graySubTitles,
                        )
                        Text(
                            text = "+ 20",
                            style = Theme.textStyle.title.regular.copy(
                                color = Theme.colors.dark
                            )
                        )
                    }
                }

                // text field
                BasicTextField(
                    value = textFieldValue,
                    onValueChange = { newValue ->
                        textFieldValue = newValue
                        onTextChange(newValue.text)
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    textStyle = LocalTextStyle.current.copy(
                        fontSize = 14.sp,
                        color = Color(0xFF1A1A1A),
                        lineHeight = 20.sp,
                        fontFamily = FontFamily.Default
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    cursorBrush = SolidColor(Color(0xFF1976D2)),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            if (textFieldValue.text.isEmpty()) {
                                Text(
                                    text = placeholder,
                                    style = TextStyle(
                                        fontFamily = ibm,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 16.sp,
                                        color = Color(0xFF9E9E9E),
                                        lineHeight = 20.sp,
                                        textDirection = TextDirection.Rtl
                                    ),
                                    modifier = Modifier
                                        .align(Alignment.TopStart)
                                )
                            }
                            innerTextField()
                        }
                    }
                )
            }
        }
    }
}

private fun hasMinLength(password: String, min: Int = 8): Boolean =
    password.length >= min

private fun hasUppercase(password: String): Boolean =
    password.any { it.isUpperCase() }

private fun hasLowercase(password: String): Boolean =
    password.any { it.isLowerCase() }

@Composable
fun AppPasswordTextField(
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit = {},
    placeholder: String = "A123456a",
    title: String,
    showRequirements: Boolean = true,
) {
    var passwordVisible by remember { mutableStateOf(false) }
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    var isFocused by remember { mutableStateOf(false) }

    val password = textFieldValue.text
    val reqMinLen = hasMinLength(password, 8)
    val reqUpper = hasUppercase(password)
    val reqLower = hasLowercase(password)
    val showReqNow = showRequirements && password.isNotBlank()


    Column(modifier = modifier) {
        Text(
            text = title,
            style = TextStyle(
                fontFamily = ibm,
                fontSize = 14.sp,
                color = Theme.colors.bluePrimary,
                fontWeight = FontWeight.Medium,
                textDirection = TextDirection.Rtl
            ),
            modifier = Modifier.align(Alignment.End)
        )

        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 1.dp,
                    shape = RoundedCornerShape(16.dp),
                    clip = false,
                    ambientColor = Color.Black.copy(alpha = 0.05f),
                    spotColor = Color.Black.copy(alpha = 0.05f)
                )
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .border(
                    width = if (isFocused) 1.5.dp else 1.dp,
                    color = if (isFocused) Color(0xFF1976D2) else Color(0xFFE0E0E0),
                    shape = RoundedCornerShape(16.dp)
                )
                .onFocusChanged { focusState -> isFocused = focusState.isFocused }
        ) {
            val icon =
                if (passwordVisible) R.drawable.ic_password_opened
                else R.drawable.ic_password_closed

            BasicTextField(
                value = textFieldValue,
                onValueChange = { newValue ->
                    textFieldValue = newValue
                    onTextChange(newValue.text)
                },
                visualTransformation = if (!passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
                modifier = Modifier.fillMaxWidth(),
                textStyle = Theme.textStyle.title.regular.copy(
                    color = Theme.colors.dark,
                    textDirection = TextDirection.Rtl
                ),
                cursorBrush = SolidColor(Color(0xFF1976D2)),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterStart)
                            .fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(icon),
                            contentDescription = if (passwordVisible) "كلمة السر مرئية الأن" else "كلمة السر مخفية الأن",
                            tint = Theme.colors.grayNonActive,
                            modifier = Modifier
                                .clickable { passwordVisible = !passwordVisible }
                                .align(Alignment.CenterStart)
                        )

                        if (textFieldValue.text.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = TextStyle(
                                    fontFamily = ibm,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    color = Color(0xFF9E9E9E),
                                    lineHeight = 20.sp,
                                    textDirection = TextDirection.Rtl
                                ),
                                modifier = Modifier.align(Alignment.CenterEnd)
                            )
                        }

                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            innerTextField()
                        }
                    }
                }
            )
        }

        if (showReqNow) {
            Column(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                PasswordRequirement(
                    message = "8 أحرف على الأقل",
                    isTrue = reqMinLen,
                    modifier = Modifier.align(Alignment.End)
                )
                PasswordRequirement(
                    message = "حرف كبير واحد على الأقل",
                    isTrue = reqUpper,
                    modifier = Modifier.align(Alignment.End)
                )
                PasswordRequirement(
                    message = "حرف صغير واحد على الأقل",
                    isTrue = reqLower,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}

@Composable
fun AppNameTextField(
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit = {},
    placeholder: String = "A123456a",
    title: String
){
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    var isFocused by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontFamily = ibm,
                fontSize = 14.sp,
                color = Theme.colors.bluePrimary,
                fontWeight = FontWeight.Medium,
                textDirection = TextDirection.Rtl
            ),
            modifier = Modifier
                .align(Alignment.End)
        )

        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .shadow(
                    elevation = 1.dp,
                    shape = RoundedCornerShape(16.dp),
                    clip = false,
                    ambientColor = Color.Black.copy(alpha = 0.05f),
                    spotColor = Color.Black.copy(alpha = 0.05f)
                )
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .border(
                    width = if (isFocused) 1.5.dp else 1.dp,
                    color = if (isFocused) Color(0xFF1976D2) else Color(0xFFE0E0E0),
                    shape = RoundedCornerShape(16.dp)
                )
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
        ) {

            BasicTextField(
                value = textFieldValue,
                onValueChange = { newValue ->
                    textFieldValue = newValue
                    onTextChange(newValue.text)
                },
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = Theme.textStyle.title.regular.copy(
                    color = Theme.colors.dark,
                    textDirection = TextDirection.Rtl
                ),
                cursorBrush = SolidColor(Color(0xFF1976D2)),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterStart)
                            .fillMaxWidth()
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_user),
                            contentDescription = "أدخل اسم المستخدم هنا",
                            tint = Theme.colors.grayNonActive,
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                        )
                        if (textFieldValue.text.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = TextStyle(
                                    fontFamily = ibm,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    color = Color(0xFF9E9E9E),
                                    lineHeight = 20.sp,
                                    textDirection = TextDirection.Rtl
                                ),
                                modifier = Modifier
                                    .align(Alignment.CenterEnd)
                            )
                        }
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            innerTextField()
                        }
                    }
                }
            )
        }
    }
}


@Composable
fun PasswordRequirement(
    message: String,
    modifier: Modifier = Modifier,
    isTrue: Boolean = false,
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = message,
            style = Theme.textStyle.title.sub.copy(
                color = if (isTrue) Theme.colors.lightGreen else Theme.colors.redWarning,
                textDirection = TextDirection.Rtl
            )
        )
        Icon(
            painter = painterResource(id = if (isTrue) R.drawable.ic_check_true else R.drawable.ic_check_false),
            contentDescription = null,
            tint = if (isTrue) Theme.colors.lightGreen else Theme.colors.redWarning,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        AppPhoneTextField(
            title = "رقم الهاتف",
            placeholder = "1069144823",
        )

        AppPasswordTextField(
            title = "كلمة المرور",
            placeholder = "A123456a",
        )

        AppNameTextField(
            title = "اسم المستخدم",
            placeholder = "أدخل اسم المستخدم",
        )
    }
}

