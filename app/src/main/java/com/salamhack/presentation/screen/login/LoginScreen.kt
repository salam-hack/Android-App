package com.salamhack.presentation.screen.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.salamhack.R
import com.salamhack.presentation.shared.components.AppButton
import com.salamhack.presentation.shared.components.AppButtonType
import com.salamhack.presentation.shared.components.AppCheckBox
import com.salamhack.presentation.shared.components.AppPasswordTextField
import com.salamhack.presentation.shared.components.AppPhoneTextField
import com.salamhack.presentation.shared.components.IconHolder
import com.salamhack.presentation.shared.designSystem.textStyle.ibm
import com.salamhack.presentation.shared.designSystem.theme.Theme
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel()
){
    val state by viewModel.screenState.collectAsStateWithLifecycle()
    LoginScreenContent(
        action = viewModel,
        state = state
    )
}

@Composable
fun LoginScreenContent(
    action: LoginInteractionListener,
    state: LoginUiState,
    modifier: Modifier = Modifier,
){
    var rememberMe by remember { mutableStateOf(false) }
    
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(253.dp)
            )
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(253.dp)
                .background(Theme.colors.bluePrimary.copy(alpha = 0.7f))
            )
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 55.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ){
                Column {
                    Text(
                        text = "بوابــــــــــة الأمــــــــــــان",
                        style = TextStyle(
                            fontFamily = ibm,
                            fontSize = 16.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            textDirection = TextDirection.Rtl
                        ),
                        modifier = Modifier.align(Alignment.End)
                    )
                    Text(
                        text = "وصول موثوق وآمن لحساباتك المصرفية.",
                        style = Theme.textStyle.contentOne.copy(
                            color = Theme.colors.blueBackground,
                            textDirection = TextDirection.Rtl
                        ),
                        modifier = Modifier.align(Alignment.End)
                    )
                }
                IconHolder(
                    icon = R.drawable.ic_security,
                    color = Color(0xFFFED65B)
                )
            }
        }

        // body
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topEnd = 32.dp, topStart = 32.dp))
                .background(Color.White)
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp)
                .fillMaxHeight(0.8f)
        ) {
            Text(
                text = "تسجيل الدخول",
                style = Theme.textStyle.header.copy(
                    color = Theme.colors.bluePrimary,
                    fontWeight = FontWeight.SemiBold,
                    textDirection = TextDirection.Rtl
                ),
                modifier = Modifier
                    .padding(top = 32.dp)
                    .align(Alignment.End)
            )
            Text(
                text = "أدخل بيانات الاعتماد الخاصة بك للوصول إلى المحفظة.",
                style = Theme.textStyle.title.sub.copy(
                    color = Color(0xFF44474E),
                    textDirection = TextDirection.Rtl
                ),
                modifier = Modifier
                    .align(Alignment.End)
            )

            AppPhoneTextField(
                title = "رقم الهاتف",
                placeholder = "106  914  4823",
                modifier = Modifier.padding(top = 32.dp)
            )
            AppPasswordTextField(
                title = "كلمة المرور",
                placeholder = "A123456a",
                showRequirements = false,
                modifier = Modifier.padding(top = 24.dp)
            )

            // Remember my data
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "نسيت كلمة المرور؟",
                    style = Theme.textStyle.contentOne.copy(
                        color = Theme.colors.bluePrimary,
                        fontWeight = FontWeight.Medium,
                        textDirection = TextDirection.Rtl
                    ),
                    modifier = Modifier
                        .clickable{
                            action.onClickForgotPassword()
                        }
                )

                Row {
                    Text(
                        text = "تذكر بياناتي",
                        style = Theme.textStyle.contentOne.copy(
                            color = Color(0xFF44474E),
                            fontWeight = FontWeight.Medium,
                            textDirection = TextDirection.Rtl
                        ),
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                    AppCheckBox(
                        isChecked = rememberMe,
                        onCheckedChange = { newValue ->
                            rememberMe = newValue
                        }
                    )
                }
            }

            // Login Button
            AppButton(
                text = "تسجيل دخول",
                type = AppButtonType.Primary,
                modifier = Modifier.padding(top = 24.dp),
                onClick = {
                    action.onClickLogin()
                }
            )

            // Divider
            Row(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .height(2.dp),
                    color = Color(0xFFD3E4FE)
                )
                Text(
                    text = "أو الدخول السريع عبر",
                    style = Theme.textStyle.contentOne.copy(
                        color = Theme.colors.graySubTitles,
                        fontWeight = FontWeight.Medium,
                        textDirection = TextDirection.Rtl
                    ),
                    modifier = Modifier
                        .padding(horizontal = 6.dp)
                )
                HorizontalDivider(
                    modifier = Modifier
                        .weight(1f)
                        .height(2.dp),
                    color = Color(0xFFD3E4FE)
                )
            }

            // Login with system security
            Row(
                modifier = Modifier
                    .padding(top = 14.dp)
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                IconHolder(
                    icon = R.drawable.ic_fingerprint,
                    color = Theme.colors.bluePrimary,
                )
                IconHolder(
                    icon = R.drawable.ic_face_scan,
                    color = Theme.colors.bluePrimary,
                )
            }
            
            // Create Account
            Row(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "حساب جديد",
                    style = Theme.textStyle.title.sub.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = Theme.colors.bluePrimary
                    ),
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .clickable{
                            action.onClickSignUp()
                        }
                )
                Text(
                    text = "ليس لديك حساب؟ ",
                    style = Theme.textStyle.title.sub.copy(
                        color = Theme.colors.graySubTitles
                    ),
                    modifier = Modifier
                )
            }

        }
    }
}

@Preview
@Composable
private fun Preview(){
    LoginScreen()
}