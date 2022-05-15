package st.slex.feature_auth.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AuthScreen(
    modifier: Modifier = Modifier
) {
    val phoneNumber = remember { mutableStateOf("+7") }
    val isError = remember { mutableStateOf(false) }
    val phoneSize = remember {
        mutableStateOf(12)
    }
    phoneSize.value =
        if (phoneNumber.value.isNotEmpty() && phoneNumber.value.first() == '+') 12 else 11
    Box(modifier = modifier.fillMaxSize()) {
        PhoneNumberField(
            phoneNumber = phoneNumber,
            isError = isError,
            phoneSize = phoneSize
        )
        FloatingActionButton(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomEnd)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Bottom)
                ),
            onClick = {
                if (phoneNumber.value.length != phoneSize.value) {
                    isError.value = true
                }
            },
            content = {
                Icon(Icons.Default.NavigateNext, contentDescription = "next")
            }
        )
    }
}