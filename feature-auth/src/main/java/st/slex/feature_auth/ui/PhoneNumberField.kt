package st.slex.feature_auth.ui

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun BoxScope.PhoneNumberField(
    modifier: Modifier = Modifier,
    phoneNumber: MutableState<String>,
    isError: MutableState<Boolean>,
    phoneSize: MutableState<Int>
) {
    val enabled = remember { mutableStateOf(true) }
    OutlinedTextField(
        modifier = modifier
            .align(Alignment.Center)
            .padding(16.dp),
        value = phoneNumber.value,
        singleLine = true,
        enabled = enabled.value,
        isError = isError.value,
        textStyle = MaterialTheme.typography.headlineMedium,
        label = { Text(text = "Phone number") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        leadingIcon = {
            Icon(imageVector = Icons.Filled.Phone, contentDescription = "Phone icon")
        },
        trailingIcon = {
            IconButton(
                modifier = Modifier.padding(4.dp),
                onClick = {
                    phoneNumber.value = ""
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    contentDescription = "clear all"
                )
            }
        },
        onValueChange = {
            if (it.length < phoneSize.value.plus(1)) {
                phoneNumber.value = it
            }
            isError.value = false
        })
}