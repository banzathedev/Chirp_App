package com.grpitsolutions.chat.presentation.chat_list_detail

import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.grpitsolutions.core.designsystem.theme.ChirpTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ChaListAdaptiveLayout(
    modifier: Modifier = Modifier,
    chatListDetailViewModel: CharListDetailViewModel = koinViewModel()
) {
    ListDetailPaneScaffold(
        
    )
}

@Composable
@Preview
fun ChaListAdaptiveLayoutPreview() {
  ChirpTheme {
        ChaListAdaptiveLayout()
    }
}