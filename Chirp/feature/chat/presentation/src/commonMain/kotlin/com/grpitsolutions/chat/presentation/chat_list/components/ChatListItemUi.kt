package com.grpitsolutions.chat.presentation.chat_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import chirp.feature.chat.presentation.generated.resources.Res
import chirp.feature.chat.presentation.generated.resources.group_chat
import com.grpitsolutions.chat.domain.models.ChatMessage
import com.grpitsolutions.chat.presentation.model.ChatUi
import com.grpitsolutions.core.designsystem.components.avatar.ChatParticipantUi
import com.grpitsolutions.core.designsystem.components.avatar.ChirpStackedAvatars
import com.grpitsolutions.core.designsystem.theme.ChirpTheme
import com.grpitsolutions.core.designsystem.theme.extended
import com.grpitsolutions.core.designsystem.theme.titleXSmall
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.time.Clock

@Composable
fun ChatListItemUI(
    chat: ChatUi,
    isSelected: Boolean,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .height(intrinsicSize = IntrinsicSize.Min)
            .background(
                color = if (isSelected){
                    MaterialTheme.colorScheme.surface
                } else {
                    MaterialTheme.colorScheme.extended.surfaceLower
                }
            )
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ChirpStackedAvatars(
                    avatars = chat.otherParticipants
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = if (chat.otherParticipants.size == 1){
                            chat.otherParticipants.first().username
                        } else {
                            stringResource(Res.string.group_chat )
                        },
                        style = MaterialTheme.typography.titleXSmall,
                        color = MaterialTheme.colorScheme.extended.textPrimary,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier.fillMaxWidth()
                    )
                    if (chat.otherParticipants.size > 1){
                        val formattedUsernames = remember(chat.otherParticipants) {
                            (listOf(chat.localParticipant) + chat.otherParticipants).joinToString{
                                it.username
                            }
                        }
                        Text(
                            text = formattedUsernames,
                            color = MaterialTheme.colorScheme.extended.textPlaceholder,
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

            }
            if (chat.lastMessage != null){
                val previewMessage = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.extended.textSecondary
                        )
                    ){
                        append(chat.lastMessageSenderUsername + ":")
                    }
                    append(chat.lastMessage.content)
                }
                Text(
                    text = previewMessage,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.extended.textSecondary,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                 
                )
            }
        }
        Box(
            modifier = Modifier
                .alpha(if (isSelected) 1f else 0f)
                .background(
                    color = MaterialTheme.colorScheme.primary
                )
                .width(4.dp)
                .fillMaxHeight()
        )
    }
}


@Composable
@Preview
private fun ChatListItemUILightModePreview() {
    ChirpTheme {
        ChatListItemUI(
            isSelected = true,
            chat = ChatUi(
                id = "1",
                localParticipant = ChatParticipantUi(
                    id = "1",
                    username = "Banza",
                    initials = "bz"
                ),
                otherParticipants = listOf(
                    ChatParticipantUi(
                        id = "2",
                        username = "Michelle",
                        initials = "mi"
                    ),
                    ChatParticipantUi(
                        id = "3",
                        username = "Lucas",
                        initials = "lc"
                    )
                ),
                lastMessage = ChatMessage(
                    id = "1",
                    chatId = "1",
                    senderId = "2",
                    content = "Gente meu modelo de previsao funciona! vou beneficiar muito futuros trabalhos! ",
                    createAt = Clock.System.now()
                ),
                lastMessageSenderUsername = "Michelle"
            )
        )
    }
}

@Composable
@Preview
private fun ChatListItemUIDarkThemePreview() {
    ChirpTheme(darkTheme = true) {
        ChatListItemUI(
            isSelected = true,
            chat = ChatUi(
                id = "1",
                localParticipant = ChatParticipantUi(
                    id = "1",
                    username = "Banza",
                    initials = "bz"
                ),
                otherParticipants = listOf(
                    ChatParticipantUi(
                        id = "2",
                        username = "Michelle",
                        initials = "mi"
                    ),
                    ChatParticipantUi(
                        id = "3",
                        username = "Lucas",
                        initials = "lc"
                    )
                ),
                lastMessage = ChatMessage(
                    id = "1",
                    chatId = "1",
                    senderId = "2",
                    content = "Gente meu modelo de previsao funciona! vou beneficiar muito futuros trabalhos! ",
                    createAt = Clock.System.now()
                ),
                lastMessageSenderUsername = "Michelle"
            )
        )
    }
}

@Composable
@Preview
private fun ChatListItemUIDarkThemeNotSelectedOneParticipantPreview() {
    ChirpTheme(darkTheme = true) {
        ChatListItemUI(
            isSelected = false,
            chat = ChatUi(
                id = "1",
                localParticipant = ChatParticipantUi(
                    id = "1",
                    username = "Banza",
                    initials = "bz"
                ),
                otherParticipants = listOf(
                    ChatParticipantUi(
                        id = "2",
                        username = "Michelle",
                        initials = "mi"
                    ),
                ),
                lastMessage = ChatMessage(
                    id = "1",
                    chatId = "1",
                    senderId = "2",
                    content = "Gente meu modelo de previsao funciona! vou beneficiar muito futuros trabalhos! ",
                    createAt = Clock.System.now()
                ),
                lastMessageSenderUsername = "Michelle"
            )
        )
    }
}