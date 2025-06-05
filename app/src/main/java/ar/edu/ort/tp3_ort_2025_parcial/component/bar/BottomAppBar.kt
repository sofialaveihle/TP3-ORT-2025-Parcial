package ar.edu.ort.tp3_ort_2025_parcial.component.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ar.edu.ort.tp3_ort_2025_parcial.navigation.getBottomBarContent
import ar.edu.ort.tp3_ort_2025_parcial.ui.theme.Gray3
import ar.edu.ort.tp3_ort_2025_parcial.viewmodel.BottomBarViewModel

@Composable
fun BottomAppBar(
    navController: NavController,
    bottomBarViewModel: BottomBarViewModel
){
    val navItems = getBottomBarContent()
    val currentSection = bottomBarViewModel.currentSection.value

    BottomAppBar(
        containerColor = Color.Transparent,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (14).dp)
                .background(
                    color = Gray3,
                    shape = RoundedCornerShape(
                        topStart = 45.dp,
                        topEnd = 45.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                navItems.forEach { item ->
                    IconButton(
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Icon(
                                imageVector = if (currentSection == item.section) item.iconFull else item.icon,
                                contentDescription = item.desc,
                                modifier = Modifier.size(20.dp),
                                tint = Color.Unspecified
                            )
                        }
                    }
                }
            }
        }
    }
}