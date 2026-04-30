package com.salamhack.presentation.screen.chatBot

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.salamhack.R
import com.salamhack.presentation.shared.components.BotAvatar
import com.salamhack.presentation.shared.components.ChatTextField
import com.salamhack.presentation.shared.components.SuggestionBox
import com.salamhack.presentation.shared.designSystem.theme.Theme
import org.koin.androidx.compose.koinViewModel
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import com.salamhack.presentation.shared.components.ReceivedMessageHolder
import com.salamhack.presentation.shared.components.SenderMessageHolder
import com.salamhack.presentation.shared.components.TypingIndicatorHolder

@Composable
fun ChatBotScreen(
    viewModel: ChatBotViewModel = koinViewModel()
) {
    val state by viewModel.screenState.collectAsStateWithLifecycle()
    ChatBotScreenContent(
        action = viewModel,
        state = state
    )
}

@Composable
fun ChatBotScreenContent(
    modifier: Modifier = Modifier,
    action: ChatBotInteractionListener,
    state: ChatBotUiState
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF6F7FD))
            .statusBarsPadding()
    ){
        val blueSectionSize = if (state.conversationId == null) 166.dp else 130.dp
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(blueSectionSize)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Theme.colors.bluePrimary)
            )
            Image(
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp, vertical = 24.dp)
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .background(Theme.colors.white, shape = RoundedCornerShape(16.dp))
                        .clickable { action.onClickHistory() },
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painterResource(id = R.drawable.ic_history),
                        contentDescription = null,
                        tint = Theme.colors.bluePrimary,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "المساعد الذكي",
                        style = Theme.textStyle.title.regular.copy(
                            fontSize = 18.sp,
                            color = Theme.colors.white,
                            textDirection = TextDirection.Rtl
                        ),
                    )
                    Row(
                        modifier = Modifier.padding(top = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                    ) {
                        Text(
                            text = "متصل الآن",
                            style = Theme.textStyle.title.regular.copy(
                                fontSize = 10.sp,
                                color = Theme.colors.white,
                                textDirection = TextDirection.Rtl
                            ),
                        )
                        Box(
                            modifier = Modifier
                                .background(
                                    color = if (state.isAssistantOnline) Theme.colors.lightGreen else Theme.colors.redWarning,
                                    shape = CircleShape
                                )
                                .size(8.dp)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .size(44.dp)
                        .background(Theme.colors.white, shape = RoundedCornerShape(16.dp))
                        .clickable { action.onClickBack() },
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                        tint = Theme.colors.bluePrimary,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            if (state.conversationId == null) {
                // شاشة البداية
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    BotAvatar()
                    Text(
                        text = "أهلا بك، كيف يمكن لرشيد\nمساعدتك اليوم؟",
                        style = Theme.textStyle.title.regular.copy(
                            fontSize = 24.sp,
                            color = Color(0xFF0F172B),
                            textDirection = TextDirection.Rtl,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(top = 32.dp)
                    )
                    Text(
                        text ="أنا رشيد مساعدك المالي الذكي. يمكنني تحليل مصاريفك،\nتخطيط أهدافك، والإجابة على أي استفسار مالي.",
                        style = Theme.textStyle.title.regular.copy(
                            fontSize = 14.sp,
                            color = Color(0xFF62748E),
                            textDirection = TextDirection.Rtl,
                            textAlign = TextAlign.Center
                        ),
                        modifier = Modifier.padding(top = 12.dp)
                    )

                    Row(
                        Modifier.padding(top = 48.dp),
                        horizontalArrangement = Arrangement.spacedBy(7.dp),
                    ) {
                        SuggestionBox(
                            text = "كيف يمكنني أن أبدأ؟",
                            iconPainter = painterResource(id = R.drawable.ic_category_thin),
                        )
                        SuggestionBox(
                            text = "حلل مصاريفي لهذا الشهر",
                            iconPainter = painterResource(id = R.drawable.ic_vege),
                        )
                    }
                    Row(
                        Modifier
                            .padding(top = 12.dp)
                            .fillMaxWidth()
                            .wrapContentWidth(unbounded = true),
                        horizontalArrangement = Arrangement.spacedBy(7.dp),
                    ) {
                        SuggestionBox(
                            text = "كيف يمكنني توفير 1000 ج.م كل شهر",
                            iconPainter = painterResource(id = R.drawable.ic_service),
                        )
                        SuggestionBox(
                            text = "كيف اصل لهدف الماك بوك اسرع",
                            iconPainter = painterResource(id = R.drawable.ic_book),
                        )
                    }
                }
            } else {
                ChatMessagesList(
                    state = state,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            HorizontalDivider(
                thickness = 1.dp,
                color = Color(0xFFF1F5F9)
            )
            Box(
                modifier = Modifier
                    .background(Theme.colors.white)
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ){
                ChatTextField(
                    modifier = Modifier.align(Alignment.Center),
                    value = state.currentInputText,
                    onValueChange = { input -> action.onChatTextFieldChange(input) },
                    onSendClick = { action.onClickSend(state.currentInputText) },
                    onMicClick = { action.onClickVoice() }
                )
            }
        }
    }
}

@Composable
fun ChatMessagesList(
    state: ChatBotUiState,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()

    LaunchedEffect(key1 = state.messages.size, key2 = state.isAssistantTyping) {
        val totalItems = state.messages.size + if (state.isAssistantTyping) 1 else 0
        if (totalItems > 0) {
            listState.animateScrollToItem(totalItems - 1)
        }
    }



    LazyColumn(
        state = listState,
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        items(
            items = state.messages,
            key = { message -> message.id }
        ) { message ->

            when (message.sender) {
                MessageSender.USER -> {
                    SenderMessageHolder(
                        message = message.text,
                        time = message.time
                    )
                }
                MessageSender.ASSISTANT -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        ReceivedMessageHolder(
                            message = message.text,
                            time = message.time,
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                        )
                    }
                }
            }
        }

        if (state.isAssistantTyping) {
            item(key = "typing_indicator") {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    TypingIndicatorHolder(
                        modifier = Modifier
                            .align(Alignment.CenterEnd)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    ChatBotScreen()
}