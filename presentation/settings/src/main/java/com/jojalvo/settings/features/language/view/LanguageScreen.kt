package com.jojalvo.settings.features.language.view

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jojalvo.component.widget.MCToolbarWithNavIcon
import com.jojalvo.framework.base.jetpack.SetLanguage
import com.jojalvo.framework.base.jetpack.singleClick
import com.jojalvo.provider.NavigationProvider
import com.jojalvo.settings.features.language.viewmodel.LanguageViewModel
import com.jojalvo.theme.*
import com.jojalvo.theme.R
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.launch

/**
 *   @author jojalvo
 *   @since 23/4/23
 *   @email josealejandro025@gmail.com
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun LanguageScreen(
    viewModel: LanguageViewModel = hiltViewModel(),
    navigator: NavigationProvider
) {
    var langs by remember { viewModel.langs }
    val scope = rememberCoroutineScope()

    SetLanguage(languageCode = langs.find { it.isSelected }?.code.toString())
    Scaffold(
        backgroundColor = MobileChallengeColors.background,
        topBar = {
            MCToolbarWithNavIcon(
                R.string.settings_app_language,
                pressOnBack = {
                    navigator.navigateUp()
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
                .background(MobileChallengeColors.background)
        ) {
            items(items = langs) { lang ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(MobileChallengeColors.surface)
                        .singleClick {
                            scope.launch {
                                viewModel.saveLanguage(lang.code)
                            }
                            langs = langs.map { dto ->
                                if (lang.id == dto.id) {
                                    dto.copy(isSelected = true)
                                } else {
                                    dto.copy(isSelected = false)
                                }
                            }
                        }
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = lang.name,
                        style = MobileChallengeTypography.titleMedium
                    )
                    AnimatedVisibility(lang.isSelected) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Selected",
                            tint = GreenCircle,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}