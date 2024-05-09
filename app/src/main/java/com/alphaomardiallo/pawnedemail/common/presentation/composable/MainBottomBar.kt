package com.alphaomardiallo.pawnedemail.common.presentation.composable

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.alphaomardiallo.pawnedemail.common.presentation.mainactivity.destination.BottomNavDestination

@Composable
fun MainBottomBar(
    modifier: Modifier = Modifier,
    isNavigationBarVisible: Boolean,
    items: List<BottomNavDestination>,
    currentRoute: String,
    selectedItemIndex: Int,
    onSelectedItemChange: (Int) -> Unit,
    onItemClick: (String) -> Unit,
) {
    if (isNavigationBarVisible) {
        NavigationBar(
            modifier = modifier,
        ) {
            items.forEachIndexed { index, destination ->
                if (destination.route == currentRoute) {
                    onSelectedItemChange(index)
                }

                NavigationBarItem(
                    alwaysShowLabel = true,
                    icon = {
                        Icon(
                            imageVector = destination.icon,
                            contentDescription = stringResource(id = destination.resId)
                        )
                    },
                    label = { Text(text = stringResource(id = destination.resId)) },
                    selected = selectedItemIndex == index,
                    onClick = {
                        onSelectedItemChange(index)
                        onItemClick(destination.route)
                    }
                )
            }
        }
    }
}
